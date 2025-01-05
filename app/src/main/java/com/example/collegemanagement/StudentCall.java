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

public class StudentCall extends AppCompatActivity {
EditText name_edt,course_edt,phone_edt;
Button enter_btn;
StudentCallDataBase dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_student_call);

        name_edt = findViewById(R.id.name_edt);
        course_edt = findViewById(R.id.course_edt);
        phone_edt = findViewById(R.id.phone_edt);
        enter_btn = findViewById(R.id.enter_btn);
        dataBase = new StudentCallDataBase(this);


        enter_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name, course, phone;
                name = name_edt.getText().toString();
                course = course_edt.getText().toString();
                phone = phone_edt.getText().toString();

                if (name.isEmpty()) {
                    name_edt.requestFocus();
                    name_edt.setError("can't empty");
                    return;
                } else if (!name.matches("[a-zA-Z ]+")) {
                    name_edt.requestFocus();
                    name_edt.setError("invalid try again");
                    return;
                } else if (phone.isEmpty()) {
                    phone_edt.requestFocus();
                    phone_edt.setError("can't empty");
                    return;
                } else if (!phone.matches("[0-9]+\\d{9}")) {
                    phone_edt.requestFocus();
                    phone_edt.setError("invalid try again");
                    return;
                } else if (course.isEmpty()) {
                    course_edt.requestFocus();
                    course_edt.setError("can't empty");
                    return;
                } else if (!course.matches("[a-zA-Z ]+")) {
                    course_edt.requestFocus();
                    course_edt.setError("invalid try again");
                    return;
                }
                boolean a = dataBase.TeacherEnterStudentPhoneNumberNotSame(phone);
                if (a == true) {
                    Toast.makeText(StudentCall.this, "Phone Number AlReady exists...", Toast.LENGTH_SHORT).show();
                } else {
                    boolean b = dataBase.InsertDataShowStudent(name,course,phone);
                    if (b == true) {
                        name_edt.setText("");
                        course_edt.setText("");
                        phone_edt.setText("");
                        Toast.makeText(StudentCall.this, "SuccessFully.........", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(StudentCall.this, "Failed......", Toast.LENGTH_SHORT).show();
                    }
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