package week_2.Library_Management;
import java.util.*;
import week_2.Library_Management.*;
public abstract class LibrarySystem implements ILibrary {
	
	protected List<Book> bookDatabase = new ArrayList<>();
	protected List<User> userDatabase = new ArrayList<User>();
	
	public abstract void addBook(Book bookDatabase);
	
	public abstract void addUser(User userDatabase);


}
