package com.student.sjh.datacog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Handler;
import java.util.Random;

public class DigitSpanActivity extends AppCompatActivity {

    TextView titleText, numberText;
    EditText TextAnswer;
    int difficulty = 3;
    List<Integer> numbersArray = new ArrayList<>();
    List<Integer> answerArray = new ArrayList<>();
    Button b;
    final Handler handler = new Handler();
    Random rand = new Random();
    int errors = 0;
    int errorsBefore;
    int lossesInRow = 0;
    int totalRuns = 0;
    String numbers = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digit_span);
        titleText = (TextView) findViewById(R.id.textTitle);
        numberText = (TextView) findViewById(R.id.textNumbers);
        TextAnswer = (EditText) findViewById(R.id.answerText);

        TextAnswer.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER){
                    if(TextAnswer.getText().toString().length() < difficulty){
                        titleText.setText("You only picked " + TextAnswer.getText().toString().length() +" number(s). You need " + difficulty + " numbers to continue");
                    }else{
                        compareAnswer();
                        return true;
                    }

                }
                return false;
            }
        });
        b = (Button) findViewById(R.id.startButton);

    }
    public void startButtonPressed(View v){
        b.setVisibility(View.GONE);
        titleText.setText(difficulty + " numbers will appear. \n Remember them.");
        numberText.setText("");

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                digitSpanTest();
            }
        }, 3000);

    }

    public void digitSpanTest(){
        totalRuns += 1;
        for(int i = 0; i < difficulty; i++ ){
            numbersArray.add(rand.nextInt(10));
        }

        for(int i = 0; i < difficulty; i++){
            if(i == 0){
                numbers = numbers + numbersArray.get(i);
            }else {
                numbers = numbers + " " + numbersArray.get(i);
            }
        }
        numberText.setText(numbers);
        titleText.setText("");
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                numberText.setText("");
                titleText.setText("Enter the numbers in the order they appeared.");
                TextAnswer.setVisibility(View.VISIBLE);

            }
        }, 3000+(difficulty-3)*500);

    }

    public void compareAnswer(){
        errorsBefore = errors;
        for(int i = 0; i < TextAnswer.getText().toString().length(); i++){
            answerArray.add(Integer.parseInt(TextAnswer.getText().toString().substring(i,i+1)));
        }
        for(int i = 0; i < numbersArray.size(); i++){
            if(!numbersArray.get(i).equals(answerArray.get(i))){
                errors += 1;
            }
        }


        TextAnswer.setVisibility(View.GONE);
        TextAnswer.setText("");
        answerArray.clear();
        numbersArray.clear();
        numbers = "";
        numberText.setText("");

        if(errorsBefore == errors){
            difficulty += 1;
            lossesInRow = 0;
        }else{
            lossesInRow += 1;
        }

        if(lossesInRow < 3 && totalRuns < 10){
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    titleText.setText(difficulty + " numbers will appear. \n Remember them.");
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            digitSpanTest();
                        }
                    }, 2000);
                }
            }, 500);
        }else{
            //titleText.setText("Total runs: " + totalRuns + ", number of errors: " + errors + ", highest level achieved: " + difficulty);
            Intent mainIntent = new Intent(this,Stroop.class);
            startActivityForResult(mainIntent, 0);
        }



    }

}