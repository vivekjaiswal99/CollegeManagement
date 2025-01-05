package com.example.collegemanagement;

import android.os.Bundle;
import android.text.style.TabStopSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AdSemesterDetail extends AppCompatActivity {
 EditText CourseName_edt,SubjectOne_edt,TeacherOne_edt,SubjectTwo_edt,TeacherTwo_edt,SubjectThree_edt,TeacherThree_edt,
        SubjectFour_edt,TeacherFour_edt,SubjectFive_edt,TeacherFive_edt,SubjectSix_edt,TeacherSix_edt;
 Button enter_btn;
 CheckSemesterDataBase checkSemesterDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ad_semester_detail);

        CourseName_edt = findViewById(R.id.CourseName_edt);

        SubjectOne_edt = findViewById(R.id.SubjectOne_edt);
        TeacherOne_edt = findViewById(R.id.TeacherOne_edt);

        SubjectTwo_edt = findViewById(R.id.SubjectTwo_edt);
        TeacherTwo_edt = findViewById(R.id.TeacherTwo_edt);

        SubjectThree_edt = findViewById(R.id.SubjectThree_edt);
        TeacherThree_edt = findViewById(R.id.TeacherThree_edt);

        SubjectFour_edt = findViewById(R.id.SubjectFour_edt);
        TeacherFour_edt= findViewById(R.id.TeacherFour_edt);

        SubjectFive_edt = findViewById(R.id.SubjectFive_edt);
        TeacherFive_edt = findViewById(R.id.TeacherFive_edt);

        SubjectSix_edt = findViewById(R.id.SubjectSix_edt);
        TeacherSix_edt = findViewById(R.id.TeacherSix_edt);

        enter_btn = findViewById(R.id.enter_btn);

        checkSemesterDataBase = new CheckSemesterDataBase(this);

        enter_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String CourseName,SubjectOne,TeacherOne,SubjectTwo,TeacherTwo,SubjectThree,TeacherThree,SubjectFour,
                        TeacherFour,SubjectFive,TeacherFive,SubjectSix,TeacherSix;

                CourseName = CourseName_edt.getText().toString();
                SubjectOne = SubjectOne_edt.getText().toString();
                TeacherOne = TeacherOne_edt.getText().toString();
                SubjectTwo = SubjectTwo_edt.getText().toString();
                TeacherTwo = TeacherTwo_edt.getText().toString();
                SubjectThree = SubjectThree_edt.getText().toString();
                TeacherThree = TeacherThree_edt.getText().toString();
                SubjectFour = SubjectFour_edt.getText().toString();
                TeacherFour = TeacherFour_edt.getText().toString();
                SubjectFive = SubjectFive_edt.getText().toString();
                TeacherFive = TeacherFive_edt.getText().toString();
                SubjectSix = SubjectSix_edt.getText().toString();
                TeacherSix = TeacherSix_edt.getText().toString();

                if (CourseName.isEmpty()){
                    CourseName_edt.requestFocus();
                    CourseName_edt.setError("can't empty");
                    return;
                } else if (!CourseName.matches("[a-zA-Z ]+")) {
                    CourseName_edt.requestFocus();
                    CourseName_edt.setError("invalid try again");
                    return;
                } else if (SubjectOne.isEmpty()) {
                    SubjectOne_edt.requestFocus();
                    SubjectOne_edt.setError("can't empty");
                    return;
                } else if (!SubjectOne.matches("[a-zA-Z ]+")) {
                    SubjectOne_edt.requestFocus();
                    SubjectOne_edt.setError("invalid try again");
                    return;
                } else if (TeacherOne.isEmpty()) {
                    TeacherOne_edt.requestFocus();
                    TeacherOne_edt.setError("can't empty");
                    return;
                } else if (!TeacherOne.matches("[a-zA-Z ]+")) {
                    TeacherOne_edt.requestFocus();
                    TeacherOne_edt.setError("invalid try again");
                    return;
                } else if (SubjectTwo.isEmpty()) {
                    SubjectTwo_edt.requestFocus();
                    SubjectTwo_edt.setError("can't empty");
                    return;
                } else if (!SubjectTwo.matches("[a-zA-Z ]+")) {
                    SubjectTwo_edt.requestFocus();
                    SubjectTwo_edt.setError("invalid try again");
                    return;
                }else if (TeacherTwo.isEmpty()) {
                    TeacherTwo_edt.requestFocus();
                    TeacherTwo_edt.setError("can't empty");
                    return;
                } else if (!TeacherTwo.matches("[a-zA-Z ]+")) {
                    TeacherTwo_edt.requestFocus();
                    TeacherTwo_edt.setError("invalid try again");
                    return;
                }else if (SubjectThree.isEmpty()) {
                    SubjectThree_edt.requestFocus();
                    SubjectThree_edt.setError("can't empty");
                    return;
                } else if (!SubjectThree.matches("[a-zA-Z ]+")) {
                    SubjectThree_edt.requestFocus();
                    SubjectThree_edt.setError("invalid try again");
                    return;
                }else if (TeacherThree.isEmpty()) {
                    TeacherThree_edt.requestFocus();
                    TeacherThree_edt.setError("can;t empty");
                    return;
                } else if (!TeacherThree.matches("[a-zA-Z ]+")) {
                    TeacherThree_edt.requestFocus();
                    TeacherThree_edt.setError("invalid try again");
                    return;
                }else if (SubjectFour.isEmpty()) {
                    SubjectFour_edt.requestFocus();
                    SubjectFour_edt.setError("can't empty");
                    return;
                } else if (!SubjectFour.matches("[a-zA-Z ]+")) {
                    SubjectFour_edt.requestFocus();
                    SubjectFour_edt.setError("invalid try again");
                    return;
                }else if (TeacherFour.isEmpty()) {
                    TeacherFour_edt.requestFocus();
                    TeacherFour_edt.setError("can't empty");
                    return;
                }else if (!TeacherFour.matches("[a-zA-Z ]+")) {
                    TeacherFour_edt.requestFocus();
                    TeacherFour_edt.setError("invalid try again");
                    return;
                }else if (SubjectFive.isEmpty()) {
                    SubjectFive_edt.requestFocus();
                    SubjectFive_edt.setError("can't empty");
                    return;
                }else if (!SubjectFive.matches("[a-zA-Z ]+")) {
                    SubjectFive_edt.requestFocus();
                    SubjectFive_edt.setError("invalid try again");
                    return;
                }else if (TeacherFive.isEmpty()) {
                    TeacherFive_edt.requestFocus();
                    TeacherFive_edt.setError("can't empty");
                    return;
                }else if (!TeacherFive.matches("[a-zA-Z ]+")) {
                    TeacherFive_edt.requestFocus();
                    TeacherFive_edt.setError("invalid try again");
                    return;
                }else if (SubjectSix.isEmpty()) {
                    SubjectSix_edt.requestFocus();
                    SubjectSix_edt.setError("can't empty");
                    return;
                }else if (!SubjectSix.matches("[a-zA-Z ]+")) {
                    SubjectSix_edt.requestFocus();
                    SubjectSix_edt.setError("invalid try again");
                    return;
                }
                else if (TeacherSix.isEmpty()) {
                    TeacherSix_edt.requestFocus();
                    TeacherSix_edt.setError("can't empty");
                    return;
                }else if (!TeacherSix.matches("[a-zA-Z ]+")) {
                    TeacherSix_edt.requestFocus();
                    TeacherSix_edt.setError("invalid try again");
                    return;
                }
              boolean b = checkSemesterDataBase.EnterButtonInsertData(CourseName,SubjectOne,SubjectTwo,SubjectThree,SubjectFour,
                      SubjectFive,TeacherOne,TeacherTwo,TeacherThree,TeacherFour,TeacherFive,SubjectSix,TeacherSix);
                if (b==true){
                    CourseName_edt.setText("");
                    SubjectOne_edt.setText("");
                    TeacherOne_edt.setText("");
                    SubjectTwo_edt.setText("");
                    TeacherTwo_edt.setText("");
                    SubjectThree_edt.setText("");
                    TeacherThree_edt.setText("");
                    SubjectFour_edt.setText("");
                    TeacherFour_edt.setText("");
                    SubjectFive_edt.setText("");
                    TeacherFive_edt.setText("");
                    SubjectSix_edt.setText("");
                    TeacherSix_edt.setText("");
                    Toast.makeText(AdSemesterDetail.this, "SuccessFully......", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(AdSemesterDetail.this, "Failed........", Toast.LENGTH_SHORT).show();
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