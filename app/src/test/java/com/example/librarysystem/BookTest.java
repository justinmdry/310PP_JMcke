package com.example.librarysystem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookTest {

    int currentID = 0;

    @BeforeEach
    public void checkID() {
        currentID = login.id;
    }

    @Test
    public void correctDefaultConstructorTest() {
        Book b = new Book();

        assertEquals(currentID, b.id, "The book does not have the correct id.");
        assertEquals("null", b.title, "The default constructor does not set the title to null.");
        assertEquals("null", b.author, "The default constructor does not set the author to null.");
        assertEquals("null", b.genre, "The default constructor does not set the genre to null.");
        assertEquals("null", b.description, "The default constructor does not set the description to null.");
        assertFalse(b.checkedOut, "The default constructor marks the book as checked out.");
        assertNull(b.inPos, "The default constructor does not set the inPos to null");

        assertEquals(currentID + 1, login.id, "The default constructor does not increment the id.");
    }

    @Test
    public void correctNonDefaultConstructorTest() {
        Book b = new Book(13, "The Magician's Nephew", "C.S. Lewis", "Fiction", "A children's fantasy that's a jesus allegory.");

        assertEquals(currentID, b.id, "The book does not have the correct id.");
        assertEquals("The Magician's Nephew", b.title, "The non default constructor does not set the title to the given title.");
        assertEquals("C.S. Lewis", b.author, "The non default constructor does not set the author to the given author.");
        assertEquals("Fiction", b.genre, "The non default constructor does not set the genre to the given genre.");
        assertEquals("A children's fantasy that's a jesus allegory.", b.description, "The non default constructor does not set the description to the given description.");
        assertFalse(b.checkedOut, "The default constructor marks the book as checked out.");
        assertNull(b.inPos, "The non default constructor does not set the inPos to null");

        assertEquals(currentID + 1, login.id, "The default constructor does not increment the id.");
    }

    @Test
    public void multipleBooksCreationTest() {
        String[][] answers = {
                {"A Wrinkle In Time", "Madeleine L'Engle", "Science Fiction", "A YA journey through time and space."},
                {"Dracula", "Bram Stoker", "Horror", "A collection of fictional letters describing England's encounter with the vampire Dracula."},
                {"null", "null", "null", "null"},
                {"The Pawn of Prophecy", "David Eddings", "Fiction", "First book in the journey of Garion."}
        };

        Book b1 = new Book(25, answers[0][0], answers[0][1], answers[0][2], answers[0][3]);
        Book b2 = new Book(13, answers[1][0], answers[1][1], answers[1][2], answers[1][3]);
        Book b3 = new Book();
        Book b4 = new Book(45, answers[3][0], answers[3][1], answers[3][2], answers[3][3]);

        //checks all the ids are correct
        assertEquals(currentID, b1.id, "A book does not have the correct id.");
        assertEquals(currentID + 1, b2.id, "A book does not have the correct id.");
        assertEquals(currentID + 2, b3.id, "A book does not have the correct id.");
        assertEquals(currentID + 3, b4.id, "A book does not have the correct id.");

        //check all the book names
        assertEquals(answers[0][0], b1.title, "A book does not have the correct title.");
        assertEquals(answers[1][0], b2.title, "A book does not have the correct title.");
        assertEquals(answers[2][0], b3.title, "A book does not have the correct title.");
        assertEquals(answers[3][0], b4.title, "A book does not have the correct title.");

        //check all the book authors
        assertEquals(answers[0][1], b1.author, "A book does not have the correct author.");
        assertEquals(answers[1][1], b2.author, "A book does not have the correct author.");
        assertEquals(answers[2][1], b3.author, "A book does not have the correct author.");
        assertEquals(answers[3][1], b4.author, "A book does not have the correct author.");

        //check all the book genres
        assertEquals(answers[0][2], b1.genre, "A book does not have the correct genre.");
        assertEquals(answers[1][2], b2.genre, "A book does not have the correct genre.");
        assertEquals(answers[2][2], b3.genre, "A book does not have the correct genre.");
        assertEquals(answers[3][2], b4.genre, "A book does not have the correct genre.");

        //check all the book descriptions
        assertEquals(answers[0][3], b1.description, "A book does not have the correct description.");
        assertEquals(answers[1][3], b2.description, "A book does not have the correct description.");
        assertEquals(answers[2][3], b3.description, "A book does not have the correct description.");
        assertEquals(answers[3][3], b4.description, "A book does not have the correct description.");


        //check if checked out by default
        assertFalse(b1.checkedOut, "A book is marked as checked out by default");
        assertFalse(b2.checkedOut, "A book is marked as checked out by default");
        assertFalse(b3.checkedOut, "A book is marked as checked out by default");
        assertFalse(b4.checkedOut, "A book is marked as checked out by default");

        //check if inPos is null
        assertNull(b1.inPos, "A book does not have inPos marked null");
        assertNull(b2.inPos, "A book does not have inPos marked null");
        assertNull(b3.inPos, "A book does not have inPos marked null");
        assertNull(b4.inPos, "A book does not have inPos marked null");


        assertEquals(currentID + 4, login.id, "The creation of multiple books does not raise the login id to the expected number.");
    }
}
