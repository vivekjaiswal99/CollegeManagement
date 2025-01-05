package com.example.collegemanagement;

import android.database.Cursor;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class DeleteCollegeReviewDetails extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<ReviewUserModel> reviewUserModelArrayList;
    CollegeReviewDataBase collegeReviewDataBase;
    DeleteCollegeReviewAdaptor adaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_delete_college_review_details);

        recyclerView = findViewById(R.id.recyclerView);
        reviewUserModelArrayList = new ArrayList<>();
        collegeReviewDataBase = new CollegeReviewDataBase(this);
        adaptor = new DeleteCollegeReviewAdaptor(reviewUserModelArrayList,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adaptor);
        Cursor cursor = collegeReviewDataBase.GetCollegeReviewData();
        while(cursor.moveToNext()){
            ReviewUserModel userModel = new ReviewUserModel(cursor.getInt(0),cursor.getString(1),cursor.getString(2),
                    cursor.getString(3),cursor.getString(4));
            reviewUserModelArrayList.add(userModel);
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}