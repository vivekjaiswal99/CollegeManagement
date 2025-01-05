package com.example.collegemanagement;

import android.database.Cursor;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdCheckAttendanceStudent extends AppCompatActivity {
RecyclerView recyclerView;
AddStudentAttendanceDataBase addStudentAttendanceDataBase;
ArrayList<AttendanceUserModel> attendanceUserModels;
AttendanceAdaptor adaptor;
SearchView SearchBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ad_check_attendance_student);

        recyclerView = findViewById(R.id.recyclerView);
        addStudentAttendanceDataBase = new AddStudentAttendanceDataBase(this);
        attendanceUserModels = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adaptor = new AttendanceAdaptor(attendanceUserModels,this);
        recyclerView.setAdapter(adaptor);
        SearchBar = findViewById(R.id.SearchBar);


        Cursor cursor = addStudentAttendanceDataBase.AttendanceShowTeacherStudentData();
        while (cursor.moveToNext()){
            AttendanceUserModel userModel = new AttendanceUserModel(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4)
            ,cursor.getString(5));
            attendanceUserModels.add(userModel);
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
        ArrayList<AttendanceUserModel> FilterList = new ArrayList<>();
        for(AttendanceUserModel attendanceUserModel:attendanceUserModels){
            if (attendanceUserModel.getName().toLowerCase().contains(Text.toLowerCase())||attendanceUserModel.getFather().toLowerCase().contains(Text.toLowerCase())
                ||attendanceUserModel.getPhone().toLowerCase().contains(Text.toLowerCase())){
                FilterList.add(attendanceUserModel);
            }
        }
        if (FilterList.isEmpty()){
            Toast.makeText(this, "Name doesn't exists.....", Toast.LENGTH_SHORT).show();
        }else {
            adaptor.SetFilterList(FilterList);
        }
    }
}