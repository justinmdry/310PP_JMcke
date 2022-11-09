package com.example.librarysystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class returns extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_returns);





        ///////////////////////////////////////CLASS NOT IMPLEMENTED////////////////////////////////////////
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }

    public void returnHome(View V){//return home button
        Intent intent= new Intent(this, AdminMain.class);
        startActivity(intent);
    }
}