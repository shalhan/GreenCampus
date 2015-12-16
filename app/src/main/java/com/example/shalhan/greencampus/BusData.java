package com.example.shalhan.greencampus;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by shalhan on 11/12/15.
 */
public class BusData implements Serializable {
    private int key_id;
    private int nobus;
    private String jadwal;

    public BusData(){

    }

    public BusData(int id, int nobus, String jadwal){
        this.key_id = id;
        this.nobus = nobus;
        this.jadwal = jadwal;
    }

    public int getKey_id() {
        return key_id;
    }

    public void setKey_id(int key_id) {
        this.key_id = key_id;
    }

    public int getNobus() {
        return nobus;
    }

    public void setNobus(int nobus) {
        this.nobus = nobus;
    }


    public String getJadwal() {
        return jadwal;
    }

    public void setJadwal(String jadwal) {
        this.jadwal = jadwal;
    }


}
