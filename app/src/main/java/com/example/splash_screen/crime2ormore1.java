package com.example.splash_screen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import android.widget.Button;

import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class crime2ormore1 extends AppCompatActivity {

    Button add;
    TextInputLayout criminalname,address,phone,firdetails;
    String text;
    FirebaseDatabase fb;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime2ormore1);


        add = findViewById(R.id.adddatabutton);
        criminalname = findViewById(R.id.criminalname);
        address = findViewById(R.id.address);
        phone = findViewById(R.id.phoneno);
        firdetails = findViewById(R.id.firdetails);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String criminalname_ = criminalname.getEditText().getText().toString();
                String address_ = address.getEditText().getText().toString();
                String phone_ = phone.getEditText().getText().toString();
                String firdetails_ = firdetails.getEditText().getText().toString();


                if (!criminalname_.isEmpty()) {
                    criminalname.setError(null);
                    criminalname.setErrorEnabled(false);
                    if (!address_.isEmpty()) {
                        address.setError(null);
                        address.setErrorEnabled(false);
                        if (!phone_.isEmpty()) {
                            phone.setError(null);
                            phone.setErrorEnabled(false);
                            if (!firdetails_.isEmpty()) {
                                firdetails.setError(null);
                                firdetails.setErrorEnabled(false);
                                fb = FirebaseDatabase.getInstance();
                                reference = fb.getReference("List of Criminals having two or more involvement of Crime");

                                String criminalname_s = criminalname.getEditText().getText().toString();
                                String address_s = address.getEditText().getText().toString();
                                String phone_s = phone.getEditText().getText().toString();
                                String firdetails_s = firdetails.getEditText().getText().toString();
                                Storingdata storingdatass = new Storingdata();
                                storingdatass.crime2or(criminalname_s, address_s, phone_s, firdetails_s);
                                reference.child(criminalname_s).setValue(storingdatass);
                                Toast.makeText(getApplicationContext(), "Insterted Successfully", Toast.LENGTH_SHORT).show();
                            } else {
                                firdetails.setError("Please enter the FIR details");
                            }
                        } else {
                            phone.setError("Please enter the office phone number of the officer firdetails");
                        }

                    } else {
                        address.setError("Please enter the address of the criminal");
                    }
                } else {
                    criminalname.setError("Please enter the name of the criminal");
                }

            }

        });
    }




}

//govdetails