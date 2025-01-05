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

public class DeleteCourseDetails extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<CourseUserModel> courseUserModelArrayList;
    DeleteCourseAdaptor adaptor;
    CourseDataBase courseDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_delete_course_details);

        recyclerView = findViewById(R.id.recyclerView);
        courseUserModelArrayList = new ArrayList<>();
        courseDataBase = new CourseDataBase(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adaptor = new DeleteCourseAdaptor(courseUserModelArrayList,this);
        recyclerView.setAdapter(adaptor);

        Cursor cursor = courseDataBase.GETCourseDetailShow();
        while(cursor.moveToNext()){
            CourseUserModel courseUserModel = new CourseUserModel(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(5),
                    cursor.getString(4),cursor.getString(3));
            courseUserModelArrayList.add(courseUserModel);
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}