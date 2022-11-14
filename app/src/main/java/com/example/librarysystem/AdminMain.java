package com.example.librarysystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class AdminMain extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_view);

    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }


    public void returns(View v){//button to open up returns
        Intent intent= new Intent(this, returns.class);
        startActivity(intent);
    }
    public void manageBooks(View v){//button to open up manageBooks
        Intent intent= new Intent(this, ManageBooks.class);
        startActivity(intent);
    }
    public void logout (View v){//button to logout
        Intent intent=new Intent (this, login.class);
        startActivity(intent);
    }

    public void report (View v){//button to logout
        Intent intent=new Intent (this, Report.class);
        startActivity(intent);
    }
}