package bookmanagerpacket;

import java.util.Scanner;

import bockManager.Book;

public class Menu {
    private Scanner scanner;
    private BookManager bookManager;

    // Constructor to initialize scanner and bookManager
    public Menu() {
        scanner = new Scanner(System.in);
        bookManager = new BookManager();
    }

    // Method to start the menu and handle user interactions
    public void start() {
        boolean running = true;
        while (running) {
            // Display menu options
            System.out.println("1. Bücher laden");
            System.out.println("2. Bücher anzeigen");
            System.out.println("3. Bücher nach Titel sortieren");
            System.out.println("4. Bücher nach Jahr sortieren");
            System.out.println("5. Buch hinzufügen");
            System.out.println("6. Beenden");
            System.out.print("Bitte wählen: ");
            
            // Get user input for menu choice
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            // Handle user choice using a switch statement
            switch (choice) {
                case 1:
                    loadBooks();
                    break;
                case 2:
                    displayBooks();
                    break;
                case 3:
                    sortBooksByTitle();
                    break;
                case 4:
                    sortBooksByYear();
                    break;
                case 5:
                    addBook();
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Ungültige Auswahl");
            }
        }
    }

    // Method to load books from a file
    private void loadBooks() {
        System.out.print("Dateiname: ");
        String filename = scanner.nextLine();
        bookManager = new BookManager(); // Initialize a new BookManager
        bookManager.getBooks().addAll(FileManager.loadBooks(filename)); // Load books from file
        System.out.println("Bücher geladen.");
    }

    // Method to display all books
    private void displayBooks() {
        bookManager.displayBooks();
    }

    // Method to sort books by title
    private void sortBooksByTitle() {
        bookManager.sortBooksByTitle();
        System.out.println("Bücher nach Titel sortiert.");
    }

    // Method to sort books by year
    private void sortBooksByYear() {
        bookManager.sortBooksByYear();
        System.out.println("Bücher nach Jahr sortiert.");
    }

    // Method to add a new book
    private void addBook() {
        System.out.print("Titel: ");
        String title = scanner.nextLine();
        System.out.print("Autor: ");
        String author = scanner.nextLine();
        System.out.print("Jahr: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.print("Format (optional): ");
        String format = scanner.nextLine();
        
        // Check if format is provided to determine if it's an EBook or Book
        if (format.isEmpty()) {
            bookManager.addBook(new Book(title, author, year));
        } else {
            bookManager.addBook(new EBook(title, author, year, format));
        }
        System.out.println("Buch hinzugefügt.");
    }
}
