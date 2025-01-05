package com.example.collegemanagement;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SemesterAdaptor extends RecyclerView.Adapter<SemesterAdaptor.ViewHolder>{
    ArrayList<SemesterUserModel> semesterUserModelArrayList;
    Context context;
    public SemesterAdaptor(ArrayList<SemesterUserModel> semesterUserModelArrayList, Context context) {
        this.semesterUserModelArrayList = semesterUserModelArrayList;
        this.context = context;
    }

    public void SetFilterList(ArrayList<SemesterUserModel> FilterList){
        this.semesterUserModelArrayList=FilterList;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.semester_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
     SemesterUserModel semesterUserModel = semesterUserModelArrayList.get(position);

        holder.textViewCourse.setText(semesterUserModel.getCourseName());
        holder.textViewSubOne.setText(semesterUserModel.getSubOne());
        holder.textViewSubTwo.setText(semesterUserModel.getSubTwo());
        holder.textViewSubThree.setText(semesterUserModel.getSubThree());
        holder.textViewSubFour.setText(semesterUserModel.getSubFour());
        holder.textViewSubFive.setText(semesterUserModel.getSubFive());
        holder.textViewSubSix.setText(semesterUserModel.getSubSix());
        holder.textViewTecOne.setText(semesterUserModel.getTecOne());
        holder.textViewTecTwo.setText(semesterUserModel.getTecTwo());
        holder.textViewTecThree.setText(semesterUserModel.getTecThree());
        holder.textViewTecFour.setText(semesterUserModel.getTecFour());
        holder.textViewTecFive.setText(semesterUserModel.getTecFive());
        holder.textViewTecSix.setText(semesterUserModel.getTecSix());

            holder.cardView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), SemesterIntent.class);
            intent.putExtra("course",semesterUserModel.getCourseName());
            intent.putExtra("subject1",semesterUserModel.getSubOne());
            intent.putExtra("teacher1",semesterUserModel.getTecOne());
            intent.putExtra("subject2",semesterUserModel.getSubTwo());
            intent.putExtra("teacher2",semesterUserModel.getTecTwo());
            intent.putExtra("subject3",semesterUserModel.getSubThree());
            intent.putExtra("teacher3",semesterUserModel.getTecThree());
            intent.putExtra("subject4",semesterUserModel.getSubFour());
            intent.putExtra("teacher4",semesterUserModel.getTecFour());
            intent.putExtra("subject5",semesterUserModel.getSubFive());
            intent.putExtra("teacher5",semesterUserModel.getTecFive());
            intent.putExtra("subject",semesterUserModel.getSubSix());
            intent.putExtra("teacher",semesterUserModel.getTecSix());
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return semesterUserModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

      private TextView textViewCourse, textViewSubOne,textViewSubTwo,textViewSubThree,textViewSubFour,textViewSubFive,textViewSubSix,textViewTecOne,
              textViewTecTwo,textViewTecThree,textViewTecFour,textViewTecFive,textViewTecSix;
      private CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewCourse = itemView.findViewById(R.id.CourseName_Tv);
            textViewSubOne = itemView.findViewById(R.id.subject_one);
            textViewSubTwo = itemView.findViewById(R.id.subject_two);
            textViewSubThree = itemView.findViewById(R.id.subject_three);
            textViewSubFour = itemView.findViewById(R.id.subject_four);
            textViewSubFive = itemView.findViewById(R.id.subject_five);
            textViewSubSix = itemView.findViewById(R.id.subject_six);
            textViewTecOne = itemView.findViewById(R.id.teacher_one);
            textViewTecTwo = itemView.findViewById(R.id.teacher_two);
            textViewTecThree = itemView.findViewById(R.id.teacher_three);
            textViewTecFour = itemView.findViewById(R.id.teacher_four);
            textViewTecFive = itemView.findViewById(R.id.teacher_five);
            textViewTecSix = itemView.findViewById(R.id.teacher_six);
            cardView = itemView.findViewById(R.id.CardViews);
        }
    }
}
