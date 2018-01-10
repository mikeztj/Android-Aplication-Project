package com.example.michael.finalproject;

/**
 * Created by michael on 31-Dec-17.
 */

public class Travels {
    private String TravelID;
    private String UserID;
    private int DestinationID;
    private String TravelDate;
    private String TravelStatus;

    public Travels() {
    }

    public Travels(String travelID, String userID, int destinationID, String travelDate, String travelStatus) {
        TravelID = travelID;
        UserID = userID;
        DestinationID = destinationID;
        TravelDate = travelDate;
        TravelStatus = travelStatus;
    }

    public Travels(String userID, int destinationID, String travelDate, String travelStatus) {
        UserID = userID;
        DestinationID = destinationID;
        TravelDate = travelDate;
        TravelStatus = travelStatus;
    }

    public String getTravelID() {
        return TravelID;
    }

    public void setTravelID(String travelID) {
        TravelID = travelID;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public int getDestinationID() {
        return DestinationID;
    }

    public void setDestinationID(int destinationID) {
        DestinationID = destinationID;
    }

    public String getTravelDate() {
        return TravelDate;
    }

    public void setTravelDate(String travelDate) {
        TravelDate = travelDate;
    }

    public String getTravelStatus() {
        return TravelStatus;
    }

    public void setTravelStatus(String travelStatus) {
        TravelStatus = travelStatus;
    }
}
