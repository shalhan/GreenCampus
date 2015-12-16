package com.example.shalhan.greencampus;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


public class GreenCampusActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    NavigationView nav_view;
    GreenDataSource myDb;
    SessionManagement session;
    UserLogin usr;
//    TapcashData tapcash;
//    BusRouteData bus;
//    ShelterData shel;
//    BusData busD;
//    MapData mapD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_green_campus);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        fragmentManager = getSupportFragmentManager();
        nav_view = (NavigationView) findViewById(R.id.nav_view);

        session = new SessionManagement(this);

        itemSelect(R.id.nav_jadwal);

        myDb = new GreenDataSource(this);
        usr = new UserLogin("username", "0");
        myDb.userLogin(usr);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.green_campus, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        itemSelect(id);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void itemSelect(int id) {
        if (id == R.id.nav_login) {
            if(!(myDb.checkLogin())) {
                Intent myIntent = new Intent(GreenCampusActivity.this, LoginActivity.class);
                startActivity(myIntent);
            }else{
                TapcashFragment tapcashFragment = new TapcashFragment();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder, tapcashFragment);
//                fragmentTransaction.addToBackStack();
                fragmentTransaction.commit();
                getSupportActionBar().setTitle("Tapcash");
            }
        } else if (id == R.id.nav_jadwal) {
            JadwalFragment jadwalFragment = new JadwalFragment();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragmentholder, jadwalFragment);
//            fragmentTransaction.addToBackStack();
            fragmentTransaction.commit();
            getSupportActionBar().setTitle("Jadwal Bus");

        } else if (id == R.id.nav_map) {
            Intent myIntent = new Intent(GreenCampusActivity.this, MapActivity.class);
            startActivity(myIntent);
//            MapFragment mapFragment = new MapFragment();
//            fragmentTransaction = fragmentManager.beginTransaction();
//            fragmentTransaction.replace(R.id.fragmentholder, mapFragment);
//            fragmentTransaction.commit();
        }
        nav_view.setCheckedItem(id);
    }

    public void setTitle(String title){
        getSupportActionBar().setTitle(title);
    }

    public void bus1(View v){
        JadwalDesFragment jadwalDesFragment = new JadwalDesFragment("1");
        FragmentTransaction fragmentTransaction =  fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.group, jadwalDesFragment, "bus1");
        fragmentTransaction.commit();
    }
    public void bus2(View v){
        JadwalDesFragment jadwalDesFragment = new JadwalDesFragment("2");
        FragmentTransaction fragmentTransaction =  fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.group, jadwalDesFragment, "bus2");
        fragmentTransaction.commit();
    }
    public void bus3(View v){
        JadwalDesFragment jadwalDesFragment = new JadwalDesFragment("3");
        FragmentTransaction fragmentTransaction =  fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.group, jadwalDesFragment, "bus3");
        fragmentTransaction.commit();
    }
    public void bus4(View v){
        JadwalDesFragment jadwalDesFragment = new JadwalDesFragment("4");
        FragmentTransaction fragmentTransaction =  fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.group, jadwalDesFragment, "bus4");
        fragmentTransaction.commit();
    }
    public void bus5(View v){
        JadwalDesFragment jadwalDesFragment = new JadwalDesFragment("5");
        FragmentTransaction fragmentTransaction =  fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.group, jadwalDesFragment, "bus5");
        fragmentTransaction.commit();
    }
    public void bus6(View v){
        JadwalDesFragment jadwalDesFragment = new JadwalDesFragment("6");
        FragmentTransaction fragmentTransaction =  fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.group, jadwalDesFragment, "bus6");
        fragmentTransaction.commit();
    }


}
