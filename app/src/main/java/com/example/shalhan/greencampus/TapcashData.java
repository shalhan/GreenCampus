package com.example.shalhan.greencampus;

import java.io.Serializable;

/**
 * Created by shalhan on 11/12/15.
 */
public class TapcashData implements Serializable {

    private int mId;
    private String mFName;
    private String mLName;
    private double mSaldoT;
    private double mSaldoR;
    private String mUser_Id="";

    public TapcashData(){

    }

    public TapcashData(int id, String fname, String lname, double saldot, double saldoR, String norek){
        setId(id);
        setUser_Id(norek);
        setFName(fname);
        setLName(lname);
        setSaldoR(saldoR);
        setSaldoT(saldot);
    }

    public void setId(int id){mId = id;}

    public int getId(){return mId;}

    public String getFName() {
        return mFName;
    }

    public void setFName(String mFName) {
        this.mFName = mFName;
    }

    public String getLName() {
        return mLName;
    }

    public void setLName(String mLName) {
        this.mLName = mLName;
    }

    public double getSaldoT() {
        return mSaldoT;
    }

    public void setSaldoT(double mSaldoT) {
        this.mSaldoT = mSaldoT;
    }

    public double getSaldoR() {
        return mSaldoR;
    }

    public void setSaldoR(double mSaldoR) {
        this.mSaldoR = mSaldoR;
    }

    public String getUser_Id() {
        return mUser_Id;
    }

    public void setUser_Id(String mUser_Id) {
        this.mUser_Id = mUser_Id;
    }
}
