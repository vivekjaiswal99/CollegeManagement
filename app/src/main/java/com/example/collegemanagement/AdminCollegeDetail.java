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

public class AdminCollegeDetail extends AppCompatActivity {
EditText CollegeName_edt,EstablishedYear_edt,CollegeRaking_edt,CollegeLocation_edt,
        CollegePlacement_edt,CollegeStudentPass_edt,CollegeNumber_edt;
Button enter_btn;
CollegeDataBase collegeDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_admin_college_detail);

        CollegeName_edt = findViewById(R.id.CollegeName_edt);
        EstablishedYear_edt = findViewById(R.id.EstablishedYear_edt);
        CollegeRaking_edt = findViewById(R.id.CollegeRaking_edt);
        CollegeLocation_edt = findViewById(R.id.CollegeLocation_edt);
        CollegeStudentPass_edt = findViewById(R.id.CollegeStudentPass_edt);
        CollegeNumber_edt = findViewById(R.id.CollegeNumber_edt);
        CollegePlacement_edt = findViewById(R.id.CollegePlacement_edt);
        enter_btn = findViewById(R.id.enter_btn);
        collegeDataBase = new CollegeDataBase(this);

        enter_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String CollegeName,CollegeEstablished,CollegeRanking,CollegeLocation,CollegePass,Number,CollegePlacement;
                CollegeName = CollegeName_edt.getText().toString();
                CollegeEstablished = EstablishedYear_edt.getText().toString();
                CollegeRanking = CollegeRaking_edt.getText().toString();
                CollegePass = CollegeStudentPass_edt.getText().toString();
                CollegeLocation = CollegeLocation_edt.getText().toString();
                Number = CollegeNumber_edt.getText().toString();
                CollegePlacement = CollegePlacement_edt.getText().toString();

                if(CollegeName.isEmpty()){
                    CollegeName_edt.requestFocus();
                    CollegeName_edt.setError("can't empty");
                    return;
                } else if (!CollegeName.matches("[a-zA-Z0-9 ]+")) {
                    CollegeName_edt.requestFocus();
                    CollegeName_edt.setError("invalid try again");
                    return;
                } else if (CollegeEstablished.isEmpty()) {
                    EstablishedYear_edt.requestFocus();
                    EstablishedYear_edt.setError("can't empty");
                    return;
                } else if (!CollegeEstablished.matches("[a-zA-Z0-9 ]+")) {
                    EstablishedYear_edt.requestFocus();
                    EstablishedYear_edt.setError("invalid try again");
                    return;
                } else if (CollegeRanking.isEmpty()) {
                    CollegeRaking_edt.requestFocus();
                    CollegeRaking_edt.setError("can't empty");
                    return;
                } else if (!CollegeRanking.matches("[a-zA-Z0-9]+")) {
                    CollegeRaking_edt.requestFocus();
                    CollegeRaking_edt.setError("invalid try again");
                    return;
                } else if (CollegePass.isEmpty()) {
                    CollegeStudentPass_edt.requestFocus();
                    CollegeStudentPass_edt.setError("can't empty");
                    return;
                } else if (!CollegePass.matches("[0-9]+")) {
                    CollegeStudentPass_edt.requestFocus();
                    CollegeStudentPass_edt.setError("invalid try again");
                    return;
                } else if (CollegeLocation.isEmpty()) {
                    CollegeLocation_edt.requestFocus();
                    CollegeLocation_edt.setError("can't empty");
                    return;
                } else if (!CollegeLocation.matches("[a-zA-Z0-9 ]+")) {
                    CollegeLocation_edt.requestFocus();
                    CollegeLocation_edt.setError("invalid try again");
                    return;
                } else if (Number.isEmpty()) {
                    CollegeNumber_edt.requestFocus();
                    CollegeNumber_edt.setError("can't empty");
                    return;
                } else if (!Number.matches("[0-9]+\\d{9}")) {
                    CollegeNumber_edt.requestFocus();
                    CollegeNumber_edt.setError("invalid try again");
                    return;
                } else if (CollegePlacement.isEmpty()) {
                    CollegePlacement_edt.requestFocus();
                    CollegePlacement_edt.setError("can't empty");
                    return;
                }else if (!CollegePlacement.matches("[0-9]\\d{0,}+")) {
                    CollegePlacement_edt.requestFocus();
                    CollegePlacement_edt.setError("invalid try again");
                    return;
                }
                boolean a = collegeDataBase.CollegeNumberValidationNotSame(Number);
                if (a==true){
                    Toast.makeText(AdminCollegeDetail.this, "Phone number Already exists....", Toast.LENGTH_SHORT).show();
                }else {
                    boolean b = collegeDataBase.EnterButtonInsertDatas(CollegeName, CollegeEstablished, CollegeRanking, CollegePass, CollegePlacement,CollegeLocation,Number);
                    if (b==true) {
                        CollegeName_edt.setText("");
                        EstablishedYear_edt.setText("");
                        CollegeRaking_edt.setText("");
                        CollegeStudentPass_edt.setText("");
                        CollegeLocation_edt.setText("");
                        CollegeNumber_edt.setText("");
                        CollegePlacement_edt.setText("");
                        Toast.makeText(AdminCollegeDetail.this, "SuccessFully.........", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(AdminCollegeDetail.this, "Failed......", Toast.LENGTH_SHORT).show();
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