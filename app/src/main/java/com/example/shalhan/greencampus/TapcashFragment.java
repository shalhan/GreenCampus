package com.example.shalhan.greencampus;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class TapcashFragment extends Fragment {

    Context context;
    View rootView;
    TextView sName, sNoRek, sSaldoT, sSaldoR;
    String name, norek, saldot, saldor;
    Button bLogout, bIsiUlang;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    GreenDataSource myDb;
    UserLogin usr;

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

        fragmentManager = getActivity().getSupportFragmentManager();
        myDb = new GreenDataSource(getActivity());

        sName = (TextView) rootView.findViewById(R.id.tvName);
        sNoRek = (TextView) rootView.findViewById(R.id.tvNoRek);
        sSaldoR = (TextView) rootView.findViewById(R.id.tvSaldoR);
        sSaldoT = (TextView) rootView.findViewById(R.id.tvSaldoT);

        bLogout = (Button) rootView.findViewById(R.id.bLogout);
        bLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDb.clearLogin();
                usr = new UserLogin("username", "0");
                myDb.userLogin(usr);
                startActivity(new Intent(getActivity(), GreenCampusActivity.class));
            }
        });
        bIsiUlang = (Button) rootView.findViewById(R.id.bIsiUlang);
        bIsiUlang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
