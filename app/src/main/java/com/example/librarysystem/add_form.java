package com.example.librarysystem;

import static com.example.librarysystem.login.lOB;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.pranavpandey.android.dynamic.toasts.DynamicToast;

import java.util.ArrayList;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class add_form extends AppCompatActivity {
    ArrayList<Book> list;
    String title, author, genre, description;
    EditText titleText, authorText, genreText, descriptionText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_form);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }

    public void addBook (View view){
        titleText = (EditText) findViewById(R.id.titleField);
        authorText = (EditText) findViewById(R.id.authorField);
        genreText = (EditText) findViewById(R.id.genreField);
        descriptionText = (EditText) findViewById(R.id.descriptionField);


        title = titleText.getText().toString();
        author = authorText.getText().toString();
        genre = genreText.getText().toString();
        description = descriptionText.getText().toString();

     //Gets the current booklist, adds the new book, and changes the master list

        if (title.isEmpty())  {
            DynamicToast.makeWarning(getApplicationContext(), "Please enter a book title").show();
        } else if (author.isEmpty()){
            DynamicToast.makeWarning(getApplicationContext(), "Please enter an author").show();
        } else if (genre.isEmpty()){
            DynamicToast.makeWarning(getApplicationContext(), "Please enter a genre").show();
        } else if (description.isEmpty()){
            DynamicToast.makeWarning(getApplicationContext(), "Please enter a description").show();
        }
        else {
        lOB.read(getApplicationContext());
        list = lOB.getBookList();
        list.add(new Book(login.id, title, author, genre, description));
        lOB = new BookList(list);
    lOB.writeToFile(lOB, getApplicationContext());
            DynamicToast.makeSuccess(getApplicationContext(), title + " has been added").show();
            restart();
        }
    }

    //Restarts activity to show changes
    public void restart(){
        Intent intent = new Intent(this, add_form.class);
        startActivity(intent); // start same activity
        finish(); // destroy older activity
        overridePendingTransition(0, 0);


    }

    public void back (View view) {
        Intent intent= new Intent(this, ManageBooks.class);
        startActivity(intent);

    }

}