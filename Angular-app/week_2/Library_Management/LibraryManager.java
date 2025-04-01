package week_2.Library_Management;
import java.util.*;
import java.util.Map.Entry;
import week_2.Library_Management.Custom_Exception.*;

/**
 * LibraryManager class extends LibrarySystem and implements library operations.
 * This class manages books, users, and their interactions with the library system.
 */
public class LibraryManager extends LibrarySystem {
    
    // Map to store book title and corresponding ISBN
    private Map<String, Long> books = new HashMap<>();
    
    // Map to store user ID and a list of borrowed books (ISBNs)
    private Map<String, ArrayList<Long>> users = new HashMap<>();
    
    // Map to store user objects and their borrowed book count
    private Map<User, Integer> books_borrow = new HashMap<>();
    
    // Map to store user objects and their reserved books
    private Map<User, ArrayList<Long>> reserve_book = new HashMap<>();

    /**
     * Utility method to append an ISBN to an existing list.
     * @param arrayList The list to modify.
     * @param ISBN The ISBN to add.
     * @return The modified list.
     */
    public static ArrayList<Long> appendToList(ArrayList<Long> arrayList, long ISBN) {
        if (arrayList != null) {
            arrayList.add(ISBN);
        }
        return arrayList;
    }

    /**
     * Method to borrow a book from the library.
     * @param ISBN The ISBN of the book to be borrowed.
     * @param userID The user ID of the borrower.
     * @throws MaxBooksAllowedException If the user has reached the borrowing limit.
     * @throws UserNotFoundException If the user is not found in the system.
     * @throws BookNotFoundException If the book is not available in the system.
     */
    @Override
    public void borrowBook(long ISBN, String userID) throws MaxBooksAllowedException, UserNotFoundException, BookNotFoundException {
        for (Entry<User, Integer> entry : books_borrow.entrySet()) {
            if (entry.getKey().getUser_id().equalsIgnoreCase(userID)) {
                if (entry.getValue() == 0) {
                    throw new MaxBooksAllowedException("Maximum books borrowed...");
                } else if (!books.containsValue(ISBN)) {
                    throw new BookNotFoundException("Book not found in Database");
                } else {
                    users.replace(userID, appendToList(users.get(userID), ISBN));
                    int newLimit = entry.getKey().getMAX_BOOK_LIMIT() - 1;
                    entry.getKey().setMAX_BOOK_LIMIT(newLimit);
                    books_borrow.replace(entry.getKey(), newLimit);

                    // Retrieve the book title and print confirmation
                    for (Entry<String, Long> bookEntry : books.entrySet()) {
                        if (bookEntry.getValue().equals(ISBN)) {
                            System.out.println("\"" + bookEntry.getKey() + "\"" + " borrowed by user " + userID);
                            return;
                        }
                    }
                }
                return;
            }
        }
        throw new UserNotFoundException("User not found in the Database");
    }

    /**
     * Method to return a borrowed book.
     * @param ISBN The ISBN of the book to return.
     * @param userID The user ID returning the book.
     * @return Confirmation message.
     * @throws BookNotFoundException If the book is not found in the system.
     * @throws UserNotFoundException If the user is not found in the system.
     */
    @Override
    public String returnBook(long ISBN, String userID) throws BookNotFoundException, UserNotFoundException {
        for (Entry<User, Integer> entry : books_borrow.entrySet()) {
            if (entry.getKey().getUser_id().equalsIgnoreCase(userID)) {
                if (books.containsValue(ISBN)) {
                    int newLimit = entry.getKey().getMAX_BOOK_LIMIT() + 1;
                    books_borrow.replace(entry.getKey(), newLimit);

                    // Retrieve book title for confirmation message
                    for (Entry<String, Long> bookEntry : books.entrySet()) {
                        if (bookEntry.getValue().equals(ISBN)) {
                            return userID + " returned the book \"" + bookEntry.getKey() + "\" successfully.";
                        }
                    }
                } else {
                    throw new BookNotFoundException("Book not found...");
                }
            }
        }
        throw new UserNotFoundException("User not found...");
    }

    /**
     * Method to reserve a book for a user.
     * @param ISBN The ISBN of the book to reserve.
     * @param userID The user ID making the reservation.
     * @return Confirmation message.
     * @throws UserNotFoundException If the user is not found in the system.
     * @throws BookNotFoundException If the book is not found in the system.
     */
    @Override
    public String reserveBook(long ISBN, String userID) throws UserNotFoundException, BookNotFoundException {
        if (!books.containsValue(ISBN)) {
            throw new BookNotFoundException("Book not found...");
        }

        for (Entry<User, Integer> entry : books_borrow.entrySet()) {
            if (entry.getKey().getUser_id().equalsIgnoreCase(userID)) {
                reserve_book.replace(entry.getKey(), appendToList(reserve_book.get(entry.getKey()), ISBN));

                // Retrieve book title for confirmation message
                for (Entry<String, Long> bookEntry : books.entrySet()) {
                    if (bookEntry.getValue().equals(ISBN)) {
                        return "\"" + bookEntry.getKey() + "\" reserved for the user " + userID;
                    }
                }
            }
        }
        throw new UserNotFoundException("User not found...");
    }

    /**
     * Method to search for a book by title.
     * @param title The title of the book to search.
     * @return Confirmation message if found.
     * @throws BookNotFoundException If the book is not found in the system.
     */
    @Override
    public String searchBook(String title) throws BookNotFoundException {
        if (!books.containsKey(title)) {
            throw new BookNotFoundException("Book not found...");
        } else {
            return "\"" + title + "\"" + " found in the Database.";
        }
    }

    /**
     * Method to add a new book to the library system.
     * @param bookDatabase The book object to add.
     */
    @Override
    public void addBook(Book bookDatabase) {
        books.put(bookDatabase.getTitle(), bookDatabase.getIsbn());
    }

    /**
     * Method to add a new user to the library system.
     * @param userDatabase The user object to add.
     */
    @Override
    public void addUser(User userDatabase) {
        users.put(userDatabase.getUser_id(), userDatabase.getBorrowed_books());
        books_borrow.put(userDatabase, userDatabase.getMAX_BOOK_LIMIT());
        reserve_book.put(userDatabase, new ArrayList<>(Arrays.asList(0L)));
    }
}
