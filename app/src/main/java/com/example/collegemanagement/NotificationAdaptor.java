package com.example.collegemanagement;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class NotificationAdaptor extends RecyclerView.Adapter<NotificationAdaptor.ViewHolder>{
    ArrayList<NotificationUserModel> notificationUserModelArrayList;
    Context context;

    public NotificationAdaptor(ArrayList<NotificationUserModel> notificationUserModelArrayList, Context context) {
        this.notificationUserModelArrayList = notificationUserModelArrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NotificationUserModel notification = notificationUserModelArrayList.get(position);
        holder.textView1.setText(notification.getName());
        holder.textView2.setText(notification.getCourse());
        holder.textView3.setText(notification.getPhone());
        holder.textView4.setText(notification.getYear());
        holder.imageView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), SendsMessage.class);
            intent.putExtra("phone",notification.getPhone());
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return notificationUserModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView textView1,textView2,textView3,textView4;
        private ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView1 =  itemView.findViewById(R.id.name_tv);
            textView2 =  itemView.findViewById(R.id.course_tv);
            textView3 =  itemView.findViewById(R.id.phone_tv);
            textView4 =  itemView.findViewById(R.id.year_tv);
            imageView = itemView.findViewById(R.id.send_img);

        }
    }
}
