package com.example.librarysystem;

import static com.example.librarysystem.login.books;
import static com.example.librarysystem.login.lOB;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class add_form extends AppCompatActivity {
    ArrayList<Book> list;
    String title, author, genre;
    EditText titleText, authorText, genreText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_form);
    }

    public void addBook (View view){
        titleText = (EditText) findViewById(R.id.titleField);
        authorText = (EditText) findViewById(R.id.authorField);
        genreText = (EditText) findViewById(R.id.genreField);

        title = titleText.getText().toString();
        author = authorText.getText().toString();
        genre = genreText.getText().toString();

     //Gets the current booklist, adds the new book, and changes the master list
        lOB.read(getApplicationContext());
        list = lOB.getBookList();
        list.add(new Book(login.id, title, author, genre));
        lOB = new BookList(list);
    lOB.writeToFile(lOB, getApplicationContext());
    }

    public void back (View view) {
        Intent intent= new Intent(this, ManageBooks.class);
        startActivity(intent);

    }

}