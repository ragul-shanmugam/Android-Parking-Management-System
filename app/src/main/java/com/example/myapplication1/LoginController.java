package com.example.myapplication1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {
    public boolean userAvailable;
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

        return userAvailable;
    }
}
