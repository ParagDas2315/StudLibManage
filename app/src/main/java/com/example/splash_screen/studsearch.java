package com.example.splash_screen;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.splash_screen.databinding.ActivityStudsearchBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class studsearch extends AppCompatActivity {

    ActivityStudsearchBinding binding;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStudsearchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.readdataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String rollno = binding.studroll.getText().toString();
                if (!rollno.isEmpty()){

                    Storingdata(rollno);
                }else{

                    Toast.makeText(studsearch.this,"PLease Enter The Roll number",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    private void Storingdata(String rollno) {

        reference = FirebaseDatabase.getInstance().getReference("studentdetails");
        reference.child(rollno).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {

                if (task.isSuccessful()){

                    if (task.getResult().exists()){

                        Toast.makeText(studsearch.this,"Successfully Searched",Toast.LENGTH_SHORT).show();
                        DataSnapshot dataSnapshot = task.getResult();
                        String studname = String.valueOf(dataSnapshot.child("name").getValue());
                        String studroll = String.valueOf(dataSnapshot.child("rollno").getValue());
                        String dep = String.valueOf(dataSnapshot.child("department").getValue());
                        binding.studname1.setText(studname);
                        binding.studroll2.setText(studroll);
                        binding.tvdep.setText(dep);


                    }else {

                        Toast.makeText(studsearch.this,"Student Doesn't Exist",Toast.LENGTH_SHORT).show();

                    }


                }else {

                    Toast.makeText(studsearch.this,"Failed to Search",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}