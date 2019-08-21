package com.example.corsiblockapp;

import java.util.HashMap;
import java.util.TreeMap;

public class User {
    String userId;
    String userName;
    String userAge;
    String userPhoneNumber;
    TreeMap<String, Integer> scores;
    public User(){

    }

    public User(String userId, String userName, String userAge, String userPhoneNumber, TreeMap<String, Integer> scores) {
        this.userId = userId;
        this.userName = userName;
        this.userAge = userAge;
        this.userPhoneNumber = userPhoneNumber;
        this.scores = scores;
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

    public TreeMap<String, Integer> getScores() {
        return scores;

    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public void setScores(TreeMap<String, Integer> scores) {
        this.scores = scores;
    }
}
