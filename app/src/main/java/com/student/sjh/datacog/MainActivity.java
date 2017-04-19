package com.student.sjh.datacog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startPressed(View v){
        Intent mainIntent = new Intent(v.getContext(), Stroop.class);
        startActivityForResult(mainIntent, 0);
    }
}
