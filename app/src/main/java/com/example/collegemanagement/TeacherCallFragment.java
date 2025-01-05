package com.example.collegemanagement;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TeacherCallFragment extends Fragment {
EditText name_ed,phone_edt,department_edt;
Button enter_btn;
TeacherPhoneNumberDataBase phoneNumberDataBase;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
         View view = inflater.inflate(R.layout.fragment_teacher_call, container, false);

         name_ed = view.findViewById(R.id.name_edt);
         phone_edt = view.findViewById(R.id.phone_edt);
         department_edt = view.findViewById(R.id.department_edt);
         enter_btn = view.findViewById(R.id.enter_btn);
         phoneNumberDataBase = new TeacherPhoneNumberDataBase(view.getContext());

         enter_btn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String name, phone, department;
                 name = name_ed.getText().toString();
                 phone = phone_edt.getText().toString();
                 department = department_edt.getText().toString();
                 if (name.isEmpty()) {
                     name_ed.requestFocus();
                     name_ed.setError("can't empty");
                     return;
                 } else if (!name.matches("[a-zA-Z ]+")) {
                     name_ed.requestFocus();
                     name_ed.setError("invalid try again");
                     return;
                 } else if (phone.isEmpty()) {
                     phone_edt.requestFocus();
                     phone_edt.setError("can't empty");
                     return;
                 } else if (!phone.matches("[0-9]+\\d{9}")) {
                     phone_edt.requestFocus();
                     phone_edt.setError("invalid try again");
                     return;
                 } else if (department.isEmpty()) {
                     department_edt.requestFocus();
                     department_edt.setError("can't empty");
                     return;
                 } else if (!department.matches("[a-zA-Z ]+")) {
                     department_edt.requestFocus();
                     department_edt.setError("invalid try again");
                     return;
                 }
                 boolean a = phoneNumberDataBase.TeacherNumberValidationNumber(phone);
                 if (a == true) {
                     Toast.makeText(v.getContext(), "Phone Number AlReady exists.......", Toast.LENGTH_SHORT).show();
                 } else {
                     boolean b = phoneNumberDataBase.InsertDataBase(name, phone, department);
                     if (b == true) {
                         name_ed.setText("");
                         phone_edt.setText("");
                         department_edt.setText("");
                         Toast.makeText(v.getContext(), "SuccessFully......", Toast.LENGTH_SHORT).show();
                     } else {
                         Toast.makeText(v.getContext(), "Failed.......", Toast.LENGTH_SHORT).show();
                     }
                 }
             }
         });
        return view;
    }
}