package com.example.splash_screen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;

public class login1 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login1);

        TextInputLayout user,password;
        user = findViewById(R.id.username1text);
        password = findViewById(R.id.passwordtext);



        Button login = this.findViewById(R.id.loginbutton);
        login.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {
//                Intent numbersIntent = new Intent(login1.this, dashboard.class);
//                startActivity(numbersIntent);

                String user_ = user.getEditText().getText().toString();
                String password_ = password.getEditText().getText().toString();

                if(!user_.isEmpty()){
                    user.setError(null);
                    user.setErrorEnabled(false);
                    if(!password_.isEmpty()){
                        password.setError(null);
                        password.setErrorEnabled(false);

                        final String user_data = user.getEditText().getText().toString();
                        final String password_data = password.getEditText().getText().toString();

                        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
//                        ActivityReadDataBinding binding;
                        DatabaseReference databaseReference = firebaseDatabase.getReference("logindata");


                        Query check_user = databaseReference.orderByChild("username").equalTo(user_data);
                        check_user.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {

                                if(snapshot.exists()){
                                    user.setError(null);
                                    user.setErrorEnabled(false);
                                    String passwordcheck = snapshot.child(user_data).child("password").getValue(String.class);
                                    if(passwordcheck.equals(password_data)){
                                        password.setError(null);
                                        password.setErrorEnabled(false);

                                        String descheck = snapshot.child("designation").getValue(String.class);
                                        Toast.makeText(getApplicationContext(),"Login Successful",Toast.LENGTH_SHORT).show();
//                                        if(descheck.equals("BEAT OFFICER")){
//                                            Intent intent = new Intent(getApplicationContext(), dashboard1.class);
//                                            startActivity(intent);
//                                            finish();
//                                        }
//                                        else {
                                            Intent intent = new Intent(getApplicationContext(), dashboard.class);
                                            startActivity(intent);
                                            finish();
//                                        }
                                    }else {
                                        password.setError("Wrong Password");
                                    }

                                }else {
                                    user.setError("User does not exist");
                                }

                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });

                    }else {
                        password.setError("Please enter the password");
                    }
                }else {
                    user.setError("Please enter the username");
                }


            }

        }
        );



        TextView t1 = this.findViewById(R.id.signuptext);
        t1.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      Intent numbersIntent = new Intent(login1.this, login.class);
                                      startActivity(numbersIntent);
                                  }

                              }
        );








    }


}