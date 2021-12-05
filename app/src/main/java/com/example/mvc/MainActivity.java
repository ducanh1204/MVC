package com.example.mvc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText edtEmail, edtPassword;
    private TextView tvMessage;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtEmail = findViewById(R.id.edt_email);
        edtPassword = findViewById(R.id.edt_password);
        tvMessage = findViewById(R.id.tv_message);
        btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickLogin();
            }
        });
    }

    private void clickLogin() {
        String email = edtEmail.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();
        User user = new User(email,password);
        tvMessage.setVisibility(View.VISIBLE);
        if(user.isValidEmail() && user.isValidPassword()){
            tvMessage.setText("Login Success");
        }else{
            tvMessage.setText("Email or password invalid");
        }
    }
}