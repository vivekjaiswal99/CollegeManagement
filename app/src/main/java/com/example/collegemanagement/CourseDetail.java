package com.example.collegemanagement;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Filter;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CourseDetail extends AppCompatActivity {
RecyclerView recyclerView;
ArrayList<CourseUserModel> courseUserModelArrayList;
CourseAdaptor adaptor;
CourseDataBase courseDataBase;
SearchView SearchBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_course_detail);

        recyclerView = findViewById(R.id.recyclerView);
        courseUserModelArrayList = new ArrayList<>();
        courseDataBase = new CourseDataBase(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adaptor = new CourseAdaptor(courseUserModelArrayList,this);
        recyclerView.setAdapter(adaptor);
        SearchBar = findViewById(R.id.SearchBar);

       Cursor cursor = courseDataBase.GETCourseDetailShow();
       while(cursor.moveToNext()){
           CourseUserModel courseUserModel = new CourseUserModel(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(5),
                   cursor.getString(4),cursor.getString(3));
           courseUserModelArrayList.add(courseUserModel);
       }

       SearchBar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
           @Override
           public boolean onQueryTextSubmit(String query) {
               return false;
           }

           @Override
           public boolean onQueryTextChange(String newText) {
               FilterList(newText);
               return true;
           }
       });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void FilterList(String Text) {
        ArrayList<CourseUserModel> FilterList = new ArrayList<>();
        for(CourseUserModel courseUserModel:courseUserModelArrayList){
            if(courseUserModel.getName().toLowerCase().contains(Text.toLowerCase())){
                FilterList.add(courseUserModel);
              }
        }
        if(FilterList.isEmpty()){
            Toast.makeText(this, "DATA DOESN'T EXITS.......", Toast.LENGTH_SHORT).show();
        }else {
            adaptor.SetFilterList(FilterList);
        }
    }
}