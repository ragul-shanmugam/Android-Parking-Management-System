package com.example.myapplication1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

public class ReservationController {

    public boolean isReservationMade = false;
    String sqlMakeReservation;
    String sqlViewReservation;
    DBConnection dbConnection;
    private Date date;
    private Time startTime;
    private int duration = 0;
    private String parkingType = null;
    private String parkingArea = null;
    private int floor = 0;

    public boolean makeReservation(Date date, Time startTime, int duration, String parkingType, String parkingArea, int floor) throws SQLException {

        sqlMakeReservation = "insert into values(" + date + "," + startTime + "," + duration + "," + parkingType + "," + parkingArea + "," + floor + ")";

        Connection conn = dbConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sqlMakeReservation);
        ps.executeQuery();

        if(ps.getUpdateCount() > 0)
        {
            isReservationMade = true;
        }
        conn.close();

        return isReservationMade;
    }

    public void viewPastReservation(String username) throws SQLException {

        //TODO: Limit row to 5 in the query

        sqlViewReservation = "select * from reservation where username like " + username;
        Connection conn = dbConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sqlViewReservation);

        ResultSet rs = ps.executeQuery();

        while (rs.next())
        {

        }

    }

}
