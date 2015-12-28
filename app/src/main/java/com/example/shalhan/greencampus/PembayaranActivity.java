package com.example.shalhan.greencampus;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by shalhan on 27/12/15.
 */
public class PembayaranActivity extends AppCompatActivity {

    private TextView mId, mDate, mName, mBiaya, mNoRek, mEmail;
    private Button mBack;
    private GreenDataSource myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_bukti_pembayaran);

        mId = (TextView) findViewById(R.id.tvIdTransaksi);
        mDate = (TextView) findViewById(R.id.tvDateTransaksi);
        mName = (TextView) findViewById(R.id.tvNamaTrans);
        mBiaya = (TextView) findViewById(R.id.tvBesarTrans);
        mNoRek = (TextView) findViewById(R.id.tvNorekTrans);
        mEmail = (TextView) findViewById(R.id.tvEmailTrans);
        mBack = (Button) findViewById(R.id.bBack);

        myDb = new GreenDataSource(this);
        Cursor cursor = myDb.getAllUserData(myDb.getKeyId());
        cursor.moveToLast();
        boolean stat = false;

        mId.setText(" " + cursor.getInt(0));
        mDate.setText(" " + cursor.getString(8));
        mName.setText(": " + cursor.getString(2) + " " + cursor.getString(3));
        mBiaya.setText(": Rp. " + String.valueOf(cursor.getDouble(7)));
        mNoRek.setText(": " + cursor.getString(4));
        mEmail.setText(": " + cursor.getString(10));

        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });
    }
}
