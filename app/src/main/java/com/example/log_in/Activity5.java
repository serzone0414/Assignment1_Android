package com.example.log_in;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity5 extends AppCompatActivity {

    TextView fullName, BMI, age, gender;
    Button details, questionnaire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);

        Intent intent = getIntent();
        Resident resident = (Resident) intent.getSerializableExtra("resident");

        fullName = (TextView) findViewById(R.id.printFullName);
        BMI = (TextView) findViewById(R.id.printBMI);
        age = (TextView) findViewById(R.id.printAge);
        details = (Button) findViewById(R.id.details);
        questionnaire = (Button) findViewById(R.id.questionair);
        gender=(TextView) findViewById(R.id.printGender);

        fullName.setText("  "+resident.getFirstName() + " " + resident.getLastName());
        BMI.setText(String.valueOf(resident.getBmi()));
        age.setText(String.valueOf(resident.getAge()));
        gender.setText(resident.getGender());

        details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                accessActivity6();
            }
        });

        questionnaire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                accessActivity7();
            }
        });
    }

    private void accessActivity6(){
        Intent intent = new Intent(this,Activity6.class);
        startActivity(intent);
    }

    private void accessActivity7(){
        Intent intent = new Intent(this,Activity7.class);
        startActivity(intent);
    }
}
