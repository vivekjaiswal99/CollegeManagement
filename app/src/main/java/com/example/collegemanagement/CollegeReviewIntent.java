package com.example.collegemanagement;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CollegeReviewIntent extends AppCompatActivity {
 TextView ReviewNane_tv,ReviewCourse_tv,ReviewSemester_tv,Review_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_college_review_intent);

        ReviewNane_tv = findViewById(R.id.ReviewNane_tv);
        ReviewCourse_tv = findViewById(R.id.ReviewCourse_tv);
        ReviewSemester_tv = findViewById(R.id.ReviewSemester_tv);
        Review_tv = findViewById(R.id.Review_tv);

        ReviewNane_tv.setText(getIntent().getExtras().getString("name"));
        ReviewCourse_tv.setText(getIntent().getExtras().getString("course"));
        ReviewSemester_tv.setText(getIntent().getExtras().getString("semester"));
        Review_tv.setText(getIntent().getExtras().getString("review"));



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}