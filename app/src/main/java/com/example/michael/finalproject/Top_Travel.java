package com.example.michael.finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Top_Travel extends AppCompatActivity {

    private ListView topTravelList;

    private Adapter_Top_Travel mAdapter_top_travel;

    private RequestQueue mRequestQueue;

    public static final String ACTIVITY_TAG= "Top_Travel";

    String Name ;
    String Location ;
    String Description ;
    String Rating ;
    String Latitude ;
    String Longitude ;

    @Override
    protected void onStop() {
        super.onStop();
        if (mRequestQueue!=null)
        {
            mRequestQueue.cancelAll(ACTIVITY_TAG);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top__travel);

        topTravelList = findViewById(R.id.list_top_travel);

        mAdapter_top_travel = new Adapter_Top_Travel(this);

        mRequestQueue = Volley.newRequestQueue(this);

        String URL ="https://api.myjson.com/bins/oqoed";

        JsonArrayRequest request = new JsonArrayRequest(URL,Success(),Error());

        mRequestQueue.add(request);
    }

    public Response.Listener Success()
    {
        Response.Listener a = new Response.Listener<JSONArray>()
        {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {

                    JSONObject Object = null;
                    try {
                        Object = response.getJSONObject(i);

                        Name = Object.getString("DestinationName");
                        Location = Object.getString("DestinationLocation");
                        Description = Object.getString("DestinationDescription");
                        Rating = Object.getString("DestinationDescription");
                        Latitude = Object.getString("DestinationLatitude");
                        Longitude = Object.getString("DestinationLongitude");

                        Log.d("JSON",Name+" "+Location+" "+Description+" "+Rating+" "+Latitude+" "+Longitude);

                        topTravel T = new topTravel();
                        T.name = Object.getString("DestinationName");;
                        T.Description = Object.getString("DestinationDescription");
                        T.location = Object.getString("DestinationLocation");;
                        T.rating = Object.getString("DestinationDescription");
                        T.latitude = Object.getString("DestinationLatitude");
                        T.longitude = Object.getString("DestinationLongitude");

                        mAdapter_top_travel.addTopTravel(T);

                        topTravelList.setAdapter(mAdapter_top_travel);

                        Log.d("test", Name);
                    } catch (JSONException e) {
                        e.printStackTrace();

                        Log.d("ERR JSON",e.getMessage());

                        Toast.makeText(getApplicationContext(),"Fail To Retrive JSON Data", Toast.LENGTH_LONG).show();
                    }
                }
            }
        };

        return a;
    }

    public Response.ErrorListener Error()
    {
        Response.ErrorListener b = new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("err", "Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),"Fail To Retrive JSON Data", Toast.LENGTH_SHORT).show();
            }
        };

        return b;
    }
}
