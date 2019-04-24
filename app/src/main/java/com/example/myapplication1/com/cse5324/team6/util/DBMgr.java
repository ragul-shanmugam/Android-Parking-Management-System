package com.example.myapplication1.com.cse5324.team6.util;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import android.util.Log;

public class DBMgr {
    private static DBMgr instance = null;
    private DBHelper dbHelper = null;

    public static DBMgr getInstance(){
        if ( null == instance ){
            throw new RuntimeException("Please initialize DB with context");
        }

        return instance;
    }

    public static DBMgr getInstance(Context context){
        if ( null == instance ){
            instance = new DBMgr(context);
        }

        return instance;
    }

    public DBMgr(Context context) {
        dbHelper = new DBHelper(context);
    }

    /*
    public ParkingSpot getSpot(String parkingAreaName, int floor, ParkingType parkingType, int spotNumber) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String args[] = new String[4];
        args[0] = parkingAreaName;
        args[1] = Integer.toString(floor);
        args[2] = Integer.toString(parkingType.ordinal());
        args[3] = Integer.toString(spotNumber);
        Cursor queryResult = db.query(dbHelper.getGarageSpotTablenName(), null, dbHelper.getSpotQuerySelection(), args, null, null, null);
        //Cursor queryResult = db.query(dbHelper.getGarageSpotTablenName(), null, "ParkingType=?", args, null, null, null);
        //Cursor queryResult = db.query(dbHelper.getGarageSpotTablenName(), null, null, null, null, null, null);

        ParkingSpot spot = null;
        if ( false == queryResult.moveToFirst() ) {
            //throw new RuntimeException("fail to query" + args);
            throw new RuntimeException("cannot find spot by given conditions " + args[0] + " " + args[1] + " " + args[2] + " " +  args[3]);
            //throw new RuntimeException("cannot find spot by given conditions " + args[0]);
        } else {
            spot = new ParkingSpot(parkingAreaName, floor, parkingType, spotNumber);
            //spot.setOccupiedUserId(queryResult.getString(queryResult.getColumnIndex("OccupiedUserName")));
        }

        return spot;
    }

    public ReservationDetails getReservation(int parkingID) {
        ReservationDetails res = null;

        return res;
    }
    */

    public ReservationDetails getReservation(ParkingSpot spot) {
        ReservationDetails res = null;
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String args[] = new String[4];
        args[0] = spot.getAreaName();
        args[1] = Integer.toString(spot.getFloor());
        args[2] = Integer.toString(spot.getParkginType().ordinal());
        args[3] = Integer.toString(spot.getParkingNum());
        Cursor queryResult = db.query(dbHelper.getReservationTablenName(), null, dbHelper.getSpotQuerySelection(), args, null, null, null);

        ReservationFactory resFactory = new ReservationFactory();
        if ( true == queryResult.moveToFirst() ) {
            res = resFactory.makeReservation(queryResult);
        } else {
            res = resFactory.makeEmptyReservation();
        }

        return res;
    }
}
