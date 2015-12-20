package com.example.shalhan.greencampus;


import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class TapcashDesFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    View rootView;
    Context context;
    Spinner spinner;
    Button isiUlang;
    double saldo = 0.0;
    GreenDataSource myDb;
    EditText passlog;
    String passLog;


    public TapcashDesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_isi_tapcash, container, false);
        context = rootView.getContext();

        spinner = (Spinner) rootView.findViewById(R.id.saldo);
        isiUlang = (Button) rootView.findViewById(R.id.bIsiUlang);
        passlog = (EditText) rootView.findViewById(R.id.etPassLog);


        myDb = new GreenDataSource(getActivity());






        isiUlang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passLog = passlog.getText().toString();

                Cursor cursor = myDb.getUserLogin();
                boolean stat = false;
                cursor.moveToFirst();
                do {
                    if (passLog.equals(cursor.getString(2))) {
                      stat = true;
                    }
                }while(cursor.moveToNext());
                if(stat){
                    Toast.makeText(context, "Success", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(context, "Gagal", Toast.LENGTH_LONG).show();
                }
            }
        });


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.getActivity(),
                R.array.saldo_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);



        return rootView;
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0:
                saldo = 0;
                break;
            case 1:
                saldo = 10000;
                break;
            case 2:
                saldo = 20000;
                break;
            case 3:
                saldo = 50000;
                break;
            case 4:
                saldo = 100000;
                break;
            case 5:
                saldo = 200000;
                break;
            case 6:
                saldo = 500000;
                break;
            case 7:
                saldo = 1000000;
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
