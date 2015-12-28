package com.example.shalhan.greencampus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shalhan on 28/12/15.
 */
public class GreenAdapter extends ArrayAdapter<ListPembayaran> {

    Context mContext;
    int mLayoutResource;
    ArrayList<ListPembayaran> mListPembayaran;


    public GreenAdapter(Context context, int layoutResource, ArrayList<ListPembayaran> list){
        super(context, layoutResource, list);
        mContext = context;
        mListPembayaran= list;
        mLayoutResource = layoutResource;
    }

    @Override
    public int getCount() {
        return mListPembayaran.size();
    }


    @Override
    public long getItemId(int position) {

        return 0;
    }

    public ListPembayaran getItemPembayaran(int position){
        return mListPembayaran.get(position);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        View row = convertView;

        if (row == null){
            row = LayoutInflater.from(mContext).inflate(mLayoutResource, parent, false);

            holder = new ViewHolder();

            holder.id = (TextView) row.findViewById(R.id.tvId);
            holder.date = (TextView) row.findViewById(R.id.tvDate);
            holder.pembayaran = (TextView) row.findViewById(R.id.tvNominal);



            row.setTag(holder);
        }else {
            holder = (ViewHolder) row.getTag();
        }

            ListPembayaran listP = mListPembayaran.get(position);

            holder.id.setText(listP.getId() + "");
            holder.date.setText(listP.getDate());
            holder.pembayaran.setText("Rp. " + listP.getBiaya() + "");




        return row;
    }

    private static class ViewHolder{
        TextView id, date, pembayaran;
    }


}
