package com.example.splash_screen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;


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
                                      Intent numbersIntent = new Intent(dashboard.this, studsearch.class);
                                      startActivity(numbersIntent);
                                  }

                              }
        );

        RelativeLayout r4 = (RelativeLayout) findViewById(R.id.sr4);
        r4.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      Intent numbersIntent = new Intent(dashboard.this, booklist.class);
                                      startActivity(numbersIntent);
                                  }

                              }
        );
    }
}