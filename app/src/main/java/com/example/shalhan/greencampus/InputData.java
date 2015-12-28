package com.example.shalhan.greencampus;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by shalhan on 14/12/15.
 */
public class InputData{

    GreenDataSource myDb;
    TapcashData tapcash;
    ShelterData shel;
    BusRouteData bus;
    BusData busD;
    MapData mapD;
    UserLogin usr;
    Context mContext;
    TransaksiData data;

    public InputData(Context context){
        mContext = context;
        myDb = new GreenDataSource(mContext);
        getData();
    }

    public void getData(){
        tapcash = new TapcashData(1, "Shalhan", "Radifan","12345678");
        myDb.addTapcash(tapcash);
        tapcash = new TapcashData(2, "Dipa", "Mustaqim","12344478");
        myDb.addTapcash(tapcash);
        tapcash = new TapcashData(3, "Dikna", "Romtikayadi", "12224478");
        myDb.addTapcash(tapcash);

        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = df.format(c.getTime());
// Now formattedDate have current date/time

        data = new TransaksiData(1,1500000, 25000, formattedDate, 0, 1);
        myDb.addTransaksi(data);
        data = new TransaksiData(2,1250000, 15000, formattedDate, 0, 2);
        myDb.addTransaksi(data);
        data = new TransaksiData(3,900000, 10000, formattedDate, 0, 3);
        myDb.addTransaksi(data);


        shel = new ShelterData(1, "Pintu Depan", -6.561742, 106.727135);
        myDb.addShelter(shel);
        shel = new ShelterData(2, "Rektorat", -6.560314, 106.726406);
        myDb.addShelter(shel);
        shel = new ShelterData(3, "Rektorat 2", -6.560207, 106.725311);
        myDb.addShelter(shel);
        shel = new ShelterData(4, "GWW", -6.560356, 106.730096);
        myDb.addShelter(shel);
        shel = new ShelterData(5, "FAPERTA", -6.559205, 106.73089);
        myDb.addShelter(shel);
        shel = new ShelterData(6, "FMIPA", -6.557223, 106.731749);
        myDb.addShelter(shel);
        shel = new ShelterData(7, "Asrama Putri", -6.55588, 106.731534);
        myDb.addShelter(shel);
        shel = new ShelterData(8, "Menwa", -6.555773, 106.729946);
        myDb.addShelter(shel);
        shel = new ShelterData(9, "FAHUTAN", -6.55686, 106.730032);
        myDb.addShelter(shel);
        shel = new ShelterData(10, "FATETA", -6.557926, 106.728981);
        myDb.addShelter(shel);
        shel = new ShelterData(11, "FEM", -6.558949, 106.727221);
        myDb.addShelter(shel);
        shel = new ShelterData(12, "FEMA", -6.559845, 106.728573);
        myDb.addShelter(shel);
        shel = new ShelterData(13, "LSI", -6.557009, 106.726513);
        myDb.addShelter(shel);
        shel = new ShelterData(14, "Al-Huriyah", -6.556455, 106.725526);
        myDb.addShelter(shel);
        shel = new ShelterData(15, "Gor Lama", -6.556306, 106.724603);
        myDb.addShelter(shel);
        shel = new ShelterData(16, "FPIK", -6.556775, 106.72353);
        myDb.addShelter(shel);
        shel = new ShelterData(17, "FAPET", -6.556818, 106.722479);
        myDb.addShelter(shel);
        shel = new ShelterData(18, "FKH", -6.55637, 106.720247);
        myDb.addShelter(shel);
        shel = new ShelterData(19, "Lab FPIK", -6.557265, 106.719067);
        myDb.addShelter(shel);
        shel = new ShelterData(20, "Green TV", -6.560186, 106.724024);
        myDb.addShelter(shel);
        shel = new ShelterData(21, "Asrama Putra", -6.5533, 106.727393);
        myDb.addShelter(shel);

        bus = new BusRouteData(1,4);
        myDb.addBusRoute(bus);
        bus = new BusRouteData(1,5);
        myDb.addBusRoute(bus);
        bus = new BusRouteData(1,6);
        myDb.addBusRoute(bus);
        bus = new BusRouteData(1,7);
        myDb.addBusRoute(bus);
        bus = new BusRouteData(1,8);
        myDb.addBusRoute(bus);
        bus = new BusRouteData(1,9);
        myDb.addBusRoute(bus);
        bus = new BusRouteData(1,10);
        myDb.addBusRoute(bus);
        bus = new BusRouteData(1,11);
        myDb.addBusRoute(bus);
        bus = new BusRouteData(1,12);
        myDb.addBusRoute(bus);
        bus = new BusRouteData(2,9);
        myDb.addBusRoute(bus);
        bus = new BusRouteData(2,10);
        myDb.addBusRoute(bus);
        bus = new BusRouteData(2,8);
        myDb.addBusRoute(bus);
        bus = new BusRouteData(2,13);
        myDb.addBusRoute(bus);
        bus = new BusRouteData(2,14);
        myDb.addBusRoute(bus);
        bus = new BusRouteData(2,15);
        myDb.addBusRoute(bus);
        bus = new BusRouteData(2,16);
        myDb.addBusRoute(bus);
        bus = new BusRouteData(2,17);
        myDb.addBusRoute(bus);

        bus = new BusRouteData(3,4);
        myDb.addBusRoute(bus);
        bus = new BusRouteData(3,12);
        myDb.addBusRoute(bus);
        bus = new BusRouteData(3,11);
        myDb.addBusRoute(bus);
        bus = new BusRouteData(3,13);
        myDb.addBusRoute(bus);
        bus = new BusRouteData(3,14);
        myDb.addBusRoute(bus);
        bus = new BusRouteData(3,15);
        myDb.addBusRoute(bus);
        bus = new BusRouteData(3,16);
        myDb.addBusRoute(bus);
        bus = new BusRouteData(3,17);
        myDb.addBusRoute(bus);
        bus = new BusRouteData(4,4);
        myDb.addBusRoute(bus);
        bus = new BusRouteData(4,1);
        myDb.addBusRoute(bus);
        bus = new BusRouteData(4,2);
        myDb.addBusRoute(bus);
        bus = new BusRouteData(4,3);
        myDb.addBusRoute(bus);
        bus = new BusRouteData(4,20);
        myDb.addBusRoute(bus);
        bus = new BusRouteData(4,19);
        myDb.addBusRoute(bus);
        bus = new BusRouteData(5,21);
        myDb.addBusRoute(bus);
        bus = new BusRouteData(5,8);
        myDb.addBusRoute(bus);

        busD = new BusData(1,1,"07.00 - 22.00");
        myDb.addBus(busD);
        busD = new BusData(2,2,"08.00 - 20.00");
        myDb.addBus(busD);
        busD = new BusData(3,3,"07.00 - 19.00");
        myDb.addBus(busD);
        busD = new BusData(4,4,"07.00 - 19.00");
        myDb.addBus(busD);
        busD = new BusData(5,5,"08.00 - 20.00");
        myDb.addBus(busD);
        busD = new BusData(6,6,"07.00 - 22.00");
        myDb.addBus(busD);

        mapD = new MapData(1, "FMIPA" , -6.55767 , 106.730686);
        myDb.addMap(mapD);
        mapD = new MapData(2, "FATETA" , -6.558438, 106.728616);
        myDb.addMap(mapD);
        mapD = new MapData(3, "FAPERTA" , -6.558683, 106.730365);
        myDb.addMap(mapD);
        mapD = new MapData(4, "FEMA" , -6.55912, 106.729206);
        myDb.addMap(mapD);
        mapD = new MapData(5, "FEM" , -6.558598 , 106.727854);
        myDb.addMap(mapD);
        mapD = new MapData(6, "FAPET" , -6.557532 , 106.72205);
        myDb.addMap(mapD);
        mapD = new MapData(7, "FPIK" , -6.557638 , 106.723455);
        myDb.addMap(mapD);
        mapD = new MapData(8, "FKH" , -6.556583  , 106.720086);
        myDb.addMap(mapD);
        mapD = new MapData(9, "Al-Huriyah" , -6.555805 , 106.725451);
        myDb.addMap(mapD);
        mapD = new MapData(10, "GWW" , -6.560356  , 106.730783);
        myDb.addMap(mapD);
        mapD = new MapData(11, "Rektorat" , -6.559973   , 106.725461);
        myDb.addMap(mapD);

        usr = new UserLogin("", "0","");
        myDb.userLogin(usr);
    }
}
