package com.example.log_in;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Activity7 extends AppCompatActivity {
    private QuesntionLibrary mQuestionLibrary = new QuesntionLibrary();
    private TextView mScoreView;
    private TextView mQuesntionView;
    private Button mButtonYes;
    private Button mButtonNo;
    private Button mButtonQuit;
    private int mScore = 0;
    private int mQuesntionNumber = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_7);


        mScoreView = (TextView) findViewById(R.id.score);
        mQuesntionView = (TextView) findViewById( R.id.question);
        mButtonYes = (Button) findViewById(R.id.choiceYes);
        mButtonNo = (Button) findViewById(R.id.choiceNo);
        mButtonQuit = (Button) findViewById(R.id.choiceQuit);
        updateScore(mQuesntionNumber);
        updateQuestion();


        mButtonYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mQuesntionNumber <= 4) {
                    mScore = mScore + 1000;
                }
                else if (mQuesntionNumber <= 8)
                {
                    mScore = mScore + 100;
                }
                else if (mQuesntionNumber <= 12)
                {
                    mScore = mScore + 10;
                }
                else if (mQuesntionNumber <= 16)
                {
                    mScore = mScore + 1;
                }
                updateQuestion();
            }
        });

        mButtonNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateQuestion();
            }
        });

        mButtonQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                accessMenuActivity();
            }
        });
    }


    private void updateQuestion(){
        if (mQuesntionNumber > 15)
        {
            accessActivity8();
        }
        else {
            mQuesntionView.setText(mQuestionLibrary.getQuestion(mQuesntionNumber));
            mQuesntionNumber++;
            updateScore(mQuesntionNumber);
        }
        }


    private void accessActivity8() {
        Intent intent = new Intent (this,Activity8.class);
        intent.putExtra("score", mScore);
        startActivity(intent);
    }

    public void accessMenuActivity() {
        Toast.makeText(Activity7.this, "Quit", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent (this, MenuActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    private void updateScore(int mQuesntionNumber) {
        mScoreView.setText("Question: " + mQuesntionNumber + "/16");
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

}