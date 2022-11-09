package com.example.librarysystem;

import static com.example.librarysystem.login.lOB;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class ManageBooks extends AppCompatActivity {
    ArrayList<Book> listOfBooks;
    TableLayout displayBooks;//creating references
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_books);

        lOB=lOB.read(getApplicationContext()); //  BookList lOB = new BookList();

        ArrayList<Book> LOBARRAY=lOB.getBookList();
        listOfBooks = lOB.getBookList();

        displayBooks= (TableLayout) findViewById(R.id.displayBooksManage);//casting table

        for(int i=0;i<listOfBooks.size();i++){//creating table
            Book fill=listOfBooks.get(i);//iterating through books
            TableRow row=new TableRow(this);//creating row

            String title=fill.title;//creating title view
            TextView titleView=new TextView(this);
            titleView.setText(""+title);

            Button checkout=new Button(this);//creating button
            checkout.setTag(fill);
            checkout.setText("Delete");
            checkout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listOfBooks.remove(fill);//removing selected book
                    //Write the new list of books to the file so its updated with the deleted book missing
                    BookList lOB = new BookList(listOfBooks);
                    lOB.writeToFile(lOB,getApplicationContext());
                    restart();

                }
            });



            row.addView(titleView);
            row.addView(checkout);
            displayBooks.addView(row);//adding rows to table

        }
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }

    //Restarts activity to show changes
public void restart(){
    Intent intent = new Intent(ManageBooks.this, ManageBooks.class);
    startActivity(intent); // start same activity
    finish(); // destroy older activity
    overridePendingTransition(0, 0);


}

    public void returnHome(View V){//return home button
        Intent intent= new Intent(this, AdminMain.class);
        startActivity(intent);
    }

    public void addView (View V) {//logout button
        Intent intent= new Intent(this, add_form.class);

        startActivity(intent);
    }


}