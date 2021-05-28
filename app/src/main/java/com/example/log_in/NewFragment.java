package com.example.log_in;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.text.ParseException;
import java.util.Calendar;

public class NewFragment extends Fragment {
    Button newResidentButton;
    EditText etFirstName, etLastName, etWeight ,etHeight;
    TextView etDOB;
    Button submitButton;
    Spinner et_Gender;
    String genderString;
    DbHandler dbHandler;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        dbHandler = new DbHandler(getActivity());


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new, container,false);

        etFirstName = view.findViewById(R.id.fg_et_firstName);
        etLastName = view.findViewById( R.id.fg_et_lastName);
        etDOB = (TextView) view.findViewById(R.id.fg_et_DOB);
        etWeight = view.findViewById(R.id.fg_et_weight);
        etHeight = view.findViewById(R.id.fg_et_height);
        submitButton = (Button) view.findViewById(R.id.fg_submitButton);
        et_Gender=(Spinner) view.findViewById(R.id.fg_et_gender);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),R.array.genderChoice, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        et_Gender.setAdapter(adapter);
        et_Gender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                genderString = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        view.findViewById(R.id.fg_datePickerButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(etFirstName.getText().toString()))
                {
                    Toast.makeText(getActivity(),"First name must be entered.",Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(etLastName.getText().toString()))
                {
                    Toast.makeText(getActivity(),"Last name must be entered", Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(etDOB.getText().toString()))
                {
                    Toast.makeText(getActivity(),"Date of birth must be entered", Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(etWeight.getText().toString()))
                {
                    Toast.makeText(getActivity(),"Weight must be entered", Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(etHeight.getText().toString()))
                {
                    Toast.makeText(getActivity(),"Height must be entered", Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(genderString))
                {
                    Toast.makeText(getActivity(),"Gender must be entered", Toast.LENGTH_SHORT).show();
                }

                else {

                    try {
                        //residentArrayList.add(creatResident());
                        Boolean success = dbHandler.addOne(creatResident());
                        Toast.makeText(getActivity(), "Success: " + success, Toast.LENGTH_SHORT).show();

                    } catch (ParseException e) {
                        e.printStackTrace();

                    }
                    accessMenuActivity();

                }
            }
        });

        newResidentButton = view.findViewById(R.id.fg_newResidentButtton);
        newResidentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                accessActivity3();
            }
        });
        return view;
    }

    private void accessActivity3() {
        Intent intent = new Intent( getActivity(),Activity3.class);
        startActivity(intent);
    }

    private void showDatePickerDialog() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), (DatePickerDialog.OnDateSetListener) getParentFragment(), Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
        int dayOfMonth = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        int newMonth =  Calendar.getInstance().get(Calendar.MONTH) + 1;
        int year = Calendar.getInstance().get(Calendar.YEAR);
        String date = dayOfMonth + "/" + newMonth + "/" + year;
        etDOB.setText(date);

    }

    private void accessMenuActivity() {
        Intent intent = new Intent (getActivity(),MenuActivity.class);
        //intent.putExtra("resident", residentArrayList);
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


}
