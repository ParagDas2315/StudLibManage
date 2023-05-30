package com.example.splash_screen;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import  android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        RelativeLayout r1 = (RelativeLayout) findViewById(R.id.sr1);
        r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent numbersIntent = new Intent(dashboard.this, details.class);
                startActivity(numbersIntent);
            }

        }
        );

        RelativeLayout r3 = (RelativeLayout) findViewById(R.id.sr3);
        r3.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      Intent numbersIntent = new Intent(dashboard.this, educationalinstitutions.class);
                                      startActivity(numbersIntent);
                                  }

                              }
        );

        RelativeLayout r4 = (RelativeLayout) findViewById(R.id.sr4);
        r4.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      Intent numbersIntent = new Intent(dashboard.this, placesworship.class);
                                      startActivity(numbersIntent);
                                  }

                              }
        );
    }
}