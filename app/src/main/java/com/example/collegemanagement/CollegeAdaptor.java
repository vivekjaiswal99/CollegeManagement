package com.example.collegemanagement;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class CollegeAdaptor extends RecyclerView.Adapter<CollegeAdaptor.ViewHolder>{
     ArrayList<CollegeUserModel> collegeUserModelArrayList;
     Context context;
    public CollegeAdaptor(ArrayList<CollegeUserModel> collegeUserModelArrayList, Context context) {
        this.collegeUserModelArrayList = collegeUserModelArrayList;
        this.context = context;
    }

    public void SetFilterList(ArrayList<CollegeUserModel> FilterList){
        this.collegeUserModelArrayList=FilterList;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.college_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CollegeUserModel userModel = collegeUserModelArrayList.get(position);
        holder.textViewN.setText(userModel.getName());
        holder.textViewE.setText(userModel.getEstablished());
        holder.textViewR.setText(userModel.getRanking());
        holder.textViewP.setText(userModel.getPass());
        holder.textViewPl.setText(userModel.getPlacement());
        holder.textViewL.setText(userModel.getLocation());
        holder.textViewNu.setText(userModel.getNumber());
        holder.cardView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), CollegeIntent.class);
            intent.putExtra("name",userModel.getName());
            intent.putExtra("established",userModel.getEstablished());
            intent.putExtra("ranking",userModel.getRanking());
            intent.putExtra("student",userModel.getPass());
            intent.putExtra("placement",userModel.getPlacement());
            intent.putExtra("location",userModel.getLocation());
            intent.putExtra("number",userModel.getNumber());
            v.getContext().startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return collegeUserModelArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
             private TextView textViewN,textViewE,textViewR,textViewP,textViewL,textViewNu,textViewPl;
             private CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewN = itemView.findViewById(R.id.CollegeName_tv);
            textViewE = itemView.findViewById(R.id.CollegeEstablished_tv);
            textViewR = itemView.findViewById(R.id.CollegeRanking_tv);
            textViewP = itemView.findViewById(R.id.CollegeStudentPass_tv);
            textViewPl = itemView.findViewById(R.id.CollegePlacement_tv);
            textViewL = itemView.findViewById(R.id.CollegeLocation_tv);
            textViewNu = itemView.findViewById(R.id.CollegeNumber_tv);
            cardView = itemView.findViewById(R.id.CardViews);
        }
    }
}
