package org.libraryLorran.model;

public class Book {

    private String title;
    private String author;
    private int isbn;

    public Book() { }

    public Book(String title, String author, int isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getTitle() { return title; }

    public String getAuthor() { return author; }

    public int getISBN() { return isbn; }

    @Override
    public String toString() {
        return "Book{" +
                "title ='" + title + '\'' +
                ", author ='" + author + '\'' +
                ", ISBN ='" + isbn + '\'' +
                '}';
    }
}
