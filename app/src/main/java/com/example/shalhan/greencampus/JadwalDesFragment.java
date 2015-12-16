package com.example.shalhan.greencampus;


import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class JadwalDesFragment extends Fragment {

    Context context;
    View rootView;
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    TextView nobus;
    private String ID;
    GreenDataSource myDb;

    public JadwalDesFragment() {

    }

    public JadwalDesFragment(String id) {
        ID = id;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_jadwal_des, container, false);
        context = rootView.getContext();

        nobus = (TextView) rootView.findViewById(R.id.tvNoBus);
        nobus.setText(ID);

        expListView = (ExpandableListView) rootView.findViewById(R.id.lvExp);
        myDb = new GreenDataSource(getActivity());

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(getActivity(), listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();
        int idBus = Integer.parseInt(ID);

        // Adding child data
        listDataHeader.add("Bus Rute");
        listDataHeader.add("Bus Schedule");

        // Adding child data
        List<String> busrute = new ArrayList<String>();
            Cursor cursor1 = myDb.getBusRoute();

        if(cursor1.moveToFirst()) {
            do {
                if (idBus == cursor1.getInt(0)) {
                    busrute.add(cursor1.getString(3));
                }
            }
            while (cursor1.moveToNext());
        }

        List<String> busschedule = new ArrayList<String>();
            Cursor cursor = myDb.getBusSchedule();
            String jadwal = "";


            cursor.moveToFirst();

            while(cursor.getInt(0)!=idBus){
                cursor.moveToNext();
            }
            jadwal = cursor.getString(2);

            busschedule.add(jadwal);


        listDataChild.put(listDataHeader.get(0), busrute); // Header, Child data
        listDataChild.put(listDataHeader.get(1), busschedule);

    }

}
