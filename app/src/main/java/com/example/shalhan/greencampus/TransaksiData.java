package com.example.shalhan.greencampus;

/**
 * Created by shalhan on 26/12/15.
 */
public class TransaksiData {
    private int mId;
    private double mSaldot;
    private double mSaldor;
    private String mDate;
    private double mBiaya;
    private int mTapcashId;

    public TransaksiData(){

    }

    public TransaksiData(double saldor, double saldot, String date, double biaya, int tapcashid){
        setSaldor(saldor);
        setSaldot(saldot);
        setDate(date);
        setBiaya(biaya);
        setTapcashId(tapcashid);
    }

    public TransaksiData(int id, double saldor, double saldot, String date, double biaya, int tapcashid){
        setId(id);
        setSaldor(saldor);
        setSaldot(saldot);
        setDate(date);
        setBiaya(biaya);
        setTapcashId(tapcashid);
    }

    public void setId(int id){
        mId = id;
    }
    public int getId(){
        return mId;
    }

    public double getSaldot() {
        return mSaldot;
    }
    public void setSaldot(double mSaldot) {
        this.mSaldot = mSaldot;
    }

    public double getSaldor() {
        return mSaldor;
    }
    public void setSaldor(double mSaldor) {
        this.mSaldor = mSaldor;
    }

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

    public int getTapcashId(){
        return mTapcashId;
    }
    public void setTapcashId(int id){
        mTapcashId = id;
    }
}
