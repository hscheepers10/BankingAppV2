package com.example.bankingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class balance extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.balance);

        dbHelper myDB;

        TextView name = (TextView)findViewById(R.id.nameTV);
        TextView surname = (TextView)findViewById(R.id.surnameTV);
        TextView cb = (TextView)findViewById(R.id.curBalTV);
        TextView sb = (TextView)findViewById(R.id.savBalTV);



    }

}