package com.example.myapplication1.com.cse5324.team6.controller;

import com.example.myapplication1.com.cse5324.team6.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {
    public boolean isUserAvailable;
    String sql = "select * from login";
    DBConnection dbConnection;
    private String usernameFromDB = null;
    private String passwordFromDB = null;

    public boolean loginCheck(String username, String password) throws SQLException {

        Connection conn = dbConnection.getConnection();

        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while(rs.next()) {
            usernameFromDB = rs.getString(1);
            passwordFromDB = rs.getString(2);
        }
        if(usernameFromDB == username && passwordFromDB == passwordFromDB)
        {
            isUserAvailable = true;
        }

        conn.close();

        return isUserAvailable;
    }
}
