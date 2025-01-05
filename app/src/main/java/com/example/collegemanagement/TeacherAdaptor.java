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


 public class TeacherAdaptor extends RecyclerView.Adapter<TeacherAdaptor.ViewHolder> {
    ArrayList<SetTeacherUserModel> setTeacherUserModelArrayList;
    Context context;

     public TeacherAdaptor(ArrayList<SetTeacherUserModel> setTeacherUserModelArrayList, Context context) {
         this.setTeacherUserModelArrayList = setTeacherUserModelArrayList;
         this.context = context;
     }

     public void setFilterList(ArrayList<SetTeacherUserModel> FilterList){
         this.setTeacherUserModelArrayList = FilterList;
         notifyDataSetChanged();
     }
     @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.teacher_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SetTeacherUserModel userModel = setTeacherUserModelArrayList.get(position);
        holder.textViewN.setText(userModel.getName());
        holder.textViewEM.setText(userModel.getEmail());
        holder.textViewD.setText(userModel.getDepartment());
        holder.textViewQ.setText(userModel.getQualification());
        holder.textViewE.setText(userModel.getExperience());
        holder.textViewP.setText(userModel.getPhone());
        holder.CardView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), TeacherIntentDetail.class);
            intent.putExtra("name",userModel.getName());
            intent.putExtra("email",userModel.getEmail());
            intent.putExtra("department",userModel.getDepartment());
            intent.putExtra("experience",userModel.getExperience());
            intent.putExtra("qualification",userModel.getQualification());
            intent.putExtra("phone",userModel.getPhone());
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return setTeacherUserModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
         private TextView textViewN,textViewEM,textViewE,textViewQ,textViewD,textViewP;
         private CardView CardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewN = itemView.findViewById(R.id. TeacherName_tv);
            textViewEM = itemView.findViewById(R.id.TeacherEmail_tv);
            textViewD = itemView.findViewById(R.id.TeacherDepartment_tv);
            textViewQ = itemView.findViewById(R.id.TeacherQualification_tv);
            textViewE = itemView.findViewById(R.id.TeacherExperience_tv);
            textViewP = itemView.findViewById(R.id.TeacherPhone_tv);
            CardView = itemView.findViewById(R.id.cardView);
        }
    }
}
