package com.example.collegemanagement;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CheckReviewCollege extends AppCompatActivity {
RecyclerView recyclerView;
ArrayList<ReviewUserModel> reviewUserModelArrayList;
CollegeReviewDataBase collegeReviewDataBase;
ReviewAdaptor adaptor;
SearchView SearchBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_check_review_college);

        SearchBar = findViewById(R.id.SearchBar);
        recyclerView = findViewById(R.id.recyclerView);
        reviewUserModelArrayList = new ArrayList<>();
        collegeReviewDataBase = new CollegeReviewDataBase(this);
        adaptor = new ReviewAdaptor(reviewUserModelArrayList,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adaptor);
        Cursor cursor = collegeReviewDataBase.GetCollegeReviewData();
        while(cursor.moveToNext()){
            ReviewUserModel userModel = new ReviewUserModel(cursor.getInt(0),cursor.getString(1),cursor.getString(2),
                    cursor.getString(3),cursor.getString(4));
            reviewUserModelArrayList.add(userModel);
        }

        SearchBar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                FilterList(newText);
                return true;
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void FilterList(String Text) {
        ArrayList<ReviewUserModel> FilterList = new ArrayList<>();
         for(ReviewUserModel reviewUserModel:reviewUserModelArrayList){
             if (reviewUserModel.getName().toLowerCase().contains(Text.toLowerCase())){
                FilterList.add(reviewUserModel);
             }
         }
         if (FilterList.isEmpty()){
             Toast.makeText(this, "DATA DOESN'T EXISTS......", Toast.LENGTH_SHORT).show();
         }else {
           adaptor.SetFilterList(FilterList);
         }
    }
}