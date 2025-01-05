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

public class deleteAttend extends AppCompatActivity {
    RecyclerView recyclerView;
    AddStudentAttendanceDataBase addStudentAttendanceDataBase;
    ArrayList<AttendanceUserModel> attendanceUserModels;
    DeleteAttendanceAdaptor adaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_delete_attend);

        recyclerView = findViewById(R.id.recyclerView);
        addStudentAttendanceDataBase = new AddStudentAttendanceDataBase(this);
        attendanceUserModels = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adaptor = new DeleteAttendanceAdaptor(attendanceUserModels,this);
        recyclerView.setAdapter(adaptor);

        Cursor cursor = addStudentAttendanceDataBase.AttendanceShowTeacherStudentData();
        while (cursor.moveToNext()){
            AttendanceUserModel userModel = new AttendanceUserModel(cursor.getInt(0),cursor.getString(1),cursor.getString(2),
                    cursor.getString(3),cursor.getString(4),cursor.getString(5));
            attendanceUserModels.add(userModel);
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}