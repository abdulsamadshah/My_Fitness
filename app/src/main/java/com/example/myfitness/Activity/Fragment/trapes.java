package com.example.myfitness.Activity.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myfitness.Activity.Adapters.categoryad;
import com.example.myfitness.Activity.Models.category;
import com.example.myfitness.R;
import com.example.myfitness.databinding.FragmentAbsBinding;
import com.example.myfitness.databinding.FragmentTrapesBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class trapes extends Fragment {

    FragmentTrapesBinding binding;
    ArrayList<category> categorylist;
    categoryad absadapters;
    FirebaseDatabase database;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding=FragmentTrapesBinding.inflate(getLayoutInflater(),container,false);




        database = FirebaseDatabase.getInstance();
        binding.trapesrv.setLayoutManager(new LinearLayoutManager(getContext()));
        categorylist = new ArrayList<>();
        absadapters = new categoryad(getContext(), categorylist);


        database.getReference().child("gymCategory").child("Trapes").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                categorylist.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    category modeldata = dataSnapshot.getValue(category.class);
                    categorylist.add(modeldata);


                }
                binding.trapesrv.setAdapter(absadapters);
                absadapters.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


        return binding.getRoot();
    }
}