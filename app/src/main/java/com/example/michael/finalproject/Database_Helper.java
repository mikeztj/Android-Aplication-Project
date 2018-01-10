package com.example.michael.finalproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by michael on 31-Dec-17.
 */

public class Database_Helper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "BluejackTravel";

    private static final String TABLE_USERS = "Users";

    private static final String KEY_USERS_UserID = "UserID";
    private static final String KEY_USERS_Username = "Username";
    private static final String KEY_USERS_Password = "Password";
    private static final String KEY_USERS_PhoneNumber = "PhoneNumber";


    private static final String TABLE_TRAVELS = "Travels";

    private static final String KEY_TRAVELS_TravelID = "TravelID";
    private static final String KEY_TRAVELS_UserID = "UserID";
    private static final String KEY_TRAVELS_DestinationID = "DestinationID";
    private static final String KEY_TRAVELS_TravelDate = "TravelDate";
    private static final String KEY_TRAVELS_TravelStatus = "TravelStatus";


    private static final String TABLE_DESTINATIONS = "Destinations";

    private static final String KEY_DESTINATIONS_DestinationID = "DestinationID";
    private static final String KEY_DESTINATIONS_DestinationName = "DestinationName";
    private static final String KEY_DESTINATIONS_DestinationDescription = "DestinationDescription";
    private static final String KEY_DESTINATIONS_DestinationLocation = "DestinationLocation";
    private static final String KEY_DESTINATIONS_DestinationRating = "DestinationRating";
    private static final String KEY_DESTINATIONS_DestinationLatitude = "DestinationLatitude";
    private static final String KEY_DESTINATIONS_DestinationLongitude = "DestinationLongitude";

    String ID = "";

    public Database_Helper(Context context) {
        super(context,  DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String CREATE_USERS_TABLE =
                "CREATE TABLE " + TABLE_USERS +
                        "("
                        +KEY_USERS_UserID+" VARCHAR PRIMARY KEY,"
                        +KEY_USERS_Username+" VARCHAR,"
                        +KEY_USERS_Password+" VARCHAR,"
                        +KEY_USERS_PhoneNumber+" VARCHAR)";

        String CREATE_TRAVELS_TABLE =
                "CREATE TABLE " + TABLE_TRAVELS +
                        "("
                        +KEY_TRAVELS_TravelID+" VARCHAR PRIMARY KEY,"
                        +KEY_TRAVELS_UserID +" VARCHAR ,"
                        +KEY_TRAVELS_DestinationID+" INTEGER ,"
                        +KEY_TRAVELS_TravelDate+" VARCHAR,"
                        +KEY_TRAVELS_TravelStatus+" VARCHAR)";

        String CREATE_DESTINATIONS_TABLE =
                "CREATE TABLE " + TABLE_DESTINATIONS +
                        "("
                        +KEY_DESTINATIONS_DestinationID+" INTEGER PRIMARY KEY,"
                        +KEY_DESTINATIONS_DestinationName+" VARCHAR,"
                        +KEY_DESTINATIONS_DestinationDescription+" VARCHAR,"
                        +KEY_DESTINATIONS_DestinationLocation+" VARCHAR,"
                        +KEY_DESTINATIONS_DestinationRating+" VARCHAR,"
                        +KEY_DESTINATIONS_DestinationLatitude+" VARCHAR,"
                        +KEY_DESTINATIONS_DestinationLongitude+" VARCHAR)";

        sqLiteDatabase.execSQL(CREATE_USERS_TABLE);
        sqLiteDatabase.execSQL(CREATE_TRAVELS_TABLE);
        sqLiteDatabase.execSQL(CREATE_DESTINATIONS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS" + TABLE_USERS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS" + TABLE_TRAVELS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS" + TABLE_DESTINATIONS);

        onCreate(sqLiteDatabase);
    }

    public void addTableUser(Users users)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_USERS_UserID, users.getUserID());
        contentValues.put(KEY_USERS_Username, users.getUsername());
        contentValues.put(KEY_USERS_Password, users.getPassword());
        contentValues.put(KEY_USERS_PhoneNumber, users.getPhoneNumber());

        sqLiteDatabase.insert(TABLE_USERS, null, contentValues);
        sqLiteDatabase.close();
    }

    public void addTableTravels(Travels travels)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_TRAVELS_TravelID,travels.getTravelID() );
        contentValues.put(KEY_TRAVELS_UserID, travels.getUserID());
        contentValues.put(KEY_TRAVELS_DestinationID, travels.getDestinationID());
        contentValues.put(KEY_TRAVELS_TravelDate, travels.getTravelDate());
        contentValues.put(KEY_TRAVELS_TravelStatus, travels.getTravelStatus());

        sqLiteDatabase.insert(TABLE_TRAVELS, null, contentValues);
        sqLiteDatabase.close();
    }

    public void addTableDestinations(Destinations destinations)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_DESTINATIONS_DestinationName, destinations.getDestinationName());
        contentValues.put(KEY_DESTINATIONS_DestinationLocation, destinations.getDestinationLocation());
        contentValues.put(KEY_DESTINATIONS_DestinationDescription, destinations.getDestinationDescription());
        contentValues.put(KEY_DESTINATIONS_DestinationRating, destinations.getDestinationRating());
        contentValues.put(KEY_DESTINATIONS_DestinationLatitude, destinations.getDestinationLatitude());
        contentValues.put(KEY_DESTINATIONS_DestinationLongitude, destinations.getDestinationLongitude());

        sqLiteDatabase.insert(TABLE_DESTINATIONS, null, contentValues);
        sqLiteDatabase.close();
    }

    public List<Users> getAllUsers(){
        List<Users> users_list = new ArrayList<Users>();
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor currsor = db.rawQuery("SELECT * FROM " + TABLE_USERS, null);

        if (currsor.moveToNext()){
            do {
                Users users = new Users();
                users.setUserID(currsor.getString(0));
                users.setUsername(currsor.getString(1));
                users.setPassword(currsor.getString(2));
                users.setPhoneNumber(currsor.getString(3));
                users_list.add(users);
            }while(currsor.moveToNext());
        }

        return  users_list;
    }

    public List<Travels> getAllTravels(String id)
    {
        List<Travels> travels_list = new ArrayList<Travels>();
        SQLiteDatabase db = this.getWritableDatabase();

        //Cursor currsor = db.rawQuery("SELECT * FROM " + TABLE_TRAVELS, null);
        Cursor currsor = db.rawQuery("SELECT *FROM "+TABLE_TRAVELS+" WHERE "+KEY_TRAVELS_UserID+"=?",new String[] {id});

        if (currsor.moveToNext()){
            do {
                Travels travels = new Travels();
                travels.setTravelID(currsor.getString(0));
                travels.setUserID(currsor.getString(1));
                travels.setDestinationID(Integer.parseInt(currsor.getString(2)));
                travels.setTravelDate(currsor.getString(3));
                travels.setTravelStatus(currsor.getString(4));
                travels_list.add(travels);
            }while(currsor.moveToNext());
        }

        return  travels_list;
    }

    public List<Travels> getSuperAllTravels()
    {
        List<Travels> travels_list = new ArrayList<Travels>();
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor currsor = db.rawQuery("SELECT * FROM " + TABLE_TRAVELS, null);

        if (currsor.moveToNext()){
            do {
                Travels travels = new Travels();
                travels.setTravelID(currsor.getString(0));
                travels.setUserID(currsor.getString(1));
                travels.setDestinationID(Integer.parseInt(currsor.getString(2)));
                travels.setTravelDate(currsor.getString(3));
                travels.setTravelStatus(currsor.getString(4));
                travels_list.add(travels);
            }while(currsor.moveToNext());
        }

        return  travels_list;
    }

    public List<Destinations> getAllDestinations(){
        List<Destinations> destinations_list = new ArrayList<Destinations>();
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor currsor = db.rawQuery("SELECT * FROM " + TABLE_DESTINATIONS, null);

        if (currsor.moveToNext()){
            do {
                Destinations destinations = new Destinations();
                destinations.setDestinationID(Integer.parseInt(currsor.getString(0)));
                destinations.setDestinationName(currsor.getString(1));
                destinations.setDestinationLocation(currsor.getString(2));
                destinations.setDestinationDescription(currsor.getString(3));
                destinations.setDestinationRating(currsor.getString(4));
                destinations.setDestinationLatitude(currsor.getString(5));
                destinations.setDestinationLongitude(currsor.getString(6));
                destinations_list.add(destinations);
            }while(currsor.moveToNext());
        }

        return  destinations_list;
    }

    public int checkUsers()
    {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = null;

        cursor = db.rawQuery("SELECT * FROM " + TABLE_USERS, null);

        int test = cursor.getCount();

        cursor.close();
        return test;
    }

    public String checkUserID()
    {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_USERS, null);
        cursor.moveToLast();

        String UserID = cursor.getString(0);

        cursor.close();
        return UserID;
    }

    public boolean checkLogin(String username, String password)
    {
        boolean check = false;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT *FROM "+TABLE_USERS+" WHERE "+KEY_USERS_Username+"=? AND "+KEY_USERS_Password+"=?",new String[] {username,password});

        if (cursor != null)
        {
            if (cursor.getCount() > 0)
            {
                check = true;
                cursor.moveToFirst();

                ID = cursor.getString(cursor.getColumnIndex(KEY_TRAVELS_UserID));

            }
            else
            {
                check = false;
            }
        }

        return check;
    }

    public String IDResult()
    {
        return ID;
    }

    public int checkDestinationID(String name)
    {
        int DestinationID=0;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT *FROM "+TABLE_DESTINATIONS+" WHERE "+KEY_DESTINATIONS_DestinationName+"=? ",new String[] {name});

        if (cursor != null)
        {
            if (cursor.getCount() > 0)
            {

                cursor.moveToFirst();

                DestinationID = Integer.parseInt(cursor.getString(cursor.getColumnIndex(KEY_DESTINATIONS_DestinationID)));

            }
        }

        return DestinationID;
    }

    public int checkTravels()
    {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = null;

        cursor = db.rawQuery("SELECT * FROM " + TABLE_TRAVELS, null);

        int testing = cursor.getCount();

        cursor.close();
        return testing;
    }

    public String checkTravelsID()
    {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_TRAVELS, null);
        cursor.moveToLast();

        String TravelID = cursor.getString(0);

        cursor.close();
        return TravelID;
    }

    public String checkDestinationName(int id)
    {
        String destinationName=null;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT *FROM "+TABLE_DESTINATIONS+" WHERE "+KEY_DESTINATIONS_DestinationID+"="+ id ,null);

        if (cursor != null)
        {
            if (cursor.getCount() > 0)
            {

                cursor.moveToFirst();

                destinationName = cursor.getString(cursor.getColumnIndex(KEY_DESTINATIONS_DestinationName));

            }
        }

        return destinationName;
    }

    public Travels getTravels(String id)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.query(TABLE_TRAVELS, new String[]{KEY_TRAVELS_TravelID,KEY_TRAVELS_UserID,KEY_TRAVELS_DestinationID,KEY_TRAVELS_TravelStatus,KEY_TRAVELS_TravelDate},KEY_TRAVELS_TravelID+" = ?",new String[]{id},null,null,null,null);

        if (cursor != null){
            cursor.moveToFirst();
        }

        return new Travels(cursor.getString(0),
                cursor.getString(1),
                Integer.parseInt(cursor.getString(2)),
                cursor.getString(3),
                cursor.getString(4));

    }

    public void deleteTravels(Travels travels)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_TRAVELS,KEY_TRAVELS_TravelID+"= ?",new String[]{travels.getTravelID()});

        db.close();
    }

    public int updateTravels(Travels travels)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_TRAVELS_TravelID,travels.getTravelID() );
        contentValues.put(KEY_TRAVELS_UserID, travels.getUserID());
        contentValues.put(KEY_TRAVELS_DestinationID, travels.getDestinationID());
        contentValues.put(KEY_TRAVELS_TravelDate, travels.getTravelDate());
        contentValues.put(KEY_TRAVELS_TravelStatus, travels.getTravelStatus());

        return db.update(TABLE_TRAVELS,contentValues,KEY_TRAVELS_TravelID+"= ?",new String[]{travels.getTravelID()});
    }

    public int checkCountDestination()
    {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = null;

        cursor = db.rawQuery("SELECT * FROM " + TABLE_DESTINATIONS, null);

        int test = cursor.getCount();

        cursor.close();
        return test;
    }
}
