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


public class PhoneAdaptor extends RecyclerView.Adapter<PhoneAdaptor.ViewHolder>{
    ArrayList<PhoneUserModel> phoneUserModelArrayList;
    Context context;
    private static final int REQUEST_CODE=1;
    public PhoneAdaptor(ArrayList<PhoneUserModel> phoneUserModelArrayList, Context context) {
        this.phoneUserModelArrayList = phoneUserModelArrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.phone_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
     PhoneUserModel userModel = phoneUserModelArrayList.get(position);
     holder.textViewN.setText(userModel.getName());
     holder.textViewD.setText(userModel.getDepartment());
     holder.imageView.setOnClickListener(v -> {
        if (ContextCompat.checkSelfPermission(v.getContext(), Manifest.permission.CALL_PHONE)==PackageManager.PERMISSION_GRANTED){
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:"+userModel.getPhone()));
            v.getContext().startActivity(intent);
                }else {
            ActivityCompat.requestPermissions((Activity)v.getContext(),new String[]{Manifest.permission.CALL_PHONE},REQUEST_CODE);
               }
          });
    }

    @Override
    public int getItemCount() {
        return phoneUserModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
         private TextView textViewN,textViewD;
         private ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.CallImgTv);
            textViewN = itemView.findViewById(R.id.CallNameTv);
            textViewD = itemView.findViewById(R.id.CallDepartmentTv);
        }
    }
}
