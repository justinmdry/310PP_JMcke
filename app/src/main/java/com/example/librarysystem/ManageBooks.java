package com.example.librarysystem;

import static com.example.librarysystem.login.books;
import static com.example.librarysystem.login.lOB;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class ManageBooks extends AppCompatActivity {
    ArrayList<Book> listOfBooks;
    TableLayout displayBooks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_books);

        lOB.read(getApplicationContext()); //  BookList lOB = new BookList();

        ArrayList<Book> LOBARRAY=lOB.getBookList();
        listOfBooks = lOB.getBookList();

        displayBooks= (TableLayout) findViewById(R.id.displayBooks);//casting table

        for(int i=0;i<listOfBooks.size();i++){//creating table
            Book fill=listOfBooks.get(i);//iterating through books
            TableRow row=new TableRow(this);//creating row

            String title=fill.title;//creating title view
            TextView titleView=new TextView(this);
            titleView.setText(""+title);

            Button checkout=new Button(this);
            checkout.setTag(fill);
            checkout.setText("Delete");
            checkout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listOfBooks.remove(fill);//removing selected book
                    //Write the new list of books to the file so its updated with the deleted book missing
                    BookList lOB = new BookList(listOfBooks);
                    lOB.writeToFile(lOB,getApplicationContext());
                }
            });



            row.addView(titleView);
            row.addView(checkout);
            displayBooks.addView(row);

        }
    }

    public void returnHome(View V){
        Intent intent= new Intent(this, AdminMain.class);
        startActivity(intent);
    }

    public void addView (View V) {
        Intent intent= new Intent(this, add_form.class);

        startActivity(intent);
    }


}