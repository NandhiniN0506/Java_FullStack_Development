package week_2.Main_Library_Management;

import week_2.Library_Management.*;
import week_2.Library_Management.Custom_Exception.*;

/**
 * The Main class serves as the entry point for the Library Management System.
 * It initializes the library system, adds books and users, and performs various operations.
 */
public class Main {
    public static void main(String[] args) throws BookNotFoundException, UserNotFoundException, MaxBooksAllowedException {
        // Initialize the library manager
        LibraryManager lib = new LibraryManager();
        
        // Create sample books
        Book book1 = new Book("Clean Code", "Robert C. Martin", 1234567890123L);
        Book book2 = new Book("Theory of Computation", "Michael Sipser", 9087654321458L);
        Book book3 = new Book("Machine Learning", "Aurélien Géron", 1432567890547L);
        
        // Create sample users
        User user1 = new User("User1", "123");
        User user2 = new User("User2", "234");
        User user3 = new User("User3", "235");
        
        // Add books to the library
        lib.addBook(book1);
        lib.addBook(book2);
        lib.addBook(book3);
        
        // Add users to the library system
        lib.addUser(user1);
        lib.addUser(user2);
        lib.addUser(user3);
        
        // Perform book reservations and borrow operations
        System.out.println(lib.reserveBook(9087654321458L, "123"));
        System.out.println(lib.searchBook("Theory of Computation"));
        lib.borrowBook(1432567890547L, "234");
        System.out.println(lib.returnBook(1432567890547L, "234"));
    }
}
