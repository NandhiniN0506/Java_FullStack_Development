package week_2.Library_Management;

import java.util.*;

public class User {
	private String name;
	private String user_id;
	private ArrayList<Long> borrowed_books = new ArrayList<>();
	private   int MAX_BOOK_LIMIT = 5;
	
	public String getName() {
		return name;
	}
	public  int getMAX_BOOK_LIMIT() {
		return MAX_BOOK_LIMIT;
	}
	public  void setMAX_BOOK_LIMIT(int mAX_BOOK_LIMIT) {
		this.MAX_BOOK_LIMIT = mAX_BOOK_LIMIT;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public ArrayList<Long> getBorrowed_books() {
		return borrowed_books;
	}
	public void setBorrowed_books(ArrayList<Long> borrowed_books) {
		this.borrowed_books = borrowed_books;
	}
	
	@Override
	public String toString() {
		return "User [name=" + name + ", user_id=" + user_id + ", borrowed_books=" + borrowed_books + "]";
	}
	
	public User(String name,String user_id) {
		this(name, user_id, new ArrayList<>(Arrays.asList(0L)));
		
	}
	public User(String name, String user_id, ArrayList<Long> borrowed_books) {
		super();
		this.name = name;
		this.user_id = user_id;
		this.borrowed_books = borrowed_books;
	}
	
	

}
