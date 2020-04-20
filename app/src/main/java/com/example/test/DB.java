package com.example.test;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DB extends SQLiteOpenHelper {
    public static final String Database_Name = "PaymentInfo.db";
    public static final String Table_Name = "payment";
    public static final String Col1 = "ID";
    public static final String Col2 = "CardNo";
    public static final String Col3 = "ExpirationDate";
    public static final String Col4 = "CVV";

    public DB(@Nullable Context context) {
        super(context, Database_Name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + Table_Name + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, CardNo TEXT , ExpirationDate TEXT , CVV TEXT)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS " + Table_Name);
        onCreate(db);
    }


    public boolean addInfo(String cardNo, String expireDate, String cvv) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Col2, cardNo);
        values.put(Col3, cvv);
        values.put(Col4, expireDate);
        long newRowId = db.insert(Table_Name, null, values);
        if (newRowId == -1) {
            return false;
        } else
            return true;
    }


    public Cursor readAllInfo() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor= db.rawQuery("SELECT * FROM " + Table_Name, null);
        return cursor;
    }


    public void deleteInfo(String cardNo){
        SQLiteDatabase db =getReadableDatabase();
        String selection = Col2 + "LIKE ? " ;
        String[] selectionArgs = {cardNo};
        db.delete(Table_Name, selection,selectionArgs);
    }


    public void updateInfo(String cardNo, String expiryDate , String cvv){
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(Col3, cvv);
        values.put(Col4, expiryDate);
        String selection = Col2 + "LIKE ? " ;
        String[] selectionArgs = {cardNo};
        int count = db.update(Table_Name, values,selection, selectionArgs);
    }


}
