package com.example.myapplication1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    Connection conn = null;

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url1 = "jdbc:mysql://192.168.1.10:3306/demo";
        String user = "root";
        String password = "mypassword";

        try {
            conn = DriverManager.getConnection(url1, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (conn != null)

        {
            System.out.println("Connected to the database test1");
        }
        return conn;
    }
}