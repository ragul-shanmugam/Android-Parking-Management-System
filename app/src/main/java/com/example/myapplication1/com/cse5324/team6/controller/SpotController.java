package com.example.myapplication1.com.cse5324.team6.controller;

import com.example.myapplication1.com.cse5324.team6.util.*;
import android.util.Log;

public class SpotController {
    /*
    public ParkingSpot getSpot(String parkingAreaName, int floor, ParkingType parkingType, int spotNumber){
        Log.d("Stag", "InGetSpot1");

        ParkingSpot spot = null;
        try{
            spot = DBMgr.getInstance().getSpot(parkingAreaName, floor, parkingType, spotNumber);
        }catch(RuntimeException re){
            Log.d("Stag", re.getMessage());
            spot = new ParkingSpot();
        }


        Log.d("Stag", "InGetSpot2");

        return spot;
    }
    */

    public ReservationDetails getReservation(String areaName, int floor, ParkingType type, int spotNumber) {
        Log.d("Stag", "The areaName " + areaName);
        Log.d("Stag", "The floor " + Integer.toString(floor));
        Log.d("Stag", "The type " + Integer.toString(type.ordinal()));
        Log.d("Stag", "The spotNumber " + Integer.toString(spotNumber));
        ReservationDetails res = null;
        try{
            res = DBMgr.getInstance().getReservation(new ParkingSpot(areaName, floor, type, spotNumber));
        }catch(RuntimeException re){
            Log.d("Stag", re.getMessage());
            res = new ReservationDetails();
        }

        return res;
    }

    /*
    public User getUser(String id) {
        User user = new User();

        ReservationDetails res = new ReservationDetails();
        user.addReservation(res);


        return user;
    }
    */
}
