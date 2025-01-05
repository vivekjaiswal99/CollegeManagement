package com.example.collegemanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DeleteItems extends AppCompatActivity {
CardView DelTeacherDetail,DelSetCollegeDetail,DelSetCourseDetail,DelStudentDetail,DelSemesterDetail,
        DelCollegeReview,DelCollegeAddStudentAttendance,DelSendNotificationImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_delete_items);

        DelTeacherDetail = findViewById(R.id.DelTeacherDetail);
        DelSetCollegeDetail = findViewById(R.id.DelSetCollegeDetail);
        DelSetCourseDetail = findViewById(R.id.DelSetCourseDetail);
        DelStudentDetail = findViewById(R.id.DelStudentDetail);
        DelSemesterDetail = findViewById(R.id.DelSemesterDetail);
        DelCollegeReview = findViewById(R.id.DelCollegeReview);
        DelCollegeAddStudentAttendance = findViewById(R.id.DelCollegeAddStudentAttendance);
        DelSendNotificationImg = findViewById(R.id.DelSendNotificationImg);

        DelTeacherDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DeleteItems.this, DeleteTeacherDetails.class));
            }
        });

        DelSetCollegeDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplication(), DeletesCollegeDetails.class));
            }
        });

        DelSetCourseDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplication(), DeleteCourseDetails.class));
            }
        });

        DelStudentDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplication(), DeleteAdmissionDetails.class));
            }
        });

        DelSemesterDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplication(), DeleteSemesterDetails.class));
            }
        });

        DelCollegeReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              startActivity(new Intent(getApplication(), DeleteCollegeReviewDetails.class));
            }
        });

        DelCollegeAddStudentAttendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             startActivity(new Intent(getApplication(), deleteAttend.class));
            }
        });

        DelSendNotificationImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             startActivity(new Intent(getApplication(), DeleteNotification.class));
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}