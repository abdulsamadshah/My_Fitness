package com.example.myfitness.Activity.Adapters;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfitness.Activity.Models.tips;
import com.example.myfitness.R;

import java.util.ArrayList;

public class tipsAd extends RecyclerView.Adapter<tipsAd.absviewholder> {

    Context context;
    ArrayList<tips> tipsArrayList;

    public tipsAd(Context context, ArrayList<tips> tipsArrayList) {
        this.context = context;
        this.tipsArrayList = tipsArrayList;
    }

    @NonNull
    @Override
    public absviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.tips_layout, parent, false);
        return new absviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull absviewholder holder, int position) {
        holder.ntitles.setText(tipsArrayList.get(position).getTitle());
        holder.ndesc.setText(tipsArrayList.get(position).getDescription());
        holder.nheaderimg.setImageURI(Uri.parse(tipsArrayList.get(position).getImages()));


    }

    @Override
    public int getItemCount() {
        return tipsArrayList.size();
    }

    public class absviewholder extends RecyclerView.ViewHolder {

        TextView ntitles, ndesc;
        ImageView nheaderimg;

        public absviewholder(@NonNull View itemView) {
            super(itemView);
            ntitles = itemView.findViewById(R.id.ntitles);
            ndesc = itemView.findViewById(R.id.ndesc);
            nheaderimg = itemView.findViewById(R.id.nheaderimg);


        }
    }
}
