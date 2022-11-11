package com.example.librarysystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class book_Description extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_description);

        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();//getting descriptions

        TextView title= (TextView) findViewById(R.id.textView4);
        title.setText("Title: "+bundle.getString("title"));//set title

        TextView author=(TextView) findViewById(R.id.viewAuthor);
        author.setText("Author: "+bundle.getString("author"));//set genre

        TextView genre=(TextView) findViewById(R.id.viewGenre);
        genre.setText("Genre: "+bundle.getString("genre"));//set genre

        TextView description=(TextView) findViewById(R.id.viewDescription);
        description.setText("Description: "+bundle.getString("description"));//set description
    }
    public void returnHomeSearch(View v){//return home button
        finish();
    }
}