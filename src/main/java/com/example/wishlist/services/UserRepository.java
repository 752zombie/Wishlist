package com.example.wishlist.services;

import com.example.wishlist.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRepository {

    public static void addUser(String name, String email, String password) {
        Connection connection = DatabaseConnection.getConnection();

        try {
            String query = String.format("INSERT INTO users (user_name, email, user_password) values ('%s', '%s', MD5('%s'))", name, email, password);
            System.out.println(query);
            PreparedStatement statement = connection.prepareStatement(query);
            statement.execute();
        }

        catch (SQLException e) {
            System.out.println("Something went wrong");
        }
    }

    public static void addUser(User user) {
        addUser(user.getName(), user.getEmail(), user.getPassword());
    }
}
