package com.jameshao.bookmanagement;

public class Book {
    private String isbn;
    private String title;
    private String author;

    public Book() {
    }

    public Book( String title, String author,String isbn) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{标题='" + title +", 作者='" + author + ", isbn='" + isbn + '}';
    }
}
