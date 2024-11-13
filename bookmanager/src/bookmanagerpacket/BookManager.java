package bookmanagerpacket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import bockManager.Book;

public class BookManager {
    // List to store Book objects
    private List<Book> books;

    // Constructor to initialize the books list
    public BookManager() {
        books = new ArrayList<>();
    }

    // Method to add a book to the list
    public void addBook(Book book) {
        books.add(book);
    }

    // Method to display all books in the list
    public void displayBooks() {
        for (Book book : books) { //for-each
            System.out.println(book); // Calls the toString() method of the Book class
        }
    }

    // Method to sort the books by title
    public void sortBooksByTitle() {
        books.sort((b1, b2) -> b1.getTitle().compareTo(b2.getTitle())); //lambda expression
    }

    // Method to sort the books by year
    public void sortBooksByYear() {
        books.sort((b1, b2) -> Integer.compare(b1.getYear(), b2.getYear()));
    }

    // Getter method to return the list of books
    public List<Book> getBooks() {
        return books;
    }
}

