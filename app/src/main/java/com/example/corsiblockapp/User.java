package com.example.corsiblockapp;

public class User {
    String userId;
    String userName;
    String userAge;
    String userPhoneNumber;
    public User(){

    }

    public User(String userId, String userName, String userAge, String userPhoneNumber) {
        this.userId = userId;
        this.userName = userName;
        this.userAge = userAge;
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getUserId(){
        return userId;
    }
    public String getUserName() {
        return userName;
    }

    public String getUserAge() {
        return userAge;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }
}
