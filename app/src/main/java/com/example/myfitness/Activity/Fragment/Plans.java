package com.example.myfitness.Activity.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.myfitness.Activity.Activity.Creatplan;
import com.example.myfitness.Activity.Adapters.plansadapter;
import com.example.myfitness.Activity.Models.plan;
import com.example.myfitness.databinding.FragmentPlansBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Plans extends Fragment {

    FragmentPlansBinding binding;
    plansadapter plansadapters;
    ArrayList<plan> planArrayListdata;
    FirebaseDatabase database;
    FirebaseAuth auth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentPlansBinding.inflate(getLayoutInflater(), container, false);

        database = FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();
        binding.createplan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Creatplan.class);
                startActivity(intent);
            }
        });


        planArrayListdata = new ArrayList<>();
        binding.planrv.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        plansadapters = new plansadapter(getActivity(), planArrayListdata);


        //authenticate use fetch karne ke liye auth.getuid nahi likhne ka

        if (auth.getCurrentUser() != null) {
            database.getReference().child("addplan").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {

                    binding.shimmer.stopShimmer();
                    binding.shimmer.setVisibility(View.GONE);
                    binding.planrv.setVisibility(View.VISIBLE);

                    planArrayListdata.clear();
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        plan plans = dataSnapshot.getValue(plan.class);
                        planArrayListdata.add(plans);

                    }
                    binding.planrv.setAdapter(plansadapters);
                    plansadapters.notifyDataSetChanged();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });

        } else {
            Toast.makeText(getContext(), "not any plans", Toast.LENGTH_SHORT).show();
        }


        return binding.getRoot();

    }
}