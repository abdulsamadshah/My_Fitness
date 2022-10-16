package com.example.myfitness.Activity.Activity;

import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.FragmentTransaction;


import com.example.myfitness.Activity.Fragment.Home;
import com.example.myfitness.Activity.Fragment.Plans;
import com.example.myfitness.Activity.Fragment.more;
import com.example.myfitness.Activity.Fragment.tipsFragment;
import com.example.myfitness.R;
import com.example.myfitness.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;



public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, new Home());
        fragmentTransaction.commit();

        binding.bottomnavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                switch (item.getItemId()){
                    case R.id.home:
                        transaction.replace(R.id.container, new Home());
                        break;

                    case R.id.plans:
                        transaction.replace(R.id.container, new Plans());
                        break;

                    case R.id.tips:
                        transaction.replace(R.id.container, new tipsFragment());
                        break;


                    case R.id.more:
                        transaction.replace(R.id.container, new more());
                        break;

                    default:
                        Log.e("bottomerror","something bottom error");
                        break;
                }
                transaction.commit();
                return false;
            }

        });

    }


//    private void exit() {
//        Dialog dialog = new Dialog(MainActivity.this, R.style.genderd);
//        dialog.setContentView(R.layout.privacypolicy);
//        TextView ok, cancel;
//
//        ok = dialog.findViewById(R.id.oks);
//        cancel = dialog.findViewById(R.id.cancels);
//
//
//        cancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                dialog.dismiss();
//            }
//        });
//        ok.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                onDestroy();
//            }
//        });
//
//    }


    @Override
    public void onBackPressed() {

        super.onBackPressed();
    }
}
