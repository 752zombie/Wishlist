package com.example.wishlist.services;

import com.example.wishlist.models.Wish;
import com.example.wishlist.models.Wishlist;

import com.example.wishlist.models.Wish;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class WishRepository {

    public static void addWish(String wishName, int quantity, int price, String url, int userId) {
        Connection connection = DatabaseConnection.getConnection();

        try {

            String command = String.format("INSERT INTO wishes (product_name, url, quantity, price, user_id) values ('%s', '%s', '%d', '%d', %d)", wishName, url, quantity, price, userId);
            System.out.println(command);
            PreparedStatement statement = connection.prepareStatement(command);
            statement.execute();


        }

        catch (SQLException e) {
            System.out.println("Error adding wish");
        }
    }


    public static void removeWish(int wishId) {
        Connection connection = DatabaseConnection.getConnection();

        try {
            String command = String.format("DELETE FROM wishes WHERE wish_id = %d", wishId);
            PreparedStatement statement = connection.prepareStatement(command);
            statement.execute();
        }

        catch (SQLException e) {
            System.out.println("Error removing wish");
        }
    }

    public static void deleteWishlist(int userid) {
        Connection connection = DatabaseConnection.getConnection();

        try {
            String command = String.format("DELETE FROM wishes WHERE user_id = %d", userid);
            PreparedStatement statement = connection.prepareStatement(command);
            statement.execute();
        }

        catch (SQLException e) {
            System.out.println("Error deleting wishlist");
        }
    }

    public static ArrayList<Wish> getWishList(int userid) {
        Connection connection = DatabaseConnection.getConnection();
      //  Wishlist wishlist = new Wishlist();
        ArrayList<Wish> wishlist = new ArrayList<>();

        try {
            ArrayList<Wish> wishes = new ArrayList<>();
            String command = String.format("SELECT * FROM wishes WHERE user_id = %d", userid);
            PreparedStatement statement = connection.prepareStatement(command);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("wish_id");
                String product = resultSet.getString("product_name");
                String url =  resultSet.getString("url");
                int quantity = resultSet.getInt("quantity");
                int price = resultSet.getInt("price");
                wishlist.add(new Wish(id, product, url, quantity, price));
            }
        }

        catch (SQLException e) {
            System.out.println("Error deleting wishlist");
        }

        return wishlist;
    }

    public static void changeWishQuantity(int wishId, int amount) {
        Connection connection = DatabaseConnection.getConnection();

        try {
            String command = String.format("UPDATE wishes SET quantity = quantity + %d WHERE wish_id = %d", amount, wishId);
            PreparedStatement statement = connection.prepareStatement(command);
            statement.execute();
        }

        catch (SQLException e) {
            System.out.println("Error deleting wishlist");
        }
    }







}
