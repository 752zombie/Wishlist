package com.example.wishlist.Model;

import java.util.ArrayList;

public class UserList {

    private ArrayList<User> userList;


    public ArrayList<User> getUserList() {
        return userList;
    }

    public void addUser(User user) {
        userList.add(user);
    }
}
