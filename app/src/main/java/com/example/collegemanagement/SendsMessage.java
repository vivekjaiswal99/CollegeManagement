package com.example.collegemanagement;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.AbstractList;

public class SendsMessage extends AppCompatActivity {
    EditText message_edt, phone_edt;
    ImageView send_img;
    public static final int SMS_REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sends_message);

        message_edt = findViewById(R.id.message_edt);
        send_img = findViewById(R.id.send_img);
        phone_edt = findViewById(R.id.phone_edt);
        phone_edt.setText(getIntent().getStringExtra("phone"));
        phone_edt.setVisibility(View.GONE);

        send_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message, phone;
                message = message_edt.getText().toString();
                phone = phone_edt.getText().toString();
                if (message.isEmpty()){
                    message_edt.requestFocus();
                    message_edt.setError("message can't empty");
                    return;
                } else if (!message.matches("[a-zA-Z0-9 ]+")) {
                    message_edt.requestFocus();
                    message_edt.setError("invalid message Send try again doesn't used special symbols ....");
                    return;
                }

                if (ContextCompat.checkSelfPermission(SendsMessage.this, Manifest.permission.SEND_SMS)== PackageManager.PERMISSION_GRANTED) {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(phone, null, message, null, null);
                    message_edt.setText("");
                    Toast.makeText(SendsMessage.this, "Send SuccessFully.....", Toast.LENGTH_SHORT).show();
                } else {
                    ActivityCompat.requestPermissions(SendsMessage.this, new String[]{Manifest.permission.SEND_SMS}, SMS_REQUEST_CODE);
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