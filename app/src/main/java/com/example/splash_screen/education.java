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

public class education extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Button add;
    TextInputLayout name,phone,loc,head1;
    String text;
    FirebaseDatabase fb;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education);

        Spinner spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.inst, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        Spinner spinner11 = findViewById(R.id.choose);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.choosing, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner11.setAdapter(adapter1);
        spinner11.setOnItemSelectedListener(this);

        add = findViewById(R.id.adddatabutton);
        name = findViewById(R.id.name);
        loc = findViewById(R.id.location);
        head1 = findViewById(R.id.head);
        phone = findViewById(R.id.phoneno);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name1 = name.getEditText().getText().toString();
                String loc1 = loc.getEditText().getText().toString();
                String h1 = head1.getEditText().getText().toString();
                String p1 = phone.getEditText().getText().toString();
                String sp1 = spinner.getSelectedItem().toString();//value stored in sp1
                String sp2 = spinner11.getSelectedItem().toString();//value stored in sp2


                View selectedView = spinner.getSelectedView();
                TextView selectedTextView = null;

                View selectedView1 = spinner11.getSelectedView();
                TextView selectedTextView1 = null;

                if (sp1 != null && selectedView instanceof TextView) {
                    selectedTextView = (TextView) selectedView;

                    if (sp2 != null && selectedView1 instanceof TextView) {
                        selectedTextView1 = (TextView) selectedView1;

                        if (!name1.isEmpty()) {
                            name.setError(null);
                            name.setErrorEnabled(false);
                            if (!loc1.isEmpty()) {
                                loc.setError(null);
                                loc.setErrorEnabled(false);
                                if (!h1.isEmpty()) {
                                    head1.setError(null);
                                    head1.setErrorEnabled(false);
                                    if (!p1.isEmpty()) {
                                        phone.setError(null);
                                        phone.setErrorEnabled(false);

                                        fb = FirebaseDatabase.getInstance();
                                        reference = fb.getReference("educationdetails");
                                        String name1s = name.getEditText().getText().toString();
                                        String loc1s = loc.getEditText().getText().toString();
                                        String h1s = head1.getEditText().getText().toString();
                                        String p1s = phone.getEditText().getText().toString();
                                        String sp1s = spinner.getSelectedItem().toString();//value stored in sp1
                                        String sp2s = spinner11.getSelectedItem().toString();//value stored in sp2
                                        Storingdata storingdatass = new Storingdata(sp1s, name1s, loc1s, h1s, p1s,sp2s);
                                        reference.child(name1s).setValue(storingdatass);
                                        Toast.makeText(getApplicationContext(), "Insterted Successfully", Toast.LENGTH_SHORT).show();
                                    } else {
                                        phone.setError("Please enter the phone number");
                                    }
                                } else {
                                    head1.setError("Please enter name");
                                }
                            } else {
                                loc.setError("Please enter the location of the institution");
                            }
                        } else {
                            name.setError("Please enter the name of the institution");
                        }
                    } else {
                        selectedTextView1.setError("Please choose from the options given");
                    }


                }else{
                    selectedTextView.setError("Please choose from the options given");
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