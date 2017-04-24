package com.student.sjh.datacog;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Stroop extends AppCompatActivity {

    TextView stroopTv;
    Button understood,purpleButton,blueButton,
            orangeButton,greenButton,redButton,yellowButton;
    Boolean modeLetter;
    GridLayout buttonsGridlayout;
    String[] colorNames;
    int[] colors;
    Random r = new Random();
    int gameCount;
    long tStart,dTime;
    int corr = 0;
    int wrong= 0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stroop);

        //Binding the UI element to variables.
        purpleButton = (Button) findViewById(R.id.purpleButton);
        blueButton = (Button) findViewById(R.id.blueButton);
        orangeButton = (Button) findViewById(R.id.orangeButton);
        greenButton = (Button) findViewById(R.id.greenButton);
        redButton = (Button) findViewById(R.id.redButton);
        yellowButton = (Button) findViewById(R.id.yellowButton);
        understood = (Button) findViewById(R.id.stroopUnderstood);
        stroopTv = (TextView) findViewById(R.id.stroopText);
        buttonsGridlayout = (GridLayout) findViewById(R.id.buttonsGrid);

        //String array containing the names of the colors.
        colorNames = getResources().getStringArray(R.array.color_names);
        //Int array holding the color values.
        colors = getResources().getIntArray(R.array.color_values);
        gameCount = 0;
        modeLetter = false;
    }

    public void colorButtonPres(View v){
        switch (v.getId()){
            case R.id.purpleButton:
                // something
                disableStroopButtons();
                checkChoice(getString(R.string.purple));
                enableStroopButtonsDelay();
                break;
            case R.id.blueButton:
                // something
                disableStroopButtons();
                checkChoice(getString(R.string.blue));
                enableStroopButtonsDelay();
                break;
            case R.id.orangeButton:
                // Somethign
                //stroopTv.setTextColor(ContextCompat.getColor(Stroop.this,R.color.colorOrange));
                disableStroopButtons();
                checkChoice(getString(R.string.orange));
                enableStroopButtonsDelay();
                break;
            case R.id.greenButton:
                // Something
                //stroopTv.setTextColor(ContextCompat.getColor(Stroop.this,R.color.colorOrange));
                disableStroopButtons();
                checkChoice(getString(R.string.green));
                enableStroopButtonsDelay();
                break;
            case R.id.redButton:
                // Something
                disableStroopButtons();
                checkChoice(getString(R.string.red));
                enableStroopButtonsDelay();
                break;
            case R.id.yellowButton:
                // Somethign
                disableStroopButtons();
                checkChoice(getString(R.string.yellow));
                enableStroopButtonsDelay();
                break;
        }
    }
/*    public void buttonsView(View v){
        if (modeLetter) {
            buttonsGridlayout.setVisibility(View.VISIBLE);
            modeLetter = false;
        } else{
            buttonsGridlayout.setVisibility(View.GONE);
            modeLetter = true;
        }

    }*/

    public void startStroop(View view){
        if (gameCount <3) {
            understood.setVisibility(View.GONE);
            buttonsGridlayout.setVisibility(View.VISIBLE);
            tStart = System.currentTimeMillis();
            newColorText();
        }else if (gameCount == 3){
            Intent intent = new Intent(this, ScoreScreen.class);
            Bundle previousExtras = getIntent().getExtras();
            String rBest = previousExtras.getString("rBest");
            String rWorst = previousExtras.getString("rWorst");
            String rAvg = previousExtras.getString("rAvg");
            String dDifficulty = previousExtras.getString("dDifficulty");
            Bundle extras = new Bundle();
            extras.putString("rBest", rBest);
            extras.putString("rWorst", rWorst);
            extras.putString("rAvg", rAvg);
            extras.putString("dDifficulty", dDifficulty);
            extras.putString("sCorr", String.valueOf(corr));
            extras.putString("sWrong", String.valueOf(wrong));
            intent.putExtras(extras);
            startActivity(intent);
        }
    }
    public void checkChoice(String cl){
        if (cl.equalsIgnoreCase(getString(R.string.purple))){
            if (modeLetter){
                if (cl.equalsIgnoreCase(stroopTv.getText().toString())){
                    showCorrect();
                }else{
                    showWrong();
                }

            }else{
                if (ContextCompat.getColor(Stroop.this, R.color.colorPurple) ==stroopTv.getCurrentTextColor()){
                    showCorrect();
                }else {
                    showWrong();
                }
            }
        }else if(cl.equalsIgnoreCase(getString(R.string.blue))){
            if (modeLetter){
                if (cl.equalsIgnoreCase(stroopTv.getText().toString())){
                    showCorrect();
                }else{
                    showWrong();
                }

            }else{
                if (ContextCompat.getColor(Stroop.this, R.color.colorBlue) ==stroopTv.getCurrentTextColor()){
                    showCorrect();
                }else {
                    showWrong();
                }
            }
        }else if (cl.equalsIgnoreCase(getString(R.string.orange))){
            if (modeLetter){
                if (cl.equalsIgnoreCase(stroopTv.getText().toString())){
                    showCorrect();
                }else{
                    showWrong();
                }

            }else{
                if (ContextCompat.getColor(Stroop.this, R.color.colorOrange) ==stroopTv.getCurrentTextColor()){
                    showCorrect();
                }else {
                    showWrong();
                }
            }
        }else if (cl.equalsIgnoreCase(getString(R.string.green))){
            if (modeLetter){
                if (cl.equalsIgnoreCase(stroopTv.getText().toString())){
                    showCorrect();
                }else{
                    showWrong();
                }

            }else{
                if (ContextCompat.getColor(Stroop.this, R.color.colorGreen) ==stroopTv.getCurrentTextColor()){
                    showCorrect();
                }else {
                    showWrong();
                }
            }

        }else if (cl.equalsIgnoreCase(getString(R.string.red))){
            if (modeLetter){
                if (cl.equalsIgnoreCase(stroopTv.getText().toString())){
                    showCorrect();
                }else{
                    showWrong();
                }

            }else{
                if (ContextCompat.getColor(Stroop.this, R.color.colorRed) ==stroopTv.getCurrentTextColor()){
                    showCorrect();
                }else {
                    showWrong();
                }
            }

        }else if (cl.equalsIgnoreCase(getString(R.string.yellow))){
            if (modeLetter){
                if (cl.equalsIgnoreCase(stroopTv.getText().toString())){
                    showCorrect();
                }else{
                    showWrong();
                }

            }else{
                if (ContextCompat.getColor(Stroop.this, R.color.colorYellow) ==stroopTv.getCurrentTextColor()){
                    showCorrect();
                }else {
                    showWrong();
                }
            }

        }
    }
