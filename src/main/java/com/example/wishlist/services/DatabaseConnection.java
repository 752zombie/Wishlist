package com.example.wishlist.services;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
    private static Connection connection;

    public static Connection getConnection() {

        if (connection != null) {
            return connection;
        }

        try {
            InputStream input = new FileInputStream("src/main/resources/application.properties");
            Properties properties = new Properties();
            properties.load(input);
            String url = properties.getProperty("url");
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            connection = DriverManager.getConnection(url, user, password);
        }

        catch (IOException e) {
            System.out.println("Error with application.properties file");
        }

        catch (SQLException e) {
            System.out.println("Error: connection to database could not be established");
        }

        return connection;
    }
}