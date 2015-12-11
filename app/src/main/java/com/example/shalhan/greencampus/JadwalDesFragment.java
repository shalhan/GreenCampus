package com.example.shalhan.greencampus;


import android.content.Context;
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

    public JadwalDesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_jadwal_des, container, false);
        context = rootView.getContext();



        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        expListView = (ExpandableListView) rootView.findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(getActivity(), listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);
    }

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Bus Rute");
        listDataHeader.add("Bus Schedule");

        // Adding child data
        List<String> busrute = new ArrayList<String>();
        busrute.add("The Shawshank Redemption");
        busrute.add("The Godfather");

        List<String> busschedule = new ArrayList<String>();
        busschedule.add("The Conjuring");
        busschedule.add("Despicable Me 2");


        listDataChild.put(listDataHeader.get(0), busrute); // Header, Child data
        listDataChild.put(listDataHeader.get(1), busschedule);

    }

}
