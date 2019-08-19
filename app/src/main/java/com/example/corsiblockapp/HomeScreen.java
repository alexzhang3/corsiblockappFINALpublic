package com.example.corsiblockapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Bundle;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class HomeScreen extends AppCompatActivity {
    public int level = 2;
    public int totalScore = 0;
    public int numCorrectTrials = 0;
    public static int b1 = 0;
    public static int b2 = 0;
    public static int b3 = 0;
    public static int b4 = 0;
    public static int b5 = 0;
    public static int b6 = 0;
    public static int b7 = 0;
    public static int b8 = 0;
    public static int b9 = 0;
    private Button buttonNotes, buttonLog, buttonGraph;
    public static int position = 1;
    private Calendar calendar;
    private String date;
    private SimpleDateFormat dateFormat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        final Button myButton1 = (Button) findViewById(R.id.myButton1);
        final Button myButton2 = (Button) findViewById(R.id.myButton2);
        final Button myButton3 = (Button) findViewById(R.id.myButton3);
        final Button myButton4 = (Button) findViewById(R.id.myButton4);
        final Button myButton5 = (Button) findViewById(R.id.myButton5);
        final Button myButton6 = (Button) findViewById(R.id.myButton6);
        final Button myButton7 = (Button) findViewById(R.id.myButton7);
        final Button myButton8 = (Button) findViewById(R.id.myButton8);
        final Button myButton9 = (Button) findViewById(R.id.myButton9);
        final Button startButton = (Button) findViewById(R.id.startButton);
        final TextView myText = (TextView) findViewById(R.id.textView);
        final TextView scoreView = (TextView) findViewById(R.id.myText1);
        final TextView blockSpan = (TextView) findViewById(R.id.myText2);
        final Button restartButton = (Button) findViewById(R.id.restart);
        final Button emailButton = (Button) findViewById(R.id.emailButton);
        buttonNotes = findViewById(R.id.buttonNotes);
        buttonLog = findViewById(R.id.buttonLog);
        buttonGraph = findViewById(R.id.buttonGraph);
        calendar = Calendar.getInstance();
        dateFormat = new SimpleDateFormat("MMddyyyy");
        date = dateFormat.format(calendar.getTime());
        buttonGraph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeScreen.this, Graph.class);
                intent.putExtra("username", getIntent().getStringExtra("username"));
                startActivity(intent);
            }
        });
        buttonLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = getIntent().getStringExtra("username");
                String file_name1 = username + date + "totalScore.txt";
                String file_name2 = username + date + "blockSpan.txt";
                myText.setText("Scores saved");
                String  text1= totalScore + "\n";
                String text2 = blockSpan + "\n";
                FileOutputStream fos = null;
                try {
                    fos = openFileOutput(file_name1, MODE_PRIVATE);
                    fos.write(text1.getBytes());
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
                FileOutputStream fos2 = null;
                try {
                    fos2 = openFileOutput(file_name2, MODE_PRIVATE);
                    fos2.write(text2.getBytes());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                finally{
                    if (fos2 != null) {
                        try {
                            fos2.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        emailButton.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v)
                    {
                        openEmailActivity();
                    }
                }
        );
        buttonNotes.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View view) {
                                               Intent intent = new Intent(HomeScreen.this, Notes.class);
                                               String a = getIntent().getStringExtra("username");
                                               intent.putExtra("username", a);
                                               startActivity(intent);
                                           }
                                       }
        );
        restartButton.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        level = 2;
                        totalScore = 0;
                        numCorrectTrials = 0;
                        scoreView.setText("Total Score: 0");
                        blockSpan.setText("Block Span: 2");
                        position = 1;
                        b1 = 0;
                        b2= 0;
                        b3= 0;
                        b4=0;
                        b5=0;
                        b6= 0;
                        b7 = 0;
                        b8 = 0;
                        b9 = 0;
                        myText.setText("Restarted!");
                    }
                }
        );
        myButton1.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        b1 = position;
                        position++;
                    }
                }
        );
        myButton2.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        b2 = position;
                        position++;

                    }
                }
        );
        myButton3.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        b3 = position;
                        position++;
                    }
                }
        );
        myButton4.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        b4 = position;
                        position++;
                    }
                }
        );
        myButton5.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        b5 = position;
                        position++;
                    }
                }
        );
        myButton6.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        b6 = position;
                        position++;
                    }
                }
        );
        myButton7.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        b7 = position;
                        position++;
                    }
                }
        );
        myButton8.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        b8 = position;
                        position++;
                    }
                }
        );
        myButton9.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        b9 = position;
                        position++;
                    }
                }
        );
        myButton9.setOnLongClickListener(
                new Button.OnLongClickListener(){
                    public boolean onLongClick(View v)
                    {
                        level = 9;
                        return true;
                    }
                }
        );
        startButton.setOnClickListener(
                new Button.OnClickListener() {

                    public void onClick(View v) {
                        if (level == 2) {
                            myText.setText("Level 2 - 1st Attempt");
                            myButton8.setBackgroundColor(Color.YELLOW);
                            final Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    // Do something after 1s = 1000ms
                                    myButton8.setBackgroundColor(Color.BLUE);
                                    myButton5.setBackgroundColor(Color.YELLOW);
                                    final Handler handler2 = new Handler();
                                    handler2.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            // Do something after 1s = 1000ms
                                            myButton5.setBackgroundColor(Color.BLUE);
                                        }
                                    }, 1000);
                                }
                            }, 1000);


                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    // Do something after 5s = 5000ms
                                    if (b8 == 1 && b5 == 2 && b1 == 0 && b2 == 0 && b3 == 0 && b4 == 0 && b6 == 0 && b7 == 0 && b9 == 0) {
                                        myText.setText("You passed level 2");
                                        numCorrectTrials ++;
                                        totalScore = numCorrectTrials * level;
                                        scoreView.setText("Total Score: " + totalScore);
                                        blockSpan.setText("Block Span: " + level);
                                        level = 3;
                                        b8 = 0;
                                        b5 = 0;
                                        position = 1;
                                    }
                                    else {
                                        b1 = b2 = b3 = b4 = b5 = b6 = b7 = b8 = b9 = 0;
                                        position = 1;
                                        myText.setText("Try again.");
                                        final Handler handlertemp = new Handler();
                                        handlertemp.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                myText.setText("Level 2 - 2nd Attempt");
                                            }
                                        }, 2000);
                                        myButton6.setBackgroundColor(Color.YELLOW);
                                        final Handler handler2 = new Handler();
                                        handler2.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                // Do something after 1s = 1000ms
                                                myButton6.setBackgroundColor(Color.BLUE);
                                                myButton4.setBackgroundColor(Color.YELLOW);
                                                handler2.postDelayed(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        // Do something after 1s = 1000ms
                                                        myButton4.setBackgroundColor(Color.BLUE);
                                                    }
                                                }, 1000);
                                            }
                                        }, 1000);
                                        final Handler handler = new Handler();
                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                if (b6 == 1 && b4 == 2 && b1 == 0 && b2 == 0 && b3 == 0 && b5 == 0 && b7 == 0 && b8 == 0 && b9 == 0) {
                                                    position = 1;
                                                    myText.setText("You passed level 2");
                                                    numCorrectTrials ++;
                                                    totalScore = numCorrectTrials * level;
                                                    scoreView.setText("Total Score: " + totalScore);
                                                    blockSpan.setText("Block Span: " + level);
                                                    level = 3;
                                                    b4 = 0;
                                                    b6 = 0;
                                                }
                                                else {
                                                    position = 1;
                                                    myText.setText("You failed!");
                                                    level = 2;
                                                    b1 = b2 = b3 = b4 = b5 = b6 = b7 =b8 = b9 = 0;
                                                    numCorrectTrials = 0;
                                                    totalScore = 0;
                                                    scoreView.setText("Total Score: " + totalScore);
                                                    blockSpan.setText("Block Span: " + level);
                                                }

                                            }
                                        }, 4000);

                                    }
                                }
                            }, 4000);
                        }
                        else if (level == 3) {
                            myText.setText("Level 3 - 1st Attempt");
                            myButton4.setBackgroundColor(Color.YELLOW);
                            final Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    // Do something after 1s = 1000ms
                                    myButton4.setBackgroundColor(Color.BLUE);
                                    myButton7.setBackgroundColor(Color.YELLOW);
                                    final Handler handler2 = new Handler();
                                    handler2.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            // Do something after 1s = 1000ms
                                            myButton7.setBackgroundColor(Color.BLUE);
                                            myButton2.setBackgroundColor(Color.YELLOW);
                                            final Handler handler3 = new Handler();
                                            handler3.postDelayed(new Runnable() {
                                                @Override
                                                public void run() {
                                                    // Do something after 1s = 1000ms
                                                    myButton2.setBackgroundColor(Color.BLUE);
                                                }
                                            }, 1000);
                                        }
                                    }, 1000);
                                }
                            }, 1000);


                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    // Do something after 5s = 5000ms
                                    if (b4 == 1 && b7 == 2 && b2 == 3 && b1 == 0 && b3 == 0 && b5 == 0 && b6 == 0 && b8 == 0 && b9 == 0) {
                                        myText.setText("You passed level 3");
                                        numCorrectTrials ++;
                                        totalScore = numCorrectTrials * level;
                                        scoreView.setText("Total Score: " + totalScore);
                                        blockSpan.setText("Block Span: " + level);
                                        level = 4;
                                        b4 = 0;
                                        b7 = 0;
                                        b2 = 0;
                                        position = 1;
                                    }
                                    else {
                                        b1 = b2 = b3 = b4 = b5 = b6 = b7 = b8 = b9 = 0;
                                        position = 1;
                                        myText.setText("Try again.");
                                        final Handler handlertemp = new Handler();
                                        handlertemp.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                myText.setText("Level 3 - 2nd Attempt");
                                            }
                                        }, 3000);
                                        myButton8.setBackgroundColor(Color.YELLOW);
                                        final Handler handler2 = new Handler();
                                        handler2.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                // Do something after 1s = 1000ms
                                                myButton8.setBackgroundColor(Color.BLUE);
                                                myButton1.setBackgroundColor(Color.YELLOW);
                                                handler2.postDelayed(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        // Do something after 1s = 1000ms
                                                        myButton1.setBackgroundColor(Color.BLUE);
                                                        myButton5.setBackgroundColor(Color.YELLOW);
                                                        handler2.postDelayed(new Runnable() {
                                                            @Override
                                                            public void run() {
                                                                // Do something after 1s = 1000ms
                                                                myButton5.setBackgroundColor(Color.BLUE);

                                                            }
                                                        }, 1000);
                                                    }
                                                }, 1000);
                                            }
                                        }, 1000);
                                        final Handler handler = new Handler();
                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                if (b8 == 1 && b1 == 2 && b5 == 3 && b2 == 0 && b3 == 0 && b4 == 0 && b6 == 0 && b7 == 0 && b9 == 0) {
                                                    position = 1;
                                                    myText.setText("You passed level 3");
                                                    numCorrectTrials ++;
                                                    totalScore = numCorrectTrials * level;
                                                    scoreView.setText("Total Score: " + totalScore);
                                                    blockSpan.setText("Block Span: " + level);
                                                    level = 4;
                                                    b8 = 0;
                                                    b1 = 0;
                                                    b5 = 0;
                                                }
                                                else {
                                                    position = 1;
                                                    myText.setText("You failed!");
                                                    level = 2;
                                                    b1 = b2 = b3 = b4 = b5 = b6 = b7 = b8 = b9 = 0;
                                                    numCorrectTrials = 0;
                                                    totalScore = 0;
                                                    scoreView.setText("Total Score: " + totalScore);
                                                    blockSpan.setText("Block Span: " + level);
                                                }

                                            }
                                        }, 7000);

                                    }
                                }
                            }, 7000);
                        }
                        else if (level == 4)
                        {
                            myText.setText("Level 4 - 1st Attempt");
                            myButton3.setBackgroundColor(Color.YELLOW);
                            final Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    // Do something after 1s = 1000ms
                                    myButton3.setBackgroundColor(Color.BLUE);
                                    myButton4.setBackgroundColor(Color.YELLOW);
                                    final Handler handler2 = new Handler();
                                    handler2.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            // Do something after 1s = 1000ms
                                            myButton4.setBackgroundColor(Color.BLUE);
                                            myButton1.setBackgroundColor(Color.YELLOW);
                                            final Handler handler3 = new Handler();
                                            handler3.postDelayed(new Runnable() {
                                                @Override
                                                public void run() {
                                                    // Do something after 1s = 1000ms
                                                    myButton1.setBackgroundColor(Color.BLUE);
                                                    myButton7.setBackgroundColor(Color.YELLOW);
                                                    final Handler handler4 = new Handler();
                                                    handler4.postDelayed(new Runnable() {
                                                        @Override
                                                        public void run() {
                                                            // Do something after 1s = 1000ms
                                                            myButton7.setBackgroundColor(Color.BLUE);
                                                        }
                                                    }, 1000);
                                                }
                                            }, 1000);
                                        }
                                    }, 1000);
                                }
                            }, 1000);


                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    // Do something after 5s = 5000ms
                                    if (b3 == 1 && b4 == 2 && b1 == 3 && b7 == 4 && b2 == 0 && b5 == 0 && b6 == 0 && b8 == 0 && b9 == 0) {
                                        myText.setText("You passed level 4");
                                        numCorrectTrials ++;
                                        totalScore = numCorrectTrials * level;
                                        scoreView.setText("Total Score: " + totalScore);
                                        blockSpan.setText("Block Span: " + level);
                                        level = 5;
                                        b3 = 0;
                                        b7 = 0;
                                        b4 = 0;
                                        b1 = 0;
                                        position = 1;
                                    }
                                    else {
                                        b1 = b2 = b3 = b4 = b5 = b6 = b7 = b8 = b9 = 0;
                                        position = 1;
                                        myText.setText("Try again.");
                                        final Handler handlertemp = new Handler();
                                        handlertemp.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                myText.setText("Level 4 - 2nd Attempt");
                                            }
                                        }, 4000);
                                        myButton6.setBackgroundColor(Color.YELLOW);
                                        final Handler handler2 = new Handler();
                                        handler2.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                // Do something after 1s = 1000ms
                                                myButton6.setBackgroundColor(Color.BLUE);
                                                myButton1.setBackgroundColor(Color.YELLOW);
                                                handler2.postDelayed(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        // Do something after 1s = 1000ms
                                                        myButton1.setBackgroundColor(Color.BLUE);
                                                        myButton5.setBackgroundColor(Color.YELLOW);
                                                        handler2.postDelayed(new Runnable() {
                                                            @Override
                                                            public void run() {
                                                                // Do something after 1s = 1000ms
                                                                myButton5.setBackgroundColor(Color.BLUE);
                                                                myButton8.setBackgroundColor(Color.YELLOW);
                                                                handler2.postDelayed(new Runnable() {
                                                                    @Override
                                                                    public void run() {
                                                                        // Do something after 1s = 1000ms
                                                                        myButton8.setBackgroundColor(Color.BLUE);

                                                                    }
                                                                }, 1000);

                                                            }
                                                        }, 1000);
                                                    }
                                                }, 1000);
                                            }
                                        }, 1000);
                                        final Handler handler = new Handler();
                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                if (b6 == 1 && b1 == 2 && b5 == 3 && b8 == 4 && b2 == 0 && b3 == 0 && b4 == 0 && b7 == 0 && b9 == 0) {
                                                    position = 1;
                                                    myText.setText("You passed level 4");
                                                    numCorrectTrials ++;
                                                    totalScore = numCorrectTrials * level;
                                                    scoreView.setText("Total Score: " + totalScore);
                                                    blockSpan.setText("Block Span: " + level);
                                                    level = 5;
                                                    b8 = 0;
                                                    b1 = 0;
                                                    b5 = 0;
                                                    b6 = 0;
                                                }
                                                else {
                                                    position = 1;
                                                    myText.setText("You failed!");
                                                    level = 2;
                                                    b1 = b2 = b3 = b4 = b5 = b6 = b7 = b8 = b9 = 0;
                                                    numCorrectTrials = 0;
                                                    totalScore = 0;
                                                    scoreView.setText("Total Score: " + totalScore);
                                                    blockSpan.setText("Block Span: " + level);
                                                }

                                            }
                                        }, 7000);

                                    }
                                }
                            }, 7000);
                        }
                        else if (level == 5)
                        {
                            myText.setText("Level 5 - 1st Attempt");
                            myButton5.setBackgroundColor(Color.YELLOW);
                            final Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    // Do something after 1s = 1000ms
                                    myButton5.setBackgroundColor(Color.BLUE);
                                    myButton2.setBackgroundColor(Color.YELLOW);
                                    final Handler handler2 = new Handler();
                                    handler2.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            // Do something after 1s = 1000ms
                                            myButton2.setBackgroundColor(Color.BLUE);
                                            myButton1.setBackgroundColor(Color.YELLOW);
                                            final Handler handler3 = new Handler();
                                            handler3.postDelayed(new Runnable() {
                                                @Override
                                                public void run() {
                                                    // Do something after 1s = 1000ms
                                                    myButton1.setBackgroundColor(Color.BLUE);
                                                    myButton8.setBackgroundColor(Color.YELLOW);
                                                    final Handler handler4 = new Handler();
                                                    handler4.postDelayed(new Runnable() {
                                                        @Override
                                                        public void run() {
                                                            // Do something after 1s = 1000ms
                                                            myButton8.setBackgroundColor(Color.BLUE);
                                                            myButton6.setBackgroundColor(Color.YELLOW);
                                                            final Handler handler5 = new Handler();
                                                            handler5.postDelayed(new Runnable() {
                                                                @Override
                                                                public void run() {
                                                                    // Do something after 1s = 1000ms
                                                                    myButton6.setBackgroundColor(Color.BLUE);
                                                                }
                                                            }, 1000);
                                                        }
                                                    }, 1000);
                                                }
                                            }, 1000);
                                        }
                                    }, 1000);
                                }
                            }, 1000);


                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    // Do something after 5s = 5000ms
                                    if (b5 == 1 && b2 == 2 && b1 == 3 && b8 == 4 && b6 == 5 && b3 == 0 && b4 == 0 && b7 == 0 && b9 == 0) {
                                        myText.setText("You passed level 5");
                                        numCorrectTrials ++;
                                        totalScore = numCorrectTrials * level;
                                        scoreView.setText("Total Score: " + totalScore);
                                        blockSpan.setText("Block Span: " + level);
                                        level = 6;
                                        b5 = 0;
                                        b2 = 0;
                                        b1 = 0;
                                        b8 = 0;
                                        b6 = 0;
                                        position = 1;
                                    }
                                    else {
                                        b1 = b2 = b3 = b4 = b5 = b6 = b7 = b8 = b9 = 0;
                                        position = 1;
                                        myText.setText("Try again.");
                                        final Handler handlertemp = new Handler();
                                        handlertemp.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                myText.setText("Level 5 - 2nd Attempt");
                                            }
                                        }, 5000);
                                        myButton4.setBackgroundColor(Color.YELLOW);
                                        final Handler handler2 = new Handler();
                                        handler2.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                // Do something after 1s = 1000ms
                                                myButton4.setBackgroundColor(Color.BLUE);
                                                myButton2.setBackgroundColor(Color.YELLOW);
                                                handler2.postDelayed(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        // Do something after 1s = 1000ms
                                                        myButton2.setBackgroundColor(Color.BLUE);
                                                        myButton7.setBackgroundColor(Color.YELLOW);
                                                        handler2.postDelayed(new Runnable() {
                                                            @Override
                                                            public void run() {
                                                                // Do something after 1s = 1000ms
                                                                myButton7.setBackgroundColor(Color.BLUE);
                                                                myButton3.setBackgroundColor(Color.YELLOW);
                                                                handler2.postDelayed(new Runnable() {
                                                                    @Override
                                                                    public void run() {
                                                                        // Do something after 1s = 1000ms
                                                                        myButton3.setBackgroundColor(Color.BLUE);
                                                                        myButton1.setBackgroundColor(Color.YELLOW);
                                                                        handler2.postDelayed(new Runnable() {
                                                                            @Override
                                                                            public void run() {
                                                                                // Do something after 1s = 1000ms
                                                                                myButton1.setBackgroundColor(Color.BLUE);
                                                                            }
                                                                        }, 1000);

                                                                    }
                                                                }, 1000);

                                                            }
                                                        }, 1000);
                                                    }
                                                }, 1000);
                                            }
                                        }, 1000);
                                        final Handler handler = new Handler();
                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                if (b4 == 1 && b2 == 2 && b7 == 3 && b3 == 4 && b1 == 5 && b5 == 0 && b6 == 0 && b9 == 0 && b8 == 0) {
                                                    position = 1;
                                                    myText.setText("You passed level 5");
                                                    numCorrectTrials ++;
                                                    totalScore = numCorrectTrials * level;
                                                    scoreView.setText("Total Score: " + totalScore);
                                                    blockSpan.setText("Block Span: " + level);
                                                    level = 6;
                                                    b4 = 0;
                                                    b2 = 0;
                                                    b7 = 0;
                                                    b3 = 0;
                                                    b1=0;
                                                }
                                                else {
                                                    position = 1;
                                                    myText.setText("You failed!");
                                                    level = 2;
                                                    b1 = b2 = b3 = b4 = b5 = b6 = b7 = b8 = b9 = 0;
                                                    numCorrectTrials = 0;
                                                    totalScore = 0;
                                                    scoreView.setText("Total Score: " + totalScore);
                                                    blockSpan.setText("Block Span: " + level);
                                                }

                                            }
                                        }, 10000);

                                    }
                                }
                            }, 10000);
                        }
                        else if (level == 6)
                        {
                            myText.setText("Level 6 - 1st Attempt");
                            myButton3.setBackgroundColor(Color.YELLOW);
                            final Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    // Do something after 1s = 1000ms
                                    myButton3.setBackgroundColor(Color.BLUE);
                                    myButton9.setBackgroundColor(Color.YELLOW);
                                    final Handler handler2 = new Handler();
                                    handler2.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            // Do something after 1s = 1000ms
                                            myButton9.setBackgroundColor(Color.BLUE);
                                            myButton2.setBackgroundColor(Color.YELLOW);
                                            final Handler handler3 = new Handler();
                                            handler3.postDelayed(new Runnable() {
                                                @Override
                                                public void run() {
                                                    // Do something after 1s = 1000ms
                                                    myButton2.setBackgroundColor(Color.BLUE);
                                                    myButton4.setBackgroundColor(Color.YELLOW);
                                                    final Handler handler4 = new Handler();
                                                    handler4.postDelayed(new Runnable() {
                                                        @Override
                                                        public void run() {
                                                            // Do something after 1s = 1000ms
                                                            myButton4.setBackgroundColor(Color.BLUE);
                                                            myButton8.setBackgroundColor(Color.YELLOW);
                                                            final Handler handler5 = new Handler();
                                                            handler5.postDelayed(new Runnable() {
                                                                @Override
                                                                public void run() {
                                                                    // Do something after 1s = 1000ms
                                                                    myButton8.setBackgroundColor(Color.BLUE);
                                                                    myButton7.setBackgroundColor(Color.YELLOW);
                                                                    final Handler handler6 = new Handler();
                                                                    handler6.postDelayed(new Runnable() {
                                                                        @Override
                                                                        public void run() {
                                                                            // Do something after 1s = 1000ms
                                                                            myButton7.setBackgroundColor(Color.BLUE);

                                                                        }
                                                                    }, 1000);
                                                                }
                                                            }, 1000);
                                                        }
                                                    }, 1000);
                                                }
                                            }, 1000);
                                        }
                                    }, 1000);
                                }
                            }, 1000);


                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    // Do something after 5s = 5000ms
                                    if (b3 == 1 && b9 == 2 && b2 == 3 && b4 == 4 && b8 == 5 && b7 == 6 && b1 == 0 && b5 == 0 && b6 == 0) {
                                        myText.setText("You passed level 6");
                                        numCorrectTrials ++;
                                        totalScore = numCorrectTrials * level;
                                        scoreView.setText("Total Score: " + totalScore);
                                        blockSpan.setText("Block Span: " + level);
                                        level = 7;
                                        b3 = 0;
                                        b9 = 0;
                                        b2 = 0;
                                        b4 = 0;
                                        b8 = 0;
                                        b7 = 0;
                                        position = 1;
                                    }
                                    else {
                                        b1 = b2 = b3 = b4 = b5 = b6 = b7 = b8 = b9 = 0;
                                        position = 1;
                                        myText.setText("Try again.");
                                        final Handler handlertemp = new Handler();
                                        handlertemp.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                myText.setText("Level 6 - 2nd Attempt");
                                            }
                                        }, 6000);
                                        myButton3.setBackgroundColor(Color.YELLOW);
                                        final Handler handler2 = new Handler();
                                        handler2.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                // Do something after 1s = 1000ms
                                                myButton3.setBackgroundColor(Color.BLUE);
                                                myButton7.setBackgroundColor(Color.YELLOW);
                                                handler2.postDelayed(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        // Do something after 1s = 1000ms
                                                        myButton7.setBackgroundColor(Color.BLUE);
                                                        myButton8.setBackgroundColor(Color.YELLOW);
                                                        handler2.postDelayed(new Runnable() {
                                                            @Override
                                                            public void run() {
                                                                // Do something after 1s = 1000ms
                                                                myButton8.setBackgroundColor(Color.BLUE);
                                                                myButton2.setBackgroundColor(Color.YELLOW);
                                                                handler2.postDelayed(new Runnable() {
                                                                    @Override
                                                                    public void run() {
                                                                        // Do something after 1s = 1000ms
                                                                        myButton2.setBackgroundColor(Color.BLUE);
                                                                        myButton9.setBackgroundColor(Color.YELLOW);
                                                                        handler2.postDelayed(new Runnable() {
                                                                            @Override
                                                                            public void run() {
                                                                                // Do something after 1s = 1000ms
                                                                                myButton9.setBackgroundColor(Color.BLUE);
                                                                                myButton4.setBackgroundColor(Color.YELLOW);
                                                                                handler2.postDelayed(new Runnable() {
                                                                                    @Override
                                                                                    public void run() {
                                                                                        // Do something after 1s = 1000ms
                                                                                        myButton4.setBackgroundColor(Color.BLUE);
                                                                                    }
                                                                                }, 1000);
                                                                            }
                                                                        }, 1000);

                                                                    }
                                                                }, 1000);

                                                            }
                                                        }, 1000);
                                                    }
                                                }, 1000);
                                            }
                                        }, 1000);
                                        final Handler handler = new Handler();
                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                if (b3 == 1 && b7 == 2 && b8 == 3 && b2== 4 && b9 == 5 && b4 == 6 && b1 == 0 && b5 == 0 && b6 == 0) {
                                                    position = 1;
                                                    myText.setText("You passed level 6");
                                                    numCorrectTrials ++;
                                                    totalScore = numCorrectTrials * level;
                                                    scoreView.setText("Total Score: " + totalScore);
                                                    blockSpan.setText("Block Span: " + level);
                                                    level = 7;
                                                    b3 = 0;
                                                    b7 = 0;
                                                    b8 = 0;
                                                    b2 = 0;
                                                    b9=0;
                                                    b4=0;
                                                }
                                                else {
                                                    position = 1;
                                                    myText.setText("You failed!");
                                                    level = 2;
                                                    b1 = b2 = b3 = b4 = b5 = b6 = b7 = b8 = b9 = 0;
                                                    numCorrectTrials = 0;
                                                    totalScore = 0;
                                                    scoreView.setText("Total Score: " + totalScore);
                                                    blockSpan.setText("Block Span: " + level);
                                                }

                                            }
                                        }, 12000);

                                    }
                                }
                            }, 12000);
                        }
                        else if (level == 7)
                        {
                            myText.setText("Level 7 - 1st Attempt");
                            myButton5.setBackgroundColor(Color.YELLOW);
                            final Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    // Do something after 1s = 1000ms
                                    myButton5.setBackgroundColor(Color.BLUE);
                                    myButton9.setBackgroundColor(Color.YELLOW);
                                    final Handler handler2 = new Handler();
                                    handler2.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            // Do something after 1s = 1000ms
                                            myButton9.setBackgroundColor(Color.BLUE);
                                            myButton1.setBackgroundColor(Color.YELLOW);
                                            final Handler handler3 = new Handler();
                                            handler3.postDelayed(new Runnable() {
                                                @Override
                                                public void run() {
                                                    // Do something after 1s = 1000ms
                                                    myButton1.setBackgroundColor(Color.BLUE);
                                                    myButton7.setBackgroundColor(Color.YELLOW);
                                                    final Handler handler4 = new Handler();
                                                    handler4.postDelayed(new Runnable() {
                                                        @Override
                                                        public void run() {
                                                            // Do something after 1s = 1000ms
                                                            myButton7.setBackgroundColor(Color.BLUE);
                                                            myButton4.setBackgroundColor(Color.YELLOW);
                                                            final Handler handler5 = new Handler();
                                                            handler5.postDelayed(new Runnable() {
                                                                @Override
                                                                public void run() {
                                                                    // Do something after 1s = 1000ms
                                                                    myButton4.setBackgroundColor(Color.BLUE);
                                                                    myButton2.setBackgroundColor(Color.YELLOW);
                                                                    final Handler handler6 = new Handler();
                                                                    handler6.postDelayed(new Runnable() {
                                                                        @Override
                                                                        public void run() {
                                                                            // Do something after 1s = 1000ms
                                                                            myButton2.setBackgroundColor(Color.BLUE);
                                                                            myButton8.setBackgroundColor(Color.YELLOW);
                                                                            final Handler handler7 = new Handler();
                                                                            handler7.postDelayed(new Runnable() {
                                                                                @Override
                                                                                public void run() {
                                                                                    // Do something after 1s = 1000ms
                                                                                    myButton8.setBackgroundColor(Color.BLUE);
                                                                                }
                                                                            }, 1000);

                                                                        }
                                                                    }, 1000);
                                                                }
                                                            }, 1000);
                                                        }
                                                    }, 1000);
                                                }
                                            }, 1000);
                                        }
                                    }, 1000);
                                }
                            }, 1000);


                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    // Do something after 5s = 5000ms
                                    if (b5 == 1 && b9 == 2 && b1 == 3 && b7 == 4 && b4 == 5 && b2 == 6 && b8 == 7 && b3 == 0 && b6 == 0) {
                                        myText.setText("You passed level 7");
                                        numCorrectTrials ++;
                                        totalScore = numCorrectTrials * level;
                                        scoreView.setText("Total Score: " + totalScore);
                                        blockSpan.setText("Block Span: " + level);
                                        level = 8;
                                        b5 = 0;
                                        b9 = 0;
                                        b1 = 0;
                                        b7 = 0;
                                        b4= 0;
                                        b2 = 0;
                                        b8 = 0;
                                        position = 1;
                                    }
                                    else {
                                        b1 = b2 = b3 = b4 = b5 = b6 = b7 = b8 = b9 = 0;
                                        position = 1;
                                        myText.setText("Try again.");
                                        final Handler handlertemp = new Handler();
                                        handlertemp.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                myText.setText("Level 7 - 2nd Attempt");
                                            }
                                        }, 7000);
                                        myButton5.setBackgroundColor(Color.YELLOW);
                                        final Handler handler2 = new Handler();
                                        handler2.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                // Do something after 1s = 1000ms
                                                myButton5.setBackgroundColor(Color.BLUE);
                                                myButton7.setBackgroundColor(Color.YELLOW);
                                                handler2.postDelayed(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        // Do something after 1s = 1000ms
                                                        myButton7.setBackgroundColor(Color.BLUE);
                                                        myButton9.setBackgroundColor(Color.YELLOW);
                                                        handler2.postDelayed(new Runnable() {
                                                            @Override
                                                            public void run() {
                                                                // Do something after 1s = 1000ms
                                                                myButton9.setBackgroundColor(Color.BLUE);
                                                                myButton2.setBackgroundColor(Color.YELLOW);
                                                                handler2.postDelayed(new Runnable() {
                                                                    @Override
                                                                    public void run() {
                                                                        // Do something after 1s = 1000ms
                                                                        myButton2.setBackgroundColor(Color.BLUE);
                                                                        myButton8.setBackgroundColor(Color.YELLOW);
                                                                        handler2.postDelayed(new Runnable() {
                                                                            @Override
                                                                            public void run() {
                                                                                // Do something after 1s = 1000ms
                                                                                myButton8.setBackgroundColor(Color.BLUE);
                                                                                myButton4.setBackgroundColor(Color.YELLOW);
                                                                                handler2.postDelayed(new Runnable() {
                                                                                    @Override
                                                                                    public void run() {
                                                                                        // Do something after 1s = 1000ms
                                                                                        myButton4.setBackgroundColor(Color.BLUE);
                                                                                        myButton6.setBackgroundColor(Color.YELLOW);
                                                                                        handler2.postDelayed(new Runnable() {
                                                                                            @Override
                                                                                            public void run() {
                                                                                                // Do something after 1s = 1000ms
                                                                                                myButton6.setBackgroundColor(Color.BLUE);
                                                                                            }
                                                                                        }, 1000);
                                                                                    }
                                                                                }, 1000);
                                                                            }
                                                                        }, 1000);

                                                                    }
                                                                }, 1000);

                                                            }
                                                        }, 1000);
                                                    }
                                                }, 1000);
                                            }
                                        }, 1000);
                                        final Handler handler = new Handler();
                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                if (b5 == 1 && b7 == 2 && b9 == 3 && b2== 4 && b8 == 5 && b4 == 6 && b6 == 7 && b3 == 0 && b1 == 0) {
                                                    position = 1;
                                                    myText.setText("You passed level 7");
                                                    numCorrectTrials ++;
                                                    totalScore = numCorrectTrials * level;
                                                    scoreView.setText("Total Score: " + totalScore);
                                                    blockSpan.setText("Block Span: " + level);
                                                    level = 8;
                                                    b5 = 0;
                                                    b7 = 0;
                                                    b9 = 0;
                                                    b2 = 0;
                                                    b8=0;
                                                    b4=0;
                                                    b6 = 0;
                                                }
                                                else {
                                                    position = 1;
                                                    myText.setText("You failed!");
                                                    level = 2;
                                                    b1 = b2 = b3 = b4 = b5 = b6 = b7 = b8 = b9 = 0;
                                                    numCorrectTrials = 0;
                                                    totalScore = 0;
                                                    scoreView.setText("Total Score: " + totalScore);
                                                    blockSpan.setText("Block Span: " + level);
                                                }

                                            }
                                        }, 13000);

                                    }
                                }
                            }, 13000);
                        }
                        else if (level == 8)
                        {
                            myText.setText("Level 8 - 1st Attempt");
                            myButton5.setBackgroundColor(Color.YELLOW);
                            final Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    // Do something after 1s = 1000ms
                                    myButton5.setBackgroundColor(Color.BLUE);
                                    myButton8.setBackgroundColor(Color.YELLOW);
                                    final Handler handler2 = new Handler();
                                    handler2.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            // Do something after 1s = 1000ms
                                            myButton8.setBackgroundColor(Color.BLUE);
                                            myButton1.setBackgroundColor(Color.YELLOW);
                                            final Handler handler3 = new Handler();
                                            handler3.postDelayed(new Runnable() {
                                                @Override
                                                public void run() {
                                                    // Do something after 1s = 1000ms
                                                    myButton1.setBackgroundColor(Color.BLUE);
                                                    myButton9.setBackgroundColor(Color.YELLOW);
                                                    final Handler handler4 = new Handler();
                                                    handler4.postDelayed(new Runnable() {
                                                        @Override
                                                        public void run() {
                                                            // Do something after 1s = 1000ms
                                                            myButton9.setBackgroundColor(Color.BLUE);
                                                            myButton2.setBackgroundColor(Color.YELLOW);
                                                            final Handler handler5 = new Handler();
                                                            handler5.postDelayed(new Runnable() {
                                                                @Override
                                                                public void run() {
                                                                    // Do something after 1s = 1000ms
                                                                    myButton2.setBackgroundColor(Color.BLUE);
                                                                    myButton6.setBackgroundColor(Color.YELLOW);
                                                                    final Handler handler6 = new Handler();
                                                                    handler6.postDelayed(new Runnable() {
                                                                        @Override
                                                                        public void run() {
                                                                            // Do something after 1s = 1000ms
                                                                            myButton6.setBackgroundColor(Color.BLUE);
                                                                            myButton4.setBackgroundColor(Color.YELLOW);
                                                                            final Handler handler7 = new Handler();
                                                                            handler7.postDelayed(new Runnable() {
                                                                                @Override
                                                                                public void run() {
                                                                                    // Do something after 1s = 1000ms
                                                                                    myButton4.setBackgroundColor(Color.BLUE);
                                                                                    myButton7.setBackgroundColor(Color.YELLOW);
                                                                                    final Handler handler8 = new Handler();
                                                                                    handler8.postDelayed(new Runnable() {
                                                                                        @Override
                                                                                        public void run() {
                                                                                            // Do something after 1s = 1000ms
                                                                                            myButton7.setBackgroundColor(Color.BLUE);

                                                                                        }
                                                                                    }, 1000);
                                                                                }
                                                                            }, 1000);

                                                                        }
                                                                    }, 1000);
                                                                }
                                                            }, 1000);
                                                        }
                                                    }, 1000);
                                                }
                                            }, 1000);
                                        }
                                    }, 1000);
                                }
                            }, 1000);


                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    // Do something after 5s = 5000ms
                                    if (b5 == 1 && b8 == 2 && b1 == 3 && b9 == 4 && b2 == 5 && b6 == 6 && b4 == 7 && b7 == 8 && b3 == 0) {
                                        myText.setText("You passed level 8");
                                        numCorrectTrials ++;
                                        totalScore = numCorrectTrials * level;
                                        scoreView.setText("Total Score: " + totalScore);
                                        blockSpan.setText("Block Span: " + level);
                                        level = 9;
                                        b5 = 0;
                                        b8 = 0;
                                        b1 = 0;
                                        b9 = 0;
                                        b2= 0;
                                        b6 = 0;
                                        b4 = 0;
                                        b7 = 0;
                                        position = 1;
                                    }
                                    else {
                                        b1 = b2 = b3 = b4 = b5 = b6 = b7 = b8 = b9 = 0;
                                        position = 1;
                                        myText.setText("Try again.");
                                        final Handler handlertemp = new Handler();
                                        handlertemp.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                myText.setText("Level 8 - 2nd Attempt");
                                            }
                                        }, 8000);
                                        myButton5.setBackgroundColor(Color.YELLOW);
                                        final Handler handler2 = new Handler();
                                        handler2.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                // Do something after 1s = 1000ms
                                                myButton5.setBackgroundColor(Color.BLUE);
                                                myButton9.setBackgroundColor(Color.YELLOW);
                                                handler2.postDelayed(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        // Do something after 1s = 1000ms
                                                        myButton9.setBackgroundColor(Color.BLUE);
                                                        myButton3.setBackgroundColor(Color.YELLOW);
                                                        handler2.postDelayed(new Runnable() {
                                                            @Override
                                                            public void run() {
                                                                // Do something after 1s = 1000ms
                                                                myButton3.setBackgroundColor(Color.BLUE);
                                                                myButton6.setBackgroundColor(Color.YELLOW);
                                                                handler2.postDelayed(new Runnable() {
                                                                    @Override
                                                                    public void run() {
                                                                        // Do something after 1s = 1000ms
                                                                        myButton6.setBackgroundColor(Color.BLUE);
                                                                        myButton7.setBackgroundColor(Color.YELLOW);
                                                                        handler2.postDelayed(new Runnable() {
                                                                            @Override
                                                                            public void run() {
                                                                                // Do something after 1s = 1000ms
                                                                                myButton7.setBackgroundColor(Color.BLUE);
                                                                                myButton2.setBackgroundColor(Color.YELLOW);
                                                                                handler2.postDelayed(new Runnable() {
                                                                                    @Override
                                                                                    public void run() {
                                                                                        // Do something after 1s = 1000ms
                                                                                        myButton2.setBackgroundColor(Color.BLUE);
                                                                                        myButton4.setBackgroundColor(Color.YELLOW);
                                                                                        handler2.postDelayed(new Runnable() {
                                                                                            @Override
                                                                                            public void run() {
                                                                                                // Do something after 1s = 1000ms
                                                                                                myButton4.setBackgroundColor(Color.BLUE);
                                                                                                myButton1.setBackgroundColor(Color.YELLOW);
                                                                                                handler2.postDelayed(new Runnable() {
                                                                                                    @Override
                                                                                                    public void run() {
                                                                                                        // Do something after 1s = 1000ms
                                                                                                        myButton1.setBackgroundColor(Color.BLUE);
                                                                                                    }
                                                                                                }, 1000);
                                                                                            }
                                                                                        }, 1000);
                                                                                    }
                                                                                }, 1000);
                                                                            }
                                                                        }, 1000);

                                                                    }
                                                                }, 1000);

                                                            }
                                                        }, 1000);
                                                    }
                                                }, 1000);
                                            }
                                        }, 1000);
                                        final Handler handler = new Handler();
                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                if (b5 == 1 && b9 == 2 && b3 == 3 && b6== 4 && b7 == 5 && b2 == 6 && b4 == 7 && b1 == 8 && b1 == 0) {
                                                    position = 1;
                                                    myText.setText("You passed level 8");
                                                    numCorrectTrials ++;
                                                    totalScore = numCorrectTrials * level;
                                                    scoreView.setText("Total Score: " + totalScore);
                                                    blockSpan.setText("Block Span: " + level);
                                                    level = 9;
                                                    b5 = 0;
                                                    b9 = 0;
                                                    b3 = 0;
                                                    b6 = 0;
                                                    b7 = 0;
                                                    b2=0;
                                                    b4=0;
                                                    b1 = 0;
                                                }
                                                else {
                                                    position = 1;
                                                    myText.setText("You failed!");
                                                    level = 2;
                                                    b1 = b2 = b3 = b4 = b5 = b6 = b7 = b8 = b9 = 0;
                                                    numCorrectTrials = 0;
                                                    totalScore = 0;
                                                    scoreView.setText("Total Score: " + totalScore);
                                                    blockSpan.setText("Block Span: " + level);
                                                }

                                            }
                                        }, 15000);

                                    }
                                }
                            }, 15000);
                        }
                        else if (level == 9)
                        {
                            myText.setText("Level 9 - 1st Attempt");
                            myButton5.setBackgroundColor(Color.YELLOW);
                            final Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    // Do something after 1s = 1000ms
                                    myButton5.setBackgroundColor(Color.BLUE);
                                    myButton3.setBackgroundColor(Color.YELLOW);
                                    final Handler handler2 = new Handler();
                                    handler2.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            // Do something after 1s = 1000ms
                                            myButton3.setBackgroundColor(Color.BLUE);
                                            myButton8.setBackgroundColor(Color.YELLOW);
                                            final Handler handler3 = new Handler();
                                            handler3.postDelayed(new Runnable() {
                                                @Override
                                                public void run() {
                                                    // Do something after 1s = 1000ms
                                                    myButton8.setBackgroundColor(Color.BLUE);
                                                    myButton7.setBackgroundColor(Color.YELLOW);
                                                    final Handler handler4 = new Handler();
                                                    handler4.postDelayed(new Runnable() {
                                                        @Override
                                                        public void run() {
                                                            // Do something after 1s = 1000ms
                                                            myButton7.setBackgroundColor(Color.BLUE);
                                                            myButton1.setBackgroundColor(Color.YELLOW);
                                                            final Handler handler5 = new Handler();
                                                            handler5.postDelayed(new Runnable() {
                                                                @Override
                                                                public void run() {
                                                                    // Do something after 1s = 1000ms
                                                                    myButton1.setBackgroundColor(Color.BLUE);
                                                                    myButton2.setBackgroundColor(Color.YELLOW);
                                                                    final Handler handler6 = new Handler();
                                                                    handler6.postDelayed(new Runnable() {
                                                                        @Override
                                                                        public void run() {
                                                                            // Do something after 1s = 1000ms
                                                                            myButton2.setBackgroundColor(Color.BLUE);
                                                                            myButton4.setBackgroundColor(Color.YELLOW);
                                                                            final Handler handler7 = new Handler();
                                                                            handler7.postDelayed(new Runnable() {
                                                                                @Override
                                                                                public void run() {
                                                                                    // Do something after 1s = 1000ms
                                                                                    myButton4.setBackgroundColor(Color.BLUE);
                                                                                    myButton6.setBackgroundColor(Color.YELLOW);
                                                                                    final Handler handler8 = new Handler();
                                                                                    handler8.postDelayed(new Runnable() {
                                                                                        @Override
                                                                                        public void run() {
                                                                                            // Do something after 1s = 1000ms
                                                                                            myButton6.setBackgroundColor(Color.BLUE);
                                                                                            myButton9.setBackgroundColor(Color.YELLOW);
                                                                                            final Handler handler9 = new Handler();
                                                                                            handler9.postDelayed(new Runnable() {
                                                                                                @Override
                                                                                                public void run() {
                                                                                                    // Do something after 1s = 1000ms
                                                                                                    myButton9.setBackgroundColor(Color.BLUE);

                                                                                                }
                                                                                            }, 1000);

                                                                                        }
                                                                                    }, 1000);
                                                                                }
                                                                            }, 1000);

                                                                        }
                                                                    }, 1000);
                                                                }
                                                            }, 1000);
                                                        }
                                                    }, 1000);
                                                }
                                            }, 1000);
                                        }
                                    }, 1000);
                                }
                            }, 1000);


                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    // Do something after 5s = 5000ms
                                    if (b5 == 1 && b3 == 2 && b8== 3 && b7== 4 && b1 == 5 && b2 == 6 && b4 == 7 && b6 == 8 && b9 == 9) {
                                        myText.setText("You passed level 9");
                                        numCorrectTrials ++;
                                        totalScore = numCorrectTrials * level;
                                        scoreView.setText("Total Score: " + totalScore);
                                        blockSpan.setText("Block Span: " + level);
                                        level = 10;
                                        b5 = 0;
                                        b8 = 0;
                                        b1 = 0;
                                        b9 = 0;
                                        b2= 0;
                                        b6 = 0;
                                        b4 = 0;
                                        b7 = 0;
                                        b3 = 0;
                                        position = 1;
                                    }
                                    else {
                                        b1 = b2 = b3 = b4 = b5 = b6 = b7 = b8 = b9 = 0;
                                        position = 1;
                                        myText.setText("Try again.");
                                        final Handler handlertemp = new Handler();
                                        handlertemp.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                myText.setText("Level 9 - 2nd Attempt");
                                            }
                                        }, 9000);
                                        myButton4.setBackgroundColor(Color.YELLOW);
                                        final Handler handler2 = new Handler();
                                        handler2.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                // Do something after 1s = 1000ms
                                                myButton4.setBackgroundColor(Color.BLUE);
                                                myButton2.setBackgroundColor(Color.YELLOW);
                                                handler2.postDelayed(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        // Do something after 1s = 1000ms
                                                        myButton2.setBackgroundColor(Color.BLUE);
                                                        myButton6.setBackgroundColor(Color.YELLOW);
                                                        handler2.postDelayed(new Runnable() {
                                                            @Override
                                                            public void run() {
                                                                // Do something after 1s = 1000ms
                                                                myButton6.setBackgroundColor(Color.BLUE);
                                                                myButton8.setBackgroundColor(Color.YELLOW);
                                                                handler2.postDelayed(new Runnable() {
                                                                    @Override
                                                                    public void run() {
                                                                        // Do something after 1s = 1000ms
                                                                        myButton8.setBackgroundColor(Color.BLUE);
                                                                        myButton1.setBackgroundColor(Color.YELLOW);
                                                                        handler2.postDelayed(new Runnable() {
                                                                            @Override
                                                                            public void run() {
                                                                                // Do something after 1s = 1000ms
                                                                                myButton1.setBackgroundColor(Color.BLUE);
                                                                                myButton7.setBackgroundColor(Color.YELLOW);
                                                                                handler2.postDelayed(new Runnable() {
                                                                                    @Override
                                                                                    public void run() {
                                                                                        // Do something after 1s = 1000ms
                                                                                        myButton7.setBackgroundColor(Color.BLUE);
                                                                                        myButton9.setBackgroundColor(Color.YELLOW);
                                                                                        handler2.postDelayed(new Runnable() {
                                                                                            @Override
                                                                                            public void run() {
                                                                                                // Do something after 1s = 1000ms
                                                                                                myButton9.setBackgroundColor(Color.BLUE);
                                                                                                myButton3.setBackgroundColor(Color.YELLOW);
                                                                                                handler2.postDelayed(new Runnable() {
                                                                                                    @Override
                                                                                                    public void run() {
                                                                                                        // Do something after 1s = 1000ms
                                                                                                        myButton3.setBackgroundColor(Color.BLUE);
                                                                                                        myButton9.setBackgroundColor(Color.YELLOW);
                                                                                                        handler2.postDelayed(new Runnable() {
                                                                                                            @Override
                                                                                                            public void run() {
                                                                                                                // Do something after 1s = 1000ms
                                                                                                                myButton9.setBackgroundColor(Color.BLUE);

                                                                                                            }
                                                                                                        }, 1000);
                                                                                                    }
                                                                                                }, 1000);
                                                                                            }
                                                                                        }, 1000);
                                                                                    }
                                                                                }, 1000);
                                                                            }
                                                                        }, 1000);

                                                                    }
                                                                }, 1000);

                                                            }
                                                        }, 1000);
                                                    }
                                                }, 1000);
                                            }
                                        }, 1000);
                                        final Handler handler = new Handler();
                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                if (b4 == 1 && b2 == 2 && b6 == 3 && b8== 4 && b1 == 5 && b7 == 6 && b9 == 7 && b3 == 8 && b5 == 9) {
                                                    position = 1;
                                                    myText.setText("You passed level 9");
                                                    numCorrectTrials ++;
                                                    totalScore = numCorrectTrials * level;
                                                    scoreView.setText("Total Score: " + totalScore);
                                                    blockSpan.setText("Block Span: " + level);
                                                    level = 10;
                                                    b5 = 0;
                                                    b9 = 0;
                                                    b3 = 0;
                                                    b6 = 0;
                                                    b7 = 0;
                                                    b2=0;
                                                    b4=0;
                                                    b8 = 0;
                                                    b1 = 0;
                                                }
                                                else {
                                                    position = 1;
                                                    myText.setText("You failed!");
                                                    level = 2;
                                                    b1 = b2 = b3 = b4 = b5 = b6 = b7 = b8 = b9 = 0;
                                                    numCorrectTrials = 0;
                                                    totalScore = 0;
                                                    scoreView.setText("Total Score: " + totalScore);
                                                    blockSpan.setText("Block Span: " + level);
                                                }

                                            }
                                        }, 15000);

                                    }
                                }
                            }, 15000);
                        }
                    }
                }
        );
    }
    public void openNotesPage()
    {
        Intent intent = new Intent(this, Notes.class);
        intent.putExtra("username", getIntent().getStringExtra("username"));
        intent.putExtra("password", getIntent().getStringExtra("password"));
        startActivity(intent);
    }
    public void openEmailActivity()
    {
        Intent intent = new Intent(this, EmailActivity.class);
        level --;
        intent.putExtra("blockspan", level + "");
        intent.putExtra("totalScore", totalScore + "");
        startActivity(intent);
    }
}





