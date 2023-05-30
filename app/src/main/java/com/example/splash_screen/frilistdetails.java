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

public class frilistdetails extends AppCompatActivity {

    Button add;
    TextInputLayout crno,acno,place,disposal;
    String text;
    FirebaseDatabase fb;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frilistdetails);


        add = findViewById(R.id.adddatabutton);
        crno = findViewById(R.id.crimeno);
        acno = findViewById(R.id.accusedname);
        place = findViewById(R.id.place);
        disposal = findViewById(R.id.disposal);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String crno_ = crno.getEditText().getText().toString();
                String acno_ = acno.getEditText().getText().toString();
                String place_ = place.getEditText().getText().toString();
                String incharge_ = disposal.getEditText().getText().toString();


                if (!crno_.isEmpty()) {
                    crno.setError(null);
                    crno.setErrorEnabled(false);
                    if (!acno_.isEmpty()) {
                        acno.setError(null);
                        acno.setErrorEnabled(false);
                        if (!place_.isEmpty()) {
                            place.setError(null);
                            place.setErrorEnabled(false);
                            if (!incharge_.isEmpty()) {
                                disposal.setError(null);
                                disposal.setErrorEnabled(false);
                                fb = FirebaseDatabase.getInstance();
                                reference = fb.getReference("FIR List");

                                String crno_s = crno.getEditText().getText().toString();
                                String acno_s = acno.getEditText().getText().toString();
                                String place_s = place.getEditText().getText().toString();
                                String disposal_s = disposal.getEditText().getText().toString();
                                Storingdata storingdatass = new Storingdata();
                                storingdatass.assign(crno_s,acno_s,place_s,disposal_s);
                                reference.child(crno_s).setValue(storingdatass);
                                Toast.makeText(getApplicationContext(), "Insterted Successfully", Toast.LENGTH_SHORT).show();
                            } else {
                                disposal.setError("Please enter the crime number");
                            }
                        } else {
                            place.setError("Please enter the accused name");
                        }

                    } else {
                        place.setError("Please enter the place");
                    }
                } else {
                    crno.setError("Please enter the disposal");
                }

            }

        });
    }




}
