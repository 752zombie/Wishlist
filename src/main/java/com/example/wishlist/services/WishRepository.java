package com.example.wishlist.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WishRepository {

    public static void addWishes(String wishName, int amount, int price, String url) {
        Connection connection = DatabaseConnection.getConnection();

        try {
            String command = String.format("INSERT INTO wishes (product_name, amount, price, url) values ('%s', '%d', %d, %%s", wishName, amount, price, url);
            System.out.println(command);
            PreparedStatement statement = connection.prepareStatement(command);
            statement.execute();
        }

        catch (SQLException e) {
            System.out.println("Error adding wish");
        }
    }

}
