package com.example.corsiblockapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.view.LineChartView;

public class Graph extends AppCompatActivity {
    private Button homeButton, graphButton;
    private EditText dates;
    private LineChartView lineChartView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        homeButton = findViewById(R.id.homeButton);
        graphButton = findViewById(R.id.graphButton);
        lineChartView = findViewById(R.id.graph);
        dates = findViewById(R.id.dates);
        final String username = getIntent().getStringExtra("username");
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Graph.this, HomeScreen.class));
            }
        });
        graphButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Date date1 = new Date();
                Date date2 = new Date();
                String[] bounds = dates.getText().toString().split(" ");
                SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyy");
                String tempdate = bounds[0];
                try {
                    date1 = sdf.parse(bounds[0]);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                try {
                    date2 = sdf.parse(bounds[1]);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                long diff = date2.getTime() - date1.getTime();
                long daysBetween = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
                int numDataPoints = (int)daysBetween + 1;
                String[] xAxisData = new String[numDataPoints];
                for (int i = 0 ; i < xAxisData.length; i++)
                    xAxisData[i] = (i+1) + "";
                int[] yAxisData = new int[numDataPoints];
                double x;
                int y = 0;
                x = 1;
                String tempfile = username + bounds[0] + "finalScore.txt";
                int maxScore = 0;
                String[] array1;
                for (int i = 0; i < numDataPoints; i++){
                    FileInputStream fis = null;
                    try {
                        fis = openFileInput(tempfile);
                        InputStreamReader isr = new InputStreamReader(fis);
                        BufferedReader br = new BufferedReader(isr);
                        StringBuilder sb = new StringBuilder();
                        String text;
                        while ((text = br.readLine())!= null){
                            sb.append(text).append("\n");
                        }
                        array1 = sb.toString().split("\n");
                        for (int z = 0; z < array1.length; z++)
                            if (Integer.parseInt(array1[z]) > maxScore)
                                maxScore = Integer.parseInt(array1[z]);
                        y = maxScore;
                        yAxisData[i] = y;
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

                    tempdate = getNewDate(tempdate);
                    tempfile = username + tempdate + "totalScore.txt";
                    x++;
                }
                List yAxisValues = new ArrayList();
                List axisValues = new ArrayList();
                Line line = new Line(yAxisValues).setColor(Color.parseColor("#9C27B0"));
                for(int i = 0; i < xAxisData.length; i++){
                    axisValues.add(i, new AxisValue(i).setLabel(xAxisData[i]));
                }

                for (int i = 0; i < yAxisData.length; i++){
                    yAxisValues.add(new PointValue(i, yAxisData[i]));
                }
                List lines = new ArrayList();
                lines.add(line);
                LineChartData data = new LineChartData();
                data.setLines(lines);
                lineChartView.setLineChartData(data);
                Axis axis = new Axis();
                axis.setName("Day");
                axis.setValues(axisValues);
                axis.setTextSize(16);
                axis.setTextColor(Color.parseColor("#03A9F4"));
                data.setAxisXBottom(axis);

                Axis yAxis = new Axis();
                yAxis.setName("Score");
                yAxis.setTextColor(Color.parseColor("#03A9F4"));
                yAxis.setTextSize(16);
                data.setAxisYLeft(yAxis);

                lineChartView.setLineChartData(data);
//                Viewport viewport = new Viewport(lineChartView.getMaximumViewport());
//                viewport.top = 110;  If you need to set a higher ymax
//                lineChartView.setMaximumViewport(viewport);
//                lineChartView.setCurrentViewport(viewport);
            }
        });

    }
    private String getNewDate(String dt){
        SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyy");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(sdf.parse(dt));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.add(Calendar.DATE, 1);  // number of days to add
        dt = sdf.format(c.getTime());  // dt is now the new date
        return dt;
    }
}
