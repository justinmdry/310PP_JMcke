package com.example.librarysystem;

import static com.example.librarysystem.login.lOB;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class Search extends AppCompatActivity {

    ArrayList<Book> listOfBooks;
    TableLayout displayBooks;//creating references
    String userN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        EditText search=(EditText) findViewById(R.id.inputSearch);
        Spinner searchCond=(Spinner) findViewById(R.id.searchCond);
        String searchCondSelect=searchCond.getSelectedItem().toString();

        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();//getting user Key
        userN = bundle.getString("userN");


        lOB.read(getApplicationContext()); //  BookList lOB = new BookList();
        listOfBooks = lOB.getBookList();
        displayBooks= (TableLayout) findViewById(R.id.displayBooks);//casting table

        for(int i=0;i<listOfBooks.size();i++) {//creating table

            Book fill = listOfBooks.get(i);//iterating through books
            TableRow row = new TableRow(this);//creating row
            if (fill.checkedOut == false) {
                String title = fill.title;//creating title view
                TextView titleView = new TextView(this);
                titleView.setText("" + title);

                Button checkout = new Button(this);//creating checkout Buttons
                checkout.setTag(fill);
                checkout.setText("Checkout");
                checkout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        fill.checkedOut = true;//if button is pressed update field
                        fill.inPos = userN;
                        //update the file so it contains the book as checked out
                        BookList lOB = new BookList(listOfBooks);
                        lOB.writeToFile(lOB, getApplicationContext());
                        restart();
                    }

                });

                row.addView(titleView);//adding both bits to table
                row.addView(checkout);
                displayBooks.addView(row);

            }
        }

    }
    public void startSearch(View v){
        EditText searchobj=(EditText) findViewById(R.id.inputSearch);
        String search=searchobj.getText().toString();
        Spinner searchCond=(Spinner) findViewById(R.id.searchCond);
        String searchCondSelect=searchCond.getSelectedItem().toString();

        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();//getting user Key
        userN = bundle.getString("userN");


        lOB.read(getApplicationContext()); //  BookList lOB = new BookList();
        listOfBooks = lOB.getBookList();
        displayBooks= (TableLayout) findViewById(R.id.displayBooks);//casting table
        displayBooks.removeAllViews();//clearing table
        System.out.println(searchCondSelect);

        if(search.isEmpty()){//if no search terms are entered
            for(int i=0;i<listOfBooks.size();i++) {//creating table

                Book fill = listOfBooks.get(i);//iterating through books
                TableRow row = new TableRow(this);//creating row
                if (fill.checkedOut == false) {
                    String title = fill.title;//creating title view
                    TextView titleView = new TextView(this);
                    titleView.setText("" + title);

                    Button checkout = new Button(this);//creating checkout Buttons
                    checkout.setTag(fill);
                    checkout.setText("Checkout");
                    checkout.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            fill.checkedOut = true;//if button is pressed update field
                            fill.inPos = userN;
                            //update the file so it contains the book as checked out
                            BookList lOB = new BookList(listOfBooks);
                            lOB.writeToFile(lOB, getApplicationContext());
                            restart();
                        }

                    });

                    row.addView(titleView);//adding both bits to table
                    row.addView(checkout);
                    displayBooks.addView(row);

                }
            }
        } else{//if search terms are entered
            if(searchCondSelect.contains("Title")){
                for(int i=0;i<listOfBooks.size();i++) {//creating table

                    Book fill = listOfBooks.get(i);//iterating through books
                    TableRow row = new TableRow(this);//creating row
                    if (fill.checkedOut == false && fill.title.toLowerCase(Locale.ROOT).contains(search.toLowerCase(Locale.ROOT))) {
                        String title = fill.title;//creating title view
                        TextView titleView = new TextView(this);
                        titleView.setText("" + title);

                        Button checkout = new Button(this);//creating checkout Buttons
                        checkout.setTag(fill);
                        checkout.setText("Checkout");
                        checkout.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                fill.checkedOut = true;//if button is pressed update field
                                fill.inPos = userN;
                                //update the file so it contains the book as checked out
                                BookList lOB = new BookList(listOfBooks);
                                lOB.writeToFile(lOB, getApplicationContext());
                                restart();
                            }

                        });

                        row.addView(titleView);//adding both bits to table
                        row.addView(checkout);
                        displayBooks.addView(row);

                    }
                }
            };
            if(searchCondSelect.contains("Author")){
                for(int i=0;i<listOfBooks.size();i++) {//creating table

                    Book fill = listOfBooks.get(i);//iterating through books
                    TableRow row = new TableRow(this);//creating row
                    if (fill.checkedOut == false && fill.author.toLowerCase(Locale.ROOT).contains(search.toLowerCase(Locale.ROOT))){
                        String title = fill.title;//creating title view
                        TextView titleView = new TextView(this);
                        titleView.setText("" + title);

                        Button checkout = new Button(this);//creating checkout Buttons
                        checkout.setTag(fill);
                        checkout.setText("Checkout");
                        checkout.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                fill.checkedOut = true;//if button is pressed update field
                                fill.inPos = userN;
                                //update the file so it contains the book as checked out
                                BookList lOB = new BookList(listOfBooks);
                                lOB.writeToFile(lOB, getApplicationContext());
                                restart();
                            }

                        });

                        row.addView(titleView);//adding both bits to table
                        row.addView(checkout);
                        displayBooks.addView(row);

                    }
                }
            };
            if(searchCondSelect.contains("Genre")){
                for(int i=0;i<listOfBooks.size();i++) {//creating table

                    Book fill = listOfBooks.get(i);//iterating through books
                    TableRow row = new TableRow(this);//creating row
                    if (fill.checkedOut == false && fill.genre.toLowerCase(Locale.ROOT).contains(search.toLowerCase(Locale.ROOT))) {
                        String title = fill.title;//creating title view
                        TextView titleView = new TextView(this);
                        titleView.setText("" + title);

                        Button checkout = new Button(this);//creating checkout Buttons
                        checkout.setTag(fill);
                        checkout.setText("Checkout");
                        checkout.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                fill.checkedOut = true;//if button is pressed update field
                                fill.inPos = userN;
                                //update the file so it contains the book as checked out
                                BookList lOB = new BookList(listOfBooks);
                                lOB.writeToFile(lOB, getApplicationContext());
                                restart();
                            }

                        });

                        row.addView(titleView);//adding both bits to table
                        row.addView(checkout);
                        displayBooks.addView(row);

                    }
                }
            };

        };
    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }

    public void returnHome(View v){//return home button
        Intent intent= new Intent(this, UserMain.class);
        Bundle bundle= new Bundle();// placeholder for getting usernames
        bundle.putString("userN",userN);
        intent.putExtras(bundle);
        startActivity(intent);

    }

    //Restarts activity to show changes
    public void restart(){
        Intent intent = new Intent(this, Search.class);
        startActivity(intent); // start same activity
        finish(); // destroy older activity
        overridePendingTransition(0, 0);


    }

}