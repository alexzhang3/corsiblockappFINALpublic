package com.example.corsiblockapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button bLogin, bInfo;
    private EditText etUsername, etPassword;
    private TextView registerLink;
    private static final String TAG = "MainActivity";
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        bLogin = findViewById(R.id.bLogin);
        bInfo = findViewById(R.id.instruction_button);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        registerLink = findViewById(R.id.registerLink);
        bLogin.setOnClickListener(this);
        registerLink.setOnClickListener(this);
        bInfo.setOnClickListener(this);
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Intent intent1 = new Intent(MainActivity.this, Homepage.class);
                    intent1.putExtra("username", etUsername.getText().toString());
                   startActivity(intent1);
                }
                else {
                    // User is signed out
                }
                // ...
            }
        };
    }
    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bLogin: {
                String email = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                if(!email.equals("") && !password.equals("")){
                    mAuth.signInWithEmailAndPassword(email,password);

                }else{
                    toastMessage("Credentials not found.");
                }
            }
            break;

            case R.id.registerLink: {
                startActivity(new Intent(this, register.class));
                break;
            }
            case R.id.instruction_button: {
                startActivity(new Intent(this, Instruction.class));
            }
        }

    }
    //add a toast to show when successfully signed in

    /**
     * customizable toast
     *
     * @param message
     */
    private void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}



