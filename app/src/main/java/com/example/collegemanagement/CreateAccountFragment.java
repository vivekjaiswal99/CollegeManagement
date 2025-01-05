package com.example.collegemanagement;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class CreateAccountFragment extends Fragment {
    EditText name_edt,email_edt,password_edt,phone_edt,location_edt;
    RadioButton male_rb,female_rb;
    Button enter_btn;
    LoginDataBase loginDataBase;
    SessionManagerSharePreference sessionManagerSharePreference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_create_account, container, false);

        name_edt = view.findViewById(R.id.name_edt);
        email_edt = view.findViewById(R.id.email_edt);
        password_edt = view.findViewById(R.id.password_edt);
        location_edt = view.findViewById(R.id.location_edt);
        phone_edt = view.findViewById(R.id.phone_edt);
        male_rb = view.findViewById(R.id.male_rb);
        female_rb = view.findViewById(R.id.female_rb);
        enter_btn =  view.findViewById(R.id.enter_btn);
        loginDataBase = new LoginDataBase(view.getContext());
        sessionManagerSharePreference = new SessionManagerSharePreference(getContext());

        enter_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name,email,password,location,phone;
                String gender="";
                name = name_edt.getText().toString();
                email = email_edt.getText().toString();
                password = password_edt.getText().toString();
                location = location_edt.getText().toString();
                phone = phone_edt.getText().toString();

                if (male_rb.isChecked()){
                    gender = male_rb.getText().toString();
                }if (female_rb.isChecked()){
                    gender = female_rb.getText().toString();
                 }
                if (name.isEmpty()){
                    name_edt.requestFocus();
                    name_edt.setError("name can't empty");
                    return;
                } else if (!name.matches("[a-zA-Z ]+")) {
                    name_edt.requestFocus();
                    name_edt.setError("invalid name try again");
                    return;
                } else if (email.isEmpty()) {
                    email_edt.requestFocus();
                    email_edt.setError("email id can't empty");
                    return;
                } else if (!email.matches("[a-zA-Z]+[@][g][m][a][i][l][.][c][o][m]")) {
                    email_edt.requestFocus();
                    email_edt.setError("email id  invalid try again @gmail.com");
                    return;
                } else if (password.isEmpty()) {
                    password_edt.requestFocus();
                    password_edt.setError("password can't empty");
                    return;
                } else if (!password.matches("[a-zA-Z0-9]+")) {
                    password_edt.requestFocus();
                    password_edt.setError("password invalid try again");
                    return;
                } else if (location.isEmpty()) {
                    location_edt.requestFocus();
                    location_edt.setError("address can't empty");
                    return;
                } else if (!location.matches("[a-zA-Z0-9 ]+")) {
                    location_edt.requestFocus();
                    location_edt.setError("address invalid try again");
                    return;
                } else if (phone.isEmpty()) {
                    phone_edt.requestFocus();
                    phone_edt.setError("phone number can't empty");
                    return;
                } else if (!phone.matches("[0-9]+\\d{9}")) {
                    phone_edt.requestFocus();
                    phone_edt.setError("phone number invalid try again");
                    return;
                }
                boolean b = loginDataBase.PressEnterButtonAlreadyExistsData(phone);
                if (b==true){
                    Toast.makeText(v.getContext(), "Account AlReady Exists....", Toast.LENGTH_SHORT).show();
                }else {
                   boolean c = loginDataBase.PressEnterButtonInsertData(name,email,password,gender,location,phone);
                   if (c==true){
                       name_edt.setText("");
                       email_edt.setText("");
                       password_edt.setText("");
                       location_edt.setText("");
                       phone_edt.setText("");
                       Toast.makeText(v.getContext(), "SuccessFully.....", Toast.LENGTH_SHORT).show();
                       sessionManagerSharePreference.CreateSharePreference(name,email,password,gender,location,phone);
                       startActivity(new Intent(getContext(), MainActivity.class));
                   }else {
                        Toast.makeText(v.getContext(), "Failed.......", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        return view;
    }
}