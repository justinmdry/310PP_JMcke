package com.example.librarysystem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class BookTest {
    @Test
    public void correctDefaultConstructor(){
        Book b = new Book();

        assertEquals("The first book does not have an id of 0", 0, b.id);
        assertEquals("The default constructor does not set the title to null.", "null", b.title);
        assertEquals("The default constructor does not set the author to null.", "null", b.author);
        assertEquals("The default constructor does not set the genre to null.", "null", b.genre);
        assertFalse("The default constructor marks the book as checked out.", b.checkedOut);

        assertEquals("The default constructor does not increment the id.", 1, login.id);
    }
}
