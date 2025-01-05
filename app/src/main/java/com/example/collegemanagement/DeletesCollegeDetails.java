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

public class DeletesCollegeDetails extends AppCompatActivity {
    RecyclerView recyclerView;
    CollegeDataBase collegeDataBase;
    DeletesCollegeAdaptors adaptor;
    ArrayList<CollegeUserModel> collegeUserModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_deletes_college_details);


        recyclerView = findViewById(R.id.recyclerView);
        collegeUserModelArrayList = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adaptor = new DeletesCollegeAdaptors(collegeUserModelArrayList,this);
        recyclerView.setAdapter(adaptor);
        collegeDataBase = new CollegeDataBase(this);
        Cursor cursor = collegeDataBase.GetCollegeDetailShow();
        while (cursor.moveToNext()){
            CollegeUserModel collegeUserModel = new CollegeUserModel(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),
                    cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7));
            collegeUserModelArrayList.add(collegeUserModel);
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}