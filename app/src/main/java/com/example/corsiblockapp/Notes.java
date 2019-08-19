package com.example.corsiblockapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Notes extends AppCompatActivity {
    private Calendar calendar;
    private String date;
    private SimpleDateFormat dateFormat;
    private EditText mEditText, dateText;
    private Button saveButton, viewButton;
    private TextView viewText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        calendar = Calendar.getInstance();
        dateFormat = new SimpleDateFormat("MMddyyyy");
        date = dateFormat.format(calendar.getTime());
        final String username = getIntent().getStringExtra("username");

        mEditText = findViewById(R.id.edit_text);
        saveButton = findViewById(R.id.button_send);
        viewButton = findViewById(R.id.button_view);
        viewText = findViewById(R.id.view_text);
        dateText = findViewById(R.id.dateText);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String file_name = username + date + ".txt";
                String text = mEditText.getText().toString();
                FileOutputStream fos = null;
                try {
                    fos = openFileOutput(file_name, MODE_PRIVATE);
                    fos.write(text.getBytes());
                    mEditText.getText().clear();
                    Toast.makeText(Notes.this, "Saved to " + getFilesDir() + "/" + file_name, Toast.LENGTH_LONG).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                finally{
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        });
        viewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tempdate = dateText.getText().toString();
                String tempfilename = username + tempdate.substring(0, 2) + tempdate.substring(3, 5) + tempdate.substring(6)+ ".txt";
                FileInputStream fis = null;
                    try {
                        fis = openFileInput(tempfilename);
                        InputStreamReader isr = new InputStreamReader(fis);
                        BufferedReader br = new BufferedReader(isr);
                        StringBuilder sb = new StringBuilder();
                        String text;
                        while ((text = br.readLine())!= null){
                            sb.append(text).append("\n");
                        }
                        viewText.setText(sb.toString());
                        dateText.setText("");
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }finally{
                        if(fis!=null){
                            try {
                                fis.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }


            }
        });


    }

}
