package week_2.Library_Management;

import week_2.Library_Management.Custom_Exception.BookNotFoundException;
import week_2.Library_Management.Custom_Exception.MaxBooksAllowedException;
import week_2.Library_Management.Custom_Exception.UserNotFoundException;

public interface ILibrary {
	public abstract void borrowBook(long ISBN, String userID) throws MaxBooksAllowedException, UserNotFoundException, BookNotFoundException;
	
	public abstract String returnBook(long ISBN, String userID) throws BookNotFoundException, UserNotFoundException;
	
	public abstract String reserveBook(long ISBN, String userID) throws UserNotFoundException, BookNotFoundException;
	
	public abstract String searchBook(String title) throws BookNotFoundException;
	

}
