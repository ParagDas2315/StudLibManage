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

public class touristguidesdetails extends AppCompatActivity {

    Button add;
    TextInputLayout name,phone,local,nativea;
    String text;
    FirebaseDatabase fb;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touristguidesdetails);


        add = findViewById(R.id.adddatabutton);
        name = findViewById(R.id.guidename);
        phone = findViewById(R.id.phoneno);
        local = findViewById(R.id.localaddress);
        nativea = findViewById(R.id.nativeaddress);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name_ = name.getEditText().getText().toString();
                String phone_ = phone.getEditText().getText().toString();
                String local_ = local.getEditText().getText().toString();
                String nativea_ = nativea.getEditText().getText().toString();


                if (!name_.isEmpty()) {
                    name.setError(null);
                    name.setErrorEnabled(false);
                    if (!phone_.isEmpty()) {
                        phone.setError(null);
                        phone.setErrorEnabled(false);
                        if (!local_.isEmpty()) {
                            local.setError(null);
                            local.setErrorEnabled(false);

                            if (!nativea_.isEmpty()) {
                                nativea.setError(null);
                                nativea.setErrorEnabled(false);
                                fb = FirebaseDatabase.getInstance();
                                reference = fb.getReference("Tourist Guide");

                                String name_s = name.getEditText().getText().toString();
                                String phone_s = phone.getEditText().getText().toString();
                                String local_s = local.getEditText().getText().toString();
                                String nativea_s = nativea.getEditText().getText().toString();
                                Storingdata storingdatass = new Storingdata();
                                storingdatass.tourist(name_s, local_s, phone_s, nativea_s);
                                reference.child(name_s).setValue(storingdatass);
                                Toast.makeText(getApplicationContext(), "Insterted Successfully", Toast.LENGTH_SHORT).show();
                            } else {
                                nativea.setError("Please enter the Native address");
                            }
                        } else {
                            local.setError("Please enter the Local address");
                        }
                    } else {
                        phone.setError("Please enter the phone number");
                    }
                } else {
                    name.setError("Please enter the name of the Tourist Guide");
                }

            }

        });
    }




}
