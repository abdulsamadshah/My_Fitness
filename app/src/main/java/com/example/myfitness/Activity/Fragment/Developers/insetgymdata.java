package com.example.myfitness.Activity.Fragment.Developers;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import com.example.myfitness.Activity.Activity.MainActivity;
import com.example.myfitness.Activity.Models.category;
import com.example.myfitness.databinding.ActivityInsetgymdataBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.Date;

public class insetgymdata extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    FirebaseAuth auth;
    FirebaseStorage storage;
    FirebaseDatabase database;
    Uri categoryimagesuri;
    String[] coursecategory = {"Abs", "Chest", "Biceps", "Legs", "Tryceps", "Forearm", "Back", "Calf", "Cardio", "Buttocks", "Shoulders", "Trapes",};
    ArrayAdapter adapter;
    ActivityInsetgymdataBinding binding;
    Uri videouri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInsetgymdataBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        storage = FirebaseStorage.getInstance();

        adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item, coursecategory);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.categoryselect.setAdapter(adapter);
        binding.categoryselect.setOnItemSelectedListener(this);


        binding.cimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, 5);
            }
        });

        binding.video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("video/*");
                startActivityForResult(intent, 10);
            }
        });


        binding.submitdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StorageReference reference = storage.getReference().child("Category").
                        child(new Date().getTime() + "");

                reference.putFile(categoryimagesuri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        reference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                category model = new category();
                                model.setCimg(uri.toString());
                                model.setCname(binding.imgname.getText().toString());
                                model.setSeconddescription(binding.seconddescription.getText().toString());
                                model.setCvideo(uri.toString());

                                model.setCdescription(binding.description.getText().toString());
                                model.setSubdescriptions(binding.subdescription.getText().toString());



                                String categorynamedata = binding.categoryname.getText().toString();
                                database.getReference().child("gymCategory").child(categorynamedata).push().setValue(model)
                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if (task.isSuccessful()) {
                                                    String id = database.getReference().child("gymCategory").child(categorynamedata).push().getKey();
                                                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                                    intent.putExtra("id", id);
                                                    startActivity(intent);
                                                    Toast.makeText(insetgymdata.this, "data create successfully", Toast.LENGTH_SHORT).show();
                                                } else {
                                                    Toast.makeText(insetgymdata.this, "errors now", Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                        });

                            }
                        });
                    }
                });
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 5) {
            categoryimagesuri = data.getData();
            binding.cimage.setImageURI(categoryimagesuri);
        } else {
            if (requestCode == 10) {
                videouri = data.getData();
                binding.video.setVideoURI(videouri);
                binding.video.start();

                StorageReference storageReference = storage.getReference().child("gymvideo").child(new Date().getTime() + "");

                storageReference.putFile(videouri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        storageReference.getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                            @Override
                            public void onComplete(@NonNull Task<Uri> task) {
                                Toast.makeText(insetgymdata.this, "video uploaded successfuly", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });

            }
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        if (position == 0) {
            binding.categoryname.setText(coursecategory[position]);
        } else if (position == 1) {
            binding.categoryname.setText(coursecategory[position]);
        } else if (position == 2) {
            binding.categoryname.setText(coursecategory[position]);
        } else if (position == 3) {
            binding.categoryname.setText(coursecategory[position]);
        } else if (position == 4) {
            binding.categoryname.setText(coursecategory[position]);
        } else if (position == 5) {
            binding.categoryname.setText(coursecategory[position]);
        } else if (position == 6) {
            binding.categoryname.setText(coursecategory[position]);
        } else if (position == 7) {
            binding.categoryname.setText(coursecategory[position]);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}