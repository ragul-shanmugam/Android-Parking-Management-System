package com.example.myapplication1.com.cse5324.team6.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "PSM";
    private static final int DB_VERSION = 4;
    private static final String GARAGESPOT_TABLE = "GarageSpot";
    private static final String createParkingSpotTable = "CREATE TABLE " + GARAGESPOT_TABLE + " ( AreaName TEXT, Floor Integer, ParkingType Integer, SpotNumber Integer, OccupiedUserName Text, ParkingID Integer, PRIMARY KEY(AreaName, Floor, SpotNumber));";
    private static final String RESERVATION_TABLE = "Rservation";
    private static final String createReservationTable = "CREATE TABLE " + RESERVATION_TABLE + " ( " +
            "ParkingID Integer, ParkingDateTime TEXT, Duration Text, AreaName Text, Floor Integer, ParkingType Integer, SpotNumber Integer, Cost Integer, Cart Boolean, Camera Boolean, History Boolean, UserName Text, PRIMARY KEY(ParkingID));";
    private static final String upgradeParkingSpot = "DROP TABLE IF EXISTS " + GARAGESPOT_TABLE;
    private static final String upgradeReservation = "DROP TABLE IF EXISTS " + RESERVATION_TABLE;

    public DBHelper (Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createParkingSpotTable);
        db.execSQL(createReservationTable);
        initialGarageSpot(db);
        initialReservation(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(upgradeParkingSpot);
        db.execSQL(upgradeReservation);
        onCreate(db);
    }

    public String getSpotQuerySelection() {
        final String spotQueryStm = "AreaName=? AND Floor=? AND ParkingType=? AND SpotNumber=?";

        return spotQueryStm;
    }

    public String getGarageSpotTablenName() {
        return GARAGESPOT_TABLE;
    }

    public String getReservationTablenName() {
        return RESERVATION_TABLE;
    }

    /* Just for test */
    private void initialGarageSpot(SQLiteDatabase db) {
        db.execSQL("insert into GarageSpot (AreaName, Floor, ParkingType, SpotNumber, OccupiedUserName) VALUES ('Davis', 1, 0, 12, 'IamUser')");
        db.execSQL("insert into GarageSpot (AreaName, Floor, ParkingType, SpotNumber, OccupiedUserName) VALUES ('Davis', 1, 1, 13, 'IamUser2')");
        db.execSQL("insert into GarageSpot (AreaName, Floor, ParkingType, SpotNumber, OccupiedUserName) VALUES ('Davis', 1, 2, 77, '')");
    }
    /* Just for test */
    private void initialReservation(SQLiteDatabase db) {
        db.execSQL("insert into " + RESERVATION_TABLE + " (ParkingID, ParkingDateTime, Duration, AreaName, Floor, ParkingType, SpotNumber, Cost, Cart, Camera, History, UserName) " +
                "VALUES (222, '2018-04-10 22:11:10', '03:00:00', 'Davis', 1, 0, 12, 90, 1, 1, 1, 'User1')");
        db.execSQL("insert into " + RESERVATION_TABLE + " (ParkingID, ParkingDateTime, Duration, AreaName, Floor, ParkingType, SpotNumber, Cost, Cart, Camera, History, UserName) " +
                "VALUES (84, '2018-01-11 02:11:10', '00:30:00', 'Davis', 2, 0, 13, 90, 1, 1, 1, 'User2')");
    }
}
