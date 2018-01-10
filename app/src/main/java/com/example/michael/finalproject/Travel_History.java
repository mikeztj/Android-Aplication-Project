package com.example.michael.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

public class Travel_History extends AppCompatActivity {

    private ListView historyList;

    private Adapter_Travel_History mAdapter_travel_history;

    String ID;

    Database_Helper mDatabase_helper = new Database_Helper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel__history);

        historyList = findViewById(R.id.list_travel_history);

        mAdapter_travel_history = new Adapter_Travel_History(this);

        ID =   getIntent().getStringExtra("id");

        List<Travels> travels_list = mDatabase_helper.getAllTravels(ID);
        for(Travels trvl: travels_list)
        {
            Log.d("Travels: ",trvl.getTravelID() + " " + trvl.getUserID()+ " " + trvl.getDestinationID()+ " " + trvl.getTravelDate()+ " " + trvl.getTravelStatus());

            History H = new History();

            H.TravelID = trvl.getTravelID();
            H.Destination_Name= mDatabase_helper.checkDestinationName(trvl.getDestinationID());
            H.Status = trvl.getTravelStatus();
            H.Date = trvl.getTravelDate();

            mAdapter_travel_history.addTravelHistory(H);

            historyList.setAdapter(mAdapter_travel_history);
        }

        historyList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent new_intent_history = new Intent(getApplicationContext(), Detail_History.class);

                History H = (History)  mAdapter_travel_history.getItem(i);

                new_intent_history.putExtra("id",H.TravelID);
                new_intent_history.putExtra("nama", H.Destination_Name );
                new_intent_history.putExtra("status", H.Status );
                new_intent_history.putExtra("date", H.Date );

                startActivity(new_intent_history);
            }
        });
    }
}
