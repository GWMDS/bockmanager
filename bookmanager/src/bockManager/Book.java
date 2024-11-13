package bockManager;

import java.util.Objects;

public class Book {
	// Constants for default title and author
    public static final String DEFAULT_TITLE = "Unknown Title";
    public static final String DEFAULT_AUTHOR = "Unknown Author";

    // Attributes of the Book class
    private String title;
    private String author;
    private int year;

    // Default constructor that uses default values for title and author
    public Book() {
        this(DEFAULT_TITLE, DEFAULT_AUTHOR, 0);
    }

    // Parameterized constructor that allows setting the title, author, and year
    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    // Getter method for the title attribute
    public String getTitle() {
        return title;
    }

    // Setter method for the title attribute
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter method for the author attribute
    public String getAuthor() {
        return author;
    }

    // Setter method for the author attribute
    public void setAuthor(String author) {
        this.author = author;
    }

    // Getter method for the year attribute
    public int getYear() {
        return year;
    }

    // Setter method for the year attribute
    public void setYear(int year) {
        this.year = year;
    }

    // Overridden toString() method to provide a string representation of the Book object
    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                '}';
    }

    // Overridden equals() method to compare two Book objects for equality
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // If the objects are the same instance, they are equal
        if (o == null || getClass() != o.getClass()) return false; // If the object is null or not of the same class, they are not equal
        Book book = (Book) o; // Cast the object to a Book
        return year == book.year &&
                Objects.equals(title, book.title) &&
                Objects.equals(author, book.author); // Compare the attributes for equality
    }

    // Overridden hashCode() method to generate a hash code for the Book object
    @Override
    public int hashCode() {
        return Objects.hash(title, author, year); // Generate a hash code based on the attributes
    }
}
