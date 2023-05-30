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

public class dancingschoolsdetails extends AppCompatActivity {

    Button add;
    TextInputLayout ename,eaddress,oname,phone,oaddress;
    String text;
    FirebaseDatabase fb;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dancingschoolsdetails);


        add = findViewById(R.id.adddatabutton);
        ename = findViewById(R.id.nameofestablishment);
        oname = findViewById(R.id.ownername);
        eaddress = findViewById(R.id.address);
        phone = findViewById(R.id.phoneno);
        oaddress = findViewById(R.id.owneraddress);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ename_ = ename.getEditText().getText().toString();
                String eaddress_ = eaddress.getEditText().getText().toString();
                String oname_ = oname.getEditText().getText().toString();
                String phone_ = phone.getEditText().getText().toString();
                String oaddress_ = oaddress.getEditText().getText().toString();


                if (!ename_.isEmpty()) {
                    ename.setError(null);
                    ename.setErrorEnabled(false);
                    if (!eaddress_.isEmpty()) {
                        eaddress.setError(null);
                        eaddress.setErrorEnabled(false);
                        if (!oname_.isEmpty()) {
                            oname.setError(null);
                            oname.setErrorEnabled(false);
                            if (!phone_.isEmpty()) {
                                phone.setError(null);
                                phone.setErrorEnabled(false);
                                if (!oaddress_.isEmpty()) {
                                    oaddress.setError(null);
                                    oaddress.setErrorEnabled(false);
                                    fb = FirebaseDatabase.getInstance();
                                    reference = fb.getReference("Dancing School");

                                    String ename_s = ename.getEditText().getText().toString();
                                    String eaddress_s = eaddress.getEditText().getText().toString();
                                    String oname_s = oname.getEditText().getText().toString();
                                    String phone_s = phone.getEditText().getText().toString();
                                    String oaddress_s = oaddress.getEditText().getText().toString();
                                    Storingdata storingdatass = new Storingdata();
                                    storingdatass.dancing(ename_s, eaddress_s, oname_s,  phone_s, oaddress_s);
                                    reference.child(ename_s).setValue(storingdatass);
                                    Toast.makeText(getApplicationContext(), "Insterted Successfully", Toast.LENGTH_SHORT).show();
                            } else {
                                oaddress.setError("Please enter the Owners' address");
                            }
                        } else {
                            phone.setError("Please enter the phone number of the Owner");
                        }

                    } else {
                        phone.setError("Please enter the Owners' name");
                    }
                } else {
                    ename.setError("Please enter the Establishment address");
                }
                } else {
                    ename.setError("Please enter the Establishment name");
                }

            }

        });
    }




}
