package com.example.collegemanagement;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;


public class DeleteSemesterAdaptor extends RecyclerView.Adapter<DeleteSemesterAdaptor.ViewHolder>{
    ArrayList<SemesterUserModel> semesterUserModelArrayList;
    Context context;
    public DeleteSemesterAdaptor(ArrayList<SemesterUserModel> semesterUserModelArrayList, Context context) {
        this.semesterUserModelArrayList = semesterUserModelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.delete_semester_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
    SemesterUserModel semesterUserModel = semesterUserModelArrayList.get(position);
    holder.textViewCourse.setText(semesterUserModel.getCourseName());
    holder.cardView.setOnLongClickListener(new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            final CheckSemesterDataBase checkSemesterDataBase = new CheckSemesterDataBase(context);
            checkSemesterDataBase.GetDeleteSemesterData(semesterUserModel.getId());
                     semesterUserModelArrayList.remove(position);
                     notifyItemRemoved(position);
                     notifyItemRangeRemoved(position,semesterUserModelArrayList.size());
            return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return semesterUserModelArrayList.size();
    }

        public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView textViewCourse;
        private CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewCourse = itemView.findViewById(R.id.CourseName_Tv);
            cardView = itemView.findViewById(R.id.CardViews);
        }
    }
}
