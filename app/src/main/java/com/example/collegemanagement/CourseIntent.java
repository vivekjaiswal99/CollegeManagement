package com.example.collegemanagement;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CourseIntent extends AppCompatActivity {
TextView CourseName_tv,CourseDuration_tv,CourseFess_tv,CourseEligibility_tv,CoursePercentage_tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_course_intent);

        CourseName_tv = findViewById(R.id.CourseName_tv);
        CourseDuration_tv = findViewById(R.id.CourseDuration_tv);
        CourseFess_tv = findViewById(R.id.CourseFess_tv);
        CourseEligibility_tv = findViewById(R.id.CourseEligibility_tv);
        CoursePercentage_tv = findViewById(R.id.CoursePercentage_tv);

        CourseName_tv.setText(getIntent().getExtras().getString("name"));
        CourseDuration_tv.setText(getIntent().getExtras().getString("duration"));
        CourseEligibility_tv.setText(getIntent().getExtras().getString("eligibility"));
        CourseFess_tv.setText(getIntent().getExtras().getString("fess"));
        CoursePercentage_tv.setText(getIntent().getExtras().getString("percentage"));



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}