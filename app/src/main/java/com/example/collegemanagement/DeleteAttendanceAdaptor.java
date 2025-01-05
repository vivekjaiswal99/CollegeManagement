package com.example.collegemanagement;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class DeleteAttendanceAdaptor extends RecyclerView.Adapter<DeleteAttendanceAdaptor.ViewHolder>{
    ArrayList<AttendanceUserModel> attendanceUserModelArrayList;
    Context context;
    public DeleteAttendanceAdaptor(ArrayList<AttendanceUserModel> attendanceUserModelArrayList, Context context) {
        this.attendanceUserModelArrayList = attendanceUserModelArrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.delete_attendance_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        AttendanceUserModel userModel = attendanceUserModelArrayList.get(position);
        holder.textViewN.setText(userModel.getName());
        holder.textViewF.setText(userModel.getFather());
        holder.textViewP.setText(userModel.getPhone());
       holder.deleteImg.setOnLongClickListener(new View.OnLongClickListener() {
           @Override
           public boolean onLongClick(View v) {
               AddStudentAttendanceDataBase addStudentAttendanceDataBase = new AddStudentAttendanceDataBase(context);
               addStudentAttendanceDataBase.GetDeleteAttendanceData(userModel.getId());
               attendanceUserModelArrayList.remove(position);
               notifyItemRemoved(position);
               notifyItemRangeRemoved(position,attendanceUserModelArrayList.size());
               Toast.makeText(context, "Delete SuccessFully............", Toast.LENGTH_SHORT).show();
               return true;
           }
       });
    }

    @Override
    public int getItemCount() {
        return attendanceUserModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView textViewN,textViewF,textViewP;
        private ImageView deleteImg;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewN = itemView.findViewById(R.id.Name);
            textViewF = itemView.findViewById(R.id.Father);
            textViewP = itemView.findViewById(R.id.Phone);
            deleteImg = itemView.findViewById(R.id.deleteImg);
        }
    }
}
