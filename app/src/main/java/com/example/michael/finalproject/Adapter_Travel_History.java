package com.example.michael.finalproject;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.Vector;

/**
 * Created by michael on 09-Jan-18.
 */

public class Adapter_Travel_History extends BaseAdapter {

    LayoutInflater inflater;

    public Adapter_Travel_History(Activity activity){
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    Vector<History> list_travel_history = new Vector<History>();

    public void addTravelHistory(History object)
    {
        list_travel_history.add(object);
    }

    @Override
    public int getCount() {
        return list_travel_history.size();
    }

    @Override
    public Object getItem(int i) {
        return list_travel_history.elementAt(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View one_row = inflater.inflate(R.layout.travel_history_item, null);

        TextView txt_name = one_row.findViewById(R.id.travel_history_destination_name);

        TextView txt_description = one_row.findViewById(R.id.travel_history_travel_date);

        TextView txt_location = one_row.findViewById(R.id.travel_history_travel_status);

        History T = (History) getItem(i);
        txt_name.setText(T.Destination_Name);
        txt_description.setText(T.Date);
        txt_location.setText(T.Status);

        return one_row;
    }
}
