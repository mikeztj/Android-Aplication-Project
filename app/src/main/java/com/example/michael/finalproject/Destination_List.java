package com.example.michael.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

public class Destination_List extends AppCompatActivity {

    private ListView destenationList;

    private Adapter_Destination mAdapter_destination;

    Database_Helper mDatabase_helper = new Database_Helper(this);

    String ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination__list);

        destenationList = (ListView) findViewById(R.id.list_destination);

        mAdapter_destination = new Adapter_Destination(this);

        Destinations D1 = new Destinations();
        D1.setDestinationName("Pasir Padi Beach");
        D1.setDestinationDescription("Pasir Padi Beach is located in Kelurahan Air Itam about 8 miles from Pangkalpinang city. That beach is one of the gorgeous beaches of Bangka Island. The beach that has a coastline of approximately 300 meters with a stretch of white sand along the 2 mile is unique because the structure of a sloping beaches and dense sand contours so that the beach is convenient to travel by foot even passable with motorcycle and car.");
        D1.setDestinationLocation("Indonesia");
        D1.setDestinationRating("3.5");
        D1.setDestinationLatitude("-2.108006");
        D1.setDestinationLongitude("106.1675777");
        //mDatabase_helper.addTableDestinations(D1);

        Destinations D2  = new Destinations();
        D2.setDestinationName("National Monument");
        D2.setDestinationDescription("The National Monument is a 132 m (433 ft) tower in the centre of Merdeka Square, Central Jakarta, symbolizing the fight for Indonesia. It is the national monument of the Republic of Indonesia, built to commemorate the struggle for Indonesian independence.");
        D2.setDestinationLocation("Indonesia");
        D2.setDestinationRating("4.5");
        D2.setDestinationLatitude("-6.1753871");
        D2.setDestinationLongitude("106.8249641");
        //mDatabase_helper.addTableDestinations(D2);

        Destinations D3  = new Destinations();
        D3.setDestinationName("Eiffel Tower");
        D3.setDestinationDescription("Eiffel Tower is a wrought iron lattice tower on the Champ de Mars in Paris, France. It is named after the engineer Gustave Eiffel, whose company designed and built the tower.");
        D3.setDestinationLocation("France");
        D3.setDestinationRating("4.6");
        D3.setDestinationLatitude("48.8583729");
        D3.setDestinationLongitude("2.2933365");
        //mDatabase_helper.addTableDestinations(D3);

        Destinations D4  = new Destinations();
        D4.setDestinationName("Angkor Wat");
        D4.setDestinationDescription("Angkor Wat is a temple complex in Cambodia and the largest religious monument in the world, on a site measuring 162.6 hectares. It was originally constructed as a Hindu temple of god Vishnu for the Khmer Empire, gradually transforming into a Buddhist temple towards the end of the 12th century.");
        D4.setDestinationLocation("Cambodia");
        D4.setDestinationRating("4.7");
        D4.setDestinationLatitude("13.4124693");
        D4.setDestinationLongitude("103.864797");
        //mDatabase_helper.addTableDestinations(D4);

        Destinations D5  = new Destinations();
        D5.setDestinationName("Walt Disney World Resort");
        D5.setDestinationDescription("The Walt Disney World Resort is an entertainment complex in Bay Lake and Lake Buena Vista, Florida, near Orlando and Kissimmee, Florida. Opened on October 1, 1971, the resort is owned and operated by Walt Disney Parks and Resorts, a division of The Walt Disney Company.");
        D5.setDestinationLocation("USA");
        D5.setDestinationRating("4.6");
        D5.setDestinationLatitude("28.385233");
        D5.setDestinationLongitude("-81.5660627");
        //mDatabase_helper.addTableDestinations(D5);

        Destinations D6  = new Destinations();
        D6.setDestinationName("Borobudur Temple");
        D6.setDestinationDescription("Borobudur Temple is a 9th-century Mahayana Buddhist temple in Magelang, Central Java, Indonesia, as well as the world's largest Buddhist temple.");
        D6.setDestinationLocation("Indonesia");
        D6.setDestinationRating("4.5");
        D6.setDestinationLatitude("-7.6078738");
        D6.setDestinationLongitude("-7.6078738");
        //mDatabase_helper.addTableDestinations(D6);

        Destinations D7  = new Destinations();
        D7.setDestinationName("Great Wall of China");
        D7.setDestinationDescription("The Great Wall of China is a series of fortifications made of stone, brick, tamped earth, wood, and other materials, generally built along an east-to-west line across the historical northern borders of China to protect the Chinese states and empires against the raids and invasions of the various nomadic groups of the Eurasian Steppe.");
        D7.setDestinationLocation("China");
        D7.setDestinationRating("4.2");
        D7.setDestinationLatitude("40.4319077");
        D7.setDestinationLongitude("116.5681862");
        //mDatabase_helper.addTableDestinations(D7);

        Destinations D8  = new Destinations();
        D8.setDestinationName("Taj Mahal");
        D8.setDestinationDescription("Taj Mahal is an ivory-white marble mausoleum on the south bank of the Yamuna river in the Indian city of Agra. It was commissioned in 1632 by the Mughal emperor, Shah Jahan (reigned 1628–1658), to house the tomb of his favourite wife, Mumtaz Mahal.");
        D8.setDestinationLocation("India");
        D8.setDestinationRating("4.5");
        D8.setDestinationLatitude("27.1750151");
        D8.setDestinationLongitude("78.0399665");
        //mDatabase_helper.addTableDestinations(D8);

        Destinations D9  = new Destinations();
        D9.setDestinationName("The Great Pyramid at Giza");
        D9.setDestinationDescription("The Great Pyramid of Giza (also known as the Pyramid of Khufu or the Pyramid of Cheops) is the oldest and largest of the three pyramids in the Giza pyramid complex bordering what is now El Giza, Egypt. It is the oldest of the Seven Wonders of the Ancient World, and the only one to remain largely intact.");
        D9.setDestinationLocation("Egypt");
        D9.setDestinationRating("4.5");
        D9.setDestinationLatitude("29.9765702");
        D9.setDestinationLongitude("31.131296");
        //mDatabase_helper.addTableDestinations(D9);

        Destinations D10  = new Destinations();
        D10.setDestinationName("Christ the Redeemer");
        D10.setDestinationDescription("Christ the Redeemer is an Art Deco statue of Jesus Christ in Rio de Janeiro, Brazil, created by French sculptor Paul Landowski and built by the Brazilian engineer Heitor da Silva Costa");
        D10.setDestinationLocation("Brazil");
        D10.setDestinationRating("4.7");
        D10.setDestinationLatitude("-22.951916");
        D10.setDestinationLongitude("-43.2126759");
        //mDatabase_helper.addTableDestinations(D10);

        Destinations D11  = new Destinations();
        D11.setDestinationName("Leaning Tower of Pisa");
        D11.setDestinationDescription("The Leaning Tower of Pisa (Italian: Torre pendente di Pisa) or simply the Tower of Pisa (Torre di Pisa) is the campanile, or freestanding bell tower, of the cathedral of the Italian city of Pisa, known worldwide for its unintended tilt. The tower is situated behind the Pisa Cathedral and is the third oldest structure in the city's Cathedral Square (Piazza del Duomo), after the cathedral and the Pisa Baptistry.");
        D11.setDestinationLocation("Italy");
        D11.setDestinationRating("4.5");
        D11.setDestinationLatitude("43.722952");
        D11.setDestinationLongitude("10.3944083");
        //mDatabase_helper.addTableDestinations(D11);

        Destinations D12  = new Destinations();
        D12.setDestinationName("Machu Picchu");
        D12.setDestinationDescription("Machu Picchu is a 15th-century Inca citadel situated on a mountain ridge 2,430 metres (7,970 ft) above sea level. It is located in the Cusco Region, Urubamba Province, Machupicchu District in Peru, above the Sacred Valley, which is 80 kilometres (50 mi) northwest of Cuzco and through which the Urubamba River flows.");
        D12.setDestinationLocation("Peru");
        D12.setDestinationRating("4.7");
        D12.setDestinationLatitude("-13.1631412");
        D12.setDestinationLongitude("-72.5471516");
        //mDatabase_helper.addTableDestinations(D12);

        Destinations D13  = new Destinations();
        D13.setDestinationName("Halong Bay");
        D13.setDestinationDescription("known for its emerald waters and thousands of towering limestone islands topped by rainforests. Junk boat tours and sea kayak expeditions take visitors past islands named for their shapes, including Stone Dog and Teapot islets. The region is popular for scuba diving, rock climbing and hiking, particularly in mountainous Cát Bà National Park.");
        D13.setDestinationLocation("Vietnam");
        D13.setDestinationRating("4.5");
        D13.setDestinationLatitude("20.959656");
        D13.setDestinationLongitude("107.0468702");
        //mDatabase_helper.addTableDestinations(D13);

        Destinations D14  = new Destinations();
        D14.setDestinationName("Phartenon");
        D14.setDestinationDescription("The parthenon is a former temple, on the Athenian Acropolis, Greece, dedicated to the goddess Athena, whom the people of Athens considered their patron. Construction began in 447 BC when the Athenian Empire was at the peak of its power.");
        D14.setDestinationLocation("Athens");
        D14.setDestinationRating("4.7");
        D14.setDestinationLatitude("37.9715327");
        D14.setDestinationLongitude("23.7245279");
        //mDatabase_helper.addTableDestinations(D14);

        Destinations D15  = new Destinations();
        D15.setDestinationName("Wahoo Bay Beach");
        D15.setDestinationDescription("Set amid lush foliage on the Caribbean Sea, this informal beachfront resort is 55 km from Port-au-Prince International Airport and 61 km from the National Museum.");
        D15.setDestinationLocation("Hariti");
        D15.setDestinationRating("4.1");
        D15.setDestinationLatitude("18.8766041");
        D15.setDestinationLongitude("-72.6170647");
        //mDatabase_helper.addTableDestinations(D15);

        Log.d("Count123", String.valueOf(mDatabase_helper.checkCountDestination()));

        if(mDatabase_helper.checkCountDestination()!=15)
        {
            mDatabase_helper.addTableDestinations(D1);
            mDatabase_helper.addTableDestinations(D2);
            mDatabase_helper.addTableDestinations(D3);
            mDatabase_helper.addTableDestinations(D4);
            mDatabase_helper.addTableDestinations(D5);
            mDatabase_helper.addTableDestinations(D6);
            mDatabase_helper.addTableDestinations(D7);
            mDatabase_helper.addTableDestinations(D8);
            mDatabase_helper.addTableDestinations(D9);
            mDatabase_helper.addTableDestinations(D10);
            mDatabase_helper.addTableDestinations(D11);
            mDatabase_helper.addTableDestinations(D12);
            mDatabase_helper.addTableDestinations(D13);
            mDatabase_helper.addTableDestinations(D14);
            mDatabase_helper.addTableDestinations(D15);
        }

        List<Destinations> destinations_list = mDatabase_helper.getAllDestinations();
        for(Destinations destinations: destinations_list)
        {
            Log.d("Destinations: ",destinations.getDestinationID() + " " + destinations.getDestinationName()+ " " +destinations.getDestinationDescription()+ " " + destinations.getDestinationLocation()+ " " + destinations.getDestinationRating()+ " " +destinations.getDestinationLatitude()+ " " + destinations.getDestinationLongitude());

            Destination D  = new Destination();

            D.name= destinations.getDestinationName();
            D.Description= destinations.getDestinationDescription();
            D.location= destinations.getDestinationLocation();
            D.rating= destinations.getDestinationRating();
            D.latitude= destinations.getDestinationLatitude() ;
            D.longitude= destinations.getDestinationLongitude();

            mAdapter_destination.addDestintation(D);

            destenationList.setAdapter(mAdapter_destination);
        }

        ID = getIntent().getStringExtra("ID");

        destenationList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent new_intent = new Intent(getApplicationContext(), Detail_Destination.class);

                Destination D = (Destination) mAdapter_destination.getItem(i);

                new_intent.putExtra("name", D.name );
                new_intent.putExtra("description", D.Description );
                new_intent.putExtra("location", D.location );
                new_intent.putExtra("rating", D.rating );
                new_intent.putExtra("latitude", D.latitude );
                new_intent.putExtra("longitude", D.longitude );
                new_intent.putExtra("ID",ID);

                startActivity(new_intent);
            }
        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.menu);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.topTravel)
                {
                    Intent intent = new Intent(getApplicationContext(), Top_Travel.class);
                    startActivity(intent);
                }
                else if(item.getItemId() == R.id.travelHistory)
                {
                    Intent intent = new Intent(getApplicationContext(), Travel_History.class);

                    intent.putExtra("id",ID);
                    startActivity(intent);
                }
                return false;
            }
        });
    }
}
