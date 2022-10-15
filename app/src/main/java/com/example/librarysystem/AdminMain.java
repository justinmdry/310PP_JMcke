package com.example.librarysystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AdminMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_view);
    }


    public void myBooksAdmin(View v){
        Intent intent= new Intent(this, myBooksAdmin.class);
        startActivity(intent);
    }
    public void searchAdmin(View v){
        Intent intent= new Intent(this, Search.class);

        String key="admin";
        Bundle bundle= new Bundle();
        bundle.putString("key",key);
        intent.putExtras(bundle);

        startActivity(intent);

    }
}