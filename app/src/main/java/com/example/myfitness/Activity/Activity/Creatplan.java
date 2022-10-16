package com.example.myfitness.Activity.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myfitness.Activity.Models.plan;
import com.example.myfitness.databinding.ActivityCreatplanBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Creatplan extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    ActivityCreatplanBinding createbinding;
    String[] creteplanarray = {"Abs", "Chest", "Biceps", "Legs", "Tryceps", "Forearm", "Back", "Calf", "Cardio", "Buttocks", "Shoulders", "Trapes",};
    ArrayAdapter adapter;
    FirebaseDatabase database;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createbinding = ActivityCreatplanBinding.inflate(getLayoutInflater());
        setContentView(createbinding.getRoot());
        database = FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();
        adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, creteplanarray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        createbinding.selectgoalsp.setAdapter(adapter);


        createbinding.selectgoalsp.setOnItemSelectedListener(this);

        createbinding.createnplan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (auth.getCurrentUser() != null) {
                    plan plans = new plan();
                    plans.setPname(createbinding.pname.getText().toString());
                    plans.setPdesc(createbinding.pdesc.getText().toString());
                    plans.setSgoal(createbinding.selectgoal.getText().toString());
                    plans.setDweek(createbinding.dweek.getText().toString());
                    plans.setPostId(FirebaseAuth.getInstance().getUid());

                    database.getReference().child("addplan").push().setValue(plans).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            if (task.isSuccessful()) {
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                            } else {
                                Log.d("perror", "plan not upload");
                            }

                        }
                    });

                } else {
                    Toast.makeText(Creatplan.this, "Sorry you are not login", Toast.LENGTH_SHORT).show();
                }


            }
        });


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if (i == 0) {
            createbinding.selectgoal.setText(creteplanarray[i]);
        } else if (i == 1) {
            createbinding.selectgoal.setText(creteplanarray[i]);
        } else if (i == 2) {
            createbinding.selectgoal.setText(creteplanarray[i]);
        } else if (i == 3) {
            createbinding.selectgoal.setText(creteplanarray[i]);
        } else if (i == 4) {
            createbinding.selectgoal.setText(creteplanarray[i]);
        } else if (i == 5) {
            createbinding.selectgoal.setText(creteplanarray[i]);
        } else if (i == 6) {
            createbinding.selectgoal.setText(creteplanarray[i]);
        } else if (i == 7) {
            createbinding.selectgoal.setText(creteplanarray[i]);
        } else if (i == 8) {
            createbinding.selectgoal.setText(creteplanarray[i]);
        } else if (i == 9) {
            createbinding.selectgoal.setText(creteplanarray[i]);
        } else if (i == 10) {
            createbinding.selectgoal.setText(creteplanarray[i]);
        } else if (i == 11) {
            createbinding.selectgoal.setText(creteplanarray[i]);
        } else if (i == 12) {
            createbinding.selectgoal.setText(creteplanarray[i]);
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}