package com.example.myfitness.Activity.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfitness.Activity.Models.plan;
import com.example.myfitness.Activity.Models.rbackc;
import com.example.myfitness.R;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Random;

public class plansadapter extends RecyclerView.Adapter<plansadapter.planviewh> {

    Context context;
    ArrayList<plan> planArrayList;

    public plansadapter(Context context, ArrayList<plan> planArrayList) {
        this.context = context;
        this.planArrayList = planArrayList;
    }

    @NonNull
    @Override
    public planviewh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.plan_item, parent, false);
        return new planviewh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull planviewh holder, int position) {

        Random rnd = new Random();
        int currentColor = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        holder.pcardview.setBackgroundColor(currentColor);

        plan plans = planArrayList.get(position);
        holder.pnames.setText(plans.getPname());
        holder.planedesc.setText(plans.getPdesc());
        holder.week.setText(plans.getDweek());
        holder.pgoal.setText(plans.getSgoal());
        String test = plans.getPname();
        String s=test.substring(0,1);
        holder.fletter.setText(s);


    }

    @Override
    public int getItemCount() {
        return planArrayList.size();
    }

    public class planviewh extends RecyclerView.ViewHolder {

        TextView fletter, pnames, planedesc, week,pgoal;
        ImageView delete;
        CardView pcardview;

        public planviewh(@NonNull View itemView) {
            super(itemView);
            fletter = itemView.findViewById(R.id.fletter);
            pnames = itemView.findViewById(R.id.pnames);
            planedesc = itemView.findViewById(R.id.plandesc);
            week = itemView.findViewById(R.id.week);
            delete = itemView.findViewById(R.id.delete);
            pgoal = itemView.findViewById(R.id.planegoal);
            pcardview=itemView.findViewById(R.id.pcardview);
        }
    }
}
