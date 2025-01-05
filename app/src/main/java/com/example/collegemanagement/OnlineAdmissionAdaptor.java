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

public class OnlineAdmissionAdaptor extends RecyclerView.Adapter<OnlineAdmissionAdaptor.ViewHolder>{
    ArrayList<OnlineAdmissionUserModel> admissionUserModelArrayList;
    Context context;

    public OnlineAdmissionAdaptor(ArrayList<OnlineAdmissionUserModel> admissionUserModelArrayList, Context context) {
        this.admissionUserModelArrayList = admissionUserModelArrayList;
        this.context = context;
    }

    public void SetFilterList(ArrayList<OnlineAdmissionUserModel> FilterList){
        this.admissionUserModelArrayList=FilterList;
        notifyDataSetChanged();
    }
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.admission_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
     OnlineAdmissionUserModel userModel = admissionUserModelArrayList.get(position);
        holder.textViewN.setText(userModel.getName());
        holder.textViewE.setText(userModel.getEmail());
        holder.textViewF.setText(userModel.getFather());
        holder.textViewC.setText(userModel.getCourse());
        holder.textViewL.setText(userModel.getLocation());
        holder.textViewP.setText(userModel.getPhone());
        holder.textViewG.setText(userModel.getGender());
        holder.cardView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), OnlineAdmissionIntent.class);
            intent.putExtra("name",userModel.getName());
            intent.putExtra("email",userModel.getEmail());
            intent.putExtra("gender",userModel.getGender());
            intent.putExtra("father",userModel.getFather());
            intent.putExtra("course",userModel.getCourse());
            intent.putExtra("location",userModel.getLocation());
            intent.putExtra("phone",userModel.getPhone());
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return admissionUserModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
          private TextView textViewN,textViewE,textViewF,textViewG,textViewC,textViewL,textViewP;
          private CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewN = itemView.findViewById(R.id.Name_tv);
            textViewE = itemView.findViewById(R.id.Email_tv);
            textViewG = itemView.findViewById(R.id.Gender_tv);
            textViewF = itemView.findViewById(R.id.Father_tv);
            textViewC = itemView.findViewById(R.id.Course_tv);
            textViewL = itemView.findViewById(R.id.Location_tv);
            textViewP = itemView.findViewById(R.id.Phone_tv);
            cardView = itemView.findViewById(R.id.CardViews);
        }
    }
}
