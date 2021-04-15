package com.example.wishlist.services;

import com.example.wishlist.models.User;
import com.example.wishlist.models.UserAttribute;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRepository {

    public static boolean addUser(String name, String email, String password) {
        Connection connection = DatabaseConnection.getConnection();

        try {
            String command = String.format("INSERT INTO users (user_name, email, user_password) values ('%s', '%s', MD5('%s'))", name, email, password);
            PreparedStatement statement = connection.prepareStatement(command);
            statement.execute();
            return true;
        }

        catch (SQLException e) {
            System.out.println("Error adding user");
            return false;
        }
    }

    public static boolean addUser(User user) {
        return addUser(user.getName(), user.getEmail(), user.getPassword());
    }

    public static void removeUser(int userid) {
        Connection connection = DatabaseConnection.getConnection();

        try {
            String command = String.format("DELETE FROM users WHERE user_id = %d", userid);
            PreparedStatement statement = connection.prepareStatement(command);
            statement.execute();
            command = String.format("DELETE FROM users_wishes WHERE user_id = %d", userid);
            statement = connection.prepareStatement(command);
            statement.execute();

        }

        catch (SQLException e) {
            System.out.println("Error deleting user");
        }
    }

    public static void removeUser(User user) {
        removeUser(user.getId());
    }

    public static void updateUserInfo(int userId, UserAttribute attributeToUpdate, String newValueOfAttribute) {
        Connection connection = DatabaseConnection.getConnection();

        try {
            String command;
            String column = userAttributeToColumn(attributeToUpdate);

            if (column.equals("user_password")) {
                command = String.format("UPDATE users SET user_password = MD5('%s') WHERE user_id = %d", newValueOfAttribute, userId);
            }

            else {
                command = String.format("UPDATE users SET %s = '%s' WHERE user_id = %d", column, newValueOfAttribute, userId);
            }
            PreparedStatement statement = connection.prepareStatement(command);
            statement.execute();
        }

        catch (SQLException e) {
            System.out.println("Error updating user info");
        }
    }



    private static String userAttributeToColumn(UserAttribute attribute) {
        switch (attribute) {
            case name:
                return "user_name";
            case email:
                return "email";
            case password:
                return "user_password";
            default:
                return "invalid";
        }
    }
}
