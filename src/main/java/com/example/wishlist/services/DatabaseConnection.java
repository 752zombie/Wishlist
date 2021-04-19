package com.example.wishlist.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@Configuration
@PropertySource("classpath:application.properties")
public class DatabaseConnection {
    private static Connection connection;

    @Value("${url}")
    public static String url;

    @Value("${user}")
    public static String user;

    @Value("${password}")
    public static String password;


    public static Connection getConnection() {

        if (connection != null) {
            return connection;
        }

        try {
            /*InputStream input = new FileInputStream("./WEB-INF/classes/application.properties");
            Properties properties = new Properties();
            properties.load(input); */
            //String url = properties.getProperty("url");
            //String user = properties.getProperty("user");
            //String password = properties.getProperty("password");

            //String url = "jdbc:mysql://localhost:3306/wishlist_project";
            connection = DriverManager.getConnection(url, user, password);
        }
/*
        catch (IOException e) {
            System.out.println("Error with application.properties file");
        }*/

        catch (SQLException e) {
            System.out.println(e);
            System.out.println("Error: connection to database could not be established");
        }

        return connection;
    }
}