package com.example.collegemanagement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class AttendanceAdaptor extends RecyclerView.Adapter<AttendanceAdaptor.ViewHolder>{
    ArrayList<AttendanceUserModel> attendanceUserModelArrayList;
    Context context;
    AddStudentAttendanceDataBase dataBase;;
    int present=0;
    int absent=0;

    public AttendanceAdaptor(ArrayList<AttendanceUserModel> attendanceUserModelArrayList, Context context) {
        this.attendanceUserModelArrayList = attendanceUserModelArrayList;
        this.context = context;
    }

    public void SetFilterList(ArrayList<AttendanceUserModel> FilterList){
        this.attendanceUserModelArrayList=FilterList;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.delete_student_attendance_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       AttendanceUserModel userModel = attendanceUserModelArrayList.get(position);
       holder.textViewN.setText(userModel.getName());
       holder.textViewF.setText(userModel.getFather());
       holder.textViewP.setText(userModel.getPhone());
       holder.switches.setOnCheckedChangeListener((buttonView, isChecked) -> {
           if (buttonView.isChecked()){
               present++;
               Toast.makeText(context, "present"+present, Toast.LENGTH_SHORT).show();
           }
       });
    }

    @Override
    public int getItemCount() {
        return attendanceUserModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
         private TextView textViewN,textViewF,textViewP;
         private Switch switches;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewN = itemView.findViewById(R.id.Name);
            textViewF = itemView.findViewById(R.id.Father);
            textViewP = itemView.findViewById(R.id.Phone);
            switches = itemView.findViewById(R.id.Switches);
        }
    }
}
