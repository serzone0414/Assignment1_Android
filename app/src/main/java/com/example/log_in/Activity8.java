package com.example.log_in;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Activity8 extends AppCompatActivity {
    private int score;
    TextView result_txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_8);

        Intent intent = getIntent();
        score = (int) intent.getSerializableExtra("score");
        result_txt = findViewById(R.id.result_txt);

        getResult(score);
    }

    private void getResult( int score) {
        if (score >= 1000) {
            result_txt.setText("We will not admit this resident, because the facility does not have  the equipments for the residernt needs.");
        }
        else if (score >= 100) {
            result_txt.setText("The resident will be admitted under Dementia care.");
        }
        else if (score >= 10) {
            result_txt.setText("The resident will be admitted under Hospital care.");
        }
        else {
            result_txt.setText("The resident will be admitted under Rest-home care.");
        }
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
