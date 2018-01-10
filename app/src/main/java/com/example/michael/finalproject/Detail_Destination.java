package com.example.michael.finalproject;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class Detail_Destination extends AppCompatActivity {

    private TextView txt_name;
    private TextView txt_description;
    private TextView txt_location;
    private TextView txt_rating;
    private TextView txt_latitude;
    private TextView txt_longitude;

    private DatePicker datepic;

    private Button map;
    private Button plan;

    String name;
    String description;
    String location;
    String rating;
    String latitude;
    String longitude;

    String UserID;
    String TravelID;

    String status= "Pending";

    Database_Helper mDatabase_helper = new Database_Helper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_destination);

        name = getIntent().getStringExtra("name");
        description = getIntent().getStringExtra("description");
        location =getIntent().getStringExtra("location");
        rating =getIntent().getStringExtra("rating");
        latitude = getIntent().getStringExtra("latitude");
        longitude = getIntent().getStringExtra("longitude");

        UserID = getIntent().getStringExtra("ID");
        Log.d("masuk", UserID);

        txt_name = findViewById(R.id.destination_name);

        txt_description = findViewById(R.id.destination_description);

        txt_location = findViewById(R.id.destination_location);

        txt_rating = findViewById(R.id.destination_rating);

        txt_latitude = findViewById(R.id.destination_latitude);

        txt_longitude = findViewById(R.id.destination_longitude);

        datepic = findViewById(R.id.datepic);
        datepic.setBackground(new ColorDrawable(Color.WHITE));

        plan = findViewById(R.id.btnplantravel);
        map = findViewById(R.id.button_open_map);

        txt_name.setText(name);
        txt_description.setText(description);
        txt_location.setText(location);
        txt_rating.setText(rating);
        txt_latitude.setText(latitude);
        txt_longitude.setText(longitude);

        final int destinationID= mDatabase_helper.checkDestinationID(name);
        Log.d("destinasi", String.valueOf(destinationID));

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent new_intent = new Intent(getApplicationContext(), MapsActivity.class);

//                Destination D = (Destination) mAdapter_destination.getItem(i);

                new_intent.putExtra("name", name);
                new_intent.putExtra("latitude", latitude);
                new_intent.putExtra("longitude",longitude);
                startActivity(new_intent);
            }
        });

        plan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Tahun = datepic.getYear();
                int Bulan = datepic.getMonth();
                int Hari = datepic.getDayOfMonth();

                Calendar c2 = Calendar.getInstance();
                c2.set(Tahun, Bulan, Hari);

                Calendar today = Calendar.getInstance();

                if (c2.before(today)){
                    Toast.makeText(Detail_Destination.this, "the date cannot before the event date", Toast.LENGTH_SHORT).show();
                }
                else if (today.equals(c2)){
                    Toast.makeText(Detail_Destination.this, "the date cannot be today", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    travel_check();

                    final SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String Tanggal = mSimpleDateFormat.format(c2.getTime());
                    Log.d("Tanggal : ", Tanggal);

                    Travels travels = new Travels();
                    travels.setTravelID(TravelID);
                    travels.setUserID(UserID);
                    travels.setDestinationID(destinationID);
                    travels.setTravelDate(Tanggal);
                    travels.setTravelStatus(status);
                    mDatabase_helper.addTableTravels(travels);

                    Toast.makeText(Detail_Destination.this, "success your transaction move into pending", Toast.LENGTH_SHORT).show();

                    List<Travels> travels_list = mDatabase_helper.getSuperAllTravels();
                    for(Travels trvl: travels_list)
                    {
                        Log.d("Travels: ",trvl.getTravelID() + " " + trvl.getUserID()+ " " + trvl.getDestinationID()+ " " + trvl.getTravelDate()+ " " + trvl.getTravelStatus());
                    }
                }


            }
        });

    }

    public void travel_check()
    {
        if (mDatabase_helper.checkTravels()==0)
        {
            TravelID = "TR001";
        }
        else
        {
            String id = mDatabase_helper.checkTravelsID();

            String split = id.substring(id.length()-3);

            int pecah = Integer.parseInt(split);

            pecah++;

            TravelID = "TR"+String.format("%03d", pecah);
        }
    }
}
