package com.example.librarysystem;

public class Book {
    int id;
    String title, author, genre;
    boolean checkedOut;

    public Book() {
    id = id;
    title = "null";
    author = "null";
    genre = "null";
    checkedOut = false;
    id++;
    }

    public Book(int id, String title, String author, String genre) {

        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        checkedOut = false;
        id++;
    }


}
