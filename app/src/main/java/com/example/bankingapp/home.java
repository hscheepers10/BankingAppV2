package com.example.bankingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.strictmode.IntentReceiverLeakedViolation;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class home extends AppCompatActivity {
    private Button viewBtn,transBtn,logoutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        viewBtn = (Button)findViewById(R.id.viewBtn);
        viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewIntent = new Intent(home.this,balance.class);
                startActivity(viewIntent);
            }
        });

        transBtn = (Button)findViewById(R.id.transferBtn);
        transBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent transIntent = new Intent(home.this,transfer.class);
                startActivity(transIntent);
            }
        });

        logoutBtn = (Button)findViewById(R.id.logoutBtn);
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast logOutToast =Toast.makeText(getApplicationContext(),"Successfully logged out.  ",Toast.LENGTH_SHORT);
                logOutToast.show();
                finish();
            }
        });
    }
}