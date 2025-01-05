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

public class DeleteSemesterDetails extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<SemesterUserModel> semesterUserModelArrayList;
    DeleteSemesterAdaptor adaptor;
    CheckSemesterDataBase checkSemesterDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_delete_semester_details);

        recyclerView = findViewById(R.id.recyclerView);
        semesterUserModelArrayList = new ArrayList<>();
        checkSemesterDataBase = new CheckSemesterDataBase(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adaptor = new DeleteSemesterAdaptor(semesterUserModelArrayList,this);
        recyclerView.setAdapter(adaptor);

        Cursor cursor  = checkSemesterDataBase.GetSemesterDetailShow();
        while(cursor.moveToNext()){
            SemesterUserModel semesterUserModel = new SemesterUserModel(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(7),
                    cursor.getString(3),cursor.getString(8),cursor.getString(4),cursor.getString(9),
                    cursor.getString(6),cursor.getString(11),cursor.getString(5),
                    cursor.getString(10),cursor.getString(12),cursor.getString(13));
                   semesterUserModelArrayList.add(semesterUserModel);

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}