package com.example.bankingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.BreakIterator;

import static com.example.bankingapp.R.id.content;
import static com.example.bankingapp.R.id.emailET;

public class login extends AppCompatActivity {

    private TextView here;
    private Button logInBtn;
//TEEEEEEEEEEEEEEEEEEEEEEEEEEEEEESSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSTTTTTTTTTTTTTTTTTTTTTTTTTTTTTIIIIIIIIIIIIIIIIIIIIIIIIIIIINNNNNNNNNNNNNNNNNNNNNNNNNNNGGGGGGGGGGGGGGGGGGGGGGGGGG
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        //On click listener for registration activity.
        here = (TextView)findViewById(R.id.regHereTV);
        here.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hereIntent = new Intent(login.this,register.class);
                startActivity(hereIntent);
            }
        });

        /////////////////////LOG IN BUTTON //////////////////////////
        logInBtn = (Button)findViewById(R.id.loginBtn);
        logInBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                EditText emailET = findViewById(R.id.emailET);
                EditText passwordET = findViewById(R.id.passwordET);

                String email = emailET.getText().toString().trim();
                String pswd = passwordET.getText().toString().trim();

                if (pswd.isEmpty() || email.isEmpty()){
                    Toast emptyToast = Toast.makeText(getApplicationContext(),"Empty fields",Toast.LENGTH_SHORT);
                    emptyToast.show();
                }

                //Validating password to be at least 5 characters long.
                else if (pswd.length()<5 || !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    Toast incorrectToast = Toast.makeText(getApplicationContext(),"incorrect fields",Toast.LENGTH_SHORT);
                    incorrectToast.show();
                }
                //TODO Validate username password.
                //    public boolean validate() {
//        boolean valid = true;
//
//        String email = emailET.getText().toString();
//        String password = passwordET.getText().toString();
//
//        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
//            emailET.setError("enter a valid email address");
//            valid = false;
//        } else {
//            emailET.setError(null);
//        }
//
//        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
//            passwordET.setError("between 4 and 10 alphanumeric characters");
//            valid = false;
//        } else {
//            passwordET.setError(null);
//        }
//
//        return valid;
//    }
                else{
                    //Intent.
                    Intent logInIntent = new Intent(login.this,home.class);
                    startActivity(logInIntent);

                    Toast loggedInToast = Toast.makeText(getApplicationContext(),"Successfully logged in",Toast.LENGTH_SHORT);
                    loggedInToast.show();
                    emailET.setText(null);
                    passwordET.setText(null);
                }
            }
        });
    }
}