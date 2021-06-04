package com.example.log_in;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity6 extends AppCompatActivity {
    EditText et_gp,
            et_medicalHistory,
            et_food,
            et_allergies,
            et_medication,
            et_warfarin,
            et_insulin,
            et_behaviours,
            et_concerns,
            et_dentures,
            et_equipment,
            et_culturalConsideration,
            et_pain,
            et_falls,
            et_wound,
            et_needAssessors,
            et_EPOAfamilyContact,
            et_leisure,
            et_pharmacy;
    Button detailConfirmButton;
    Resident resident;
    DbHandler dbHandler = new DbHandler(Activity6.this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_6);

        Intent intent = getIntent();
        Resident resident = (Resident) intent.getSerializableExtra("resident");

        et_gp = (EditText) findViewById(R.id.et_gp);
        et_medicalHistory = (EditText) findViewById(R.id.et_medicalHistory);
        et_food =(EditText) findViewById(R.id.et_food);
        et_allergies = (EditText)findViewById(R.id.et_allergies);
        et_medication =(EditText) findViewById(R.id.et_medication);
        et_warfarin = (EditText) findViewById(R.id.et_warfarin);
        et_insulin = (EditText) findViewById(R.id.et_insulin);
        et_behaviours = (EditText) findViewById(R.id.et_behaviours);
        et_concerns = (EditText) findViewById(R.id.et_concerns);
        et_dentures = (EditText) findViewById(R.id.et_dentures);
        et_equipment = (EditText) findViewById(R.id.et_equipment);
        et_culturalConsideration = (EditText) findViewById(R.id.et_culturalConsideration);
        et_pain = (EditText) findViewById(R.id.et_pain);
        et_falls = (EditText) findViewById(R.id.et_falls);
        et_wound = (EditText) findViewById(R.id.et_wound);
        et_needAssessors=(EditText)findViewById(R.id.et_needAssessors);
        et_EPOAfamilyContact = (EditText) findViewById(R.id.et_EPOAfamilyContact);
        et_leisure =  (EditText) findViewById(R.id.et_leisure);
        et_pharmacy = (EditText) findViewById(R.id.et_pharmacy);
        detailConfirmButton = (Button) findViewById(R.id.detailsConfirmButton);

        ActivityCompat.requestPermissions(Activity6.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);

        et_gp.setText(resident.getGP());
        et_medicalHistory.setText(resident.getMedicalHistory());
        et_food.setText(resident.getFood());
        et_allergies.setText(resident.getAllergies());
        et_medication.setText(resident.getMedication());
        et_warfarin.setText(resident.getWarfarin());
        et_insulin.setText(resident.getInsulin());
        et_behaviours.setText(resident.getBehaviours());
        et_concerns.setText(resident.getConcerns());
        et_dentures.setText(resident.getDentures());
        et_equipment.setText(resident.getEquipment());
        et_culturalConsideration.setText(resident.getCulturalConsideration());
        et_pain.setText(resident.getPain());
        et_wound.setText(resident.getWound());
        et_falls.setText(resident.getFalls());
        et_needAssessors.setText(resident.getNeedAssessors());
        et_EPOAfamilyContact.setText(resident.getEPOAfamilyContact());
        et_leisure.setText(resident.getLeisure());
        et_pharmacy.setText(resident.getPharmacy());

        detailConfirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateResidentDetails(resident);
                updateResidentDataBase(resident);
                accessMenuActivity();
            }
        });


    }


    private void updateResidentDetails(Resident resident) {
        resident.setGP(et_gp.getText().toString());
        resident.setMedicalHistory(et_medicalHistory.getText().toString());
        resident.setFood(et_food.getText().toString());
        resident.setAllergies(et_allergies.getText().toString());
        resident.setMedication(et_medication.getText().toString());
        resident.setWarfarin(et_warfarin.getText().toString());
        resident.setInsulin(et_insulin.getText().toString());
        resident.setBehaviours(et_behaviours.getText().toString());
        resident.setConcerns(et_concerns.getText().toString());
        resident.setDentures(et_dentures.getText().toString());
        resident.setEquipment(et_equipment.getText().toString());
        resident.setCulturalConsideration(et_culturalConsideration.getText().toString());
        resident.setPain(et_pain.getText().toString());
        resident.setWound(et_wound.getText().toString());
        resident.setFalls(et_falls.getText().toString());
        resident.setNeedAssessors(et_needAssessors.getText().toString());
        resident.setEPOAfamilyContact(et_EPOAfamilyContact.getText().toString());
        resident.setLeisure(et_leisure.getText().toString());
        resident.setPharmacy(et_pharmacy.getText().toString());
    }

    private  void updateResidentDataBase(Resident resident)
    {
        try {

            boolean success = dbHandler.updateResidentDetail(resident);
            Toast.makeText(Activity6.this, "Update: " + success, Toast.LENGTH_SHORT).show();
        }
        catch (Exception e){
            Toast.makeText(Activity6.this, "Error updating resident", Toast.LENGTH_SHORT).show();
        }

    }

    private void accessMenuActivity() {

            Intent intent = new Intent(this,MenuActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

}