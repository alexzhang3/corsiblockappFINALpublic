package com.example.corsiblockapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.TreeMap;

public class Database extends AppCompatActivity {
    private static final String TAG = "Database";

    private Button mAddToDB, homepageButton;

    private EditText mAge, mName, mNumber;
    private DatabaseReference users;
    private FirebaseDatabase mFirebaseDatabase;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        mAge = findViewById(R.id.add_age);
        mName = findViewById(R.id.add_name);
        mNumber = findViewById(R.id.add_number);
        mAddToDB = findViewById(R.id.addButton1);
        homepageButton = findViewById(R.id.addButton2);
        mAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        users = FirebaseDatabase.getInstance().getReference("users");

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                    toastMessage("Successfully signed in with: " + user.getEmail());
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                    toastMessage("Successfully signed out.");
                }
                // ...
            }
        };
        homepageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Database.this, Homepage.class));
            }
        });
        mAddToDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addUserInfo();


            }
        });
    }
    private void addUserInfo()
    {
        String newAge = mAge.getText().toString();
        String newName = mName.getText().toString();
        String newNumber = mNumber.getText().toString();
        FirebaseUser user1 = mAuth.getCurrentUser();
        TreeMap<String, Integer> temp = new TreeMap<>();
        temp.put("Placeholder", 0);
        String userID = user1.getUid();
        User user = new User(userID, newName, newAge, newNumber, temp);
        users.child(userID).setValue(user);
        mAge.setText("");
        mName.setText("");
        mNumber.setText("");
        toastMessage("Info Added");
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
    private void toastMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}
