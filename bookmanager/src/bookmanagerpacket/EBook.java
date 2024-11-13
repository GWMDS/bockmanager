package bookmanagerpacket;

import bockManager.Book;

// EBook class extending Book class
public class EBook extends Book {
    // Attribute for format of the eBook
    private String format;

    // Default constructor
    public EBook() {
        super(); // Calls the default constructor of the Book class
        this.format = "Unknown Format"; // Sets default format
    }

    // Parameterized constructor
    public EBook(String title, String author, int year, String format) {
        super(title, author, year); // Calls the parameterized constructor of the Book class
        this.format = format; // Sets the format attribute
    }

    // Getter method for the format attribute
    public String getFormat() {
        return format;
    }

    // Setter method for the format attribute
    public void setFormat(String format) {
        this.format = format;
    }

    // Overridden toString() method to include the format attribute
    @Override
    public String toString() {
        return super.toString() + ", format='" + format + '\'' + '}'; // Calls the toString() method of the Book class and adds format information
    }
}

