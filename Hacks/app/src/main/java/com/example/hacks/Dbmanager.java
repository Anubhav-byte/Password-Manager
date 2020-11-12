package com.example.hacks;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Dbmanager extends SQLiteOpenHelper {
    public static final String TABLE_NAME = "password";

    // Table columns
    public static final String UID = "User_id";
    public static final String Website = "Website";
    public static final String Password = "Password";

    // Database Information
    static final String DB_NAME = "Password_manager.DB";

    // database version
    static final int DB_VERSION = 1;

    // Creating table query
    private static final String CREATE_TABLE = "create table " + TABLE_NAME + "(" + UID
            + " , " + Website + " TEXT NOT NULL, " + Password + " TEXT);";
    public Dbmanager( Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
    public String addRecord(String user, String web ,String password){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("User_id" , user);
        cv.put("Website",web);
        cv.put("Password", password);

        long res=db.insert(TABLE_NAME,null, cv);
        if(res==-1)
            return "Failed";
        else
            return "Saved Successfully";
    }
    public Cursor getData(){
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cr=db.rawQuery("SELECT * FROM "+ TABLE_NAME+ ";", null);
        return cr;
    }
}
