package com.example.collegemanagement;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminPasswordFragment extends Fragment {
    Button enter_btn;
    EditText email_edt,password_edt;
    LoginDataBase dataBase;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_admin_psaaword, container, false);

       email_edt = view.findViewById(R.id.email_edt);
       password_edt = view.findViewById(R.id.password_edt);
       enter_btn = view.findViewById(R.id.enter_btn);
       dataBase = new LoginDataBase(view.getContext());

       enter_btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String email,password;
               email = email_edt.getText().toString();
               password = password_edt.getText().toString();
               if (email.isEmpty()){
                   email_edt.requestFocus();
                   email_edt.setError("email id can't empty");
                   return;
               } else if (!email.matches("[a-zA-Z ]+[@][a-zA-Z]+[.][a-zA-Z]+")) {
                   email_edt.requestFocus();
                   email_edt.setError("email id invalid try again");
                   return;   
               } else if (password.isEmpty()) {
                   password_edt.requestFocus();
                   password_edt.setError("password can't empty");
                   return;
               } else if (!password.matches("[a-zA-Z0-9]+")) {
                   password_edt.requestFocus();
                   password_edt.setError("password invalid try again");
                   return;
               }
              boolean b= dataBase.PressEnterButtonOpenAdminPanel(email,password);
               if (b==true){
                   email_edt.setText("");
                   password_edt.setText("");
                    getParentFragmentManager().beginTransaction().replace(R.id.FrameLayout,new AdminFragment()).commit();
               }else {
                   Toast.makeText(getContext(), "Email and Password Doesn't Match..........", Toast.LENGTH_SHORT).show();
               }
           }
       });

        return view;
    }
}