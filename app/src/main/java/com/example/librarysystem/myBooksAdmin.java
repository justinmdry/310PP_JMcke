package com.example.librarysystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class myBooksAdmin extends AppCompatActivity {

    ArrayList<Book> listOfBooks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_books_admin);

        BookList lOB = new BookList();
        lOB.read(getApplicationContext());

        listOfBooks = lOB.getBookList();
    }

    public void returnHome(View V){
        Intent intent= new Intent(this, AdminMain.class);
        startActivity(intent);
    }
}