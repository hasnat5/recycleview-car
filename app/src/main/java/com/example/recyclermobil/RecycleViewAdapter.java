package com.example.recyclermobil;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder> {

    List<Mobil> mobilList;
    Context context;

    public RecycleViewAdapter(List<Mobil> mobilList, Context context) {
        this.mobilList = mobilList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.one_line_mobil, parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_mobilName.setText(mobilList.get(position).getName());
        holder.tv_mobilElectionDate.setText(String.valueOf(mobilList.get(position).getDateOfElection()));
        Glide.with(this.context).load(mobilList.get(position).getImageURL()).into(holder.iv_mobilPic);
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // send the control to the EditOneIte activity
                Intent intent = new Intent(context, AddEditOne.class);
                intent.putExtra("id", mobilList.get(position).getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mobilList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_mobilPic;
        TextView tv_mobilName;
        TextView tv_mobilElectionDate;
        ConstraintLayout parentLayout;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_mobilPic = itemView.findViewById(R.id.iv_mobilPicture);
            tv_mobilElectionDate = itemView.findViewById(R.id.tv_dateElection);
            tv_mobilName = itemView.findViewById(R.id.tv_mobilName);
            parentLayout = itemView.findViewById(R.id.oneLineMobilLayout);
        }
    }
}
