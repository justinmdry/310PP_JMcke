package com.example.librarysystem;

public class Book {
    int id;
    String title, author, genre;
    boolean checkedOut;

    public Book() {
    id = login.id;
    title = "null";
    author = "null";
    genre = "null";
    checkedOut = false;
    login.id++;
    }

    public Book(int id, String title, String author, String genre) {

        this.id = login.id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        checkedOut = false;
        login.id++;
    }
    public void deleteBook(Book book){

    }
}
