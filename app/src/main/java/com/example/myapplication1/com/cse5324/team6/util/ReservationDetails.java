package com.example.myapplication1.com.cse5324.team6.util;

import java.util.Date;
//import java.sql.Time;


public class ReservationDetails {

    public int pid;
    public Date date;
    //public Time startTime;
    public Date duration;
    private ParkingSpot spot;
    private String UserName;
    private boolean isCart;
    private boolean isCamera;
    private boolean isHistory;

    public ReservationDetails() {
        spot = new ParkingSpot();
        UserName = new String("");
        pid = -1;
    }

    public int getCost() {
        return Cost;
    }

    public void setCost(int cost) {
        Cost = cost;
    }

    int Cost;

    public boolean isCart() {
        return isCart;
    }

    public void setCart(boolean cart) {
        isCart = cart;
    }

    public boolean isCamera() {
        return isCamera;
    }

    public void setCamera(boolean camera) {
        isCamera = camera;
    }

    public boolean isHistory() {
        return isHistory;
    }

    public void setHistory(boolean history) {
        isHistory = history;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDuration() {
        return duration;
    }

    public void setDuration(Date duration) {
        this.duration = duration;
    }

    public ParkingSpot getSpot() {
        return spot;
    }

    public void setSpot(ParkingSpot spot) {
        this.spot = spot;
    }
}
