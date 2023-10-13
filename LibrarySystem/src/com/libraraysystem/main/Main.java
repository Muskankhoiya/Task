package com.libraraysystem.main;
import java.util.List;
import java.util.Scanner;
import com.libraraysystem.library.*;
import com.libraraysystem.book.*;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("");
            System.out.print("---------------------------------------------------------");
            System.out.println("\n Welcome to Library System:");
            System.out.println("-------------------------------------------------------");
            System.out.println("1. Add a new book");
            System.out.println("2. Display all books");
            System.out.println("3. Search for a book by title");
            System.out.println("4. Check out a book");
            System.out.println("5. Return a book");
            System.out.println("6. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addBook(library, scanner);
                    break;
                case 2:
                    displayAllBooks(library);
                    break;
                case 3:
                    searchByTitle(library, scanner);
                    break;
                case 4:
                    checkOutBook(library, scanner);
                    break;
                case 5:
                    returnBook(library, scanner);
                    break;
                case 6:
                    System.out.println("Thank you for using the Library System!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Method to add a new book to the library
    private static void addBook(Library library, Scanner scanner) {
        try {
            System.out.print("Enter the book title: ");
            String title = scanner.nextLine();
            System.out.print("Enter the author's name: ");
            String author = scanner.nextLine();
            System.out.print("Enter the ISBN: ");
            String isbn = scanner.nextLine();

            Book book = new Book(title, author, isbn);
            library.addBook(book);
            System.out.println("Book added to the library.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Method to display a list of all books in the library
    private static void displayAllBooks(Library library) {
        List<Book> books = library.getBooks();
        System.out.println("\nList of all books in the library:");
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    // Method to search for a book by its title and display matching books
    private static void searchByTitle(Library library, Scanner scanner) {
        try {
            System.out.print("Enter the book title to search: ");
            String title = scanner.nextLine();
            List<Book> result = library.searchByTitle(title);
            if (result.isEmpty()) {
                System.out.println("No matching books found.");
            } else {
                System.out.println("\nMatching books:");
                for (Book book : result) {
                    System.out.println(book);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Method to check out a book from the library
    private static void checkOutBook(Library library, Scanner scanner) {
        try {
            System.out.print("Enter the book title to check out: ");
            String title = scanner.nextLine();
            List<Book> result = library.searchByTitle(title);
            if (result.isEmpty()) {
                System.out.println("No matching books found for checkout.");
            } else {
                for (Book book : result) {
                    if (book.isAvailable()) {
                        library.checkOutBook(book);
                        System.out.println("Book checked out successfully.");
                        return;
                    }
                }
                System.out.println("All matching books are already checked out.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Method to return a checked-out book to the library
    private static void returnBook(Library library, Scanner scanner) {
        try {
            System.out.print("Enter the book title to return: ");
            String title = scanner.nextLine();
            List<Book> result = library.searchByTitle(title);
            if (result.isEmpty()) {
                System.out.println("No matching books found for return.");
            } else {
                for (Book book : result) {
                    if (!book.isAvailable()) {
                        library.returnBook(book);
                        System.out.println("Book returned successfully.");
                        return;
                    }
                }
                System.out.println("All matching books are already available.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
