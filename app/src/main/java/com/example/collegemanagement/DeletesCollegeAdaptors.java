package com.example.collegemanagement;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DeletesCollegeAdaptors extends RecyclerView.Adapter<DeletesCollegeAdaptors.ViewHolder>{
    ArrayList<CollegeUserModel> collegeUserModelArrayList;
    Context context;
    public DeletesCollegeAdaptors(ArrayList<CollegeUserModel> collegeUserModelArrayList, Context context) {
        this.collegeUserModelArrayList = collegeUserModelArrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.delete_college_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        CollegeUserModel userModel = collegeUserModelArrayList.get(position);
        holder.textViewN.setText(userModel.getName());
        holder.textViewE.setText(userModel.getEstablished());
        holder.textViewR.setText(userModel.getRanking());
        holder.textViewP.setText(userModel.getPass());
        holder.textViewPl.setText(userModel.getPlacement());
        holder.textViewL.setText(userModel.getLocation());
        holder.textViewNu.setText(userModel.getNumber());
        holder.deleteImg.setOnClickListener(new View.OnClickListener() {
            CollegeDataBase collegeDataBase = new CollegeDataBase(context);
            @Override
            public void onClick(View v) {
                collegeDataBase.GetDeleteCollegeData(userModel.getId());
                collegeUserModelArrayList.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeRemoved(position,collegeUserModelArrayList.size());
            }
        });
    }

    @Override
    public int getItemCount() {
        return collegeUserModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView textViewN,textViewE,textViewR,textViewP,textViewL,textViewNu,textViewPl;
        private ImageView deleteImg;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewN = itemView.findViewById(R.id.CollegeName_tv);
            textViewE = itemView.findViewById(R.id.CollegeEstablished_tv);
            textViewR = itemView.findViewById(R.id.CollegeRanking_tv);
            textViewP = itemView.findViewById(R.id.CollegeStudentPass_tv);
            textViewPl = itemView.findViewById(R.id.CollegePlacement_tv);
            textViewL = itemView.findViewById(R.id.CollegeLocation_tv);
            textViewNu = itemView.findViewById(R.id.CollegeNumber_tv);
            deleteImg = itemView.findViewById(R.id.deleteImg);
        }
    }
}
