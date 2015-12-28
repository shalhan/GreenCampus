package com.example.shalhan.greencampus;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shalhan on 08/12/15.
 */
public class GreenDataSource {
    Context mContext;
    GreenSQLiteHelper mGreenSQLiteHelper;

    public GreenDataSource(Context context){
        mContext = context;
        mGreenSQLiteHelper = new GreenSQLiteHelper(context);
        SQLiteDatabase database = mGreenSQLiteHelper.getReadableDatabase();
        database.close();
    }

    private SQLiteDatabase read(){
        return mGreenSQLiteHelper.getReadableDatabase();
    }

    private SQLiteDatabase open(){
        return mGreenSQLiteHelper.getWritableDatabase();
    }

    private void close(SQLiteDatabase database){
        database.close();
    }

    public void addUser(UserData userData){
        SQLiteDatabase database = open();
        database.beginTransaction();
        //implements details

        ContentValues userValues = new ContentValues();
        userValues.put(mGreenSQLiteHelper.COLLUMN_USERNAME, userData.getUsername());
        userValues.put(mGreenSQLiteHelper.COLLUMN_PASSWORD, userData.getPassword());
        userValues.put(mGreenSQLiteHelper.COLLUMN_NOREK, userData.getNoRek());
        userValues.put(mGreenSQLiteHelper.COLLUMN_EMAIL, userData.getEmail());
        database.insert(GreenSQLiteHelper.USER_TABLE, null, userValues);

        database.setTransactionSuccessful();
        database.endTransaction();
        close(database);

        Log.d("Database operation", "One row inserted");


    }

    public void addTapcash(TapcashData tapcash){
        SQLiteDatabase database = open();
        database.beginTransaction();
        //implements details

        ContentValues userValues = new ContentValues();
        userValues.put(mGreenSQLiteHelper.TAPCASH_ID, tapcash.getId());
        userValues.put(mGreenSQLiteHelper.COLLUMN_FNAME, tapcash.getFName());
        userValues.put(mGreenSQLiteHelper.COLLUMN_LNAME, tapcash.getLName());
        userValues.put(mGreenSQLiteHelper.FOREIGN_KEY_NOREK, tapcash.getUser_Id());
        long tapcashId = database.insert(GreenSQLiteHelper.TAPCASH_TABLE, null, userValues);

        database.setTransactionSuccessful();
        database.endTransaction();
        close(database);

        Log.d("Database operation", "One row inserted");

    }

    public void addTransaksi(TransaksiData data){
        SQLiteDatabase database = open();
        database.beginTransaction();

        ContentValues transaksiValues = new ContentValues();
        transaksiValues.put(mGreenSQLiteHelper.TRANSAKSI_ID, data.getId());
        transaksiValues.put(mGreenSQLiteHelper.COLLUMN_SALDOR, data.getSaldor());
        transaksiValues.put(mGreenSQLiteHelper.COLLUMN_SALDOT, data.getSaldot());
        transaksiValues.put(mGreenSQLiteHelper.COLLUMN_TRANSAKSI, data.getBiaya());
        transaksiValues.put(mGreenSQLiteHelper.COLLUMN_DATE, data.getDate());
        transaksiValues.put(mGreenSQLiteHelper.FOREIGN_KEY_TAPCASH,data.getTapcashId());
        database.insert(GreenSQLiteHelper.TRANSAKSI_TABLE, null, transaksiValues);

        database.setTransactionSuccessful();
        database.endTransaction();
        close(database);
    }

    public boolean isNoRek(String key){
        SQLiteDatabase database = read();

        String selectquery = "SELECT * FROM " + mGreenSQLiteHelper.TAPCASH_TABLE;
        Cursor cursor = database.rawQuery(selectquery, null);
        if(cursor.moveToFirst()){
            do{
                if(cursor.getString(3).equals(key)) return true;
            }while (cursor.moveToNext());
        }


        return false;
    }

    public Cursor getUserData() {
        SQLiteDatabase database = read();

        Cursor cursor = database.query(
                GreenSQLiteHelper.USER_TABLE,
                new String[]{
                        GreenSQLiteHelper.COLLUMN_NOREK,
                        GreenSQLiteHelper.COLLUMN_USERNAME,
                        GreenSQLiteHelper.COLLUMN_PASSWORD,
                        GreenSQLiteHelper.COLLUMN_EMAIL},
                null,
                null,
                null,
                null,
                null);

        return cursor;
    }

