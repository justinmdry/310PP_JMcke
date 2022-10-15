package com.example.librarysystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Search extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
    }
    public void returnHome(View V){
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();

        String key=bundle.getString("key");
        if(key.equals("user")){
            Intent intentuser= new Intent(this, UserMain.class);
            startActivity(intentuser);
        }
        if(key.equals("admin")){
            Intent intentadmin= new Intent(this, AdminMain.class);
            startActivity(intentadmin);
        }
    }

}