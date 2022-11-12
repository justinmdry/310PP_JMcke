package com.example.librarysystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class AccountTest {
    @Test
    public void correctDefaultConstructor(){
        Account a = new Account();

        assertNull(a.userName);
        assertNull(a.passWord);
        assertFalse(a.isAdmin);
    }

    @Test
    public void correctUserConstructorTest(){

    }

    @Test
    public void correctAdminConstructorTest(){

    }

    @Test
    public void correctGetUsernameMethodTest(){

    }

    @Test
    public void correctGetPasswordMethodTest(){

    }
}
