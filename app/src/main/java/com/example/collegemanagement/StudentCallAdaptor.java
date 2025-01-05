package com.example.collegemanagement;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StudentCallAdaptor extends RecyclerView.Adapter<StudentCallAdaptor.ViewHolder> {
    private static final int REQUEST_CODE=1;
    ArrayList<StudentCallNumberUserModel> studentCallNumberUserModels;
    Context context;
    public StudentCallAdaptor(ArrayList<StudentCallNumberUserModel> studentCallNumberUserModels, Context context) {
        this.studentCallNumberUserModels = studentCallNumberUserModels;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_call_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    StudentCallNumberUserModel numberUserModel = studentCallNumberUserModels.get(position);
    holder.textViewN.setText(numberUserModel.getName());
    holder.textViewD.setText(numberUserModel.getCourse());
    holder.imageView.setOnClickListener(v -> {
        if (ContextCompat.checkSelfPermission(v.getContext(), Manifest.permission.CALL_PHONE)== PackageManager.PERMISSION_GRANTED){
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:"+numberUserModel.phone));
            v.getContext().startActivity(intent);
             }else {
            ActivityCompat.requestPermissions((Activity)v.getContext(),new String[]{Manifest.permission.CALL_PHONE},REQUEST_CODE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return studentCallNumberUserModels.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
       private TextView textViewN,textViewD;
       private ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewN = itemView.findViewById(R.id.CallNameTv);
            textViewD = itemView.findViewById(R.id.CallCourseTv);
            imageView = itemView.findViewById(R.id.CallImgTv);

        }
    }
}
