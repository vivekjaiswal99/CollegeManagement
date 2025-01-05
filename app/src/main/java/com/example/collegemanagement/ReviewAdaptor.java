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

public class ReviewAdaptor extends RecyclerView.Adapter<ReviewAdaptor.ViewHolder>{

    ArrayList<ReviewUserModel> reviewUserModelArrayList;
    Context context;
    public ReviewAdaptor(ArrayList<ReviewUserModel> reviewUserModelArrayList, Context context) {
        this.reviewUserModelArrayList = reviewUserModelArrayList;
        this.context = context;
    }

    public void SetFilterList(ArrayList<ReviewUserModel> FilterList){
        this.reviewUserModelArrayList=FilterList;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.review_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
     ReviewUserModel userModel = reviewUserModelArrayList.get(position);
        holder.textViewSn.setText(userModel.getName());
        holder.textViewCn.setText(userModel.getCourse());
        holder.textViewSe.setText(userModel.getSemester());
        holder.textViewRe.setText(userModel.getReview());
        holder.cardView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), CollegeReviewIntent.class);
            intent.putExtra("name",userModel.getName());
            intent.putExtra("course",userModel.getCourse());
            intent.putExtra("semester",userModel.getSemester());
            intent.putExtra("review",userModel.getReview());
            v.getContext().startActivity(intent);
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
