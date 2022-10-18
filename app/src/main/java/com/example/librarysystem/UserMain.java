package com.example.librarysystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class UserMain extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main);
    }

    public void myBooksUser (View v){
            Intent intent= new Intent(this, myBooksUser.class);
            startActivity(intent);
    }
    public void searchUser (View v){
        Intent intent= new Intent(this, Search.class);

        String key="user";
        Bundle bundle= new Bundle();// placeholder for getting usernames
        bundle.putString("key",key);
        intent.putExtras(bundle);


        startActivity(intent);
    }
    public void logout (View v){
        Intent intent=new Intent (this, login.class);
        startActivity(intent);
    }



}