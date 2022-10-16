package com.example.myfitness.Activity.Fragment;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.myfitness.Activity.Activity.Profilea;
import com.example.myfitness.Activity.Adapters.mainAd;
import com.example.myfitness.Activity.Models.Users;
import com.example.myfitness.Activity.Models.main;
import com.example.myfitness.R;
import com.example.myfitness.databinding.FragmentHomeBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.messaging.FirebaseMessaging;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class Home extends Fragment {
    FragmentHomeBinding binding;
    ArrayList<main> mainAdArrayList;
    mainAd mainAdapters;
    ActionBarDrawerToggle toggle;
    FirebaseDatabase database;
    FirebaseAuth auth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentHomeBinding.inflate(getLayoutInflater(), container, false);
        windowtoptollbar();
        database = FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();
        notification();

        binding.mainrv.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        mainAdArrayList = new ArrayList<>();
        mainAdArrayList.add(new main(R.drawable.chestmain));
        mainAdArrayList.add(new main(R.drawable.bicepsmain));
        mainAdArrayList.add(new main(R.drawable.legmain));
        mainAdArrayList.add(new main(R.drawable.absmain));
        mainAdArrayList.add(new main(R.drawable.tricepsmain));
        mainAdArrayList.add(new main(R.drawable.forearmsmain));
        mainAdArrayList.add(new main(R.drawable.bacmain));
        mainAdArrayList.add(new main(R.drawable.calfmain));
        mainAdArrayList.add(new main(R.drawable.cardiomain));
        mainAdArrayList.add(new main(R.drawable.buttocksman));
        mainAdArrayList.add(new main(R.drawable.shouldermain));
        mainAdArrayList.add(new main(R.drawable.trapesmain));

        mainAdapters = new mainAd(getActivity(), mainAdArrayList);
        binding.mainrv.setAdapter(mainAdapters);


        if (auth.getCurrentUser() != null) {
            database.getReference().child("Users").child(auth.getUid()).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    Users users = snapshot.getValue(Users.class);
                    Picasso.get().load(users.getUserimg()).placeholder(R.drawable.profile).into(binding.profile);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });

        } else {
            Toast.makeText(getActivity(), "no user", Toast.LENGTH_SHORT).show();
//            Toast.makeText(this, "some error", Toast.LENGTH_SHORT).show();
        }
        binding.profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Profilea.class);
                startActivity(intent);
            }
        });


        return binding.getRoot();

    }


    private void windowtoptollbar() {
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(binding.toolbar);
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getActivity().getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.tbcolor));
        }
    }


    public void notification() {
        FirebaseMessaging.getInstance().subscribeToTopic("weather").addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                String msg = "Done";
                if (!task.isSuccessful()) {
                    msg = "failed";
                }
                Log.d(TAG, msg);
            }
        });
    }


}