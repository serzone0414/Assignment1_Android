package com.example.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

public class DbHandler extends SQLiteOpenHelper {

    private  static  final int DB_VERSION=1;
    private  static  final String DB_NAME = "userdatabase";
    private  static  final String TABLE_Users = "userdetails";
    private  static  final String KEY_ID = "id";
    private  static  final String KEY_NAME = "username";
    private  static  final String KEY_LOC = "location";
    private  static  final String KEY_DESG = "designation";


    public DbHandler(@Nullable Context context) {
        super(context, DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE=" CREATE TABLE "+ TABLE_Users + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_NAME + " TEXT,"
                + KEY_LOC + " TEXT,"
                +KEY_DESG + " TEXT"
                + ")";

        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Users);
        onCreate(db);
    }

    public void inserUserDetails (String username, String location, String designation)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_NAME,username);
        contentValues.put(KEY_LOC,location);
        contentValues.put(KEY_DESG,designation);

        long newRowID=db.insert(TABLE_Users, null, contentValues);
        db.close();

    }

    public ArrayList<HashMap<String,String>>  getUsers() {
        SQLiteDatabase db = this.getWritableDatabase();

        ArrayList<HashMap<String,String>> userList = new ArrayList<>();

        String query = " SELECT username,location,designation FROM " + TABLE_Users;
        Cursor cursor = db.rawQuery(query,null);

        while(cursor.moveToNext())
        {
            HashMap<String,String> user = new HashMap<>();
            user.put("username",cursor.getString(cursor.getColumnIndex(KEY_NAME)));
            user.put("location",cursor.getString(cursor.getColumnIndex(KEY_LOC)));
            user.put("deisgnation",cursor.getString(cursor.getColumnIndex(KEY_DESG)));

            userList.add(user);

        }
        return userList;
    }

    public int UpdateUserDetail(String location, String designation, int id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_LOC,location);
        contentValues.put(KEY_DESG,designation);
        int count = db.update(TABLE_Users,contentValues,KEY_ID+" = ?",
                new String[] {String.valueOf(id)});
        return count;
    }

    public void DeleteUser(int userId){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_Users,
                KEY_ID+" = ?",
                new String[] {String.valueOf(userId)});
        db.close();
    }
}