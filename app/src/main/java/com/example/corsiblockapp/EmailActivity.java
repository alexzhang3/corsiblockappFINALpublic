package com.example.corsiblockapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

public class EmailActivity extends AppCompatActivity {
    private EditText mEditTextTo;
    private EditText nameView;
    private Button buttonSend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        mEditTextTo = findViewById(R.id.edit_text_to);
        nameView = findViewById(R.id.nameText);
        buttonSend = findViewById(R.id.button_send);
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
                                          public void onClick(View v) {
                                              sendMail();
                                          }
                                      }
        );
    }

    private void sendMail() {
        String recipientList = mEditTextTo.getText().toString();
        String[] recipients = recipientList.split(",");
        String name = nameView.getText().toString();
        String blockSpan = getIntent().getStringExtra("blockspan");
        String totalScore = getIntent().getStringExtra("totalScore");
        String message = name + " has obtained a block span of: " + blockSpan + " and a total score of: " + totalScore;
        String subject = "Corsi Block Test Scores";

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, recipients);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);

        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "Choose an email client"));
    }

}
