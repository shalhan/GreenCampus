package com.example.shalhan.greencampus;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by shalhan on 02/12/15.
 */
public class LoginActivity extends AppCompatActivity{
    TextView tvRegister;
    EditText sUsername, sPassword;
    String username, password;
    Button sLogin;
    GreenDataSource myDb;
    SessionManagement session;
    UserLogin usr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login_activity);

        tvRegister = (TextView) findViewById(R.id.tvRegister);
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(myIntent);
            }
        });


        sUsername = (EditText) findViewById(R.id.etUsernamel);
        sPassword = (EditText) findViewById(R.id.etPasswordl);

        sLogin = (Button) findViewById(R.id.bLogin);
        myDb = new GreenDataSource(this);
        session = new SessionManagement(this);

        sLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = sUsername.getText().toString();
                password = sPassword.getText().toString();

                Cursor cursor = myDb.getUserData();
                cursor.moveToFirst();
                boolean status = false;
                do{
                    if(!(username.isEmpty()) && !(password.isEmpty())){
                      if(username.equals(cursor.getString(1)) && password.equals(cursor.getString(2))){
                          status = true;
                          myDb.clearLogin();
                          usr = new UserLogin(cursor.getString(1), "1", cursor.getString(2));
                          myDb.userLogin(usr);
                      }
                   }else{
                        Toast.makeText(getBaseContext(), "Masih ada field yang kosong", Toast.LENGTH_LONG).show();
                    }
                } while(cursor.moveToNext());

                if(status){
                    Toast.makeText(getBaseContext(), "Welcome", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(LoginActivity.this, GreenCampusActivity.class));

                }else{
                    Toast.makeText(getBaseContext(), "Username or id are wrong", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

}