    public void addBus(BusData bus){
        SQLiteDatabase database = open();
        database.beginTransaction();

        ContentValues userValues = new ContentValues();
        userValues.put(mGreenSQLiteHelper.BUS_ID, bus.getKey_id());
        userValues.put(mGreenSQLiteHelper.COLLUMN_NOBUS, bus.getNobus());
        userValues.put(mGreenSQLiteHelper.COLLUMN_JADWAL, bus.getJadwal());
        database.insert(GreenSQLiteHelper.BUS_TABLE, null, userValues);

        database.setTransactionSuccessful();
        database.endTransaction();
        close(database);
    }

    public void addShelter(ShelterData shelter){
        SQLiteDatabase database = open();
        database.beginTransaction();

        ContentValues userValues = new ContentValues();
        userValues.put(mGreenSQLiteHelper.SHELTER_ID, shelter.getKey_shelter());
        userValues.put(mGreenSQLiteHelper.COLLUMN_NAMAS, shelter.getNamaShelter());
        userValues.put(mGreenSQLiteHelper.COLLUMN_KOORDINATSX, shelter.getKoordinatx());
        userValues.put(mGreenSQLiteHelper.COLLUMN_KOORDINATSY, shelter.getKoordinaty());
        database.insert(GreenSQLiteHelper.SHELTER_TABLE, null, userValues);

        database.setTransactionSuccessful();
        database.endTransaction();
        close(database);
    }

    public Cursor getBusRoute(){
        SQLiteDatabase database = read();


        String select = " select * from bus_route inner join shelter on bus_route.shelter_id = shelter.shelter_id";
//        String query = "SELECT " + mGreenSQLiteHelper.BUS_ID+", "  +
//                mGreenSQLiteHelper.BUS_ROUTE_TABLE+"."+mGreenSQLiteHelper.SHELTER_ID+", " +
//                mGreenSQLiteHelper.COLLUMN_NAMAS + " FROM " +
//                mGreenSQLiteHelper.SHELTER_TABLE+", " +
//                mGreenSQLiteHelper.BUS_ROUTE_TABLE + " WHERE " +
//                mGreenSQLiteHelper.BUS_ROUTE_TABLE+"."+mGreenSQLiteHelper.SHELTER_ID + " = " +
//                mGreenSQLiteHelper.SHELTER_TABLE+"."+mGreenSQLiteHelper.SHELTER_ID;
        Cursor cursor = database.rawQuery(select, null);

        return cursor;
    }

    public Cursor getAllUserData(){
        SQLiteDatabase database = read();

        String select = "select transaksi.key_id, username, fname, lname, norek, saldot, saldor, besar_transaksi, date, tapcash.key_id  " +
                "from user, tapcash, transaksi where norek = user_norek and tapcash.key_id = transaksi.tapcash_id";

        Cursor cursor = database.rawQuery(select, null);


        return cursor;
    }

    public Cursor getAllUserData(int id){
        SQLiteDatabase database = read();

        String select = "select transaksi.key_id, username, fname, lname, norek, saldot, saldor, besar_transaksi, date, tapcash.key_id, email  " +
                "from user, tapcash, transaksi where norek = user_norek and tapcash.key_id = transaksi.tapcash_id and tapcash.key_id = " + id;

        Cursor cursor = database.rawQuery(select, null);


        return cursor;
    }

    public int getKeyId(){

        SQLiteDatabase database = read();

        String select = "select user.username, tapcash.key_id from login, user, tapcash where login.username = user.username and norek = user_norek";
        Cursor cursor = database.rawQuery(select, null);

        cursor.moveToFirst();

        int id = cursor.getInt(1);


        return id;
    }

    public Cursor getBusSchedule(){
        SQLiteDatabase database = read();

        Cursor cursor = database.query(
                mGreenSQLiteHelper.BUS_TABLE,
                new String[]{
                        mGreenSQLiteHelper.BUS_ID,
                        mGreenSQLiteHelper.COLLUMN_NOBUS,
                        mGreenSQLiteHelper.COLLUMN_JADWAL,
                },
                null,
                null,
                null,
                null,
                null);

        return cursor;
    }


    public void addBusRoute(BusRouteData bus){
        SQLiteDatabase database = open();
        database.beginTransaction();

        ContentValues userValues = new ContentValues();
        userValues.put(mGreenSQLiteHelper.ID_BUS,bus.getIdBus() );
        userValues.put(mGreenSQLiteHelper.ID_SHELTER,bus.getIdShelter());
        database.insert(GreenSQLiteHelper.BUS_ROUTE_TABLE, null, userValues);


        database.setTransactionSuccessful();
        database.endTransaction();
        close(database);
    }

