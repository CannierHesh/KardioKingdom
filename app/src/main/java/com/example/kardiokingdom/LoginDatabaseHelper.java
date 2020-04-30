package com.example.kardiokingdom;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class LoginDatabaseHelper extends SQLiteOpenHelper {

    public static final String  DATABASE_NAME = "database.db";
    public static final String  TABLE_NAME = "user";
    public static final String  COL_1 = "username";
    public static final String  COL_2 = "email";
    public static final String  COL_3 = "password";


    public LoginDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null , 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE user (username TEXT PRIMARY KEY, email TEXT,password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public long addUser (String user,String email,String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",user);
        contentValues.put("email",email);
        contentValues.put("password",password);

        long res = db.insert("user",null,contentValues);
        db.close();
        return res;
    }

    public boolean checkUser(String username, String password){
        String[] columns = {COL_1};
        SQLiteDatabase db =getReadableDatabase();
        String selection = COL_1 + "=?" + " and " + COL_3 + "=?";
        String[] selectionArgs = { username, password};
        Cursor cursor = db.query(TABLE_NAME,columns,selection,selectionArgs,null,null,null);
        int count = cursor.getCount();
        cursor.close();
        db.close();

        if (count>0)
            return true;
        else
            return false;
    }

    public String getUsername() throws SQLException {
        String username = "";
        Cursor cursor = this.getReadableDatabase().query(TABLE_NAME, new String[] {COL_1},null,null,null,null,null);
        if (cursor.moveToFirst()){
            do{
                username = cursor.getString(1);

            }while (cursor.moveToNext());
        }
        cursor.close();
        return username;
    }


    public String getEmail(String username) throws SQLException {
        String email = "";
        Cursor cursor = this.getReadableDatabase().query(TABLE_NAME, new String[] {COL_2},COL_1 + " = " + username,null ,null,null,null,null);
        if (cursor.moveToFirst()){
            do{
                email = cursor.getString(1);

            }while (cursor.moveToNext());
        }
        cursor.close();
        return email;
    }

}
