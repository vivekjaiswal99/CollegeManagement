package com.example.collegemanagement;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class CallFragment extends Fragment {
RecyclerView recyclerView;
ArrayList<PhoneUserModel> phoneUserModelArrayList;
TeacherPhoneNumberDataBase teacherPhoneNumberDataBase;
PhoneAdaptor adaptor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_call, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        phoneUserModelArrayList = new ArrayList<>();
        teacherPhoneNumberDataBase = new TeacherPhoneNumberDataBase(view.getContext());
        adaptor = new PhoneAdaptor(phoneUserModelArrayList,view.getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(adaptor);

        Cursor cursor = teacherPhoneNumberDataBase.ShowData();
        while(cursor.moveToNext()){
            PhoneUserModel userModel = new PhoneUserModel(cursor.getString(1),cursor.getString(2),cursor.getString(3));
            phoneUserModelArrayList.add(userModel);
        }

        return view;
    }
}