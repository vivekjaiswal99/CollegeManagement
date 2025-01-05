package com.example.collegemanagement;

import android.database.Cursor;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DeleteNotification extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<NotificationUserModel> notificationUserModelArrayList;
    DeleteNotificationAdaptor adaptor;
    NotificationDataBase notificationDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_delete_notification);

        recyclerView = findViewById(R.id.recyclerView);
        notificationUserModelArrayList = new ArrayList<>();
        adaptor = new DeleteNotificationAdaptor(notificationUserModelArrayList,this);
        recyclerView.setAdapter(adaptor);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        notificationDataBase = new NotificationDataBase(this);

        Cursor cursor = notificationDataBase.GetDataFromStudent();
        while(cursor.moveToNext()){
            NotificationUserModel notificationUserModel = new NotificationUserModel(cursor.getInt(0),cursor.getString(1),cursor.getString(2)
                    ,cursor.getString(4),cursor.getString(3));
            notificationUserModelArrayList.add(notificationUserModel);
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}