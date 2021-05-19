package com.example.log_in;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Activity5 extends AppCompatActivity {

    TextView fullName, BMI, age, gender;
    ImageButton delete, questionnaire, details, writeNote;
    Resident resident;
    DbHandler dbHandler = new DbHandler(Activity5.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);

        Intent intent = getIntent();
        Resident resident = (Resident) intent.getSerializableExtra("resident");

        fullName = (TextView) findViewById(R.id.printFullName);
        BMI = (TextView) findViewById(R.id.printBMI);
        age = (TextView) findViewById(R.id.printAge);
        details = (ImageButton) findViewById(R.id.details);
        questionnaire = (ImageButton) findViewById(R.id.questionair);
        writeNote = (ImageButton) findViewById(R.id.writeNote);
        delete = (ImageButton) findViewById(R.id.deleteResidentButton);
        gender=(TextView) findViewById(R.id.printGender);

        fullName.setText("  "+resident.getFirstName() + " " + resident.getLastName());
        BMI.setText(String.valueOf(resident.getBmi()));
        age.setText(String.valueOf(resident.getAge()));
        gender.setText(resident.getGender());

        details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                accessActivity6(resident);
            }
        });

        questionnaire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resident.getAge() < 65)
                {
                    Toast.makeText(Activity5.this, "This Resident's age is under 65, it will not be admitted by faciulity.", Toast.LENGTH_LONG).show();
                    accessActivity8();
                }
                else if (resident.getBmi() >= 30)
                {
                    Toast.makeText(Activity5.this, "This Resident's BMI is above 30, it will not be admitted by faciulity.", Toast.LENGTH_LONG).show();
                    accessActivity8();
                }
                else {
                    accessActivity7();
                }
            }
        });

        writeNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                accessActivity9(resident);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                accessActivity4(resident);
            }
        });
    }

    private void accessActivity4(Resident resident) {
        dbHandler.deleteUser(resident);
        Toast.makeText(Activity5.this, "Resident deleted", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,Activity4.class);
        startActivity(intent);
    }

    private void accessActivity9(Resident resident) {
        Intent intent = new Intent(this,Activity9.class);
        intent.putExtra("resident", resident);
        startActivity(intent);
    }

    private void accessActivity6(Resident resident){
        Intent intent = new Intent(this,Activity6.class);
        intent.putExtra("resident", resident);
        startActivity(intent);
    }

    private void accessActivity7(){

            Intent intent = new Intent(this, Activity7.class);
            startActivity(intent);
    }

    private void accessActivity8() {
        Intent intent = new Intent (this,Activity8.class);
        intent.putExtra("score", 1000);
        startActivity(intent);
    }


}
