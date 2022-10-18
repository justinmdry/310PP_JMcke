package com.example.librarysystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class AdminMain extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_view);

    }


    public void returns(View v){
        Intent intent= new Intent(this, returns.class);
        startActivity(intent);
    }
    public void manageBooks(View v){
        Intent intent= new Intent(this, ManageBooks.class);
        startActivity(intent);
    }
    public void logout (View v){
        Intent intent=new Intent (this, login.class);
        startActivity(intent);
    }
}