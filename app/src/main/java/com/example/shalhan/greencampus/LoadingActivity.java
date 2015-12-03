package com.example.shalhan.greencampus;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by shalhan on 02/12/15.
 */
public class LoadingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_activity);

        Thread myThread = new Thread(){
            public void run() {
                try{
                    sleep(2000);
                    Intent myIntent = new Intent(LoadingActivity.this, GreenCampusActivity.class);
                    startActivity(myIntent);
                    finish();
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        myThread.run();
    }

}
