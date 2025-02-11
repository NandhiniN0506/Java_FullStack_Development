package week_2.Library_Management.Custom_Exception;

public class BookNotFoundException extends Exception{
	
	public BookNotFoundException(String message) {
		super(message);
	}

}
