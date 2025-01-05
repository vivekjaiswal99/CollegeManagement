package com.example.collegemanagement;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class DeleteCourseAdaptor extends RecyclerView.Adapter<DeleteCourseAdaptor.ViewHolder>{
    ArrayList<CourseUserModel> courseUserModelArrayList;
    Context context;
    public DeleteCourseAdaptor(ArrayList<CourseUserModel> courseUserModelArrayList, Context context) {
        this.courseUserModelArrayList = courseUserModelArrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.delete_course_items,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        CourseUserModel courseUserModel = courseUserModelArrayList.get(position);
        holder.textViewN.setText(courseUserModel.getName());
        holder.textViewD.setText(courseUserModel.getDuration());
        holder.textViewP.setText(courseUserModel.getPercentage());
        holder.textViewF.setText(courseUserModel.getFess());
        holder.textViewE.setText(courseUserModel.getEligibility());
        holder.CardViews.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CourseDataBase dataBase = new CourseDataBase(context);
                dataBase.GetDeleteCourseData(courseUserModel.getId());
                Toast.makeText(context, "Delete SuccessFully.......", Toast.LENGTH_SHORT).show();
                courseUserModelArrayList.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeRemoved(position,courseUserModelArrayList.size());
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return courseUserModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
            private TextView textViewN,textViewD,textViewF,textViewP,textViewE;
           private CardView CardViews;
         public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewN = itemView.findViewById(R.id.CourseName_tv);
            textViewD = itemView.findViewById(R.id.CourseDuration_tv);
            textViewF = itemView.findViewById(R.id.CourseFess_tv);
            textViewE = itemView.findViewById(R.id.CourseEligibility_tv);
            textViewP = itemView.findViewById(R.id.CourseMark_tv);
            CardViews = itemView.findViewById(R.id.CardViews);
        }
    }
}
