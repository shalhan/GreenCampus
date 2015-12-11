package com.example.shalhan.greencampus;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

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
}
