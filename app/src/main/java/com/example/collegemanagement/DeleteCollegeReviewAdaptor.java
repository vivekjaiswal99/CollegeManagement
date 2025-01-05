package com.example.collegemanagement;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DeleteCollegeReviewAdaptor extends RecyclerView.Adapter<DeleteCollegeReviewAdaptor.ViewHolder>{
    ArrayList<ReviewUserModel> reviewUserModelArrayList;
    Context context;
    public DeleteCollegeReviewAdaptor(ArrayList<ReviewUserModel> reviewUserModelArrayList, Context context) {
        this.reviewUserModelArrayList = reviewUserModelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.deletes_college_items,parent,false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        ReviewUserModel userModel = reviewUserModelArrayList.get(position);
        holder.textViewSn.setText(userModel.getName());
        holder.textViewCn.setText(userModel.getCourse());
        holder.textViewSe.setText(userModel.getSemester());
        holder.textViewRe.setText(userModel.getReview());
        holder.cardView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CollegeReviewDataBase collegeReviewDataBase = new CollegeReviewDataBase(context);
                collegeReviewDataBase.GetDeleteCollegeReview(userModel.getId());
                reviewUserModelArrayList.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeRemoved(position,reviewUserModelArrayList.size());
                Toast.makeText(context, "Delete SuccessFully......", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }


    @Override
    public int getItemCount() {
        return reviewUserModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView textViewSn,textViewCn,textViewSe,textViewRe;
        private CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewSn = itemView.findViewById(R.id.StudentName_tv);
            textViewCn = itemView.findViewById(R.id.CourseName_tv);
            textViewSe = itemView.findViewById(R.id.StudentSemester_tv);
            textViewRe = itemView.findViewById(R.id.StudentReview_tv);
            cardView = itemView.findViewById(R.id.CardViews);

        }
    }
}
