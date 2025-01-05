package com.example.collegemanagement;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Filter;
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

public class CollegeDetail extends AppCompatActivity {
RecyclerView recyclerView;
ArrayList<CollegeUserModel> collegeUserModelArrayList;
CollegeDataBase collegeDataBase;
CollegeAdaptor adaptor;
SearchView SearchBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_college_detail);

        SearchBar = findViewById(R.id.SearchBar);
        recyclerView = findViewById(R.id.recyclerView);
        collegeUserModelArrayList = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adaptor = new CollegeAdaptor(collegeUserModelArrayList,this);
        recyclerView.setAdapter(adaptor);
        collegeDataBase = new CollegeDataBase(this);
       Cursor cursor = collegeDataBase.GetCollegeDetailShow();
       while (cursor.moveToNext()){
           CollegeUserModel collegeUserModel = new CollegeUserModel(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),
                   cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7));
             collegeUserModelArrayList.add(collegeUserModel);
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
        ArrayList<CollegeUserModel> FilterList = new ArrayList<>();
        for(CollegeUserModel collegeUserModel:collegeUserModelArrayList){
            if (collegeUserModel.getName().toLowerCase().contains(Text.toLowerCase())){
                 FilterList.add(collegeUserModel);
            }
        }
        if (FilterList.isEmpty()){
            Toast.makeText(this, "DATA DOESN'T EXITS", Toast.LENGTH_SHORT).show();
        }else {
            adaptor.SetFilterList(FilterList);
        }
    }
}