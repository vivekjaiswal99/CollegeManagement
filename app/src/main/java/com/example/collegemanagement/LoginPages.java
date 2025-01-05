package com.example.collegemanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.tabs.TabLayout;

public class LoginPages extends AppCompatActivity {
    Button enter_btn,create_btn;
    EditText email_edt,password_edt;
    LoginDataBase dataBase;
    TextView ForGetPassword_tv;
    SessionManagerSharePreference sessionManagerSharePreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_pages);

        email_edt = findViewById(R.id.email_edt);
        password_edt = findViewById(R.id.password_edt);
        enter_btn = findViewById(R.id.enter_btn);
        create_btn = findViewById(R.id.create_btn);
        dataBase = new LoginDataBase(this);
        ForGetPassword_tv = findViewById(R.id.ForGetPassword_tv);
        sessionManagerSharePreference = new SessionManagerSharePreference(getApplicationContext());

        ForGetPassword_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginPages.this, ForgetPassword.class));
            }
        });

        create_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayouts,new CreateAccountFragment()).commit();
            }
        });

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
                } else if (!email.matches("[a-zA-Z]+[@][a-zA-Z]+[.][a-zA-Z]+")) {
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
                boolean b = dataBase.PressEnterButtonLoginValidation(email,password);
                if (b==true){
                    email_edt.setText("");
                    password_edt.setText("");
                    sessionManagerSharePreference.CreateSharePreference(email,password,null,null,null,null);
                     startActivity(new Intent(LoginPages.this,MainActivity.class));
                }else {
                    Toast.makeText(LoginPages.this,"Email and Password doesn't match try again...", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}