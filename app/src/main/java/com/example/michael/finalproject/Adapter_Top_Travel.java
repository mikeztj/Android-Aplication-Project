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
 * Created by michael on 02-Jan-18.
 */

public class Adapter_Top_Travel extends BaseAdapter {

    LayoutInflater inflater;

    public Adapter_Top_Travel(Activity activity){
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    Vector<topTravel> list_top_travel = new Vector<topTravel>();

    public void addTopTravel(topTravel object)
    {
        list_top_travel.add(object);
    }

    @Override
    public int getCount() {
        return list_top_travel.size();
    }

    @Override
    public Object getItem(int i) {
        return list_top_travel.elementAt(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View one_row = inflater.inflate(R.layout.top_travel_item, null);

        TextView txt_name = one_row.findViewById(R.id.top_travel_name);

        TextView txt_description = one_row.findViewById(R.id.top_travel_description);

        TextView txt_location = one_row.findViewById(R.id.top_travel_location);

        TextView txt_rating = one_row.findViewById(R.id.top_travel_rating);

        TextView txt_latitude = one_row.findViewById(R.id.top_travel_latitude);

        TextView txt_longitude = one_row.findViewById(R.id.top_travel_longitude);

        topTravel T = (topTravel) getItem(i);
        txt_name.setText(T.name);
        txt_description.setText(T.Description);
        txt_location.setText(T.location);
        txt_rating.setText(T.rating);
        txt_latitude.setText(T.latitude);
        txt_longitude.setText(T.longitude);

        return one_row;
    }

}
