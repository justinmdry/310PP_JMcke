package com.example.librarysystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class returns extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_returns);





        ///////////////////////////////////////CLASS NOT IMPLEMENTED////////////////////////////////////////
    }



    public void returnHome(View V){//return home button
        Intent intent= new Intent(this, AdminMain.class);
        startActivity(intent);
    }
}