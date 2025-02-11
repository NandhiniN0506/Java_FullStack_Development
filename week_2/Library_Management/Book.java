package week_2.Library_Management;
import java.util.*;
public class Book {
	private String title;
	private String  author;
	private long ISBN;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public long getIsbn() {
		return ISBN;
	}
	public void setIsbn(long ISBN) {
		this.ISBN = ISBN;
	}
	public Book(String title, String author, long iSBN) {
		super();
		this.title = title;
		this.author = author;
		ISBN = iSBN;
	}
	
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", ISBN=" + ISBN + "]";
	}
	
	

	
	

}
