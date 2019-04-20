package com.example.myapplication1.com.cse5324.team6.util;

public class ParkingSpot {
    private String areaName;
    private int parkingNum;
    private int floor;
    private ParkingType parkginType;

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public ParkingSpot(){
        areaName = new String("");
        parkingNum = -1;
        floor = -1;
        parkginType = ParkingType.Basic;
    }

    public ParkingSpot(String _areaName, int _floor, ParkingType _type, int _parkingNum){
        areaName = _areaName;
        parkingNum = _parkingNum;
        floor = _floor;
        parkginType = _type;
    }

    public int getParkingNum() {
        return parkingNum;
    }

    public void setParkingNum(int parkingNum) {
        this.parkingNum = parkingNum;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public ParkingType getParkginType() {
        return parkginType;
    }

    public void setParkginType(ParkingType parkginType) {
        this.parkginType = parkginType;
    }
}
