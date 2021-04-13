package com.example.wishlist.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection;

    public static Connection getConnection() {

        if (connection != null) {
            return connection;
        }

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_dept", "root", "notperma");
        }

        catch (SQLException e) {
            System.out.println("Error: connection to database could not be established");
        }

        return connection;
    }
}