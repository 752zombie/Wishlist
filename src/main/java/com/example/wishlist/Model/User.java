package com.example.wishlist.Model;

import java.util.ArrayList;

public class User {

    private String name;
    private String eMail;
    private String password;
    private int userId;

    // private ArrayList<WishList> wishList = new ArrayList<>();


    public User(String name, String eMail, String password, int userId) {
        this.name = name;
        this.eMail = eMail;
        this.password = password;
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return eMail;
    }

    public String getPassword() {
        return password;
    }

    public int getUserId() {
        return userId;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void editUser(){}

    @Override
    public String toString() {
        return  "name='" + name + '\'' +
                ", eMail='" + eMail + '\'' +
                ", password='" + password + '\'' +
                ", userId=" + userId;
    }

}
