package com.example.wishlist.services;

import com.example.wishlist.models.SharedWish;
import com.example.wishlist.models.Wish;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ShareRepository {

    public static void shareWishlist(String receiverName, ArrayList<Wish> wishes, int userId) {

        Connection connection = DatabaseConnection.getConnection();

        try {
            for (Wish wish : wishes) {
                int receiverId = getReceiverId(receiverName);

                String command = String.format("INSERT INTO shared_list (sharing_user_id, reciever_id, product_name, url, quantity, price) VALUES (%d, %d, '%s', '%s', %d, %d)", userId, receiverId, wish.getName(), wish.getUrl(), wish.getQuantity(), wish.getPrice());
                PreparedStatement statement = connection.prepareStatement(command);
                statement.executeUpdate();

            }
        } catch (SQLException e) {
            System.out.println("Error sharing wishlist");
        }
    }


    private static int getReceiverId(String username) {

        Connection connection = DatabaseConnection.getConnection();
        int receiver_id = 0;

        try {

            String command = String.format("SELECT * FROM users WHERE user_name = '%s'", username);
            PreparedStatement statement = connection.prepareStatement(command);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                receiver_id = resultSet.getInt("user_id");
            }

        } catch (SQLException s) {
            System.out.println("Something went wrong getting user id");
        }
        return receiver_id;
    }


    public static ArrayList<SharedWish> getSharedWishList(int userId) {


        Connection connection = DatabaseConnection.getConnection();
        ArrayList<SharedWish> wishes = new ArrayList<>();

        int sharer_id;

        try {

            String command = String.format("SELECT * FROM shared_list WHERE reciever_id = %d", userId);
            PreparedStatement statement = connection.prepareStatement(command);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                sharer_id = resultSet.getInt("sharing_user_id");
                String sharer_name = getSharingUsername(sharer_id);
                String product = resultSet.getString("product_name");
                String url = resultSet.getString("url");
                int quantity = resultSet.getInt("quantity");
                int price = resultSet.getInt("price");
                wishes.add(new SharedWish(sharer_name, product, url, quantity, price));
            }
        } catch (SQLException e) {
            System.out.println("Error deleting wishlist");
        }

        return wishes;
    }

    private static String getSharingUsername(int sharer_id) {

        Connection connection = DatabaseConnection.getConnection();
        String sharer_name = "";

        try {

            String command = String.format("SELECT * FROM users WHERE user_id = %d", sharer_id);
            PreparedStatement statement = connection.prepareStatement(command);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                sharer_name = resultSet.getString("user_name");

            }

        } catch (SQLException s) {

            System.out.println("something went wrong");
        }
        return sharer_name;
    }

    public static void deleteSharelist(int userid) {
        Connection connection = DatabaseConnection.getConnection();

        try {
            String command = String.format("DELETE FROM shared_list WHERE sharing_user_id = %d", userid);
            PreparedStatement statement = connection.prepareStatement(command);
            statement.executeUpdate();
        }

        catch (SQLException e) {
            System.out.println("Error deleting shared list");
        }
    }
}