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
 * Created by michael on 29-Dec-17.
 */

public class Adapter_Destination extends BaseAdapter {

    LayoutInflater inflater;

    public Adapter_Destination(Activity activity){
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    Vector<Destination> list_destenation = new Vector<Destination>();

    public void addDestintation(Destination object)
    {
        list_destenation.add(object);
    }

    @Override
    public int getCount() {
        return list_destenation.size();
    }

    @Override
    public Object getItem(int i) {
        return list_destenation.elementAt(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View one_row = inflater.inflate(R.layout.destination_item, null);

        TextView txt_name = one_row.findViewById(R.id.destination_name);

        TextView txt_description = one_row.findViewById(R.id.destination_description);

        TextView txt_location = one_row.findViewById(R.id.destination_location);

        TextView txt_rating = one_row.findViewById(R.id.destination_rating);

        TextView txt_latitude = one_row.findViewById(R.id.destination_latitude);

        TextView txt_longitude = one_row.findViewById(R.id.destination_longitude);

        Destination D = (Destination) getItem(i);
        txt_name.setText(D.name);
        txt_description.setText(D.Description);
        txt_location.setText(D.location);
        txt_rating.setText(D.rating);
        txt_latitude.setText(D.latitude);
        txt_longitude.setText(D.longitude);

        return one_row;
    }
}
