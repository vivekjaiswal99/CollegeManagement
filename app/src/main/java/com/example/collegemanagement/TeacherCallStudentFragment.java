package com.example.collegemanagement;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.AbstractList;
import java.util.ArrayList;

public class TeacherCallStudentFragment extends Fragment {
    RecyclerView recyclerView;
    ArrayList<StudentCallNumberUserModel> studentCallNumberUserModels;
    StudentCallAdaptor adaptor;
    StudentCallDataBase studentCallDataBase;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_teacher_call_student, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        studentCallDataBase = new StudentCallDataBase(view.getContext());
        studentCallNumberUserModels = new ArrayList<>();
        adaptor = new StudentCallAdaptor(studentCallNumberUserModels, view.getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(adaptor);
        Cursor cursor = studentCallDataBase.ShowDataGetDetails();
        while (cursor.moveToNext()) {
            StudentCallNumberUserModel studentCallNumber = new StudentCallNumberUserModel(cursor.getString(1), cursor.getString(3), cursor.getString(2));
            studentCallNumberUserModels.add(studentCallNumber);
        }

        return view;
    }
}
