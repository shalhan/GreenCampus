package com.example.shalhan.greencampus;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        setUpMapIfNeeded();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    private void setUpMapIfNeeded() {
        if (mMap == null){
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
            if (mMap != null){
                setUpMap();
            }
        }

    }

    private void setUpMap() {
        mMap.addMarker(new MarkerOptions().position(new LatLng(0,0)).title("marker"));
        mMap.setMyLocationEnabled(true);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng ipb = new LatLng(-6.555944, 106.724045);
        mMap.moveCamera( CameraUpdateFactory.newLatLngZoom(ipb , 15.0f) );
        mMap.addMarker(new MarkerOptions().position(new LatLng(-6.561742, 106.727135)).title("Pintu Depan"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(-6.560314, 106.726406)).title("Rektorat"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(-6.560207, 106.725311)).title("Rektorat 2"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(-6.560356, 106.730096)).title("GWW"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(-6.559205, 106.73089)).title("FAPERTA"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(-6.557223, 106.731749)).title("FMIPA"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(-6.55588, 106.731534)).title("Asrama Putri"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(-6.555773, 106.729946)).title("Menwa"));
        mMap.addMarker(new MarkerOptions().position(new LatLng( -6.55686, 106.730032)).title("FAHUTAN"));
        mMap.addMarker(new MarkerOptions().position(new LatLng( -6.557926, 106.728981)).title("FATETA"));
        mMap.addMarker(new MarkerOptions().position(new LatLng( -6.558949, 106.727221)).title("FEM"));
        mMap.addMarker(new MarkerOptions().position(new LatLng( -6.559845, 106.728573)).title("FEMA"));
        mMap.addMarker(new MarkerOptions().position(new LatLng( -6.557009, 106.726513)).title("LSI"));
        mMap.addMarker(new MarkerOptions().position(new LatLng( -6.556455,  106.725526)).title("Al-Huriyah"));
        mMap.addMarker(new MarkerOptions().position(new LatLng( -6.556306, 106.724603)).title("Gor Lama"));
        mMap.addMarker(new MarkerOptions().position(new LatLng( -6.556775, 106.72353)).title("FPIK"));
        mMap.addMarker(new MarkerOptions().position(new LatLng( -6.556818, 106.722479)).title("FAPET"));
        mMap.addMarker(new MarkerOptions().position(new LatLng( -6.55637 , 106.720247)).title("FKH"));
        mMap.addMarker(new MarkerOptions().position(new LatLng( -6.557265 , 106.719067)).title("Lab FPIK"));
        mMap.addMarker(new MarkerOptions().position(new LatLng( -6.560186 , 106.724024)).title("Green TV"));
        mMap.addMarker(new MarkerOptions().position(new LatLng( -6.5533 , 106.727393)).title("Asrama Putra"));




    }
}
