package com.libraraysystem.library;
import java.util.ArrayList;
import java.util.List;
import com.libraraysystem.book.Book;

public class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    // Method to add a book to the library
    public void addBook(Book book) {
        books.add(book);
    }

    // Method to retrieve a list of all books in the library
    public List<Book> getBooks() {
        return books;
    }

    // Method to search for books by title and return a list of matching books
    public List<Book> searchByTitle(String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                result.add(book);
            }
        }
        return result;
    }

    // Method to mark a book as checked out
    public void checkOutBook(Book book) {
        book.setAvailable(false);
    }

    // Method to mark a book as returned and available
    public void returnBook(Book book) {
        book.setAvailable(true);
    }
}
