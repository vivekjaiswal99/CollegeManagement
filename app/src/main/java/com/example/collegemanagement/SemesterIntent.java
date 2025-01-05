package com.example.collegemanagement;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SemesterIntent extends AppCompatActivity {
TextView CourseNameTv,SubjectOneTv,TeacherOneTv,SubjectTwoTv,TeacherTwoTv,SubjectThreeTv,TeacherThreeTv,SubjectFourTv,
         TeacherFourTv,SubjectFiveTv,TeacherFiveTv,SubjectOtherTv,TeacherOtherTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_semester_intent);

        CourseNameTv = findViewById(R.id.CourseNameTv);
        SubjectOneTv = findViewById(R.id.SubjectOneTv);
        TeacherOneTv = findViewById(R.id.TeacherOneTv);
        SubjectTwoTv = findViewById(R.id.SubjectTwoTv);
        TeacherTwoTv = findViewById(R.id.TeacherTwoTv);
        SubjectThreeTv= findViewById(R.id.SubjectThreeTv);
        TeacherThreeTv = findViewById(R.id.TeacherThreeTv);
        SubjectFourTv = findViewById(R.id.SubjectFourTv);
        TeacherFourTv = findViewById(R.id.TeacherFourTv);
        SubjectFiveTv= findViewById(R.id.SubjectFiveTv);
        TeacherFiveTv = findViewById(R.id.TeacherFiveTv);
        SubjectOtherTv = findViewById(R.id.SubjectOtherTv);
        TeacherOtherTv = findViewById(R.id.TeacherOtherTv);

        CourseNameTv.setText(getIntent().getExtras().getString("course"));
        SubjectOneTv.setText(getIntent().getExtras().getString("subject1"));
        TeacherOneTv.setText(getIntent().getExtras().getString("teacher1"));
        SubjectTwoTv.setText(getIntent().getExtras().getString("subject2"));
        TeacherTwoTv.setText(getIntent().getExtras().getString("teacher2"));
        SubjectThreeTv.setText(getIntent().getExtras().getString("subject3"));
        TeacherThreeTv.setText(getIntent().getExtras().getString("teacher3"));
        SubjectFourTv.setText(getIntent().getExtras().getString("subject4"));
        TeacherFourTv.setText(getIntent().getExtras().getString("teacher4"));
        SubjectFiveTv.setText(getIntent().getExtras().getString("subject5"));
        TeacherFiveTv.setText(getIntent().getExtras().getString("teacher5"));
        SubjectOtherTv.setText(getIntent().getExtras().getString("subject"));
        TeacherOtherTv.setText(getIntent().getExtras().getString("teacher"));


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}