package com.example.shalhan.greencampus;

/**
 * Created by shalhan on 28/12/15.
 */
public class ListPembayaran {
    private int mId;
    private String mDate;
    private double mBiaya;

    public ListPembayaran(){

    }

    public ListPembayaran(int id, String date, double biaya){
        mId = id;
        mDate = date;
        mBiaya = biaya;
    }

    public int getId() {return mId;}
    public void setId(int mId) {this.mId = mId;}

    public String getDate() {
        return mDate;
    }
    public void setDate(String mDate) {
        this.mDate = mDate;
    }

    public double getBiaya() {
        return mBiaya;
    }
    public void setBiaya(double mBiaya) {
        this.mBiaya = mBiaya;
    }
}
