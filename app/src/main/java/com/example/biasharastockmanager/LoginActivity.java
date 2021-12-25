package com.example.biasharastockmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class LoginActivity extends AppCompatActivity {
    private Button loginButton;
    private Button createAccountButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButton = findViewById(R.id.email_sign_in_button);
        createAccountButton = findViewById(R.id.create_account_button);

        createAccountButton.setOnClickListener(v -> {
          startActivity(new Intent(LoginActivity.this,CreateAccountActivity.class));
        });

        loginButton.setOnClickListener(v -> {
            //we go to MainActivity
            startActivity(new Intent(LoginActivity.this,
                    MainActivity.class));
        });

    }
}