package com.example.gittest;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Mealplans.db";
    public static final String TABLE_NAME = "Meal_table";
    public static final String COL_1 = "BREAKFAST";
    public static final String COL_2 = "SNACK";
    public static final String COL_3 = "LUNCH";
    public static final String COL_4 = "SNACKS";
    public static final String COL_5 = "DINNER";
    public DatabaseHelper( Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (BREAKFAST TEXT PRIMARY KEY,SNACK TEXT,LUNCH TEXT,SNACKS TEXT,DINNER TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData (String breakfast,String snack,String lunch,String snacks,String dinner) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,breakfast);
        contentValues.put(COL_2,snack);
        contentValues.put(COL_3,lunch);
        contentValues.put(COL_4,snacks);
        contentValues.put(COL_5,dinner);
        long result = db.insert (TABLE_NAME,null ,contentValues);
        if (result ==-1)
            return false;
        else
            return true;

    }
}

