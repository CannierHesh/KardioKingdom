package com.example.kardiokingdom;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PDBHandler extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "PDB.db";
    public static final String TABLE_NAME = "Exercise_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "EXERCISE";
    public static final String COL_3 = "DESCRIPTION";
    public static final String COL_4 = "WORKOUT";
    public static final String COL_5 = "REST";
    public static final String COL_6 = "ROUND";


    public PDBHandler( Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,EXERCISE TEXT,DESCRIPTION TEXT,WORKOUT TEXT,REST TEXT,ROUND TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData (String exercise,String description,String workout,String rest,String round) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,exercise);
        contentValues.put(COL_3,description);
        contentValues.put(COL_4,workout);
        contentValues.put(COL_5,rest);
        contentValues.put(COL_6,round);

        long result = db.insert (TABLE_NAME,null ,contentValues);
        if (result ==-1)
            return false;
        else
            return true;

    }
    /////VIEW LIST
    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " +TABLE_NAME,null);
        return data;
    }
///// DELETE

    public Integer deleteData(String exercise){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "EXERCISE = ?",new String[] {exercise} );
    }

///// UPDATE

    public boolean updateData(String exercise,String description,String workout,String rest,String round) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, exercise);
        contentValues.put(COL_3, description);
        contentValues.put(COL_4, workout);
        contentValues.put(COL_5, rest);
        contentValues.put(COL_6, round);
        db.update(TABLE_NAME, contentValues, "EXERCISE = ?", new String[]{exercise});
        return true;
    }
    ////GET

    public Cursor getItemId(String exercise){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + COL_2 +" = '" + exercise + "'" ;

        Cursor data = db.rawQuery(query, null);
        return data;

    }
}