    public void clearBusRoute(){
        SQLiteDatabase database = open();
        database.beginTransaction();

        database.delete(mGreenSQLiteHelper.BUS_ROUTE_TABLE, null, null);

        database.setTransactionSuccessful();
        database.endTransaction();
        close(database);
    }

    public Cursor getShelter(){
        SQLiteDatabase database = read();

        Cursor cursor = database.query(
                mGreenSQLiteHelper.SHELTER_TABLE,
                new String[]{
                        mGreenSQLiteHelper.SHELTER_ID,
                        mGreenSQLiteHelper.COLLUMN_NAMAS,
                        mGreenSQLiteHelper.COLLUMN_KOORDINATSX,
                        mGreenSQLiteHelper.COLLUMN_KOORDINATSY,
                },
                null,
                null,
                null,
                null,
                null);


        return cursor;
    }

    public void addMap(MapData map){
        SQLiteDatabase database = open();
        database.beginTransaction();

        ContentValues userValues = new ContentValues();
        userValues.put(mGreenSQLiteHelper.MAP_ID, map.getMap_id());
        userValues.put(mGreenSQLiteHelper.COLLUMN_NAMAM, map.getNamaMap());
        userValues.put(mGreenSQLiteHelper.COLLUMN_KOORDINATMX, map.getKoordinatx());
        userValues.put(mGreenSQLiteHelper.COLLUMN_KOORDINATMY, map.getKoordinaty());
        database.insert(GreenSQLiteHelper.MAP_TABLE, null, userValues);

        database.setTransactionSuccessful();
        database.endTransaction();
        close(database);
    }

    public  Cursor getMap(){
        SQLiteDatabase database = read();

        Cursor cursor = database.query(
                mGreenSQLiteHelper.MAP_TABLE,
                new String[]{
                        mGreenSQLiteHelper.MAP_ID,
                        mGreenSQLiteHelper.COLLUMN_NAMAM,
                        mGreenSQLiteHelper.COLLUMN_KOORDINATMX,
                        mGreenSQLiteHelper.COLLUMN_KOORDINATMY,
                },
                null,
                null,
                null,
                null,
                null
        );


        return  cursor;
    }

    public void userLogin(UserLogin user){
        SQLiteDatabase database = read();
        database.beginTransaction();

        ContentValues userValues = new ContentValues();
        userValues.put(mGreenSQLiteHelper.COLLUMN_USERLOG, user.getUser());
        userValues.put(mGreenSQLiteHelper.COLLUMN_STATUSLOG, user.getStatus());
        userValues.put(mGreenSQLiteHelper.COLLUMN_PASSLOG, user.getPass());
        database.insert(GreenSQLiteHelper.LOGIN_TABLE, null, userValues);

        database.setTransactionSuccessful();
        database.endTransaction();
        close(database);
    }

    public Cursor getUserLogin(){
        SQLiteDatabase database = read();

        Cursor cursor = database.query(
                mGreenSQLiteHelper.LOGIN_TABLE,
                new String[]{
                        mGreenSQLiteHelper.COLLUMN_USERLOG,
                        mGreenSQLiteHelper.COLLUMN_STATUSLOG,
                        mGreenSQLiteHelper.COLLUMN_PASSLOG,
                },
                null,
                null,
                null,
                null,
                null);

        return cursor;
    }

    public boolean checkLogin(){
        SQLiteDatabase database = read();
        boolean stat;

        Cursor cursor = database.query(
                mGreenSQLiteHelper.LOGIN_TABLE,
                new String[]{
                        mGreenSQLiteHelper.COLLUMN_USERLOG,
                        mGreenSQLiteHelper.COLLUMN_STATUSLOG,
                },
                null,
                null,
                null,
                null,
                null
        );

        cursor.moveToFirst();
        if(cursor.getString(1).equals("0")) stat = false;
        else stat = true;
        close(database);

        return stat;
    }

    public void clearLogin(){
        SQLiteDatabase database = open();
        database.beginTransaction();

        database.delete(mGreenSQLiteHelper.LOGIN_TABLE, null, null);

        database.setTransactionSuccessful();
        database.endTransaction();
        close(database);
    }

    public void clearUser(){
        SQLiteDatabase database = open();
        database.beginTransaction();

        database.delete(mGreenSQLiteHelper.USER_TABLE, null, null);

        database.setTransactionSuccessful();
        database.endTransaction();
        close(database);
    }

}

