package com.example.collegemanagement;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CollegeIntent extends AppCompatActivity {
    TextView CollegeNameTv,CollegeEstablishedTv,CollegeRankingTv,CollegeStudentPassTv,CollegePlacementTv,CollegeLocationTv,CollegeNumberTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_college_intent);

        CollegeNameTv = findViewById(R.id.CollegeNameTv);
        CollegeEstablishedTv = findViewById(R.id.CollegeEstablishedTv);
        CollegeRankingTv = findViewById(R.id.CollegeRankingTv);
        CollegeStudentPassTv = findViewById(R.id.CollegeStudentPassTv);
        CollegePlacementTv = findViewById(R.id.CollegePlacementTv);
        CollegeLocationTv = findViewById(R.id.CollegeLocationTv);
        CollegeNumberTv = findViewById(R.id.CollegeNumberTv);

            CollegeNameTv.setText(getIntent().getExtras().getString("name"));
            CollegeEstablishedTv.setText(getIntent().getExtras().getString("established"));
            CollegeRankingTv.setText(getIntent().getExtras().getString("ranking"));
            CollegeStudentPassTv.setText(getIntent().getExtras().getString("student"));
            CollegePlacementTv.setText(getIntent().getExtras().getString("placement"));
            CollegeLocationTv.setText(getIntent().getExtras().getString("location"));
            CollegeNumberTv.setText(getIntent().getExtras().getString("number"));


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}