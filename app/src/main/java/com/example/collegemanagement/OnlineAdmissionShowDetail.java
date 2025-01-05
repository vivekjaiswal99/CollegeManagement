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

public class OnlineAdmissionShowDetail extends AppCompatActivity {
RecyclerView recyclerView;
ArrayList<OnlineAdmissionUserModel> admissionUserModelArrayList;
OnlineAdmissionAdaptor adaptor;
OnlineAdmissionDataBase dataBase;
SearchView SearchBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_online_admission_showe_detail);

        SearchBar = findViewById(R.id.SearchBar);
        recyclerView = findViewById(R.id.recyclerView);
        admissionUserModelArrayList = new ArrayList<>();
        adaptor = new OnlineAdmissionAdaptor(admissionUserModelArrayList,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adaptor);
        dataBase = new OnlineAdmissionDataBase(this);

        Cursor cursor = dataBase.GetOnlineAdmissionData();
        while(cursor.moveToNext()){
            OnlineAdmissionUserModel userModel = new OnlineAdmissionUserModel(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),
                    cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7));
            admissionUserModelArrayList.add(userModel);
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
        ArrayList<OnlineAdmissionUserModel> FilterList = new ArrayList<>();
        for(OnlineAdmissionUserModel onlineAdmissionUserModel:admissionUserModelArrayList) {
            if (onlineAdmissionUserModel.getName().toLowerCase().contains(Text.toLowerCase())) {
                FilterList.add(onlineAdmissionUserModel);
            }
        }
        if (FilterList.isEmpty()){
            Toast.makeText(this, "DATA  DOESN'T EXISTS....", Toast.LENGTH_SHORT).show();
        }else {
            adaptor.SetFilterList(FilterList);
        }
    }
}