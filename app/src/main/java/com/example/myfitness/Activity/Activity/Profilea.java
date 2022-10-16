package com.example.myfitness.Activity.Activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myfitness.Activity.Models.Users;
import com.example.myfitness.R;
import com.example.myfitness.databinding.ActivityProfileaBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.util.Calendar;
import java.util.Date;

public class Profilea extends AppCompatActivity {

    ActivityProfileaBinding binding;
    Uri imageuri;
    FirebaseDatabase database;
    FirebaseStorage storage;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        windowtoptollbar();
        database = FirebaseDatabase.getInstance();
        storage = FirebaseStorage.getInstance();
        auth=FirebaseAuth.getInstance();


        if (auth.getCurrentUser() !=null){
            fetchuserdata();
        }else{
            Toast.makeText(this, "not any user", Toast.LENGTH_SHORT).show();
        }



        binding.save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createuserdatabase();
            }
        });
        binding.genderc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gender();
            }
        });

        binding.dobc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dateofbirth();
            }
        });

        binding.userimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, 20);
            }
        });


    }


    private void createuserdatabase() {


        String emails=binding.email.getText().toString();
        String dob=binding.dob.getText().toString();
        auth.createUserWithEmailAndPassword(emails,dob).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {

                StorageReference reference = storage.getReference().child("Users").child(auth.getUid()).child(new Date().getTime() + "");

                reference.putFile(imageuri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                        reference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {

                                Users users = new Users();
                                users.setUserimg(uri.toString());
                                users.setName(binding.name.getText().toString());
                                users.setLastname(binding.lastname.getText().toString());
                                users.setDob(binding.dob.getText().toString());
                                users.setGender(binding.gender.getText().toString());
                                users.setUseremail(binding.email.getText().toString());
                                database.getReference().child("Users").child(auth.getUid()).setValue(users).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
//
                                            Toast.makeText(Profilea.this, "user create success", Toast.LENGTH_SHORT).show();
                                            fetchuserdata();
                                            binding.name.setFocusable(false);
                                        } else {
                                            Toast.makeText(Profilea.this, "error", Toast.LENGTH_SHORT).show();
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

    private void gender() {
        Dialog dialog = new Dialog(Profilea.this, R.style.genderd);
        dialog.setContentView(R.layout.genderlayout);


        RadioGroup radioGroup;
        radioGroup = dialog.findViewById(R.id.radioGroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                switch (i) {
                    case R.id.male:
                        binding.gender.setText("Male");
                        dialog.dismiss();
                        break;


                    case R.id.female:
                        binding.gender.setText("Female");
                        dialog.dismiss();
                        break;

                    case R.id.others:
                        binding.gender.setText("Others");
                        dialog.dismiss();
                        break;

                    default:
                        Toast.makeText(Profilea.this, "Please Select the Anyone", Toast.LENGTH_SHORT).show();
                        break;

                }
            }
        });


        dialog.show();

    }

    private void dateofbirth() {


        binding.dobc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendar = Calendar.getInstance();
                final int day = calendar.get(Calendar.DAY_OF_MONTH);
                final int month = calendar.get(Calendar.MONTH);
                final int year = calendar.get(Calendar.YEAR);

                DatePickerDialog datePickerDialog = new DatePickerDialog(Profilea.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayofmonth) {

                        binding.dob.setText(dayofmonth + "/" + (month + 1) + "/" + year);

                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });

    }

    private void windowtoptollbar() {
        setSupportActionBar(binding.profiletb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = Profilea.this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.tbcolor));

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            imageuri = data.getData();
            binding.userimg.setImageURI(imageuri);
        }
    }


    private void fetchuserdata() {
        database.getReference().child("Users").child(auth.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Users users = snapshot.getValue(Users.class);
                binding.name.setText(users.getName());
                binding.lastname.setText(users.getLastname());
                binding.email.setText(users.getUseremail());
                binding.dob.setText(users.getDob());
                binding.gender.setText(users.getGender());
                Picasso.get().load(users.getUserimg()).placeholder(R.drawable.profile).into(binding.userimg);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d("fetchdata", "fetchdatabase");
            }
        });
    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


}