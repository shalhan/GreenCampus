package com.example.shalhan.greencampus;


import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TapcashFragment extends Fragment implements AdapterView.OnItemSelectedListener{

    Context context;
    View rootView, layout, layout2;
    TextView sName, sNoRek, sSaldoT, sSaldoR;
    Double saldot, saldor;
    Button bIsiUlang;
    FragmentManager fragmentManager;
    GreenDataSource myDb;
    GreenAdapter adapter2;
    int sett=0;

    public TapcashFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_tapcash, container, false);
        context = rootView.getContext();

        final ViewGroup viewGroup = (ViewGroup) rootView.findViewById(R.id.viewgroup);

        fragmentManager = getActivity().getSupportFragmentManager();
        myDb = new GreenDataSource(getActivity());

        sName = (TextView) rootView.findViewById(R.id.tvName);
        sNoRek = (TextView) rootView.findViewById(R.id.tvNoRek);
        sSaldoR = (TextView) rootView.findViewById(R.id.tvSaldoR);
        sSaldoT = (TextView) rootView.findViewById(R.id.tvSaldoT);

        ArrayList<ListPembayaran> data = new ArrayList<ListPembayaran>();

        Cursor cursor2 = myDb.getAllUserData(myDb.getKeyId());
        cursor2.moveToFirst();
        do{
            data.add(new ListPembayaran(cursor2.getInt(0), cursor2.getString(8), cursor2.getDouble(7)));
        }while(cursor2.moveToNext());


        adapter2 = new GreenAdapter(getActivity(), R.layout.transaksi_listview, data);
        ListView list = (ListView) rootView.findViewById(R.id.transaksi);
        list.setAdapter(adapter2);
        /*
        List<ListPembayaran> list = new ArrayList<ListPembayaran>();
        list.add(new ListPembayaran(1,"16-Des-2015", 50000));
        GreenAdapter adapter = new GreenAdapter(getActivity(),list);
        ListView lv = (ListView) rootView.findViewById(R.id.transaksi);
        lv.setAdapter(adapter);
        */

        Cursor cursor = myDb.getAllUserData();
        Cursor cursorLogin = myDb.getUserLogin();
        cursor.moveToFirst();
        cursorLogin.moveToFirst();
        do{
            if(cursorLogin.getString(0).equals(cursor.getString(1))){
                saldot = cursor.getDouble(6);
                saldor = cursor.getDouble(5);

                sName.setText(": " + cursor.getString(2) + " " + cursor.getString(3));
                sNoRek.setText(": " + cursor.getString(4));
                sSaldoT.setText(": Rp. " + String.valueOf(saldot));
                sSaldoR.setText(": Rp. " + String.valueOf(saldor));
            }
        }while(cursor.moveToNext());

        bIsiUlang = (Button) rootView.findViewById(R.id.bBigger);

        bIsiUlang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* TapcashDesFragment tapcashDesFragment = new TapcashDesFragment();
                FragmentTransaction fragmentTransaction =  fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.isitapcash, tapcashDesFragment, "Tapcash");
                fragmentTransaction.commit();*/
                layout = rootView.findViewById(R.id.tapcashLayout);
                layout2 = rootView.findViewById(R.id.isitapcash);

                TransitionManager.beginDelayedTransition(viewGroup);

                if (sett == 0) {
                    ViewGroup.LayoutParams sizeRules = layout.getLayoutParams();
                    sizeRules.height = 650;
                    layout.setLayoutParams(sizeRules);
                    ViewGroup.LayoutParams sizeRules2 = layout2.getLayoutParams();
                    sizeRules2.height = 500;
                    layout2.setLayoutParams(sizeRules2);
                    sett = 1;
                } else {
                    ViewGroup.LayoutParams sizeRules = layout.getLayoutParams();
                    sizeRules.height = 230;
                    layout.setLayoutParams(sizeRules);
                    ViewGroup.LayoutParams sizeRules2 = layout2.getLayoutParams();
                    sizeRules2.height = 0;
                    layout2.setLayoutParams(sizeRules2);
                    sett = 0;
                }


                TapcashDesFragment tapcashDesFragment = new TapcashDesFragment();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.isitapcash, tapcashDesFragment, "Tapcash");
                fragmentTransaction.commit();
            }

        });

        return rootView;
    }



    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
