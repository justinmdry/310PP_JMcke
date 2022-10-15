package com.example.librarysystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login(View v){
        EditText user=(EditText) findViewById(R.id.username);
        EditText pass=(EditText) findViewById(R.id.password);
        String userS=user.getText().toString();
        String passS=pass.getText().toString();

        if(userS.equals("user") && passS.equals("pass")){
            Intent intent= new Intent(this, UserMain.class);
            startActivity(intent);
        }
        if(userS.equals("admin") && passS.equals("pass")){
            Intent intent= new Intent(this, AdminMain.class);
            startActivity(intent);
        }
    }
}