package com.example.shalhan.greencampus;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by shalhan on 07/12/15.
 */
public class GreenSQLiteHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "greencp.db";
    private static final int DB_VERSION = 1;

    //table USER
    public static final String USER_TABLE = "USER";
    public static final String COLLUMN_USERNAME = "USERNAME";
    public static final String COLLUMN_PASSWORD = "PASWORD";
    public static final String COLLUMN_NOREK=  "NOREK";
    public static final String COLLUMN_EMAIL = "EMAIL";
    public static final String CREATE_USER =
            "CREATE TABLE " + USER_TABLE + "("
                    + COLLUMN_NOREK + " TEXT PRIMARY KEY,"
                    +COLLUMN_USERNAME + " TEXT,"
                    + COLLUMN_PASSWORD + " TEXT,"
                    + COLLUMN_EMAIL + " TEXT)";

    //table tapcash
    public static final String TAPCASH_TABLE = "TAPCASH";
    public static final String COLLUMN_FNAME = "FNAME";
    public static final String COLLUMN_LNAME = "LNAME";
    public static final String COLLUMN_SALDOT = "SALDOT";
    public static final String COLLUMN_SALDOR = "SALDOR";
    public static final String FOREIGN_KEY_NOREK = "USER_NOREK";
    public static final String CREATE_TAPCASH =
            "CREATE TABLE " + TAPCASH_TABLE +"("
                    + BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COLLUMN_SALDOT + " TEXT, " +
                    COLLUMN_SALDOR + " TEXT, " +
                    COLLUMN_FNAME + " TEXT, " +
                    COLLUMN_LNAME + " TEXT, " +
                    FOREIGN_KEY_NOREK + " TEXT, " +
                    "FOREIGN KEY(" + FOREIGN_KEY_NOREK + ") REFERENCES USER(NOREK))";


    //table bus
    public static final String BUS_TABLE = "BUS";
    public static final String COLLUMN_NOBUS = "NOBUS";
    public static final String COLLUMN_JADWAL = "JADWAL";
    public static final String FOREIGN_KEY_SHELTER ="SHELTER_ID";
    public static final String CREATE_BUS =
            "CREATE TABLE " + BUS_TABLE + "("
                    + BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COLLUMN_NOBUS + " TEXT, " +
                    COLLUMN_JADWAL + " TEXT, " +
                    FOREIGN_KEY_SHELTER + " INTEGER, " +
                    "FOREIGN KEY(" + FOREIGN_KEY_SHELTER + ") REFERENCES SHELTER(_ID))";

    //table shelter
    public static final String SHELTER_TABLE = "SHELTER";
    public static final String COLLUMN_NAMAS = "NAMA";
    public static final String COLLUMN_KOORDINATS = "KOORDINAT";
    public static final String CREATE_SHELTER =
            "CREATE TABLE " + SHELTER_TABLE + "("
                    + BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COLLUMN_NAMAS + " TEXT, " +
                    COLLUMN_KOORDINATS + " TEXT) ";

    //table map
    public static final String MAP_TABLE = "MAP";
    public static final String COLLUMN_NAMAM = "NAMA MAP";
    public static final String COLLUMN_KOORDINATM = "KOORDINAT";
    public static final String CREATE_MAP =
            "CREATE TABLE " + MAP_TABLE + "("
                    + BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COLLUMN_NAMAM + " TEXT, " +
                    COLLUMN_KOORDINATM + " TEXT) ";


    public GreenSQLiteHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER);
       db.execSQL(CREATE_TAPCASH);
        db.execSQL(CREATE_SHELTER);
        db.execSQL(CREATE_BUS);
        db.execSQL(CREATE_MAP);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

