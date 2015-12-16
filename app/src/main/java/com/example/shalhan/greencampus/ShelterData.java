package com.example.shalhan.greencampus;

/**
 * Created by shalhan on 13/12/15.
 */
public class ShelterData {
    private int key_shelter;
    private String namaShelter;
    private double koordinatx;
    private double Koordinaty;

    public ShelterData(){

    }

    public ShelterData(int id, String nama, double x, double y){
        setKey_shelter(id);
        setNamaShelter(nama);
        setKoordinatx(x);
        setKoordinaty(y);
    }

    public int getKey_shelter() {
        return key_shelter;
    }

    public void setKey_shelter(int key_shelter) {
        this.key_shelter = key_shelter;
    }

    public String getNamaShelter() {
        return namaShelter;
    }

    public void setNamaShelter(String namaShelter) {
        this.namaShelter = namaShelter;
    }

    public double getKoordinatx() {
        return koordinatx;
    }

    public void setKoordinatx(double koordinatx) {
        this.koordinatx = koordinatx;
    }

    public double getKoordinaty() {
        return Koordinaty;
    }

    public void setKoordinaty(double getKoordinaty) {
        this.Koordinaty = getKoordinaty;
    }
}
