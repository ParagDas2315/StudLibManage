package com.example.splash_screen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class educationalinstitutions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_educationalinstitutions);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(v -> {
            Intent numbersIntent = new Intent(educationalinstitutions.this,education.class);
            startActivity(numbersIntent);
        }
        );





    }
}
