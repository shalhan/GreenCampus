package com.example.shalhan.greencampus;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by shalhan on 11/12/15.
 */
public class TapcashData implements Serializable {

    private int mId;
    private String mFName;
    private String mLName;
    private String mUser_Id="";

    public TapcashData(){

    }

    public TapcashData(int id, String fname, String lname, String norek){
        setId(id);
        setUser_Id(norek);
        setFName(fname);
        setLName(lname);
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

    public String getUser_Id() {
        return mUser_Id;
    }
    public void setUser_Id(String mUser_Id) {
        this.mUser_Id = mUser_Id;
    }

}
