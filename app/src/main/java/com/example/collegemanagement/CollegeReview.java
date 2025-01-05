package com.example.collegemanagement;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CollegeReview extends AppCompatActivity {
EditText StudentName_edt,CourseName_edt,CollegeReview_edt,Semester_edt;
Button submit_btn;
CollegeReviewDataBase collegeReviewDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_college_review);

        StudentName_edt = findViewById(R.id.StudentName_edt);
        CourseName_edt = findViewById(R.id.CourseName_edt);
        CollegeReview_edt = findViewById(R.id.CollegeReview_edt);
        Semester_edt = findViewById(R.id.Semester_edt);
        submit_btn = findViewById(R.id.submit_btn);
        collegeReviewDataBase = new CollegeReviewDataBase(this);

        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String StudentName,CourseName,CollegeReview,Semester;

                StudentName = StudentName_edt.getText().toString();
                CourseName = CourseName_edt.getText().toString();
                CollegeReview = CollegeReview_edt.getText().toString();
                Semester = Semester_edt.getText().toString();

                if(StudentName.isEmpty()){
                    StudentName_edt.requestFocus();
                    StudentName_edt.setError("can't empty");
                    return;
                } else if (!StudentName.matches("[a-zA-Z ]+")) {
                    StudentName_edt.requestFocus();
                    StudentName_edt.setError("invalid try again");
                    return;
                } else if (CourseName.isEmpty()) {
                    CourseName_edt.requestFocus();
                    CourseName_edt.setError("can't empty");
                    return;
                } else if (!CourseName.matches("[a-zA-Z ]+")) {
                    CourseName_edt.requestFocus();
                    CourseName_edt.setError("invalid try again");
                    return;
                } else if (CollegeReview.isEmpty()) {
                    CollegeReview_edt.requestFocus();
                    CollegeReview_edt.setError("can't empty");
                    return;
                } else if (!CollegeReview.matches("[a-zA-Z ]+")) {
                    CollegeReview_edt.requestFocus();
                    CollegeReview_edt.setError("invalid try again");
                    return;
                } else if (Semester.isEmpty()) {
                    Semester_edt.requestFocus();
                    Semester_edt.setError("can't empty");
                    return;
                } else if (!Semester.matches("[a-zA-Z0-9 ]+")) {
                    Semester_edt.requestFocus();
                    Semester_edt.setError("invalid try again");
                    return;
                }
               boolean b = collegeReviewDataBase.PressSubmitButtonInsertData(StudentName,CourseName,Semester,CollegeReview);
                if(b==true){
                    StudentName_edt.setText("");
                    CourseName_edt.setText("");
                    CollegeReview_edt.setText("");
                    Semester_edt.setText("");
                    Toast.makeText(CollegeReview.this, "SuccessFully........", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(CollegeReview.this, "Failed.........", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}