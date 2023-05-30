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

public class details extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Button add;
    TextInputLayout user,phone,area;
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
        user = findViewById(R.id.username1text);
        phone = findViewById(R.id.phoneno);
        area = findViewById(R.id.beatarea1);


        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                String user1 = user.getEditText().getText().toString();
                String p1 = phone.getEditText().getText().toString();
                String a1 = area.getEditText().getText().toString();
                String sp1 = spinner.getSelectedItem().toString();//value stored in sp1


                Log.d("CREATION", sp1);

                View selectedView = spinner.getSelectedView();
                TextView selectedTextView = null;
                if (selectedView != null && selectedView instanceof TextView) {
                    selectedTextView = (TextView) selectedView;
                    selectedTextView.setError("Please select a value");

                    if (!user1.isEmpty()) {
                        user.setError(null);
                        user.setErrorEnabled(false);
                        if (!p1.isEmpty()) {
                            phone.setError(null);
                            phone.setErrorEnabled(false);
                            if (!a1.isEmpty()) {
                                area.setError(null);
                                area.setErrorEnabled(false);

                                fb = FirebaseDatabase.getInstance();
                                reference = fb.getReference("policedetails");
                                String sp1_s = spinner.getSelectedItem().toString();
                                String user1_s = user.getEditText().getText().toString();
                                String p1_s = phone.getEditText().getText().toString();
                                String a1_s = area.getEditText().getText().toString();
                                Storingdata storingdatass = new Storingdata(sp1_s, user1_s, p1_s, a1_s);
                                reference.child(user1_s).setValue(storingdatass);
                                Toast.makeText(getApplicationContext(), "Insterted Successfully", Toast.LENGTH_SHORT).show();
                            } else {
                                area.setError("Please enter the year");
                            }
                        } else {
                            phone.setError("Please enter the year");
                        }
                    } else {
                        user.setError("Please enter the Student's name");
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