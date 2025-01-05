package com.example.collegemanagement;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SendNotification extends AppCompatActivity {
EditText student_edt,course_edt,phone_edt,year_edt;
Button submit_btn;
NotificationDataBase notificationDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_send_notification);


        student_edt = findViewById(R.id.student_edt);
        course_edt = findViewById(R.id.course_edt);
        phone_edt =  findViewById(R.id.phone_edt);
        submit_btn = findViewById(R.id.submit_btn);
        year_edt = findViewById(R.id.year_edt);

        notificationDataBase = new NotificationDataBase(this);

        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String name,course,phone,year;
               name = student_edt.getText().toString();
               course = course_edt.getText().toString();
               phone = phone_edt.getText().toString();
               year = year_edt.getText().toString();

               if (name.isEmpty()){
                   student_edt.requestFocus();
                   student_edt.setError("");
                   return;
               } else if (!name.matches("[a-zA-Z ]+")) {
                   student_edt.requestFocus();
                   student_edt.setError("");
                   return;
               } else if (course.isEmpty()) {
                   course_edt.requestFocus();
                   course_edt.setError("");
                   return;
               } else if (!course.matches("[a-zA-Z._ ]+")) {
                   course_edt.requestFocus();
                   course_edt.setError("");
                   return;
               } else if (phone.isEmpty()) {
                   phone_edt.requestFocus();
                   phone_edt.setError("");
                   return;
               }else if (!phone.matches("[0-9]+\\d{9}")){
                  phone_edt.requestFocus();
                  phone_edt.setError("");
                   return;
               } else if (year.isEmpty()) {
                   year_edt.requestFocus();
                   year_edt.setError("");
                   return;
               } else if (!year.matches("[0-9]+\\d{0,}")) {
                   year_edt.requestFocus();
                   year_edt.setError("");
                   return;
               }
                boolean b = notificationDataBase.InsertDataStudent(name,course,phone,year);
               if (b==true){
                   student_edt.setText("");
                   course_edt.setText("");
                   phone_edt.setText("");
                   year_edt.setText("");
                   Toast.makeText(SendNotification.this, "SuccessFully.........", Toast.LENGTH_SHORT).show();
               }else {
                   Toast.makeText(SendNotification.this, "Failed.........", Toast.LENGTH_SHORT).show();
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