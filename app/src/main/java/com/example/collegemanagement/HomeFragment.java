package com.example.collegemanagement;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class HomeFragment extends Fragment {
    CardView HmTeacherDetailImg,HmCollegeDetailImg,HmCourseDetailImg,
    HmCallImg,HmOnlineAdmissionImg,HmSemesterDetailImg,HmCollegeReviewImg,CheckAttendanceImg;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        HmTeacherDetailImg = view.findViewById(R.id.HmTeacherDetailImg);
        HmCollegeDetailImg = view.findViewById(R.id.HmCollegeDetailImg);
        HmCourseDetailImg = view.findViewById(R.id.HmCourseDetailImg);
        HmOnlineAdmissionImg = view.findViewById(R.id.HmOnlineAdmissionImg);
        HmSemesterDetailImg = view.findViewById(R.id.HmSemesterDetailImg);
        HmCollegeReviewImg = view.findViewById(R.id.HmCollegeReviewImg);
        HmCallImg = view.findViewById(R.id.HmCallImg);
  //      CheckAttendanceImg = view.findViewById(R.id.CheckAttendanceImg);

//        CheckAttendanceImg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });


        HmCallImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), StudentCall.class));
            }
        });

        HmTeacherDetailImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), TeacherDetail.class));
            }
        });

        HmCollegeDetailImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), CollegeDetail.class));
            }
        });

        HmCourseDetailImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), CourseDetail.class));
            }
        });

        HmOnlineAdmissionImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), OnlineAdmission.class));
            }
        });

        HmSemesterDetailImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),CheckSemesterDetail.class));
            }
        });

        HmCollegeReviewImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), CollegeReview.class));
            }
        });

        return view;
    }
}