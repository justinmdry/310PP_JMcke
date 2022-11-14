package com.example.librarysystem;

import static com.example.librarysystem.login.ROB;
import static com.example.librarysystem.login.lOB;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class Report extends AppCompatActivity {
    ArrayList<ReportObj> listofreports;
    TableLayout displayreportView;//creating references

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        ROB=ROB.read(getApplicationContext()); //  BookList lOB = new BookList();
        listofreports = ROB.getReportList();
        if (ROB == null) {
            ROB = new ReportList();
        } else if (listofreports!=null) {
        listofreports = ROB.getReportList();
        displayreportView= (TableLayout) findViewById(R.id.tableviewrepo);//casting table




        for(int i=0;i<listofreports.size();i++) {//creating table

            ReportObj fill = listofreports.get(i);//iterating through books

            TableRow row = new TableRow(this);//creating row


            String title = fill.title;//creating title view
            String description = fill.description;//creating title view
            TextView titleView = new TextView(this);
            titleView.setText("" + title + ": " + description);

            Button checkout = new Button(this);//creating checkout Buttons
            checkout.setTag(fill);
            checkout.setText("Resolve");
            checkout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    //update the file so it contains the book as checked out
                    listofreports.remove(fill);
                    ReportList ROB = new ReportList(listofreports);
                    ROB.writeToFile(ROB, getApplicationContext());
                    reset();

                }


            });

            row.addView(titleView);//adding both bits to table
            row.addView(checkout);


            displayreportView.addView(row);
        }
            }



        }
        public void reset() {
            Intent intent = new Intent(this, Report.class);
            startActivity(intent); // start same activity
            finish(); // destroy older activity
            overridePendingTransition(0, 0);
    }

    public void home(View view){
        Intent intent = new Intent(this, AdminMain.class);
        startActivity(intent); // start same activity
        finish(); // destroy older activity
    }
    }



