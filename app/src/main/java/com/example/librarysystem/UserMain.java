package com.example.librarysystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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
        Bundle bundle= new Bundle();
        bundle.putString("key",key);
        intent.putExtras(bundle);


        startActivity(intent);
    }

}