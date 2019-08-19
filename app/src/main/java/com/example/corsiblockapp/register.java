package com.example.corsiblockapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
public class register extends AppCompatActivity{
     private Button bRegister, bLogin;
     private EditText etUsername, etPassword;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        bRegister = findViewById(R.id.bRegister);
        bLogin=findViewById(R.id.bLoginScreen);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        mAuth = FirebaseAuth.getInstance();

        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.createUserWithEmailAndPassword(etUsername.getText().toString(), etPassword.getText().toString());
            }
        });
        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               goLoginScreen();
            }
        });


    }
    public void goLoginScreen()
    {
        startActivity(new Intent(this, MainActivity.class));
    }

}
