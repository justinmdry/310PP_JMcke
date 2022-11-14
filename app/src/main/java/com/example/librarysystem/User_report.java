package com.example.librarysystem;

import static com.example.librarysystem.login.ROB;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.pranavpandey.android.dynamic.toasts.DynamicToast;
import java.util.ArrayList;

public class User_report extends AppCompatActivity {
    String title;
    String userN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_report);

        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();//getting user Key
        userN = bundle.getString("userN");


        title = bundle.getString("title");
        TextView textView = (TextView) findViewById(R.id.textView7);
        textView.setText(title);
    }

    public void submitBtn (View view) {
        EditText editText = (EditText) findViewById(R.id.editTextTextMultiLine2);
        String description = editText.getText().toString();
        if (description.isEmpty()){
            DynamicToast.makeWarning(getApplicationContext(), "Please enter a description").show();
        } else {
            ROB.read(getApplicationContext());
            ArrayList<ReportObj> list;
            list = ROB.getReportList();
            if (list == null || list.isEmpty()){
                list = new ArrayList<ReportObj>();
            }
            list.add(new ReportObj(title, description));
            ROB = new ReportList(list);
            ROB.writeToFile(ROB, getApplicationContext());

        }
        DynamicToast.makeWarning(getApplicationContext(), "Report submitted").show();
        Intent intent= new Intent(this, myBooksUser.class);
        Bundle bundle= new Bundle();// placeholder for getting usernames
        bundle.putString("userN",userN);
        intent.putExtras(bundle);
        startActivity(intent);
        finish();

    }

}