package com.example.log_in;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.text.ParseException;
import java.util.ArrayList;

public class Activity2 extends AppCompatActivity {

    Button newResidentButton, existResident;
    ArrayList<Resident> residentArrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);



        newResidentButton = (Button) findViewById(R.id.newResident);
        existResident = (Button) findViewById(R.id.existResident);
        Resident demo = new Resident("Bob", "Smith (Demo)", "01/01/1970", 80, 175, "Male");
        try {
            demo.setAge(Calculation.ageCalculator(demo.getDateOfBirth()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        demo.setBmi(Calculation.bmiCalculator(demo.getWeight(),demo.getHeight()));
        residentArrayList.add(demo);

        newResidentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                accessActivity3();
            }
        });

        existResident.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                accessActivity4();
            }
        });
    }

    private void accessActivity3() {
        Intent intent = new Intent( this,Activity3.class);
        intent.putExtra("resident", residentArrayList);
        startActivity(intent);
    }

    private void accessActivity4(){
        Intent intent = new Intent(this,Activity4.class);
        intent.putExtra("resident", residentArrayList);
        startActivity(intent);
    }

}