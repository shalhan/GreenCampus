package com.example.shalhan.greencampus;


import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class TapcashFragment extends Fragment {

    Context context;
    View rootView, layout, layout2;
    TextView sName, sNoRek, sSaldoT, sSaldoR;
    Double saldot, saldor;
    Button bIsiUlang;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    GreenDataSource myDb;
    UserLogin usr;
    TextView mDate;
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


        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = df.format(c.getTime());
// Now formattedDate have current date/time
        Toast.makeText(getActivity(), formattedDate, Toast.LENGTH_SHORT).show();

        String[] test = {"sempak", "sempak2", "sempak3"};
        ListAdapter adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, test);

        ListView listView = (ListView) rootView.findViewById(R.id.transaksi);
        listView.setAdapter(adapter);

        Cursor cursor = myDb.getAllUserData();
        Cursor cursorLogin = myDb.getUserLogin();
        cursor.moveToFirst();
        cursorLogin.moveToFirst();
        do{
            if(cursorLogin.getString(0).equals(cursor.getString(0))){
                saldot = cursor.getDouble(5);
                saldor = cursor.getDouble(4);

                sName.setText(": " + cursor.getString(1) + " " + cursor.getString(2));
                sNoRek.setText(": " + cursor.getString(3));
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

                if(sett==0) {
                    ViewGroup.LayoutParams sizeRules = layout.getLayoutParams();
                    sizeRules.height = 650;
                    layout.setLayoutParams(sizeRules);
                    ViewGroup.LayoutParams sizeRules2 = layout2.getLayoutParams();
                    sizeRules2.height = 500;
                    layout2.setLayoutParams(sizeRules2);
                    sett = 1;
                }else{
                    ViewGroup.LayoutParams sizeRules = layout.getLayoutParams();
                    sizeRules.height = 230;
                    layout.setLayoutParams(sizeRules);
                    ViewGroup.LayoutParams sizeRules2 = layout2.getLayoutParams();
                    sizeRules2.height = 0;
                    layout2.setLayoutParams(sizeRules2);
                    sett = 0;
                }


                TapcashDesFragment tapcashDesFragment = new TapcashDesFragment();
                FragmentTransaction fragmentTransaction =  fragmentManager.beginTransaction();
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
}
