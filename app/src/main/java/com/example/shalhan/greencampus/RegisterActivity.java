package com.example.shalhan.greencampus;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by shalhan on 02/12/15.
 */
public class RegisterActivity extends AppCompatActivity {


    EditText username, password, email, cpassword, norek;
    String sUsername, sPassword, sEmail, sCPassword, sNorek;
    Button signup, cancel;
    GreenDataSource myDb;
    TapcashData tapcash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);

        username = (EditText) findViewById(R.id.etUsernamel);
        password = (EditText) findViewById(R.id.etPasswordl);
        email = (EditText) findViewById(R.id.etEmail);
        norek = (EditText) findViewById(R.id.etNoRek);
        cpassword = (EditText) findViewById(R.id.etCPassword);

        signup = (Button) findViewById(R.id.bLogin);
        cancel = (Button) findViewById(R.id.bCancel);

        myDb = new GreenDataSource(this);


        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setEditTextNull();
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setEditText();

                if (!(sUsername.isEmpty()) && !(sPassword.isEmpty()) && !(sEmail.isEmpty()) && !(sNorek.isEmpty()) && !(sCPassword.isEmpty())) {
                    if (isEmailValid(sEmail)) {
                        if (!(isUserTaken(sUsername))) {
                            if(!(isNorekTaken(sNorek))) {
                                if (sPassword.length() >= 5) {
                                    if (sPassword.equals(sCPassword)) {
                                        if (myDb.isNoRek(sNorek)) {
                                            UserData mUserData = new UserData(sUsername, sPassword, sNorek, sEmail);
                                            myDb.addUser(mUserData);
                                            Toast.makeText(getBaseContext(), "Registration Success", Toast.LENGTH_LONG).show();
                                            finish();
                                        } else {
                                            Toast.makeText(getBaseContext(), "Nomor rekening anda belum terdaftar", Toast.LENGTH_LONG).show();
                                            norek.setText("");
                                        }
                                    } else {
                                        Toast.makeText(getBaseContext(), "Your password are not matching", Toast.LENGTH_LONG).show();
                                        password.setText("");
                                        cpassword.setText("");
                                    }
                                } else {
                                    Toast.makeText(getBaseContext(), "Password anda kurang", Toast.LENGTH_LONG).show();
                                }
                            } else{
                                Toast.makeText(getBaseContext(), "Nomor Rekening Sudah di Gunakan", Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Toast.makeText(getBaseContext(), "Username anda sudah terpakai", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(getBaseContext(), "Email yang anda masukkan salah", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getBaseContext(), "Isi field yang masih kosong", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    public void setEditTextNull() {
        username.setText("");
        password.setText("");
        email.setText("");
        cpassword.setText("");
        norek.setText("");
    }

    public void setEditText() {
        sUsername = username.getText().toString();
        sPassword = password.getText().toString();
        sEmail = email.getText().toString();
        sCPassword = cpassword.getText().toString();
        sNorek = norek.getText().toString();
    }

    public static boolean isEmailValid(String email) {
        boolean isValid = false;

        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }

    public boolean isUserTaken(String usr){
        boolean isValid = false;

        Cursor cursor = myDb.getUserData();
        cursor.moveToFirst();
        do{
            if(usr.equals(cursor.getString(1))){
                isValid = true;
            }
        }while (cursor.moveToNext());

        return isValid;
    }

    public boolean isNorekTaken(String norek){
        boolean isValid = false;

        Cursor cursor = myDb.getUserData();
        cursor.moveToFirst();
        do{
            if(norek.equals(cursor.getString(0))){
                isValid = true;
            }
        }while (cursor.moveToNext());

        return isValid;
    }
}

