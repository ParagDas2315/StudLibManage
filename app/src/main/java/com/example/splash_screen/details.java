package com.example.splash_screen;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class details extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Button add;
    TextInputLayout name,rollno,area;
    String text;
    FirebaseDatabase fb;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Spinner spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.des,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        add = findViewById(R.id.adddatabutton);
        name = findViewById(R.id.username1text);
        rollno = findViewById(R.id.phoneno);
        area = findViewById(R.id.beatarea1);


        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                String name1 = name.getEditText().getText().toString();
                String roll = rollno.getEditText().getText().toString();
                String year = area.getEditText().getText().toString();
                String sp1 = spinner.getSelectedItem().toString();//value stored in sp1


                Log.d("CREATION", sp1);

                View selectedView = spinner.getSelectedView();
                TextView selectedTextView = null;
                if (selectedView != null && selectedView instanceof TextView) {
                    selectedTextView = (TextView) selectedView;
                    selectedTextView.setError("Please select a value");

                    if (!name1.isEmpty()) {
                        name.setError(null);
                        name.setErrorEnabled(false);
                        if (!roll.isEmpty()) {
                            rollno.setError(null);
                            rollno.setErrorEnabled(false);
                            if (!year.isEmpty()) {
                                area.setError(null);
                                area.setErrorEnabled(false);

                                fb = FirebaseDatabase.getInstance();
                                reference = fb.getReference("studentdetails");
                                String sp1_s = spinner.getSelectedItem().toString();
                                String name1_s = name.getEditText().getText().toString();
                                String roll_s = rollno.getEditText().getText().toString();
                                String year_s = area.getEditText().getText().toString();
                                Storingdata storingdatass = new Storingdata(sp1_s, name1_s, roll_s, year_s);
                                reference.child(roll_s).setValue(storingdatass);
                                Toast.makeText(getApplicationContext(), "Inserted Successfully", Toast.LENGTH_SHORT).show();
                                Intent numbersIntent = new Intent(details.this, dashboard.class);
                                startActivity(numbersIntent);
                                finish();
                            } else {
                                area.setError("Please enter the year");
                            }
                        } else {
                            rollno.setError("Please enter the year");
                        }
                    } else {
                        name.setError("Please enter the Student's name");
                    }
                } else {
                    selectedTextView.setError("Please select a Branch");
                }
            }
        });
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}