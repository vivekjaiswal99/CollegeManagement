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

public class CourseAdaptor extends RecyclerView.Adapter<CourseAdaptor.ViewHolder>{
    ArrayList<CourseUserModel> courseUserModelArrayList;
    Context context;
    public CourseAdaptor(ArrayList<CourseUserModel> courseUserModelArrayList, Context context) {
        this.courseUserModelArrayList = courseUserModelArrayList;
        this.context = context;
    }

    public void SetFilterList(ArrayList<CourseUserModel> FilterList){
        this.courseUserModelArrayList=FilterList;
        notifyDataSetChanged();
    }
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
      CourseUserModel courseUserModel = courseUserModelArrayList.get(position);
        holder.textViewN.setText(courseUserModel.getName());
        holder.textViewD.setText(courseUserModel.getDuration());
        holder.textViewP.setText(courseUserModel.getPercentage());
        holder.textViewF.setText(courseUserModel.getFess());
        holder.textViewE.setText(courseUserModel.getEligibility());
        holder.cardView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), CourseIntent.class);
            intent.putExtra("name",courseUserModel.getName());
            intent.putExtra("duration",courseUserModel.getDuration());
            intent.putExtra("eligibility",courseUserModel.getEligibility());
            intent.putExtra("fess",courseUserModel.getFess());
            intent.putExtra("percentage",courseUserModel.getPercentage());
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return courseUserModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView textViewN,textViewD,textViewF,textViewP,textViewE;
        private CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewN = itemView.findViewById(R.id.CourseName_tv);
            textViewD = itemView.findViewById(R.id.CourseDuration_tv);
            textViewF = itemView.findViewById(R.id.CourseFess_tv);
            textViewE = itemView.findViewById(R.id.CourseEligibility_tv);
            textViewP = itemView.findViewById(R.id.CourseMark_tv);
            cardView = itemView.findViewById(R.id.CardViews);
        }
    }
}
