<head></head>
# Library Management System

## Project Overview

The Library Management System is a Java-based application that manages book loans, reservations, and returns. It demonstrates core Java concepts including object-oriented programming (OOP), exception handling, multithreading, and file handling using Java I/O streams.

## Features

- **Book and User Management**:

    - Manage books with properties like title, author, and ISBN.
    - Maintain user records including user ID and borrowed books.
- **Library Operations**:

    - Borrow, return, and reserve books.
    - Search for books by title.
- **Exception Handling**:

    - Custom exceptions: `BookNotFoundException`, `UserNotFoundException`, and `MaxBooksAllowedException` for robust error handling.
- **Multithreading Support**:

    - Ensures concurrent operations are safely executed.
- **Persistence with Java I/O**:

    - Store and retrieve book and user records across sessions.

## Project Structure

    week_2/│── Library_Management/│ ├── Book.java│ ├── User.java│ ├── ILibrary.java│ ├── LibrarySystem.java│ ├── LibraryManager.java│ ├── Custom_Exception/│ │ ├── BookNotFoundException.java│ │ ├── UserNotFoundException.java│ │ ├── MaxBooksAllowedException.java│── Main_Library_Management/│ ├── Main.java│── README.md

## Setup & Usage

1. Clone the repository:

        git clone <repository-url>cd week_2
2. Compile the Java files:

        javac -d bin Library_Management/*.java Main_Library_Management/Main.java
3. Run the program:

        java -cp bin week_2.Main_Library_Management.Main
4. The system initializes with predefined books and users.
5. Perform operations like borrowing, returning, and reserving books.

## Java Files Overview

### **Main.java** (Entry Point)

Handles user interactions, book operations, and library initialization.

### **Book.java**

Defines the `Book` class with properties and methods to manage book data.

### **User.java**

Defines the `User` class with properties and methods to manage library users.

### **ILibrary.java**

An interface declaring core library functions like `borrowBook`, `returnBook`, and `searchBook`.

### **LibrarySystem.java**

An abstract class that provides a framework for library operations.

### **LibraryManager.java**

Implements `LibrarySystem`, handling book borrowing, returning, and reservations with proper exception handling.

### **Custom Exceptions**

- **BookNotFoundException.java**: Raised when a book is not found.
- **UserNotFoundException.java**: Raised when a user is not found.
- **MaxBooksAllowedException.java**: Raised when a user exceeds the book borrowing limit.



