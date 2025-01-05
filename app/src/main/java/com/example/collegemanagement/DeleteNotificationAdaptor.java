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
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DeleteNotificationAdaptor extends RecyclerView.Adapter<DeleteNotificationAdaptor.ViewHolder>{
    ArrayList<NotificationUserModel> notificationUserModelArrayList;
    Context context;
    public DeleteNotificationAdaptor(ArrayList<NotificationUserModel> notificationUserModelArrayList, Context context) {
        this.notificationUserModelArrayList = notificationUserModelArrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.delete_notification_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        NotificationUserModel notification = notificationUserModelArrayList.get(position);
        holder.textView1.setText(notification.getName());
        holder.textView2.setText(notification.getCourse());
        holder.textView3.setText(notification.getPhone());
        holder.textView4.setText(notification.getYear());
        holder.deleteImg.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                NotificationDataBase notificationDataBase = new NotificationDataBase(context);
                notificationDataBase.GetDeleteNotificationData(notification.getId());
                notificationUserModelArrayList.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeRemoved(position,notificationUserModelArrayList.size());
                Toast.makeText(context, "Delete SuccessFully......", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }


    @Override
    public int getItemCount() {
        return notificationUserModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView textView1,textView2,textView3,textView4;
        private ImageView deleteImg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView1 =  itemView.findViewById(R.id.name_tv);
            textView2 =  itemView.findViewById(R.id.course_tv);
            textView3 =  itemView.findViewById(R.id.phone_tv);
            textView4 =  itemView.findViewById(R.id.year_tv);
            deleteImg = itemView.findViewById(R.id.deleteImg);
        }
    }
}
