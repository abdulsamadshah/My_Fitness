package com.example.myfitness.Activity.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.myfitness.Activity.Activity.Profilea;
import com.example.myfitness.Activity.Activity.Setting;
import com.example.myfitness.databinding.FragmentMoreBinding;

public class more extends Fragment {

    FragmentMoreBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentMoreBinding.inflate(getLayoutInflater(), container, false);


        binding.profiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), Profilea.class);
                startActivity(intent);
            }
        });

        binding.settins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), Setting.class);
                startActivity(intent);
            }
        });

        return binding.getRoot();
    }

}