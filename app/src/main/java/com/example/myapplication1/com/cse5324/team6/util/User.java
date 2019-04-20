package com.example.myapplication1.com.cse5324.team6.util;

import java.util.ArrayList;
import android.util.Log;

public class User {

    public String firstName;
    public String lastName;
    public String username;
    public String password;
    public int utaId;
    public int phone;
    public String email;
    public String permitType;
    public String userType;
    public String carInfo;
    public int licenseNumber;

    private ArrayList<ReservationDetails> reservationList;

    public User(){
        reservationList = new ArrayList<ReservationDetails>();
    }

    public ReservationDetails getReservation(int idx) {
        return reservationList.get(idx);
    }

    public void addReservation(ReservationDetails res){
        reservationList.add(res);
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUtaId() {
        return utaId;
    }

    public void setUtaId(int utaId) {
        this.utaId = utaId;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPermitType() {
        return permitType;
    }

    public void setPermitType(String permitType) {
        this.permitType = permitType;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getCarInfo() {
        return carInfo;
    }

    public void setCarInfo(String carInfo) {
        this.carInfo = carInfo;
    }

    public int getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(int licenseNumber) {
        this.licenseNumber = licenseNumber;
    }
}
