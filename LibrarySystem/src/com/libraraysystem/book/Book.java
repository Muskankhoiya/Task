package com.libraraysystem.book;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean available;

    // Constructor to initialize a book with title, author, and ISBN
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.available = true; // Initially, the book is available
    }

    // Getter method to retrieve the title of the book
    public String getTitle() {
        return title;
    }

    // Getter method to retrieve the author of the book
    public String getAuthor() {
        return author;
    }

    // Getter method to retrieve the ISBN of the book
    public String getIsbn() {
        return isbn;
    }

    // Getter method to check if the book is available
    public boolean isAvailable() {
        return available;
    }

    // Setter method to update the availability of the book
    public void setAvailable(boolean available) {
        this.available = available;
    }

    // Overridden toString method to provide a formatted string representation of the book
    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + isbn + ", Available: " + (available ? "Yes" : "No");
    }
}
