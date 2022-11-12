package com.example.librarysystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class AccountTest {
    @Test
    public void correctDefaultConstructor(){
        Account a = new Account();

        assertNull(a.userName, "The default constructor does not make the username null.");
        assertNull(a.passWord, "The default constructor does not make the password null.");
        assertFalse(a.isAdmin, "The default constructor does not set the admin boolean to false.");
    }

    @Test
    public void correctUserConstructorTest(){
        Account a = new Account("Dave1234", "strongP@ssw0rd");

        assertEquals("Dave1234", a.userName, "Your user constructor does not set the username to the given string.");
        assertEquals("strongP@ssw0rd", a.passWord, "Your user constructor does not set the password to the given string.");
        assertFalse(a.isAdmin, "Your user constructor does not set the admin boolean to false");
    }

    @Test
    public void correctPotentialAdminConstructorTest(){
        Account a = new Account("NotAnAdmin", "myCatsName", false);
        Account b = new Account("IsAnAdmin", "he27dsb5", true);

        assertEquals("NotAnAdmin", a.userName, "Your potential admin constructor does not set the username to the given string.");
        assertEquals("IsAnAdmin", b.userName, "Your potential admin constructor does not set the username to the given string.");

        assertEquals("myCatsName", a.passWord, "Your potential admin constructor does not set the password to the given string.");
        assertEquals("he27dsb5", b.passWord, "Your potential admin constructor does not set the password to the given string.");

        assertFalse(a.isAdmin, "Your potential admin constructor does not set isAdmin to false when passed a false boolean.");
        assertTrue(b.isAdmin, "Your potential admin constructor does not set isAdmin to true when passed a true boolean.");
    }

    @Test
    public void correctGetUsernameMethodTest(){
        Account a = new Account("username123", "password456");
        assertEquals("username123", a.getUserName(), "Your getUserName method does not return the expected value.");

        a.userName = "changed username";
        assertEquals("changed username", a.getUserName(), "Your getUserName method does not return the correct username after it has been altered.");
    }

    @Test
    public void correctGetPasswordMethodTest(){
        Account a = new Account("username123", "password456");
        assertEquals("password456", a.getPassWord(), "Your getPassWord method does not return the expected value.");

        a.passWord = "changed password";
        assertEquals("changed password", a.getPassWord(), "Your getPassWord method does not return the correct password after it has been altered.");
    }
}
