package com.example.collegemanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ForgetPassword extends AppCompatActivity {
EditText email_edt,password_edt2,password_edt;
Button  enter_btn;
LoginDataBase loginDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_forget_password);

        email_edt = findViewById(R.id.email_edt);
        password_edt = findViewById(R.id.password_edt);
        password_edt2 = findViewById(R.id.password_edt2);
        enter_btn = findViewById(R.id.enter_btn);
        loginDataBase = new LoginDataBase(this);

        enter_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email,password,password2;
                email = email_edt.getText().toString();
                password = password_edt.getText().toString();
                password2 = password_edt2.getText().toString();

                if (email.isEmpty()){
                    email_edt.requestFocus();
                    email_edt.setError("email can't empty");
                    return;
                } else if (!email.matches("[a-zA-Z0-9]+[@][g][m][a][i][l][.][c][o][m]")) {
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
                } else if (password2.isEmpty()) {
                    password_edt2.requestFocus();
                    password_edt2.setError("password confirm can't empty");
                    return;
                } else if (!password2.matches("[a-zA-Z0-9]+")) {
                    password_edt2.requestFocus();
                    password_edt2.setError("password invalid try again");
                    return;
                }if (password.equals(password2)){
                  boolean b = loginDataBase.PressForgetPasswordButtonUpdatedPassword(email,password);
                  if (b==true){
                    email_edt.setText("");
                    password_edt.setText("");
                    password_edt2.setText("");
                      Toast.makeText(ForgetPassword.this, "Password Updated SuccessFully....", Toast.LENGTH_SHORT).show();
                       startActivity(new Intent(ForgetPassword.this, LoginPages.class));
                   }else {
                      Toast.makeText(ForgetPassword.this, "password not Updated.....", Toast.LENGTH_SHORT).show();
                  }
                }else {
                    Toast.makeText(ForgetPassword.this, "Password doesn't match try again....", Toast.LENGTH_SHORT).show();
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