package com.example.splash_screen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.database.FirebaseDatabase;

public class placesworship extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placesworship);
        FirebaseDatabase.getInstance().getReference().child("ProgrammingKnowledge").child("Android").setValue("abcd");


    }
}