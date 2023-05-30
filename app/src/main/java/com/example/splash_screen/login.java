package com.example.splash_screen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.lang.reflect.Array;

public class login extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextInputLayout user, password, phone;
    String text;
    FirebaseDatabase fb;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Spinner spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.des, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        user = findViewById(R.id.username1text);
        password = findViewById(R.id.passwordtext);
        phone = findViewById(R.id.phoneno);


        Button b1 = this.findViewById(R.id.registerbutton);
        b1.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {

                                      String fullname = user.getEditText().getText().toString();
                                      String password_ = user.getEditText().getText().toString();
                                      String phone_ = user.getEditText().getText().toString();
                                      String sp1 = spinner.getSelectedItem().toString();

                                      View selectedView = spinner.getSelectedView();
                                      TextView selectedTextView = null;
                                      if (sp1 != null && selectedView instanceof TextView) {
                                          selectedTextView = (TextView) selectedView;
                                          if (!fullname.isEmpty()) {
                                              user.setError(null);
                                              user.setErrorEnabled(false);
                                              if (!password_.isEmpty()) {
                                                  password.setError(null);
                                                  password.setErrorEnabled(false);
                                                  if (!phone_.isEmpty()) {
                                                      phone.setError(null);
                                                      phone.setErrorEnabled(false);

                                                      fb = FirebaseDatabase.getInstance();
                                                      reference = fb.getReference("logindata");
                                                      String user_s = user.getEditText().getText().toString();
                                                      String password_s = password.getEditText().getText().toString();
                                                      String sp1s = spinner.getSelectedItem().toString();
                                                      String phone_s = phone.getEditText().getText().toString();

                                                      Storingdata storingdatass = new Storingdata();
                                                      storingdatass.loginregister(user_s,password_s,sp1s,phone_s);
                                                      reference.child(user_s).setValue(storingdatass);

                                                      Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_SHORT).show();

                                                      Intent numbersIntent = new Intent(login.this, dashboard.class);
                                                      startActivity(numbersIntent);
                                                      finish();

                                                  }else {
                                                      phone.setError("Please enter the phone number");
                                                  }

                                              }else {
                                                  password.setError("Please enter the password");
                                              }

                                          }else {
                                              user.setError("Please enter the username");
                                          }


                                      }else {
                                          selectedTextView.setError("Please choose from the options given");
                                      }

                                  }
                              }
        );

    }

        @Override
        public void onItemSelected (AdapterView < ? > parent, View view,int position, long l){
            String text = parent.getItemAtPosition(position).toString();
            Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNothingSelected (AdapterView < ? > adapterView){

        }
}
