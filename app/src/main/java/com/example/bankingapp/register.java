package com.example.bankingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class register extends AppCompatActivity {

    private TextView here;
    private Button createAcc;
    private RadioGroup radGroup1;
    private RadioButton radioButton1;

    //DB Helper
    dbHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        myDB = new dbHelper(this);

        /////////////HERE ACTIVITY /////////////////
        //Simply returns the user to the login page.
        here = (TextView) findViewById(R.id.logHereTV);
        here.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //////////////REGISTER ACTIVITY ////////////
        createAcc = (Button) findViewById(R.id.createAccBtn);
        radGroup1 = (RadioGroup)findViewById(R.id.radGroup);
        createAcc.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                //Finding variables from XML Names.
                EditText emailEt = findViewById(R.id.eMailRegET);
                EditText fNameEt = findViewById(R.id.fNameET);
                EditText lNameEt = findViewById(R.id.lNameET4);
                EditText passwordEt = findViewById(R.id.passwordRegET);
                EditText mobileEt = findViewById(R.id.mobileET);

                //Declaring variables, getting text,  and parsing to string.
                String emailReg = emailEt.getText().toString().trim();
                String fName = fNameEt.getText().toString().trim();
                String lName = lNameEt.getText().toString().trim();
                String passwordReg = passwordEt.getText().toString().trim();
                String mobile = mobileEt.getText().toString().trim();

                //RadioButton being a nuisance.
                int radGrpId = radGroup1.getCheckedRadioButtonId();
                radioButton1 = (RadioButton)findViewById(radGrpId);

                //

                //Validation
                //Fields are tested as to not be empty.
                if (passwordReg.isEmpty() || emailReg.isEmpty() || fName.isEmpty() || lName.isEmpty() || mobile.isEmpty()){
                    Toast emptyToast = Toast.makeText(getApplicationContext(),"Please enter all of the fields to register! ",Toast.LENGTH_SHORT);
                    emptyToast.show();
                }

                //The mobile number EditText is automatically checked for numbers only data because
                    //the "mobileET" EditText in "register.xml" file is set to number.
                //Email address is checked by the Patterns matcher class.
                //And Password should be more that 5 characters.
                //The password is automatically hidden due to it being set to hidden in xml.
                else if (passwordReg.length()<5 || !Patterns.EMAIL_ADDRESS.matcher(emailReg).matches()){
                    Toast incorrectToast = Toast.makeText(getApplicationContext(),"incorrect fields",Toast.LENGTH_SHORT);
                    incorrectToast.show();
                }

                //TODO Check if email is already registered.

                else{

                    //TODO use SQLite helper class to create a user in the Database.
                    //Create account on SQLite. //Create two variables used to store values for current account and savings account.

                    //Check if email isn't already registered.

                    //Intent. finishes the activity if successful.
                    finish();

                    //TODO create variables for (i) currentAcc and (ii) savingsAccount and insert any amount of money into each.

                    //Toast.
                    Toast createdToast = Toast.makeText(getApplicationContext(),"User Account successfully created.  xD",Toast.LENGTH_SHORT);
                    createdToast.show();  //To be removed upon implementing DB.
                }
                //Calling myDB instance of addData class in dbHelper class.
//                myDB.addData(emailReg,fName, lName,passwordReg,mobile);
            }
        });
    }
}