package com.student.sjh.datacog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ReponseTime extends AppCompatActivity {

    long startTime, lapTime,pressTime;
    List<Double> timeList = new ArrayList<>();
    Random r = new Random();
    int Low = 1000;
    int High = 3000;
    int counter = 0;
    int backgroundColor = Color.TRANSPARENT;
    TextView tv,tvIntro;
    RelativeLayout view;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reponse_time);
        view = (RelativeLayout) findViewById(R.id.activity_reponse);
        tv = (TextView) findViewById(R.id.textView);
        tvIntro = (TextView) findViewById(R.id.reponseIntro);
    }
    public void changeBackgroundColor(){
        if (getBackgroundColor() == ContextCompat.getColor(this,R.color.colorAccent)){
            view.setBackgroundColor(ContextCompat.getColor(this,R.color.colorTrueWhite));
        }else{
            view.setBackgroundColor(ContextCompat.getColor(this,R.color.colorAccent));
        }
    }
    public int getBackgroundColor(){
        Drawable background = view.getBackground();
        if (background instanceof ColorDrawable)
            backgroundColor = ((ColorDrawable) background).getColor();
        return backgroundColor;
    }
    public void screenPressed(View v){

        if (getBackgroundColor() == ContextCompat.getColor(this,R.color.colorAccent)){
            pressTime = System.currentTimeMillis();
            addTimeElapse(lapTime,pressTime);
            changeBackgroundColor();
            if((pressTime-startTime) >=30000){
                //Scorescreen call
                /*
                b = (Button) findViewById(R.id.start_button);
                tv.setText("");
                tv.setVisibility(View.GONE);
                setValues();
                timeList.clear();
                */
                Intent intent = new Intent(this, DigitSpanActivity.class);
                startActivity(intent);
            }else {
                spawnElement();
            }
        }else {
            counter++;
            if (counter >= 5){
                tv.setText("CHEATER");
            }

        }
    }
    public void setValues(){
        double best = 0.0;
        double worst = 0.0;
        double avg = 0.0;
        boolean firstBest =  true;

        for (int i = 0; i <timeList.size(); i++){
            if (timeList.get(i) < best || firstBest == true){
                best = timeList.get(i);
                firstBest = false;
            }else if(timeList.get(i) > worst){
                worst = timeList.get(i);
            }avg += timeList.get(i);
        }
        avg = avg/timeList.size();
        DecimalFormat finalAvg = new DecimalFormat("#.###") ;
    }
    public void addTimeElapse(Long lap, Long press){
        TextView tv = (TextView) findViewById(R.id.textView);
        double elapseTime = (press.doubleValue()-lap.doubleValue())/1000;
        timeList.add(elapseTime);
        tv.setText(elapseTime + "");
    }

    public void spawnElement(){
        int rResult = r.nextInt(High-Low) + Low;
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                changeBackgroundColor();
                lapTime = System.currentTimeMillis();
            }
        },rResult);
    }
    public void reponseStartButtonPressed(View v){
        tvIntro.setVisibility(View.GONE);
        tv.setVisibility(View.VISIBLE);
        v.setVisibility(View.GONE);

        startTime = System.currentTimeMillis();
        spawnElement();
    }
}
