package com.example.myapplication1.com.cse5324.team6.util;

import android.database.Cursor;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ReservationFactory {
    public ReservationDetails makeReservation(Cursor cursor){
        ReservationDetails res = new ReservationDetails();
        String dateTime = cursor.getString(cursor.getColumnIndex("ParkingDateTime"));
        String duration = cursor.getString(cursor.getColumnIndex("Duration"));
        SimpleDateFormat parkingDateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat durationFormat = new SimpleDateFormat("HH:mm:ss");
        try{
            res.setDate(parkingDateTimeFormat.parse(dateTime));
            res.setDuration(durationFormat.parse(duration));
        } catch (ParseException pe) {
            Log.d("Stag", "parse date fail" + dateTime + pe.getMessage());
        }
        String areaName = cursor.getString(cursor.getColumnIndex("AreaName"));
        int floor = cursor.getInt(cursor.getColumnIndex("Floor"));
        int parkingType = cursor.getInt(cursor.getColumnIndex("ParkingType"));
        int spotNumber = cursor.getInt(cursor.getColumnIndex("SpotNumber"));
        ParkingSpot spot = new ParkingSpot( areaName, floor, ParkingType.values()[parkingType], spotNumber);
        res.setSpot(spot);

        res.setCart(1 == cursor.getInt(cursor.getColumnIndex("Cart")));
        res.setCamera(1 == cursor.getInt(cursor.getColumnIndex("Camera")));
        res.setHistory(1 == cursor.getInt(cursor.getColumnIndex("History")));

        res.setPid(cursor.getInt(cursor.getColumnIndex("ParkingID")));
        res.setCost(cursor.getInt(cursor.getColumnIndex("Cost")));
        res.setUserName(cursor.getString(cursor.getColumnIndex("UserName")));

        return res;
    }

    public ReservationDetails makeEmptyReservation(){
        ReservationDetails res = new ReservationDetails();
        res.setPid(-1);
        return res;
    }
}
