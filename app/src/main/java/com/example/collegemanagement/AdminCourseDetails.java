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

public class AdminCourseDetails extends AppCompatActivity {
EditText CoursePercentage_edt,CourseEligibility_edt,CourseFess_edt,CourseDuration_edt,CourseName_edt;
Button submits_btn;
CourseDataBase courseDataBase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_admin_course_details);

        CourseName_edt = findViewById(R.id.CourseName_edt);
        CourseEligibility_edt = findViewById(R.id.CourseEligibility_edt);
        CourseFess_edt = findViewById(R.id.CourseFess_edt);
        CourseDuration_edt = findViewById(R.id.CourseDuration_edt);
        CoursePercentage_edt = findViewById(R.id.CoursePercentage_edt);
        submits_btn = findViewById(R.id.submits_btn);
        courseDataBase = new CourseDataBase(this);

        submits_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String CourseName,CourseDuration,CourseFess,CourseEligibility,CoursePercentage;

                CourseName = CourseName_edt.getText().toString();
                CourseDuration = CourseDuration_edt.getText().toString();
                CourseFess = CourseFess_edt.getText().toString();
                CourseEligibility = CourseEligibility_edt.getText().toString();
                CoursePercentage = CoursePercentage_edt.getText().toString();

                if (CourseName.isEmpty()){
                    CourseName_edt.requestFocus();
                    CourseName_edt.setError("can't empty");
                    return;
                } else if (!CourseName.matches("[a-zA-Z ]+")) {
                    CourseName_edt.requestFocus();
                    CourseName_edt.setError("invalid try again");
                    return;
                } else if (CourseDuration.isEmpty()) {
                    CourseDuration_edt.requestFocus();
                    CourseDuration_edt.setError("can't empty");
                    return;
                } else if (!CourseDuration.matches("[a-zA-Z0-9 ]+")) {
                    CourseDuration_edt.requestFocus();
                    CourseDuration_edt.setError("invalid try again");
                    return;
                } else if (CourseFess.isEmpty()) {
                    CourseFess_edt.requestFocus();
                    CourseFess_edt.setError("can't empty");
                    return;
                } else if (!CourseFess.matches("[a-zA-Z0-9 ]+")) {
                    CourseFess_edt.requestFocus();
                    CourseFess_edt.setError("invalid try again");
                    return;
                } else if (CourseEligibility.isEmpty()) {
                    CourseEligibility_edt.requestFocus();
                    CourseEligibility_edt.setError("can't empty");
                    return;
                } else if (!CourseEligibility.matches("[a-zA-Z0-9 ]+")) {
                    CourseEligibility_edt.requestFocus();
                    CourseEligibility_edt.setError("invalid try again");
                    return;
                } else if (CoursePercentage.isEmpty()) {
                    CoursePercentage_edt.requestFocus();
                    CoursePercentage_edt.setError("can't empty");
                    return;
                } else if (!CoursePercentage.matches("[a-zA-Z0-9 ]+")) {
                    CoursePercentage_edt.requestFocus();
                    CoursePercentage_edt.setError("invalid try again");
                    return;
                }
                boolean b = courseDataBase.PressButtonSubmitInsertData(CourseName,CourseEligibility,CoursePercentage,CourseFess,CourseDuration);
                if (b==true){
                    CourseName_edt.setText("");
                    CourseDuration_edt.setText("");
                    CoursePercentage_edt.setText("");
                    CourseFess_edt.setText("");
                    CourseEligibility_edt.setText("");
                    Toast.makeText(AdminCourseDetails.this, "SuccessFully.......", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(AdminCourseDetails.this, "Failed.........", Toast.LENGTH_SHORT).show();
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