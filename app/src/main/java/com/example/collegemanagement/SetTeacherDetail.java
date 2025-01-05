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

public class SetTeacherDetail extends AppCompatActivity {
EditText name_edt,email_edt,department_edt,call_edt,experience_edt,qualification_edt;
Button submit_btn;
SetTeacherDataBase teacherDataBase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_set_teacher_detail);

        name_edt = findViewById(R.id.name_edt);
        email_edt = findViewById(R.id.email_edt);
        department_edt = findViewById(R.id.department_edt);
        call_edt = findViewById(R.id.call_edt);
        experience_edt = findViewById(R.id.experience_edt);
        qualification_edt = findViewById(R.id.qualification_edt);
        submit_btn = findViewById(R.id.submit_btn);
        teacherDataBase = new SetTeacherDataBase(this);

        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name, email, qualification, experience, call, department;
                name = name_edt.getText().toString();
                email = email_edt.getText().toString();
                qualification = qualification_edt.getText().toString();
                experience = experience_edt.getText().toString();
                call = call_edt.getText().toString();
                department = department_edt.getText().toString();

                if (name.isEmpty()) {
                    name_edt.requestFocus();
                    name_edt.setError("name can't empty");
                    return;
                } else if (!name.matches("[a-zA-Z ]+")) {
                    name_edt.requestFocus();
                    name_edt.setError("invalid name try again");
                    return;
                } else if (email.isEmpty()) {
                    email_edt.requestFocus();
                    email_edt.setError("email can't empty");
                    return;
                } else if (!email.matches("[a-zA-Z]+[@][g][m][a][i][l][.][c][o][m]")) {
                    email_edt.requestFocus();
                    email_edt.setError("invalid email try again proper end gmail.com");
                    return;
                } else if (qualification.isEmpty()) {
                    qualification_edt.requestFocus();
                    qualification_edt.setError("qualification can't empty");
                    return;
                } else if (!qualification.matches("[a-zA-Z._ ]+")) {
                    qualification_edt.requestFocus();
                    qualification_edt.setError("invalid try again");
                    return;
                } else if (department.isEmpty()) {
                    department_edt.requestFocus();
                    department_edt.setError("department can't empty");
                    return;
                } else if (!department.matches("[a-zA-Z]+")) {
                    department_edt.requestFocus();
                    department_edt.setError("invalid try again");
                    return;
                } else if (experience.isEmpty()) {
                    experience_edt.requestFocus();
                    experience_edt.setError("experience can't empty");
                    return;
                } else if (!experience.matches("[0-9]+\\d{0,1}")) {
                    experience_edt.requestFocus();
                    experience_edt.setError("invalid try again");
                    return;
                } else if (call.isEmpty()) {
                    call_edt.requestFocus();
                    call_edt.setError("call can't empty");
                    return;
                } else if (!call.matches("[0-9]+\\d{9}")) {
                    call_edt.requestFocus();
                    call_edt.setError("invalid try again");
                    return;
                }
                boolean a = teacherDataBase.TeacherNumberValidationNotSame(call);
                if (a == true) {
                    Toast.makeText(SetTeacherDetail.this, "Phone Number Already exists.....", Toast.LENGTH_SHORT).show();
                } else {
                    boolean b = teacherDataBase.PressButtonSubmitInsertData(name, email, department, qualification, experience, call);
                    if (b == true) {
                        name_edt.setText("");
                        email_edt.setText("");
                        department_edt.setText("");
                        qualification_edt.setText("");
                        experience_edt.setText("");
                        call_edt.setText("");
                        Toast.makeText(SetTeacherDetail.this, "SuccessFully.....", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(SetTeacherDetail.this, "Failed....", Toast.LENGTH_SHORT).show();
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