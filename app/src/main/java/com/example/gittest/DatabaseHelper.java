package com.example.gittest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.nfc.Tag;
import android.util.Log;

import static android.content.ContentValues.TAG;
import static android.icu.text.MessagePattern.ArgType.SELECT;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Mealplans.db";
    public static final String TABLE_NAME = "Meal_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "BREAKFAST";
    public static final String COL_3 = "SNACK";
    public static final String COL_4 = "LUNCH";
    public static final String COL_5 = "SNACKS";
    public static final String COL_6 = "DINNER";

    public DatabaseHelper( Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,BREAKFAST TEXT,SNACK TEXT,LUNCH TEXT,SNACKS TEXT,DINNER TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData (String breakfast,String snack,String lunch,String snacks,String dinner) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,breakfast);
        contentValues.put(COL_3,snack);
        contentValues.put(COL_4,lunch);
        contentValues.put(COL_5,snacks);
        contentValues.put(COL_6,dinner);
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

    public Integer deleteData(String breakfast){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "BREAKFAST = ?",new String[] {breakfast} );
    }

///// UPDATE

    public void updateName(String newName,int id,String oldName){
        SQLiteDatabase db = this.getWritableDatabase();

        String query = " UPDATE " + TABLE_NAME + " SET " + COL_2 +" = '" + newName + "' WHERE " + COL_1 + " = '" + id + "'" + "AND" + COL_2 + " = '" + oldName + "'" ;
        Log.d(TAG,"update name: query: "+query);
        Log.d(TAG,"update name: setting name to: "+newName);
        db.execSQL(query);
    }
    ////GET

    public Cursor getItemId(String breakfast){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + COL_2 +" = '" + breakfast + "'" ;

        Cursor data = db.rawQuery(query, null);
        return data;

    }
}

