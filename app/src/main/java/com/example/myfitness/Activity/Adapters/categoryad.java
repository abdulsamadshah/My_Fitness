package com.example.myfitness.Activity.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfitness.Activity.Activity.absviewA;
import com.example.myfitness.Activity.Models.category;
import com.example.myfitness.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class categoryad extends RecyclerView.Adapter<categoryad.absviewholder> {

    Context context;
    ArrayList<category> absArrayList;

    public categoryad(Context context, ArrayList<category> absArrayList) {
        this.context = context;
        this.absArrayList = absArrayList;
    }

    @NonNull
    @Override
    public absviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.abs_item, parent, false);
        return new absviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull absviewholder holder, int position) {
        category category = absArrayList.get(position);
        holder.cname.setText(category.getCname());
        holder.videoview.setVideoURI(Uri.parse(category.getCvideo()));
        holder.description.setText(category.getCdescription());
        holder.subdesc.setText(category.getSubdescriptions());
        holder.seconddesc.setText(category.getSeconddescription());
        Picasso.get().load(category.getCimg()).placeholder(R.drawable.selected).into(holder.abscimg);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, absviewA.class);
                intent.putExtra("video",category.getCvideo());
                intent.putExtra("description",category.getCdescription());
                intent.putExtra("subdesc",category.getSubdescriptions());
                intent.putExtra("cname",category.getCname());
                intent.putExtra("secdesc",category.getSeconddescription());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return absArrayList.size();
    }

    public class absviewholder extends RecyclerView.ViewHolder {

        ImageView abscimg;
        TextView cname,description,subdesc,seconddesc;
        VideoView videoview;


        public absviewholder(@NonNull View itemView) {
            super(itemView);
            abscimg = itemView.findViewById(R.id.abscimg);
            cname=itemView.findViewById(R.id.cname);
            description=itemView.findViewById(R.id.desc);
            subdesc=itemView.findViewById(R.id.subdesc);
            videoview=itemView.findViewById(R.id.videoView);
            seconddesc=itemView.findViewById(R.id.seconddesc);
        }
    }
}
