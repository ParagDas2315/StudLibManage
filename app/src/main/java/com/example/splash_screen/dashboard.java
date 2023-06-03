package com.example.splash_screen;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import org.checkerframework.checker.nullness.qual.NonNull;


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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_scrolling,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.logout)
        {
            startActivity(new Intent(dashboard.this, login1.class));
        }


        return super.onOptionsItemSelected(item);
    }
}

