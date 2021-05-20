package com.example.log_in;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.text.ParseException;

public class Activity2 extends AppCompatActivity {

    Button newResidentButton, existResident;
    //ArrayList<Resident> residentArrayList = new ArrayList<>();
    Resident demo;

    Resident resident = new Resident();
    //ResidentDbHandler residentDbHandler = new ResidentDbHandler(Activity2.this);
    DbHandler dbHandler = new DbHandler(Activity2.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);



        newResidentButton = (Button) findViewById(R.id.newResident);
        existResident = (Button) findViewById(R.id.existResident);


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
        //intent.putExtra("resident", residentArrayList);
        startActivity(intent);
    }

    private void accessActivity4(){
        //Those codes under are only for creating few demo residents
        Resident demo = new Resident("Bob", "Smith (Demo - Low Age)", "01/01/1970", 80, 175, "Male");
        try {
            demo.setAge(Calculation.ageCalculator(demo.getDateOfBirth()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        demo.setBmi(Calculation.bmiCalculator(demo.getWeight(),demo.getHeight()));

        Resident demoTwo = new Resident("Merry", "Kerr (Demo - High BMI)", "01/01/1950", 140, 169, "Female");
        try {
            demoTwo.setAge(Calculation.ageCalculator(demoTwo.getDateOfBirth()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        demoTwo.setBmi(Calculation.bmiCalculator(demoTwo.getWeight(),demoTwo.getHeight()));

        Resident demoThree = new Resident("Tony", "Lee (Demo - Acceptable resident)", "01/01/1950", 75, 172, "Male");
        try {
            demoThree.setAge(Calculation.ageCalculator(demoThree.getDateOfBirth()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        demoThree.setBmi(Calculation.bmiCalculator(demoThree.getWeight(),demoThree.getHeight()));
        dbHandler.addOne(demoThree);
        dbHandler.addOne(demoTwo);
        try {

            boolean success = dbHandler.addOne(demo);
            Toast.makeText(Activity2.this, "Success: " + success, Toast.LENGTH_SHORT).show();
        }
        catch (Exception e){
            Toast.makeText(Activity2.this, "Error adding resident", Toast.LENGTH_SHORT).show();
            //Account failedAccount = new Account("Error","Error");
            //accountDbHandler.addOne(failedAccount);
        }

        // Access to Activity 4
        Intent intent = new Intent(this,Activity4.class);
        //intent.putExtra("resident", residentArrayList);
        startActivity(intent);
    }

}