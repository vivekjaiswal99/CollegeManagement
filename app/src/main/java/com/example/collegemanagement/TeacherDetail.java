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

public class TeacherDetail extends AppCompatActivity {
RecyclerView recyclerView;
ArrayList<SetTeacherUserModel> setTeacherUserModelArrayList;
TeacherAdaptor adaptor;
SetTeacherDataBase dataBase;
SearchView SearchBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_teacher_detail);

        SearchBar = findViewById(R.id.SearchBar);
        recyclerView = findViewById(R.id.recyclerView);
        setTeacherUserModelArrayList = new ArrayList<>();
        dataBase = new SetTeacherDataBase(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adaptor = new TeacherAdaptor(setTeacherUserModelArrayList,this);
        recyclerView.setAdapter(adaptor);
        Cursor cursor = dataBase.GetTeacherData();
        while (cursor.moveToNext()){
            SetTeacherUserModel setTeacherUserModel = new SetTeacherUserModel(cursor.getInt(0),cursor.getString(1),cursor.getString(2),
                    cursor.getString(4),cursor.getString(3),cursor.getString(5),cursor.getString(6));
            setTeacherUserModelArrayList.add(setTeacherUserModel);
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
      ArrayList<SetTeacherUserModel> FilterList = new ArrayList<>();
      for (SetTeacherUserModel setTeacherUserModel : setTeacherUserModelArrayList){
          if (setTeacherUserModel.getDepartment().toLowerCase().contains(Text.toLowerCase())||setTeacherUserModel.getName().toLowerCase().contains(Text.toLowerCase())){
              FilterList.add(setTeacherUserModel);
            }
        }
       if (FilterList.isEmpty()){
           Toast.makeText(this, "DATA DOESN'T EXISTS.....", Toast.LENGTH_SHORT).show();
       }else {
           adaptor.setFilterList(FilterList);
       }
    }
}