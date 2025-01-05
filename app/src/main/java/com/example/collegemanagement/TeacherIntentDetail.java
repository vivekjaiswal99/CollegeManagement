package com.example.collegemanagement;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TeacherIntentDetail extends AppCompatActivity {
 TextView TeacherNameTv,TeacherEmailTv,TeacherDepartmentTv,TeacherExperienceTv,TeacherQualificationTv,TeacherPhoneTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_teacher_intent_detail);

        TeacherNameTv = findViewById(R.id.TeacherNameTv);
        TeacherEmailTv = findViewById(R.id.TeacherEmailTv);
        TeacherDepartmentTv = findViewById(R.id.TeacherDepartmentTv);
        TeacherExperienceTv = findViewById(R.id.TeacherExperienceTv);
        TeacherQualificationTv = findViewById(R.id.TeacherQualificationTv);
        TeacherPhoneTv = findViewById(R.id.TeacherPhoneTv);

        TeacherNameTv.setText(getIntent().getExtras().getString("name"));
        TeacherEmailTv.setText(getIntent().getExtras().getString("email"));
        TeacherDepartmentTv.setText(getIntent().getExtras().getString("department"));
        TeacherExperienceTv.setText(getIntent().getExtras().getString("experience"));
        TeacherQualificationTv.setText(getIntent().getExtras().getString("qualification"));
        TeacherPhoneTv.setText(getIntent().getExtras().getString("phone"));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}