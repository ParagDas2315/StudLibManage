package com.example.splash_screen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.util.Log;
import android.widget.EditText;
import android.text.TextUtils;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class govdetails extends AppCompatActivity {

    Button add;
    TextInputLayout ofname,loc,phone,incharge;
    String text;
    FirebaseDatabase fb;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_govdetails);


        add = findViewById(R.id.adddatabutton);
        ofname = findViewById(R.id.officename);
        loc = findViewById(R.id.location);
        phone = findViewById(R.id.phoneno);
        incharge = findViewById(R.id.officerincharge);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ofname_ = ofname.getEditText().getText().toString();
                String loc_ = loc.getEditText().getText().toString();
                String phone_ = phone.getEditText().getText().toString();
                String incharge_ = incharge.getEditText().getText().toString();


                if (!ofname_.isEmpty()) {
                    ofname.setError(null);
                    ofname.setErrorEnabled(false);
                    if (!loc_.isEmpty()) {
                        loc.setError(null);
                        loc.setErrorEnabled(false);
                        if (!phone_.isEmpty()) {
                            phone.setError(null);
                            phone.setErrorEnabled(false);
                            if (!incharge_.isEmpty()) {
                                incharge.setError(null);
                                incharge.setErrorEnabled(false);
                                fb = FirebaseDatabase.getInstance();
                                reference = fb.getReference("governmentoffices");

                                String ofname_s = ofname.getEditText().getText().toString();
                                String loc_s = loc.getEditText().getText().toString();
                                String phone_s = phone.getEditText().getText().toString();
                                String incharge_s = incharge.getEditText().getText().toString();
                                Storingdata storingdatass = new Storingdata();
                                storingdatass.gov(ofname_s, loc_s, phone_s, incharge_s);
                                reference.child(ofname_s).setValue(storingdatass);
                                Toast.makeText(getApplicationContext(), "Insterted Successfully", Toast.LENGTH_SHORT).show();
                            } else {
                                incharge.setError("Please enter the name of the officer incharge");
                            }
                        } else {
                            phone.setError("Please enter the office phone number of the officer incharge");
                        }

                    } else {
                        phone.setError("Please enter the office location");
                    }
                } else {
                    ofname.setError("Please enter the office name");
                }

            }

        });
    }




}

//govdetails