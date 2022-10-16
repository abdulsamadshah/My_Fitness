package com.example.myfitness.Activity.Activity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.myfitness.Activity.Adapters.categoryad;
import com.example.myfitness.Activity.Fragment.Abs;
import com.example.myfitness.Activity.Fragment.Cardios;
import com.example.myfitness.Activity.Fragment.Forarms;
import com.example.myfitness.Activity.Fragment.backf;
import com.example.myfitness.Activity.Fragment.biceps;
import com.example.myfitness.Activity.Fragment.buttocks;
import com.example.myfitness.Activity.Fragment.calf;
import com.example.myfitness.Activity.Fragment.chest;
import com.example.myfitness.Activity.Fragment.leg;
import com.example.myfitness.Activity.Fragment.shoulder;
import com.example.myfitness.Activity.Fragment.trapes;
import com.example.myfitness.Activity.Fragment.triceps;
import com.example.myfitness.Activity.Models.category;
import com.example.myfitness.R;
import com.example.myfitness.databinding.ActivityExmainBinding;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class exmain extends AppCompatActivity implements View.OnClickListener {

    ActivityExmainBinding binding;
    ArrayList<category> categorylist;
    categoryad absadapters;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityExmainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        windowtoptollbar();
        Abs abss = new Abs();
        replacefragment(abss);


    }

    private void windowtoptollbar() {
        setSupportActionBar(binding.abstoolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = exmain.this.getWindow();
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


    public void replacefragment(Fragment fragment) {

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.mycontainer, fragment);
        transaction.commit();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.abs:
                binding.abs.setBackground(getResources().getDrawable(R.drawable.selected));
                binding.abs.setTextColor(getResources().getColor(R.color.white));
                binding.biceps.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.biceps.setTextColor(getResources().getColor(R.color.black));
                binding.cardio.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.cardio.setTextColor(getResources().getColor(R.color.black));
                binding.tryceps.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.tryceps.setTextColor(getResources().getColor(R.color.black));
                binding.trapes.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.trapes.setTextColor(getResources().getColor(R.color.black));
                binding.leg.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.leg.setTextColor(getResources().getColor(R.color.black));
                binding.shoulder.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.shoulder.setTextColor(getResources().getColor(R.color.black));
                binding.back.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.back.setTextColor(getResources().getColor(R.color.black));
                binding.forarms.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.forarms.setTextColor(getResources().getColor(R.color.black));
                binding.chest.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.chest.setTextColor(getResources().getColor(R.color.black));
                binding.calf.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.calf.setTextColor(getResources().getColor(R.color.black));
                binding.buttocks.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.buttocks.setTextColor(getResources().getColor(R.color.black));
                Abs abss = new Abs();
                replacefragment(abss);

                break;

            case R.id.biceps:
                binding.biceps.setBackground(getResources().getDrawable(R.drawable.selected));
                binding.biceps.setTextColor(getResources().getColor(R.color.white));
                binding.abs.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.abs.setTextColor(getResources().getColor(R.color.black));
                binding.cardio.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.cardio.setTextColor(getResources().getColor(R.color.black));
                binding.tryceps.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.tryceps.setTextColor(getResources().getColor(R.color.black));
                binding.trapes.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.trapes.setTextColor(getResources().getColor(R.color.black));
                binding.leg.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.leg.setTextColor(getResources().getColor(R.color.black));
                binding.shoulder.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.shoulder.setTextColor(getResources().getColor(R.color.black));
                binding.back.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.back.setTextColor(getResources().getColor(R.color.black));
                binding.forarms.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.forarms.setTextColor(getResources().getColor(R.color.black));
                binding.chest.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.chest.setTextColor(getResources().getColor(R.color.black));
                binding.calf.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.calf.setTextColor(getResources().getColor(R.color.black));
                binding.buttocks.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.buttocks.setTextColor(getResources().getColor(R.color.black));
                biceps bicepss = new biceps();
                replacefragment(bicepss);
                break;

            case R.id.cardio:
                binding.cardio.setBackground(getResources().getDrawable(R.drawable.selected));
                binding.cardio.setTextColor(getResources().getColor(R.color.white));
                binding.abs.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.abs.setTextColor(getResources().getColor(R.color.black));
                binding.biceps.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.biceps.setTextColor(getResources().getColor(R.color.black));
                binding.tryceps.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.tryceps.setTextColor(getResources().getColor(R.color.black));
                binding.trapes.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.trapes.setTextColor(getResources().getColor(R.color.black));
                binding.leg.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.leg.setTextColor(getResources().getColor(R.color.black));
                binding.shoulder.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.shoulder.setTextColor(getResources().getColor(R.color.black));
                binding.back.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.back.setTextColor(getResources().getColor(R.color.black));
                binding.forarms.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.forarms.setTextColor(getResources().getColor(R.color.black));
                binding.chest.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.chest.setTextColor(getResources().getColor(R.color.black));
                binding.calf.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.calf.setTextColor(getResources().getColor(R.color.black));
                binding.buttocks.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.buttocks.setTextColor(getResources().getColor(R.color.black));
                Cardios cardioss = new Cardios();
                replacefragment(cardioss);
                break;


            case R.id.tryceps:
                binding.tryceps.setBackground(getResources().getDrawable(R.drawable.selected));
                binding.tryceps.setTextColor(getResources().getColor(R.color.white));
                binding.abs.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.abs.setTextColor(getResources().getColor(R.color.black));
                binding.biceps.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.biceps.setTextColor(getResources().getColor(R.color.black));
                binding.cardio.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.cardio.setTextColor(getResources().getColor(R.color.black));
                binding.trapes.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.trapes.setTextColor(getResources().getColor(R.color.black));
                binding.leg.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.leg.setTextColor(getResources().getColor(R.color.black));
                binding.shoulder.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.shoulder.setTextColor(getResources().getColor(R.color.black));
                binding.back.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.back.setTextColor(getResources().getColor(R.color.black));
                binding.forarms.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.forarms.setTextColor(getResources().getColor(R.color.black));
                binding.chest.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.chest.setTextColor(getResources().getColor(R.color.black));
                binding.calf.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.calf.setTextColor(getResources().getColor(R.color.black));
                binding.buttocks.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.buttocks.setTextColor(getResources().getColor(R.color.black));
                triceps tricepss = new triceps();
                replacefragment(tricepss);
                break;


            case R.id.trapes:
                binding.trapes.setBackground(getResources().getDrawable(R.drawable.selected));
                binding.trapes.setTextColor(getResources().getColor(R.color.white));
                binding.abs.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.abs.setTextColor(getResources().getColor(R.color.black));
                binding.biceps.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.biceps.setTextColor(getResources().getColor(R.color.black));
                binding.cardio.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.cardio.setTextColor(getResources().getColor(R.color.black));
                binding.tryceps.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.tryceps.setTextColor(getResources().getColor(R.color.black));
                binding.leg.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.leg.setTextColor(getResources().getColor(R.color.black));
                binding.shoulder.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.shoulder.setTextColor(getResources().getColor(R.color.black));
                binding.back.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.back.setTextColor(getResources().getColor(R.color.black));
                binding.forarms.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.forarms.setTextColor(getResources().getColor(R.color.black));
                binding.chest.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.chest.setTextColor(getResources().getColor(R.color.black));
                binding.calf.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.calf.setTextColor(getResources().getColor(R.color.black));
                binding.buttocks.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.buttocks.setTextColor(getResources().getColor(R.color.black));
                trapes tra = new trapes();
                replacefragment(tra);
                break;


            case R.id.leg:
                binding.leg.setBackground(getResources().getDrawable(R.drawable.selected));
                binding.leg.setTextColor(getResources().getColor(R.color.white));
                binding.abs.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.abs.setTextColor(getResources().getColor(R.color.black));
                binding.biceps.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.biceps.setTextColor(getResources().getColor(R.color.black));
                binding.cardio.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.cardio.setTextColor(getResources().getColor(R.color.black));
                binding.tryceps.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.tryceps.setTextColor(getResources().getColor(R.color.black));
                binding.trapes.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.trapes.setTextColor(getResources().getColor(R.color.black));
                binding.shoulder.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.shoulder.setTextColor(getResources().getColor(R.color.black));
                binding.back.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.back.setTextColor(getResources().getColor(R.color.black));
                binding.forarms.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.forarms.setTextColor(getResources().getColor(R.color.black));
                binding.chest.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.chest.setTextColor(getResources().getColor(R.color.black));
                binding.calf.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.calf.setTextColor(getResources().getColor(R.color.black));
                binding.buttocks.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.buttocks.setTextColor(getResources().getColor(R.color.black));
                leg legs = new leg();
                replacefragment(legs);
                break;


            case R.id.shoulder:
                binding.shoulder.setBackground(getResources().getDrawable(R.drawable.selected));
                binding.shoulder.setTextColor(getResources().getColor(R.color.white));
                binding.abs.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.abs.setTextColor(getResources().getColor(R.color.black));
                binding.biceps.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.biceps.setTextColor(getResources().getColor(R.color.black));
                binding.cardio.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.cardio.setTextColor(getResources().getColor(R.color.black));
                binding.tryceps.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.tryceps.setTextColor(getResources().getColor(R.color.black));
                binding.trapes.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.trapes.setTextColor(getResources().getColor(R.color.black));
                binding.leg.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.leg.setTextColor(getResources().getColor(R.color.black));
                binding.back.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.back.setTextColor(getResources().getColor(R.color.black));
                binding.forarms.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.forarms.setTextColor(getResources().getColor(R.color.black));
                binding.chest.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.chest.setTextColor(getResources().getColor(R.color.black));
                binding.calf.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.calf.setTextColor(getResources().getColor(R.color.black));
                binding.buttocks.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.buttocks.setTextColor(getResources().getColor(R.color.black));
                shoulder shoulders = new shoulder();
                replacefragment(shoulders);
                break;


            case R.id.back:
                binding.back.setBackground(getResources().getDrawable(R.drawable.selected));
                binding.back.setTextColor(getResources().getColor(R.color.white));
                binding.abs.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.abs.setTextColor(getResources().getColor(R.color.black));
                binding.biceps.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.biceps.setTextColor(getResources().getColor(R.color.black));
                binding.cardio.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.cardio.setTextColor(getResources().getColor(R.color.black));
                binding.tryceps.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.tryceps.setTextColor(getResources().getColor(R.color.black));
                binding.trapes.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.trapes.setTextColor(getResources().getColor(R.color.black));
                binding.leg.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.leg.setTextColor(getResources().getColor(R.color.black));
                binding.shoulder.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.shoulder.setTextColor(getResources().getColor(R.color.black));
                binding.forarms.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.forarms.setTextColor(getResources().getColor(R.color.black));
                binding.chest.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.chest.setTextColor(getResources().getColor(R.color.black));
                binding.calf.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.calf.setTextColor(getResources().getColor(R.color.black));
                binding.buttocks.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.buttocks.setTextColor(getResources().getColor(R.color.black));
                backf backs = new backf();
                replacefragment(backs);
                break;


            case R.id.forarms:
                binding.forarms.setBackground(getResources().getDrawable(R.drawable.selected));
                binding.forarms.setTextColor(getResources().getColor(R.color.white));
                binding.abs.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.abs.setTextColor(getResources().getColor(R.color.black));
                binding.biceps.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.biceps.setTextColor(getResources().getColor(R.color.black));
                binding.cardio.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.cardio.setTextColor(getResources().getColor(R.color.black));
                binding.tryceps.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.tryceps.setTextColor(getResources().getColor(R.color.black));
                binding.trapes.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.trapes.setTextColor(getResources().getColor(R.color.black));
                binding.leg.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.leg.setTextColor(getResources().getColor(R.color.black));
                binding.shoulder.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.shoulder.setTextColor(getResources().getColor(R.color.black));
                binding.back.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.back.setTextColor(getResources().getColor(R.color.black));
                binding.chest.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.chest.setTextColor(getResources().getColor(R.color.black));
                binding.calf.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.calf.setTextColor(getResources().getColor(R.color.black));
                binding.buttocks.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.buttocks.setTextColor(getResources().getColor(R.color.black));
                Forarms forarmss = new Forarms();
                replacefragment(forarmss);
                break;


            case R.id.chest:
                binding.chest.setBackground(getResources().getDrawable(R.drawable.selected));
                binding.chest.setTextColor(getResources().getColor(R.color.white));
                binding.abs.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.abs.setTextColor(getResources().getColor(R.color.black));
                binding.biceps.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.biceps.setTextColor(getResources().getColor(R.color.black));
                binding.cardio.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.cardio.setTextColor(getResources().getColor(R.color.black));
                binding.tryceps.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.tryceps.setTextColor(getResources().getColor(R.color.black));
                binding.trapes.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.trapes.setTextColor(getResources().getColor(R.color.black));
                binding.leg.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.leg.setTextColor(getResources().getColor(R.color.black));
                binding.shoulder.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.shoulder.setTextColor(getResources().getColor(R.color.black));
                binding.forarms.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.forarms.setTextColor(getResources().getColor(R.color.black));
                binding.chest.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.chest.setTextColor(getResources().getColor(R.color.black));
                binding.calf.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.calf.setTextColor(getResources().getColor(R.color.black));
                binding.buttocks.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.buttocks.setTextColor(getResources().getColor(R.color.black));
                chest chests = new chest();
                replacefragment(chests);
                break;


            case R.id.calf:
                binding.calf.setBackground(getResources().getDrawable(R.drawable.selected));
                binding.calf.setTextColor(getResources().getColor(R.color.white));
                binding.abs.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.abs.setTextColor(getResources().getColor(R.color.black));
                binding.biceps.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.biceps.setTextColor(getResources().getColor(R.color.black));
                binding.cardio.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.cardio.setTextColor(getResources().getColor(R.color.black));
                binding.tryceps.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.tryceps.setTextColor(getResources().getColor(R.color.black));
                binding.trapes.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.trapes.setTextColor(getResources().getColor(R.color.black));
                binding.leg.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.leg.setTextColor(getResources().getColor(R.color.black));
                binding.shoulder.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.shoulder.setTextColor(getResources().getColor(R.color.black));
                binding.forarms.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.forarms.setTextColor(getResources().getColor(R.color.black));
                binding.chest.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.chest.setTextColor(getResources().getColor(R.color.black));
                binding.calf.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.calf.setTextColor(getResources().getColor(R.color.black));
                binding.buttocks.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.buttocks.setTextColor(getResources().getColor(R.color.black));
                calf calfs = new calf();
                replacefragment(calfs);
                break;


            case R.id.buttocks:
                binding.buttocks.setBackground(getResources().getDrawable(R.drawable.selected));
                binding.buttocks.setTextColor(getResources().getColor(R.color.white));
                binding.abs.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.abs.setTextColor(getResources().getColor(R.color.black));
                binding.biceps.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.biceps.setTextColor(getResources().getColor(R.color.black));
                binding.cardio.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.cardio.setTextColor(getResources().getColor(R.color.black));
                binding.tryceps.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.tryceps.setTextColor(getResources().getColor(R.color.black));
                binding.trapes.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.trapes.setTextColor(getResources().getColor(R.color.black));
                binding.leg.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.leg.setTextColor(getResources().getColor(R.color.black));
                binding.shoulder.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.shoulder.setTextColor(getResources().getColor(R.color.black));
                binding.forarms.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.forarms.setTextColor(getResources().getColor(R.color.black));
                binding.chest.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.chest.setTextColor(getResources().getColor(R.color.black));
                binding.calf.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.calf.setTextColor(getResources().getColor(R.color.black));
                binding.buttocks.setBackground(getResources().getDrawable(R.drawable.unselected));
                binding.buttocks.setTextColor(getResources().getColor(R.color.black));
                buttocks buttock = new buttocks();
                replacefragment(buttock);
                break;

            default:
                Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
        }
    }
}