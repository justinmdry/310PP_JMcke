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

public class myBooksUser extends AppCompatActivity {

    ArrayList<Book> listOfBooksUserView;
    TableLayout displayBooksUserView;//creating references

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_books_user);

        lOB=lOB.read(getApplicationContext()); //  BookList lOB = new BookList();
        listOfBooksUserView = lOB.getBookList();
        displayBooksUserView= (TableLayout) findViewById(R.id.displayBooksUserView);//casting table


        for(int i=0;i<listOfBooksUserView.size();i++){//creating table

            Book fill=listOfBooksUserView.get(i);//iterating through books

            TableRow row=new TableRow(this);//creating row

            if(fill.checkedOut==true){
                String title=fill.title;//creating title view
                TextView titleView=new TextView(this);
                titleView.setText(""+title);

                Button checkout=new Button(this);//creating checkout Buttons
                checkout.setTag(fill);
                checkout.setText("Return");
                checkout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        fill.checkedOut=false;//change value if button is pressed
                        //update the file so it contains the book as checked out
                        BookList lOB = new BookList(listOfBooksUserView);
                        lOB.writeToFile(lOB,getApplicationContext());
                        restart();
                    }
                });

                row.addView(titleView);//adding both bits to table
                row.addView(checkout);

                displayBooksUserView.addView(row);

           }


        }
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }

    public void returnHome(View V){//return home button
        Intent intent= new Intent(this, UserMain.class);
        startActivity(intent);
    }

    //Restarts activity to show changes
    public void restart(){
        Intent intent = new Intent(this, myBooksUser.class);
        startActivity(intent); // start same activity
        finish(); // destroy older activity
        overridePendingTransition(0, 0);


    }
}