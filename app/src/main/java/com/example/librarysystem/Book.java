package com.example.librarysystem;

import java.io.Serializable;

//Creates a book object that holds title, author, genre, id, and checked out status
public class Book implements Serializable {
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

}
