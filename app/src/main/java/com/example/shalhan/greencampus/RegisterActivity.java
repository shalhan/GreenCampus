package com.example.shalhan.greencampus;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by shalhan on 02/12/15.
 */
public class RegisterActivity extends AppCompatActivity{


    EditText username, password, email, cpassword, norek;
    String sUsername, sPassword, sEmail, sCPassword, sNorek;
    Button signup, cancel;
    GreenDataSource myDb;
    TapcashData tapcash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);

        username = (EditText) findViewById(R.id.etUsername);
        password = (EditText) findViewById(R.id.etPassword);
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
                    if (sPassword.equals(sCPassword)) {
                        if (myDb.isNoRek(sNorek)) {
                            UserData mUserData = new UserData(sUsername, sPassword, sNorek, sEmail, 0);
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
                }else{
                    Toast.makeText(getBaseContext(), "Isi field yang masih kosong", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public void setEditTextNull(){
        username.setText("");
        password.setText("");
        email.setText("");
        cpassword.setText("");
        norek.setText("");
    }
    public void setEditText(){
        sUsername = username.getText().toString();
        sPassword = password.getText().toString();
        sEmail = email.getText().toString();
        sCPassword = cpassword.getText().toString();
        sNorek = norek.getText().toString();
    }

}
