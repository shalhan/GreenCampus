package com.example.shalhan.greencampus;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by shalhan on 13/12/15.
 */
public class MapData implements Serializable {
    private int map_id;
    private String namaMap;
    private double koordinatx;
    private double koordinaty;

    public  MapData(){

    }

    public MapData(int id, String nama, double x, double y){
        setMap_id(id);
        setKoordinatx(x);
        setKoordinaty(y);
        setNamaMap(nama);
    }

    public int getMap_id() {
        return map_id;
    }
    public void setMap_id(int map_id) {
        this.map_id = map_id;
    }

    public String getNamaMap() {
        return namaMap;
    }
    public void setNamaMap(String namaMap) {
        this.namaMap = namaMap;
    }

    public double getKoordinatx() {
        return koordinatx;
    }
    public void setKoordinatx(double koordinatx) {
        this.koordinatx = koordinatx;
    }

    public double getKoordinaty() {
        return koordinaty;
    }
    public void setKoordinaty(double koordinaty) {
        this.koordinaty = koordinaty;
    }
}
