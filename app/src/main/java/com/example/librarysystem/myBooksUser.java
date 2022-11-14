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

        Intent intent=getIntent();

        Bundle bundle = getIntent().getExtras();
        String userN = bundle.getString("userN");


        for(int i=0;i<listOfBooksUserView.size();i++){//creating table

            Book fill=listOfBooksUserView.get(i);//iterating through books

            TableRow row=new TableRow(this);//creating row

            if(fill.checkedOut==true && userN.compareTo(fill.inPos) == 0){
                String title=fill.title;//creating title view
                TextView titleView=new TextView(this);
                titleView.setText(""+title);

                Button report=new Button(this);//creating checkout Buttons
                report.setTag(fill);
                report.setText("Report");
                report.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Bundle bundle= new Bundle();// placeholder for getting usernames
                        bundle.putString("userN", userN);
                        bundle.putString("title", title);

                        Intent intent2= new Intent(view.getContext(), User_report.class);
                        intent2.putExtras(bundle);
                        startActivity(intent2);
                    }
                });

                Button checkout=new Button(this);//creating checkout Buttons
                checkout.setTag(fill);
                checkout.setText("Return");
                checkout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        fill.checkedOut=false;//change value if button is pressed
                        fill.inPos = null;
                        //update the file so it contains the book as checked out
                        BookList lOB = new BookList(listOfBooksUserView);
                        lOB.writeToFile(lOB,getApplicationContext());
                        restart();
                    }
                });

                row.addView(titleView);//adding both bits to table
                row.addView(checkout);
                row.addView(report);

                displayBooksUserView.addView(row);

           }


        }
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }

    public void returnHome(View V){//return home button
        Bundle bundle1 = getIntent().getExtras();
        String userN = bundle1.getString("userN");

        Intent intent= new Intent(this, UserMain.class);
        Bundle bundle= new Bundle();// placeholder for getting usernames
        bundle.putString("userN",userN);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    //Restarts activity to show changes
    public void restart(){
        Bundle bundle1 = getIntent().getExtras();
        String userN = bundle1.getString("userN");

        Intent intent = new Intent(this, myBooksUser.class);
        Bundle bundle= new Bundle();// placeholder for getting usernames
        bundle.putString("userN",userN);
        intent.putExtras(bundle);
        startActivity(intent); // start same activity
        finish(); // destroy older activity
        overridePendingTransition(0, 0);


    }
}