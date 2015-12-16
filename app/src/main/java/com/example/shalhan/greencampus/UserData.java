package com.example.shalhan.greencampus;

import java.util.ArrayList;

/**
 * Created by shalhan on 11/12/15.
 */
public class UserData {
    private String mUsername;
    private String mPassword;
    private String mNoRek;
    private String mEmail;
    private int statusL;

    public UserData(){

    }

    public UserData(String username, String pass, String norek, String email, int id){
        mUsername = username;
        mPassword = pass;
        mNoRek = norek;
        mEmail = email;
        statusL = id;
    }

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String mUsername) {
        this.mUsername = mUsername;
    }


    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String mPassword) {
        this.mPassword = mPassword;
    }

    public String getNoRek() {
        return mNoRek;
    }

    public void setNoRek(String mNoRek) {
        this.mNoRek = mNoRek;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public void setStatus(int id){
        statusL = id;
    }

    public int getStatus(){
        return statusL;
    }


}
