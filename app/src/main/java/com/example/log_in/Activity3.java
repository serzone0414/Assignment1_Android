package com.example.log_in;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Activity3 extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    //Initialize Vairable
    EditText etFirstName, etLastName, etDOB, etWeight ,etHeight;
    Button submitButton;
    ArrayList<Resident> residentArrayList;
    Spinner et_Gender;
    String genderString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        Intent intent = getIntent();
        residentArrayList = (ArrayList<Resident>) intent.getSerializableExtra("resident");

        //Assign Variable
        etFirstName = findViewById(R.id.et_firstName);
        etLastName = findViewById( R.id.et_lastName);
        etDOB = findViewById(R.id.et_DOB);
        etWeight = findViewById(R.id.et_weight);
        etHeight = findViewById(R.id.et_height);
        submitButton = (Button) findViewById(R.id.submitButton);
        et_Gender=(Spinner) findViewById(R.id.et_gender);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.genderChoice, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        et_Gender.setAdapter(adapter);
        et_Gender.setOnItemSelectedListener(this);


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(etFirstName.getText().toString()))
                {
                    Toast.makeText(Activity3.this,"First name must be entered.",Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(etLastName.getText().toString()))
                {
                    Toast.makeText(Activity3.this,"Last name must be entered", Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(etDOB.getText().toString()))
                {
                    Toast.makeText(Activity3.this,"Date of birth must be entered", Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(etWeight.getText().toString()))
                {
                    Toast.makeText(Activity3.this,"Weight must be entered", Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(etHeight.getText().toString()))
                {
                    Toast.makeText(Activity3.this,"Height must be entered", Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(genderString))
                {
                    Toast.makeText(Activity3.this,"Gender must be entered", Toast.LENGTH_SHORT).show();
                }

                else {
                    try {
                        residentArrayList.add(creatResident());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                        accessActivity4();

                }
            }
        });
    }

    private void accessActivity4() {
        Intent intent = new Intent (this,Activity4.class);
        intent.putExtra("resident", residentArrayList);
        startActivity(intent);
    }

    private Resident creatResident() throws ParseException {
        Resident resident = new Resident();
        Calculation calculation= new Calculation();
        resident.setFirstName(etFirstName.getText().toString());
        resident.setLastName(etLastName.getText().toString());
        resident.setDateOfBirth(etDOB.getText().toString());
        resident.setWeight(Integer.parseInt(etWeight.getText().toString()));
        resident.setHeight(Integer.parseInt(etHeight.getText().toString()));
        resident.setAge(calculation.ageCalculator(resident.getDateOfBirth()));
        resident.setBmi(calculation.bmiCalculator(resident.getWeight(), resident.getHeight()));
        resident.setGender(genderString);
        return resident;
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            genderString = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}