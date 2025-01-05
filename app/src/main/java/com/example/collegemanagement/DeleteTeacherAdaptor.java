package com.example.collegemanagement;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DeleteTeacherAdaptor extends RecyclerView.Adapter<DeleteTeacherAdaptor.ViewHolder> {

    ArrayList<SetTeacherUserModel> setTeacherUserModels;
    Context context;
    SetTeacherUserModel userModel;

    public DeleteTeacherAdaptor(ArrayList<SetTeacherUserModel> setTeacherUserModels, Context context) {
        this.setTeacherUserModels = setTeacherUserModels;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.delete_teacher_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        userModel = setTeacherUserModels.get(position);
        holder.textViewN.setText(userModel.getName());
        holder.textViewEM.setText(userModel.getEmail());
        holder.textViewD.setText(userModel.getDepartment());
        holder.textViewQ.setText(userModel.getQualification());
        holder.textViewE.setText(userModel.getExperience());
        holder.textViewP.setText(userModel.getPhone());
        holder.deleteImg.setOnClickListener(new View.OnClickListener() {
                final SetTeacherDataBase dataBase = new SetTeacherDataBase(context);
                @Override
                public void onClick(View v) {
                  dataBase.Deletes(userModel.getId());
                  setTeacherUserModels.remove(position);
                  notifyItemRemoved(position);
                  notifyItemRangeRemoved(position,setTeacherUserModels.size());
                    Toast.makeText(context, "Delete SuccessFully.....", Toast.LENGTH_SHORT).show();
                }
            });
    }

    @Override
    public int getItemCount() {
        return setTeacherUserModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView textViewN,textViewEM,textViewE,textViewQ,textViewD,textViewP;
        ImageView deleteImg;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewN = itemView.findViewById(R.id. TeacherName_tv);
            textViewEM = itemView.findViewById(R.id.TeacherEmail_tv);
            textViewD = itemView.findViewById(R.id.TeacherDepartment_tv);
            textViewQ = itemView.findViewById(R.id.TeacherQualification_tv);
            textViewE = itemView.findViewById(R.id.TeacherExperience_tv);
            textViewP = itemView.findViewById(R.id.TeacherPhone_tv);
            deleteImg = itemView.findViewById(R.id.deleteImg);
        }
    }
}
