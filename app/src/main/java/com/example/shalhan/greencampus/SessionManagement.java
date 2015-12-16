package com.example.shalhan.greencampus;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

/**
 * Created by shalhan on 15/12/15.
 */
public class SessionManagement {

    Context mContext;

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "LOGIN_SESSION";
    private static final String USERNAME = "USENAME";
    private static  final String PASSWORD = "PASS";
    private static final String LOGIN_STAT= "LOGIN_STAT";

    public SessionManagement(Context context){
        mContext = context;
        pref = mContext.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void createLoginSession(String name, String password){
        editor.putBoolean(LOGIN_STAT, true);
        editor.putString(USERNAME, name);
        editor.putString(PASSWORD, password);


        editor.commit();
    }

    /**
     * clear session
     */
    public void logoutUser(){
        editor.clear();
        editor.commit();
        editor.putBoolean(LOGIN_STAT, false);


    }

    public boolean isLoggedIn(){
        return pref.getBoolean(LOGIN_STAT, true);
    }


}
