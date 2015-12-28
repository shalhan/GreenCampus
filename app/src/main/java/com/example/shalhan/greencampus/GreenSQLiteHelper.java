package com.example.shalhan.greencampus;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by shalhan on 07/12/15.
 */
public class GreenSQLiteHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "greencampp.db";
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
                    + COLLUMN_USERNAME + " TEXT,"
                    + COLLUMN_PASSWORD + " TEXT,"
                    + COLLUMN_EMAIL + " TEXT)";

    //table tapcash
    public static final String TAPCASH_TABLE = "TAPCASH";
    public static final String TAPCASH_ID = "KEY_ID";
    public static final String COLLUMN_FNAME = "FNAME";
    public static final String COLLUMN_LNAME = "LNAME";
    public static final String FOREIGN_KEY_NOREK = "USER_NOREK";
    public static final String CREATE_TAPCASH =
            "CREATE TABLE " + TAPCASH_TABLE +"("
                    + TAPCASH_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COLLUMN_FNAME + " TEXT, " +
                    COLLUMN_LNAME + " TEXT, " +
                    FOREIGN_KEY_NOREK + " TEXT, " +
                    "FOREIGN KEY(" + FOREIGN_KEY_NOREK + ") REFERENCES USER(NOREK))";

    //table transaksi
    public static final String TRANSAKSI_TABLE = "TRANSAKSI";
    public static final String TRANSAKSI_ID = "KEY_ID";
    public static final String COLLUMN_SALDOT = "SALDOT";
    public static final String COLLUMN_SALDOR = "SALDOR";
    public static final String COLLUMN_TRANSAKSI = "BESAR_TRANSAKSI";
    public static final String COLLUMN_DATE = "DATE";
    public static final String FOREIGN_KEY_TAPCASH = "TAPCASH_ID";
    public static final String CREATE_TRANSAKSI =
            "CREATE TABLE " + TRANSAKSI_TABLE +"("
                    + TRANSAKSI_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLLUMN_SALDOT + " REAL, " +
                    COLLUMN_SALDOR + " REAL, " +
                    COLLUMN_TRANSAKSI + " REAL, " +
                    COLLUMN_DATE + " TEXT, " +
                    FOREIGN_KEY_TAPCASH + " INTEGER, " +
                    "FOREIGN KEY(" + FOREIGN_KEY_TAPCASH + ") REFERENCES TAPCASH(KEY_ID))";


    //table shelter
    public static final String SHELTER_TABLE = "SHELTER";
    public static final String SHELTER_ID = "SHELTER_ID";
    public static final String COLLUMN_NAMAS = "NAMA";
    public static final String COLLUMN_KOORDINATSX = "KOORDINATSX";
    public static final String COLLUMN_KOORDINATSY = "KOORDINATSY";
    public static final String CREATE_SHELTER =
            "CREATE TABLE " + SHELTER_TABLE + "("
                    + SHELTER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COLLUMN_NAMAS + " TEXT, " +
                    COLLUMN_KOORDINATSX + " REAL, " +
                    COLLUMN_KOORDINATSY + " REAL)";


    //table bus
    public static final String BUS_TABLE = "BUS";
    public static final String BUS_ID = "BUS_ID";
    public static final String COLLUMN_NOBUS = "NOBUS";
    public static final String COLLUMN_JADWAL = "JADWAL";
    public static final String CREATE_BUS =
            "CREATE TABLE " + BUS_TABLE + "("
                    + BUS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COLLUMN_NOBUS + " TEXT, " +
                    COLLUMN_JADWAL + " TEXT)";

    //table bus_route
    public static final String BUS_ROUTE_TABLE = "BUS_ROUTE";
    public static final String ID_BUS = "BUS_ID";
    public static final String ID_SHELTER = "SHELTER_ID";
    public static final String CREATE_BUS_ROUTE =
        "CREATE TABLE " + BUS_ROUTE_TABLE +  "("
                + ID_BUS + " INTEGER, "
                + ID_SHELTER + " INTEGER, "
                + "FOREIGN KEY(" + ID_BUS + ") REFERENCES BUS(BUS_ID), "
                + "FOREIGN KEY(" + ID_SHELTER + ") REFERENCES SHELTER(SHELTER_ID))";


    //table map
    public static final String MAP_TABLE = "MAP";
    public static final String MAP_ID = "MAP_ID";
    public static final String COLLUMN_NAMAM = "NAMA MAP";
    public static final String COLLUMN_KOORDINATMX = "KOORDINATMX";
    public static final String COLLUMN_KOORDINATMY = "KOORDINATMY";
    public static final String CREATE_MAP =
            "CREATE TABLE " + MAP_TABLE + "("
                    + MAP_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COLLUMN_NAMAM + " TEXT, " +
                    COLLUMN_KOORDINATMX + " REAL," +
                    COLLUMN_KOORDINATMY + " REAL)";

    //table login
    public static final String LOGIN_TABLE = "LOGIN";
    public static final String COLLUMN_USERLOG = "USERNAME";
    public static final String COLLUMN_STATUSLOG = "STATUS";
    public static final String COLLUMN_PASSLOG = "PASS";
    public static final String CREATE_LOGIN =
            "CREATE TABLE " + LOGIN_TABLE + "("
                    + COLLUMN_USERLOG + " TEXT, "
                    + COLLUMN_STATUSLOG + " TEXT, "
                    + COLLUMN_PASSLOG + " TEXT)";


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
        db.execSQL(CREATE_BUS_ROUTE);
        db.execSQL(CREATE_LOGIN);
        db.execSQL(CREATE_TRANSAKSI);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

