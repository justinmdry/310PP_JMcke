package com.example.librarysystem;

public class Book {
int id;
    String title, author, genre;
    boolean checkedOut;

    public Book() {
    id = UserMain.id;
    title = "null";
    author = "null";
    genre = "null";
    checkedOut = false;
    UserMain.id++;
    }

    public Book(int id, String title, String author, String genre) {

        this.id = UserMain.id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        checkedOut = false;
        UserMain.id++;
    }


}
