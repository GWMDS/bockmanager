package bookmanagerpacket;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import bockManager.Book;

public class FileManager {

    // Method to load books from a file
    public static List<Book> loadBooks(String filename) {
        List<Book> books = new ArrayList<>();
        File file = new File(filename);
        System.out.println("Trying to load file from: " + file.getAbsolutePath());

        // Try-with-resources to ensure BufferedReader is closed after usage
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;

            // Read the file line by line
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");

                // If line contains 4 parts, it's an EBook
                if (parts.length == 4) {
                    books.add(new EBook(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3]));
                } 
                // If line contains 3 parts, it's a regular Book
                else if (parts.length == 3) {
                    books.add(new Book(parts[0], parts[1], Integer.parseInt(parts[2])));
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + file.getAbsolutePath()); // Handle file not found
        } catch (IOException e) {
            e.printStackTrace(); // Handle other IO exceptions
        }
        return books; // Return the list of books
    }

    // Method to save books to a file
    public static void saveBooks(String filename, List<Book> books) {
        // Try-with-resources to ensure BufferedWriter is closed after usage
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (Book book : books) {
                // Check if the book is an instance of EBook
                if (book instanceof EBook) {
                    EBook ebook = (EBook) book;
                    // Write EBook attributes to file
                    bw.write(ebook.getTitle() + "," + ebook.getAuthor() + "," + ebook.getYear() + "," + ebook.getFormat());
                } else {
                    // Write Book attributes to file
                    bw.write(book.getTitle() + "," + book.getAuthor() + "," + book.getYear());
                }
                bw.newLine(); // Move to the next line
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle IO exceptions
        }
    }
}
