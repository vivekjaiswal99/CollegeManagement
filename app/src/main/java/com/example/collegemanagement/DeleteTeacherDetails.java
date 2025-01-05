package com.example.collegemanagement;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DeleteTeacherDetails extends AppCompatActivity {
RecyclerView recyclerView;
SetTeacherDataBase dataBase;
DeleteTeacherAdaptor adaptor;
ArrayList<SetTeacherUserModel> setTeacherUserModels;
    SetTeacherUserModel userModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_delete_teacher_details);

        recyclerView = findViewById(R.id.recyclerView);
        setTeacherUserModels = new ArrayList<>();
        dataBase = new SetTeacherDataBase(this);
        adaptor = new DeleteTeacherAdaptor(setTeacherUserModels,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adaptor);
        Cursor cursor = dataBase.GetTeacherData();
        while(cursor.moveToNext()){
            userModel = new SetTeacherUserModel(cursor.getInt(0),cursor.getString(1),cursor.getString(2),
                    cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6));
            setTeacherUserModels.add(userModel);
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}