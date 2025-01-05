package com.example.collegemanagement;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class OnlineAdmissionIntent extends AppCompatActivity {
TextView StudentName_tv,StudentEmail_tv,StudentGender_tv,StudentFather_tv,StudentCourse_tv,StudentLocation_tv,StudentPhone_tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_online_admission_intent);

        StudentName_tv = findViewById(R.id.StudentName_tv);
        StudentEmail_tv = findViewById(R.id.StudentEmail_tv);
        StudentGender_tv = findViewById(R.id.StudentGender_tv);
        StudentFather_tv = findViewById(R.id.StudentFather_tv);
        StudentCourse_tv = findViewById(R.id.StudentCourse_tv);
        StudentLocation_tv = findViewById(R.id.StudentLocation_tv);
        StudentPhone_tv = findViewById(R.id.StudentPhone_tv);

        StudentName_tv.setText(getIntent().getExtras().getString("name"));
        StudentEmail_tv.setText(getIntent().getExtras().getString("email"));
        StudentGender_tv.setText(getIntent().getExtras().getString("gender"));
        StudentFather_tv.setText(getIntent().getExtras().getString("father"));
        StudentCourse_tv.setText(getIntent().getExtras().getString("course"));
        StudentLocation_tv.setText(getIntent().getExtras().getString("location"));
        StudentPhone_tv.setText(getIntent().getExtras().getString("phone"));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}