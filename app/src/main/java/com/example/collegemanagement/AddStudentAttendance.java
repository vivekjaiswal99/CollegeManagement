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

public class AddStudentAttendance extends AppCompatActivity {
EditText StudentName_edt,FatherName_edt,StudentPhone_edt;
Button submit_btn;
AddStudentAttendanceDataBase addStudentAttendanceDataBase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_student_attendance);

        StudentName_edt = findViewById(R.id.StudentName_edt);
        FatherName_edt= findViewById(R.id.FatherName_edt);
        StudentPhone_edt = findViewById(R.id.StudentPhone_edt);
        submit_btn = findViewById(R.id.submit_btn);
        addStudentAttendanceDataBase = new AddStudentAttendanceDataBase(this);

        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name,father,phone;

                name = StudentName_edt.getText().toString();
                father = FatherName_edt.getText().toString();
                phone =  StudentPhone_edt.getText().toString();
                if(name.isEmpty()){
                    StudentName_edt.requestFocus();
                    StudentName_edt.setError("can't empty");
                    return;
                } else if (!name.matches("[a-zA-Z ]+")) {
                    StudentName_edt.requestFocus();
                    StudentName_edt.setError("invalid try again");
                    return;
                } else if (father.isEmpty()) {
                    FatherName_edt.requestFocus();
                    FatherName_edt.setError("can't empty");
                    return;
                } else if (!father.matches("[a-zA-Z ]+")) {
                    FatherName_edt.requestFocus();
                    FatherName_edt.setError("invalid try again");
                    return;
                } else if (phone.isEmpty()) {
                    StudentPhone_edt.requestFocus();
                    StudentPhone_edt.setError("can't empty");
                    return;
                } else if (!phone.matches("[0-9]+\\d{9}")) {
                  StudentPhone_edt.requestFocus();
                  StudentPhone_edt.setError("invalid try again");
                  return;
                }
               boolean a = addStudentAttendanceDataBase.StudentAttendanceNumberValidation(phone);
                if (a==true){
                    Toast.makeText(AddStudentAttendance.this, "Phone number Already exists....", Toast.LENGTH_SHORT).show();
                }else {
                    boolean b =  addStudentAttendanceDataBase.PressSubmitButtonInsertData(name,father,phone);
                    if (b==true){
                        StudentName_edt.setText("");
                        FatherName_edt.setText("");
                        StudentPhone_edt.setText("");
                        Toast.makeText(AddStudentAttendance.this, "SuccessFully........", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(AddStudentAttendance.this, "Failed..........", Toast.LENGTH_SHORT).show();
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