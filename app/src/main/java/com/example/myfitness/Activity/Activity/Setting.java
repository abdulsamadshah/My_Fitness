package com.example.myfitness.Activity.Activity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myfitness.R;
import com.example.myfitness.databinding.ActivitySettingBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Locale;

public class Setting extends AppCompatActivity {

    ActivitySettingBinding binding;
    FirebaseDatabase database;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySettingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        windowtoptollbar();
        database = FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();



        LoadLocale();


        binding.languages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChanLanguage();
            }
        });

        binding.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plan");
                String sharebody = "Download the App now :" +
                        "https://MyFitness.com/";
                String sharesub = "Lets Get you Dream";

                shareIntent.putExtra(Intent.EXTRA_SUBJECT, sharesub);
                shareIntent.putExtra(Intent.EXTRA_TEXT, sharebody);

                startActivity(Intent.createChooser(shareIntent, "My Fitness"));
            }
        });

        binding.privacypolicys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                privacypolicy();

            }
        });

        binding.logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auth.signOut();
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private void privacypolicy() {

        Dialog dialog = new Dialog(Setting.this, R.style.genderd);
        dialog.setContentView(R.layout.privacypolicy);


        TextView policy;
        policy = dialog.findViewById(R.id.privacypolicydata);

//        policy.setOnClickListener(new View.OnClickListener() {
//              @Override
//              public void onClick(View view) {
//                  dialog.dismiss();
//              }
//          });

        dialog.show();
    }


    private void ChanLanguage() {
        final String language[] = {"English", "Hindi", "Marathi"};
        AlertDialog.Builder mbuilder = new AlertDialog.Builder(Setting.this);
        mbuilder.setTitle("Choose Language");
        mbuilder.setSingleChoiceItems(language, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                if (i == 0) {
                    setLocale("");
//                    requireContext();
                    recreate();
                } else if (i == 1) {
                    setLocale("hi");
//                    requireContext();
                    recreate();
                } else if (i == 2) {
                    setLocale("mr");
//                    requireContext();
                    recreate();
                }
            }
        });
        mbuilder.create();
        mbuilder.show();


    }


    private void setLocale(String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);

        Configuration configuration = new Configuration();
        configuration.locale = locale;
        getBaseContext().getResources().updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());

        SharedPreferences.Editor editor = this.getApplicationContext().getSharedPreferences("Setting", Context.MODE_PRIVATE).edit();
        editor.putString("app_lang", language);
        editor.apply();
    }


    private void LoadLocale() {
        SharedPreferences sharedPreferences = this.getApplicationContext().getSharedPreferences("Setting", Context.MODE_PRIVATE);
        String languagess = sharedPreferences.getString("app_lang", "");
        setLocale(languagess);
    }


    private void windowtoptollbar() {
        setSupportActionBar(binding.settingtb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = Setting.this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.tbcolor));

        }
    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }




}