/*
    public void stroopBackPressed(View view){
        Intent intent = new Intent();
        setResult(RESULT_OK,intent);
        finish();
    }
*/
    public void showCorrect(){
        // Parameters for toast
        corr = corr +1;
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.correct_toast,
                (ViewGroup) findViewById(R.id.correct_toast));
        Toast toast= new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER,0,0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();

    }
    public void showWrong(){
        // Parameters for toast
        wrong = wrong +1;
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.wrong_toast,
                (ViewGroup) findViewById(R.id.wrong_toast));
        Toast toast= new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER,0,0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }

    public long getTimeElapse(){
        long currentTime = System.currentTimeMillis();
        long deltaTime =  currentTime - tStart;
        if (deltaTime > 900000){
            return 0L;
        }
        return deltaTime;
    }

    private void newColorText(){

        dTime = getTimeElapse();
        if (dTime < 20000){

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    int rText = r.nextInt(colorNames.length);
                    int rColor = r.nextInt(colors.length);
                    stroopTv.setText(colorNames[rText]);
                    //stroopTv.setText(Long.toString(dTime));
                    stroopTv.setTextColor(colors[rColor]);
                }
            },500);
        }else {
            if (gameCount ==0 ){
                gameCount = 1;
                understood.setVisibility(View.VISIBLE);
                buttonsGridlayout.setVisibility(View.GONE);
                stroopTv.setTextColor(ContextCompat.getColor(Stroop.this,R.color.colorTextSecondary));
                stroopTv.setText(R.string.stroop_word);
                modeLetter = true;
            } else if (gameCount == 1){
                gameCount = 2;
                understood.setVisibility(View.VISIBLE);
                buttonsGridlayout.setVisibility(View.GONE);
                stroopTv.setTextColor(ContextCompat.getColor(Stroop.this,R.color.colorTextSecondary));
                stroopTv.setText(R.string.stroop_letters);
                modeLetter = false;

            } else{
                gameCount = 3;
                understood.setVisibility(View.VISIBLE);
                buttonsGridlayout.setVisibility(View.GONE);
                stroopTv.setTextColor(ContextCompat.getColor(Stroop.this,R.color.colorTextSecondary));
                stroopTv.setText(R.string.stroop_end);
            }
        }
    }

    private void disableStroopButtons(){
        purpleButton.setEnabled(false);
        blueButton.setEnabled(false);
        orangeButton.setEnabled(false);
        greenButton.setEnabled(false);
        redButton.setEnabled(false);
        yellowButton.setEnabled(false);

    }

    private void enableStroopButtonsDelay(){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                purpleButton.setEnabled(true);
                blueButton.setEnabled(true);
                orangeButton.setEnabled(true);
                greenButton.setEnabled(true);
                redButton.setEnabled(true);
                yellowButton.setEnabled(true);
                stroopTv.setText(" ");
                newColorText();
            }
        },2000);
    }

}
