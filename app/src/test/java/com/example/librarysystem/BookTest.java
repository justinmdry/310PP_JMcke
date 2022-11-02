package com.example.librarysystem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookTest {
    //Okay self. Maybe run a before All to create a bunch of book objects to run tests on

    int currentID = 0;

    @BeforeEach
    public void checkID(){
        currentID = login.id;
    }

    @Test
    public void correctDefaultConstructorTest(){
        Book b = new Book();

        assertEquals(currentID, b.id, "The book does not have the correct id.");
        assertEquals("null", b.title, "The default constructor does not set the title to null.");
        assertEquals("null", b.author, "The default constructor does not set the author to null.");
        assertEquals("null", b.genre, "The default constructor does not set the genre to null.");
        assertFalse(b.checkedOut, "The default constructor marks the book as checked out.");

        assertEquals(currentID+1, login.id, "The default constructor does not increment the id.");
    }

    @Test
    public void correctNonDefaultConstructorTest(){
        Book b = new Book(13, "The Magician's Nephew", "C.S. Lewis", "Fiction");

        assertEquals(currentID, b.id, "The book does not have the correct id.");
        assertEquals("The Magician's Nephew", b.title, "The default constructor does not set the title to the given title.");
        assertEquals("C.S. Lewis", b.author, "The default constructor does not set the author to the given author.");
        assertEquals("Fiction", b.genre, "The default constructor does not set the genre to the given genre.");
        assertFalse(b.checkedOut, "The default constructor marks the book as checked out.");

        assertEquals(currentID+1, login.id, "The default constructor does not increment the id.");
    }

    @Test
    public void multipleBooksCreationTest(){
        String[][] answers = {
                {"A Wrinkle In Time", "Madeleine L'Engle", "Science Fiction"},
                {"Dracula", "Bram Stoker", "Horror"},
                {"null", "null", "null"},
                {"The Belfariad", "David Eddings", "Fiction"}
        };

        Book b1 = new Book(25, answers[0][0], answers[0][1], answers[0][2]);
        Book b2 = new Book(13, answers[1][0], answers[1][1], answers[1][2]);
        Book b3 = new Book();
        Book b4 = new Book(45, answers[3][0], answers[3][1], answers[3][2]);

        //checks all the ids are correct
        assertEquals(currentID, b1.id, "A book does not have the correct id.");
        assertEquals(currentID+1, b2.id, "A book does not have the correct id.");
        assertEquals(currentID+2, b3.id, "A book does not have the correct id.");
        assertEquals(currentID+3, b4.id, "A book does not have the correct id.");

        //check all the book names
        assertEquals(answers[0][0], b1.title, "A book does not have the correct title.");
        assertEquals(answers[1][0], b2.title, "A book does not have the correct title.");
        assertEquals(answers[2][0], b3.title, "A book does not have the correct title.");
        assertEquals(answers[3][0], b4.title, "A book does not have the correct title.");

        //check all the book authors

        //check all the book genres

        //check if checked out by default

        assertEquals(currentID+4, login.id, "The creation of multiple books does not raise the login id to the expected number.");
    }

    //check if you can alter information
}