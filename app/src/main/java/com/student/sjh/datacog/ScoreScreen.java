package com.student.sjh.datacog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ScoreScreen extends AppCompatActivity {

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_screen);
        tv =(TextView) findViewById(R.id.scoreText);
        Bundle previousExtras = getIntent().getExtras();
        String rBest = previousExtras.getString("rbest");
        String rWorst = previousExtras.getString("rWorst");
        String rAvg = previousExtras.getString("rAvg");
        String dDifficulty = previousExtras.getString("dDifficulty");
        String sCorr = previousExtras.getString("sCorr");
        String sWrong = previousExtras.getString("sWrong");
        tv.setText("Reponse"+"\n"
                + "Best: "+rBest+"   Worst: "+rWorst+"     Avg: "+rAvg+"\n"
                + "Digit"+ "\n"
                + "Difficulty: "+dDifficulty+"\n"
                + "Stroop"+"\n"
                + "Correct: "+sCorr+"   Wrong: "+sWrong);

    }
}
