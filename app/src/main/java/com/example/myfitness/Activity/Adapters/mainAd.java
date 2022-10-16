package com.example.myfitness.Activity.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfitness.Activity.Activity.exmain;
import com.example.myfitness.Activity.Models.main;
import com.example.myfitness.R;

import java.util.ArrayList;

public class mainAd extends RecyclerView.Adapter<mainAd.absviewholder> {

    Context context;
    ArrayList<main> mainArrayList;


    public mainAd(Context context, ArrayList<main> mainArrayList) {
        this.context = context;
        this.mainArrayList = mainArrayList;
    }

    @NonNull
    @Override
    public absviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.allitems_layouts, parent, false);
        return new absviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull absviewholder holder, int position) {
        holder.mainimg.setImageResource(mainArrayList.get(position).getImages());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, exmain.class);
                context.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return mainArrayList.size();
    }

    public class absviewholder extends RecyclerView.ViewHolder {

        ImageView mainimg;

        public absviewholder(@NonNull View itemView) {
            super(itemView);
            mainimg = itemView.findViewById(R.id.mainimg);


        }

    }
}
