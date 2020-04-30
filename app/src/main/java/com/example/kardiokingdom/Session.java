package com.example.kardiokingdom;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Session {
    private SharedPreferences prefs;

    public Session(Context cntx){
        prefs = PreferenceManager.getDefaultSharedPreferences(cntx);
    }

    public void setusername(String username){
        prefs.edit().putString("username",username).apply();
    }

    public String getusername(){
        String username = prefs.getString("username","");
        return username;
    }
}
