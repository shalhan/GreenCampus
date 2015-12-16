package com.example.shalhan.greencampus;

/**
 * Created by shalhan on 14/12/15.
 */
public class BusRouteData {
    private int idBus;
    private int idShelter;

    public BusRouteData(){

    }

    public BusRouteData(int idB, int idS){
        idBus = idB;
        idShelter = idS;
    }

    public int getIdBus() {
        return idBus;
    }

    public void setIdBus(int idBus) {
        this.idBus = idBus;
    }

    public int getIdShelter() {
        return idShelter;
    }

    public void setIdShelter(int idShelter) {
        this.idShelter = idShelter;
    }
}
