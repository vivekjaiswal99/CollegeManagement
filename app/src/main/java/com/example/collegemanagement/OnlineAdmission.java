package com.example.collegemanagement;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class OnlineAdmission extends AppCompatActivity {
 EditText Name_edt,Email_edt,FatherName_edt,Location_edt,Number_edt;
 RadioButton male_rb,female_rb;
 Spinner spinner;
 Button enter_btn;
 OnlineAdmissionDataBase onlineAdmissionDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_online_admisssion);

         Name_edt = findViewById(R.id.Name_edt);
         Email_edt = findViewById(R.id.Email_edt);
         FatherName_edt = findViewById(R.id.FatherName_edt);
         Location_edt = findViewById(R.id.Location_edt);
         Number_edt = findViewById(R.id.Number_edt);
         male_rb = findViewById(R.id.male_rb);
         female_rb = findViewById(R.id.female_rb);
         enter_btn = findViewById(R.id.enter_btn);
         spinner = findViewById(R.id.spinner);
         onlineAdmissionDataBase = new OnlineAdmissionDataBase(this);

         enter_btn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String name,email,location,number,father;
                 String gender="";
                 String course="";
                 name = Name_edt.getText().toString();
                 email = Email_edt.getText().toString();
                 father = FatherName_edt.getText().toString();
                 location = Location_edt.getText().toString();
                 number = Number_edt.getText().toString();
                 if (male_rb.isChecked()){
                     gender = male_rb.getText().toString();
                 }if (female_rb.isChecked()){
                     gender = female_rb.getText().toString();
                 }if (spinner.isClickable()) {
                     course += spinner.getSelectedItem().toString();
                 }
                 if (name.isEmpty()) {
                     Name_edt.requestFocus();
                     Name_edt.setError("name can't eempty");
                     return;
                 } else if (!name.matches("[a-zA-Z ]+")) {
                     Name_edt.requestFocus();
                     Name_edt.setError("invalid try again");
                     return;
                 } else if (email.isEmpty()) {
                     Email_edt.requestFocus();
                     Email_edt.setError("email can't empty");
                     return;
                 } else if (!email.matches("[a-zA-Z0-9]+[@][g][m][a][i][l][.][c][o][m]")) {
                     Email_edt.requestFocus();
                     Email_edt.setError("invalid try again ending part gmail.com");
                     return;
                 } else if (father.isEmpty()) {
                     FatherName_edt.requestFocus();
                     FatherName_edt.setError("father nme can't empty");
                     return;
                 } else if (!father.matches("[a-zA-Z ]+")) {
                     FatherName_edt.requestFocus();
                     FatherName_edt.setError("invalid try again");
                     return;
                 } else if (number.isEmpty()) {
                     Number_edt.requestFocus();
                     Number_edt.setError("number can't empy");
                     return;
                 } else if (!number.matches("[0-9 ]+")) {
                     Number_edt.requestFocus();
                     Number_edt.setError("invalid try again");
                     return;
                 } else if (location.isEmpty()) {
                     Location_edt.requestFocus();
                     Location_edt.setError("can't empty");
                     return;
                 } else if (!location.matches("[a-zA-Z0-9 ]+")) {
                     Location_edt.requestFocus();
                     Location_edt.setError("invalid try again");
                     return;
                 }
               boolean a = onlineAdmissionDataBase.AdmissionStudentNumberValidationNumberNotSame(number);
                 if (a==true){
                     Toast.makeText(OnlineAdmission.this, "Phone Number AlReady Exists.....", Toast.LENGTH_SHORT).show();
                 }else {
                     boolean b = onlineAdmissionDataBase.PressButtonSubmitInsertData(name, email, gender, father, course, location, number);
                     if (b == true) {
                         Name_edt.setText("");
                         Number_edt.setText("");
                         Email_edt.setText("");
                         FatherName_edt.setText("");
                         Location_edt.setText("");
                         Number_edt.setText("");
                         Toast.makeText(OnlineAdmission.this, "SuccessFully.........", Toast.LENGTH_SHORT).show();
                     } else {
                         Toast.makeText(OnlineAdmission.this, "Failed.......", Toast.LENGTH_SHORT).show();
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