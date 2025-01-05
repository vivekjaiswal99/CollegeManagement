package com.example.collegemanagement;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class AdminFragment extends Fragment {
   CardView AdTeacherDetail,AdSetCollegeDetail,AdSetCourseDetail,AdStudentDetail,AdSemesterDetail,AdCollegeReview
           ,AdCollegeAddStudentAttendance,AdCollegeStudentAttendance,AdSendNotificationImg,AdSendNotification,AdDeleteImg;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_admin, container, false);

        AdTeacherDetail = view.findViewById(R.id.AdTeacherDetail);
        AdSetCollegeDetail = view.findViewById(R.id.AdSetCollegeDetail);
        AdSetCourseDetail = view.findViewById(R.id.AdSetCourseDetail);
        AdStudentDetail = view.findViewById(R.id.AdStudentDetail);
        AdSemesterDetail = view.findViewById(R.id.AdSemesterDetail);
        AdCollegeReview = view.findViewById(R.id.AdCollegeReview);
        AdCollegeStudentAttendance = view.findViewById(R.id.AdCollegeStudentAttendance);
        AdCollegeAddStudentAttendance = view.findViewById(R.id.AdCollegeAddStudentAttendance);
        AdSendNotificationImg = view.findViewById(R.id.AdSendNotificationImg);
        AdSendNotification = view.findViewById(R.id.AdSendNotification);
        AdDeleteImg = view.findViewById(R.id.AdDeleteImg);

        AdDeleteImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), DeleteItems.class));
            }
        });

        AdSendNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             startActivity(new Intent(getContext(), GetNotificationDetailsDataBase.class));
            }
        });

        AdSendNotificationImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), SendNotification.class));
            }
        });

        AdTeacherDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), SetTeacherDetail.class));
            }
        });

        AdSetCollegeDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), AdminCollegeDetail.class));
            }
        });

        AdSetCourseDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), AdminCourseDetails.class));
            }
        });

        AdStudentDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), OnlineAdmissionShowDetail.class));
            }
        });

        AdSemesterDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),AdSemesterDetail.class));
            }
        });

        AdCollegeReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), CheckReviewCollege.class));
            }
        });

        AdCollegeAddStudentAttendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), AddStudentAttendance.class));
            }
        });
        AdCollegeStudentAttendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              startActivity(new Intent(getContext(), AdCheckAttendanceStudent.class));
            }
        });
        return view;
    }
}