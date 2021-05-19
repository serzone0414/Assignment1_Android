package com.example.log_in;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DbHandler extends SQLiteOpenHelper {

    private  static  final int DB_VERSION = 1;
    private  static  final String DB_NAME = "userdatabase";
    private  static  final String TABLE_Account = "ACCOUNT_TABLE";
    private  static  final String TABLE_Resident = "RESIDENT_TABLE";

    //Account table column details
    private  static  final String KEY_ID = "id";
    private  static  final String KEY_NAME = "username";
    private  static  final String KEY_PASSWORD = "password";

    //Resident table column details
    private  static  final String KEY_RESIDENTID = "residentID";
    private  static  final String KEY_FIRSTNAME = "firstName";
    private  static  final String KEY_LASTNAME = "lastName";
    private  static  final String KEY_DATEOFBIRTH = "dateOfBirth";
    private  static  final String KEY_WEIGHT = "weight";
    private  static  final String KEY_HEIGHT = "height";
    private  static  final String KEY_AGE = "age";
    private  static  final String KEY_BMI = "bmi";
    private  static  final String KEY_GENDER = "gender";
    private  static  final String KEY_NHI = "NHI";
    private  static  final String KEY_GP = "GP";
    private  static  final String KEY_MEDICALHISTORY = "medicalHistory";
    private  static  final String KEY_FOOD = "food";
    private  static  final String KEY_ALLERGIES = "allergies";
    private  static  final String KEY_MEDICATION = "medication";
    private  static  final String KEY_WARFARIN = "warfarin";
    private  static  final String KEY_INSULIN = "insulin";
    private  static  final String KEY_BEHAVIOURS = "behaviours";
    private  static  final String KEY_CONCERNS = "concerns";
    private  static  final String KEY_DENTURES = "dentures";
    private  static  final String KEY_EQUIPMENT = "equipment";
    private  static  final String KEY_CULTURALCONSIDERATION = "culturalConsideration";
    private  static  final String KEY_PAIN = "pain";
    private  static  final String KEY_FALLS = "falls";
    private  static  final String KEY_WOUND = "wound";
    private  static  final String KEY_NEEDASSESSORS = "needAssessors";
    private  static  final String KEY_EPOAFAMILYCONTACT = "EPOAfamilyContact";
    private  static  final String KEY_LEISURE = "leisure";
    private  static  final String KEY_PHARMACY = "pharmacy";

    public DbHandler(@Nullable Context context) {
        super(context, DB_NAME,null,DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //create account table
        String CREATE_TABLE= "CREATE TABLE "+ TABLE_Account + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_NAME + " TEXT,"
                + KEY_PASSWORD + " TEXT"
                + ")";
        db.execSQL(CREATE_TABLE);

        //create resident table
        String CREATE_TABLE_2= "CREATE TABLE "+ TABLE_Resident + "("
                + KEY_RESIDENTID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_FIRSTNAME + " TEXT,"
                + KEY_LASTNAME + " TEXT,"
                + KEY_DATEOFBIRTH + " TEXT,"
                + KEY_WEIGHT + " TEXT,"
                + KEY_HEIGHT + " TEXT,"
                + KEY_AGE + " INT,"
                + KEY_BMI + " TEXT,"
                + KEY_GENDER + " TEXT,"
                + KEY_NHI + " TEXT,"
                + KEY_GP + " TEXT,"
                + KEY_MEDICALHISTORY + " TEXT,"
                + KEY_FOOD + " TEXT,"
                + KEY_ALLERGIES + " TEXT,"
                + KEY_MEDICATION + " TEXT,"
                + KEY_WARFARIN + " TEXT,"
                + KEY_INSULIN + " TEXT,"
                + KEY_BEHAVIOURS + " TEXT,"
                + KEY_CONCERNS + " TEXT,"
                + KEY_DENTURES + " TEXT,"
                + KEY_EQUIPMENT + " TEXT,"
                + KEY_CULTURALCONSIDERATION + " TEXT,"
                + KEY_PAIN + " TEXT,"
                + KEY_FALLS + " TEXT,"
                + KEY_WOUND + " TEXT,"
                + KEY_NEEDASSESSORS + " TEXT,"
                + KEY_EPOAFAMILYCONTACT + " TEXT,"
                + KEY_LEISURE + " TEXT,"
                + KEY_PHARMACY + " TEXT"
                + ")";
        db.execSQL(CREATE_TABLE_2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Account);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Resident);
        onCreate(db);
    }

    public boolean addOne (Account acount)
    {
        // adding one account into the account table
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(KEY_NAME, acount.getUsername());
        contentValues.put(KEY_PASSWORD, acount.getPassword());

        long newRowID=db.insert(TABLE_Account, null, contentValues);

        if (newRowID== -1){
            return false;
        }
        else{
            return true;
        }

        //db.close();

    }

    public boolean addOne (Resident resident)
    {
        //adding one resident into the resident table
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(KEY_FIRSTNAME, resident.getFirstName());
        contentValues.put(KEY_LASTNAME, resident.getLastName());
        contentValues.put(KEY_DATEOFBIRTH, resident.getDateOfBirth());
        contentValues.put(KEY_WEIGHT, resident.getWeight());
        contentValues.put(KEY_HEIGHT, resident.getHeight());
        contentValues.put(KEY_AGE, resident.getAge());
        contentValues.put(KEY_BMI, resident.getBmi());
        contentValues.put(KEY_GENDER, resident.getGender());
        contentValues.put(KEY_NHI, resident.getNHI());
        contentValues.put(KEY_GP, resident.getGP());
        contentValues.put(KEY_MEDICALHISTORY, resident.getMedicalHistory());
        contentValues.put(KEY_FOOD, resident.getFood());
        contentValues.put(KEY_ALLERGIES, resident.getAllergies());
        contentValues.put(KEY_MEDICATION, resident.getMedication());
        contentValues.put(KEY_WARFARIN, resident.getWarfarin());
        contentValues.put(KEY_INSULIN, resident.getInsulin());
        contentValues.put(KEY_BEHAVIOURS, resident.getBehaviours());
        contentValues.put(KEY_CONCERNS, resident.getConcerns());
        contentValues.put(KEY_DENTURES, resident.getDentures());
        contentValues.put(KEY_EQUIPMENT, resident.getEquipment());
        contentValues.put(KEY_CULTURALCONSIDERATION, resident.getCulturalConsideration());
        contentValues.put(KEY_PAIN, resident.getPain());
        contentValues.put(KEY_FALLS, resident.getFalls());
        contentValues.put(KEY_WOUND, resident.getWound());
        contentValues.put(KEY_NEEDASSESSORS, resident.getNeedAssessors());
        contentValues.put(KEY_EPOAFAMILYCONTACT, resident.getEPOAfamilyContact());
        contentValues.put(KEY_LEISURE, resident.getLeisure());
        contentValues.put(KEY_PHARMACY, resident.getPharmacy());

        long newRowID=db.insert(TABLE_Resident, null, contentValues);

        if (newRowID== -1){
            return false;
        }
        else{
            return true;
        }

        //db.close();

    }

    public List<Account> getAllAccounts() {
        //return whole acount list from database

        List<Account> returnList = new ArrayList<>();
        String query = " SELECT * FROM " + TABLE_Account;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query,null);

        if (cursor.moveToFirst()){
            do
            {
                String username = cursor.getString(cursor.getColumnIndex(KEY_NAME));
                String password = cursor.getString(cursor.getColumnIndex(KEY_PASSWORD));
                Account account = new Account(username,password);

                returnList.add(account);

            }while(cursor.moveToNext());
        }
        else{}
        cursor.close();
        db.close();
        return returnList;
    }

    public List<Resident> getAllResidents() {
        //return whole resident list from database

        List<Resident> returnList = new ArrayList<>();
        String query = " SELECT * FROM " + TABLE_Resident;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query,null);

        if (cursor.moveToFirst()){
            do
            {
                int residentID = cursor.getInt(cursor.getColumnIndex(KEY_RESIDENTID));
                String firstName = cursor.getString(cursor.getColumnIndex(KEY_FIRSTNAME));
                String lastName = cursor.getString(cursor.getColumnIndex(KEY_LASTNAME));
                String dateOfBirth = cursor.getString(cursor.getColumnIndex(KEY_DATEOFBIRTH));
                double weight = cursor.getDouble(cursor.getColumnIndex(KEY_WEIGHT));
                double height = cursor.getDouble(cursor.getColumnIndex(KEY_HEIGHT));
                int age  = cursor.getInt(cursor.getColumnIndex(KEY_AGE));
                double bmi  = cursor.getDouble(cursor.getColumnIndex(KEY_BMI));
                String gender = cursor.getString(cursor.getColumnIndex(KEY_GENDER));
                String NHI  = cursor.getString(cursor.getColumnIndex(KEY_NHI));
                String GP= cursor.getString(cursor.getColumnIndex(KEY_GP));
                String medicalHistory = cursor.getString(cursor.getColumnIndex(KEY_MEDICALHISTORY));
                String food = cursor.getString(cursor.getColumnIndex(KEY_FOOD));
                String allergies= cursor.getString(cursor.getColumnIndex(KEY_ALLERGIES));
                String medication= cursor.getString(cursor.getColumnIndex(KEY_MEDICATION));
                String warfarin= cursor.getString(cursor.getColumnIndex(KEY_WARFARIN));
                String insulin= cursor.getString(cursor.getColumnIndex(KEY_INSULIN));
                String behaviours= cursor.getString(cursor.getColumnIndex(KEY_BEHAVIOURS));
                String concerns= cursor.getString(cursor.getColumnIndex(KEY_CONCERNS));
                String dentures= cursor.getString(cursor.getColumnIndex(KEY_DENTURES));
                String equipment= cursor.getString(cursor.getColumnIndex(KEY_EQUIPMENT));
                String culturalConsideration= cursor.getString(cursor.getColumnIndex(KEY_CULTURALCONSIDERATION));
                String pain= cursor.getString(cursor.getColumnIndex(KEY_PAIN));
                String falls= cursor.getString(cursor.getColumnIndex(KEY_FALLS));
                String wound= cursor.getString(cursor.getColumnIndex(KEY_WOUND));
                String needAssessors= cursor.getString(cursor.getColumnIndex(KEY_NEEDASSESSORS));
                String EPOAfamilyContact= cursor.getString(cursor.getColumnIndex(KEY_EPOAFAMILYCONTACT));
                String leisure= cursor.getString(cursor.getColumnIndex(KEY_LEISURE));
                String pharmacy = cursor.getString(cursor.getColumnIndex(KEY_PHARMACY));


                Resident resident = new Resident();
                resident.setResidentID(residentID);
                resident.setFirstName(firstName);
                resident.setLastName(lastName);
                resident.setDateOfBirth(dateOfBirth);
                resident.setWeight(weight);
                resident.setHeight(height);
                resident.setAge(age);
                resident.setBmi(bmi);
                resident.setGender(gender);
                resident.setNHI(NHI);
                resident.setGP(GP);
                resident.setMedicalHistory(medicalHistory);
                resident.setFood(food);
                resident.setAllergies(allergies);
                resident.setMedication(medication);
                resident.setWarfarin(warfarin);
                resident.setInsulin(insulin);
                resident.setBehaviours(behaviours);
                resident.setConcerns(concerns);
                resident.setDentures(dentures);
                resident.setEquipment(equipment);
                resident.setCulturalConsideration(culturalConsideration);
                resident.setPain(pain);
                resident.setFalls(falls);
                resident.setWound(wound);
                resident.setNeedAssessors(needAssessors);
                resident.setEPOAfamilyContact(EPOAfamilyContact);
                resident.setLeisure(leisure);
                resident.setPharmacy(pharmacy);

                returnList.add(resident);

            }while(cursor.moveToNext());
        }
        else{}
        cursor.close();
        db.close();
        return returnList;
    }


    public boolean updateResidentDetail(Resident resident)
    {
        //update resident details into the database
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(KEY_FIRSTNAME, resident.getFirstName());
        contentValues.put(KEY_LASTNAME, resident.getLastName());
        contentValues.put(KEY_DATEOFBIRTH, resident.getDateOfBirth());
        contentValues.put(KEY_WEIGHT, resident.getWeight());
        contentValues.put(KEY_HEIGHT, resident.getHeight());
        contentValues.put(KEY_AGE, resident.getAge());
        contentValues.put(KEY_BMI, resident.getBmi());
        contentValues.put(KEY_GENDER, resident.getGender());
        contentValues.put(KEY_NHI, resident.getNHI());
        contentValues.put(KEY_GP, resident.getGP());
        contentValues.put(KEY_MEDICALHISTORY, resident.getMedicalHistory());
        contentValues.put(KEY_FOOD, resident.getFood());
        contentValues.put(KEY_ALLERGIES, resident.getAllergies());
        contentValues.put(KEY_MEDICATION, resident.getMedication());
        contentValues.put(KEY_WARFARIN, resident.getWarfarin());
        contentValues.put(KEY_INSULIN, resident.getInsulin());
        contentValues.put(KEY_BEHAVIOURS, resident.getBehaviours());
        contentValues.put(KEY_CONCERNS, resident.getConcerns());
        contentValues.put(KEY_DENTURES, resident.getDentures());
        contentValues.put(KEY_EQUIPMENT, resident.getEquipment());
        contentValues.put(KEY_CULTURALCONSIDERATION, resident.getCulturalConsideration());
        contentValues.put(KEY_PAIN, resident.getPain());
        contentValues.put(KEY_FALLS, resident.getFalls());
        contentValues.put(KEY_WOUND, resident.getWound());
        contentValues.put(KEY_NEEDASSESSORS, resident.getNeedAssessors());
        contentValues.put(KEY_EPOAFAMILYCONTACT, resident.getEPOAfamilyContact());
        contentValues.put(KEY_LEISURE, resident.getLeisure());
        contentValues.put(KEY_PHARMACY, resident.getPharmacy());


        long count = db.update(TABLE_Resident,contentValues,KEY_RESIDENTID+" = ?",
                new String[] {String.valueOf(resident.getResidentID())});

        if (count== -1){
            return false;
        }
        else{
            return true;
        }
    }

    public void deleteUser(Resident resident){
        //delete the resident from database
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_Resident,
                KEY_RESIDENTID+" = ?",
                new String[] {String.valueOf(resident.getResidentID())});
        db.close();
    }
}