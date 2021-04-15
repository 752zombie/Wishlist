package com.example.wishlist.models;

import java.util.ArrayList;
import java.util.List;

public class Wishlist {
    private ArrayList<Wish> wishes;

    public Wishlist() {
        this.wishes = new ArrayList<>();
    }

    public void addWish(Wish wish) {
        wishes.add(wish);



    }

    public ArrayList<Wish> getWishes(){

        System.out.println(wishes.get(0).getName());

        return wishes;
    }

}
