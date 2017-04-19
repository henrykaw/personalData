package com.student.sjh.datacog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DigitSpanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digit_span);
    }
    public void digitBackPressed(View view){
        Intent intent = new Intent();
        setResult(RESULT_OK,intent);
        finish();
    }
}
