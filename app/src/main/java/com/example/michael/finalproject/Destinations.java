package com.example.michael.finalproject;

/**
 * Created by michael on 31-Dec-17.
 */

public class Destinations {
    private int DestinationID;
    private String DestinationName;
    private String DestinationDescription;
    private String DestinationLocation;
    private String DestinationRating;
    private String DestinationLatitude;
    private String DestinationLongitude;

    public Destinations() {

    }

    public Destinations(int destinationID, String destinationName, String destinationDescription, String destinationLocation, String destinationRating, String destinationLatitude, String destinationLongitude) {
        DestinationID = destinationID;
        DestinationName = destinationName;
        DestinationDescription = destinationDescription;
        DestinationLocation = destinationLocation;
        DestinationRating = destinationRating;
        DestinationLatitude = destinationLatitude;
        DestinationLongitude = destinationLongitude;
    }

    public Destinations(String destinationName, String destinationDescription, String destinationLocation, String destinationRating, String destinationLatitude, String destinationLongitude) {
        DestinationName = destinationName;
        DestinationDescription = destinationDescription;
        DestinationLocation = destinationLocation;
        DestinationRating = destinationRating;
        DestinationLatitude = destinationLatitude;
        DestinationLongitude = destinationLongitude;
    }

    public int getDestinationID() {
        return DestinationID;
    }

    public void setDestinationID(int destinationID) {
        DestinationID = destinationID;
    }

    public String getDestinationName() {
        return DestinationName;
    }

    public void setDestinationName(String destinationName) {
        DestinationName = destinationName;
    }

    public String getDestinationDescription() {
        return DestinationDescription;
    }

    public void setDestinationDescription(String destinationDescription) {
        DestinationDescription = destinationDescription;
    }

    public String getDestinationLocation() {
        return DestinationLocation;
    }

    public void setDestinationLocation(String destinationLocation) {
        DestinationLocation = destinationLocation;
    }

    public String getDestinationRating() {
        return DestinationRating;
    }

    public void setDestinationRating(String destinationRating) {
        DestinationRating = destinationRating;
    }

    public String getDestinationLatitude() {
        return DestinationLatitude;
    }

    public void setDestinationLatitude(String destinationLatitude) {
        DestinationLatitude = destinationLatitude;
    }

    public String getDestinationLongitude() {
        return DestinationLongitude;
    }

    public void setDestinationLongitude(String destinationLongitude) {
        DestinationLongitude = destinationLongitude;
    }
}

