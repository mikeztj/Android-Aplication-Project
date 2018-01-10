package com.example.michael.finalproject;

/**
 * Created by michael on 31-Dec-17.
 */

public class Users {
    private String UserID;
    private String Username;
    private String Password;
    private String PhoneNumber;

    public Users() {

    }

    public Users(String userID, String username, String password, String phoneNumber) {
        UserID = userID;
        Username = username;
        Password = password;
        PhoneNumber = phoneNumber;
    }

    public Users(String username, String password, String phoneNumber) {
        Username = username;
        Password = password;
        PhoneNumber = phoneNumber;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }
}
