package com.example.wishlist.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WishRepository {

    public static void addWishes(String wishName, int quantity, int price, String url) {
        Connection connection = DatabaseConnection.getConnection();

        try {

            String command = String.format("INSERT INTO wishes (product_name, url, quantity, price) values ('%s', '%s', '%d', '%d')", wishName, url, quantity, price);
            System.out.println(command);
            PreparedStatement statement = connection.prepareStatement(command);
            statement.execute();
        }

        catch (SQLException e) {
            System.out.println("Error adding wish");
        }
    }

}
