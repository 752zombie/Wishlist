package com.example.wishlist.models;

import com.example.wishlist.models.User;

import java.util.ArrayList;

public class UserList {

    private ArrayList<User> userList = new ArrayList<>();


    public ArrayList<User> getUserList() {
        return userList;
    }

    public void addUser(User user) {
        userList.add(user);
    }

}
