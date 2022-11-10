package com.example.librarysystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class UserMain extends AppCompatActivity {

    String userN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main);
        Bundle bundle = getIntent().getExtras();
        userN = bundle.getString("userName");
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }

    public void myBooksUser (View v){//button to access users book view
            Intent intent= new Intent(this, myBooksUser.class);
            Bundle bundle= new Bundle();// placeholder for getting usernames
            bundle.putString("userN",userN);
            intent.putExtras(bundle);
            startActivity(intent);
    }
    public void searchUser (View v){//button to access user search view
        Intent intent= new Intent(this, Search.class);

        Bundle bundle= new Bundle();// placeholder for getting usernames
        bundle.putString("userN",userN);
        intent.putExtras(bundle);


        startActivity(intent);
    }
    public void logout (View v){//logout button
        Intent intent=new Intent (this, login.class);
        startActivity(intent);
    }



}