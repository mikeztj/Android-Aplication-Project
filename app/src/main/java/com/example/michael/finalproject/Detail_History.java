package com.example.michael.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Detail_History extends AppCompatActivity {

    private TextView txt_name;
    private TextView txt_status;
    private TextView txt_date;

    private Button done;
    private Button delete;

    String ID;
    String destinationName;
    String status;
    String date;

    Database_Helper mDatabase_helper = new Database_Helper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail__history);

        ID = getIntent().getStringExtra("id");
        destinationName = getIntent().getStringExtra("nama");
        status = getIntent().getStringExtra("status");
        date =getIntent().getStringExtra("date");

        Log.d("status123", ID);

        txt_name = findViewById(R.id.detail_destination_name);
        txt_status = findViewById(R.id.detail_status);
        txt_date = findViewById(R.id.detail_date);

        done = findViewById(R.id.done);
        delete = findViewById(R.id.delete);

        if(status.equals("Done"))
        {
            done.setEnabled(false);
        }

        txt_name.setText(destinationName);
        txt_status.setText(status);
        txt_date.setText(date);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Travels updateTravels = mDatabase_helper.getTravels(ID);
                updateTravels.setTravelStatus("Done");
                mDatabase_helper.updateTravels(updateTravels);

                Intent move = new Intent(getApplicationContext(), Destination_List.class);
                startActivity(move);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDatabase_helper.deleteTravels(mDatabase_helper.getTravels(ID));

                Intent move = new Intent(getApplicationContext(), Destination_List.class);
                startActivity(move);
            }
        });
    }
}
