package com.example.myfitness.Activity.Activity;

import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myfitness.R;
import com.example.myfitness.databinding.ActivityTipaboutBinding;
import com.squareup.picasso.Picasso;

public class tipabout extends AppCompatActivity {

    ActivityTipaboutBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTipaboutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        setContentView(binding.getRoot());
        windowtoptollbar();
        String images = getIntent().getStringExtra("nimage");
        Picasso.get().load(images).placeholder(R.drawable.profile).into(binding.nimage);
        binding.ntitle.setText(getIntent().getStringExtra("ntitles"));
        binding.ndescription.setText(getIntent().getStringExtra("ndesc"));


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    private void windowtoptollbar() {
        setSupportActionBar(binding.tipabouttb);
        binding.tipabouttb.setTitle(getIntent().getStringExtra("ntitles"));
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = tipabout.this.getWindow();
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