package com.example.wishlist.models;

import java.util.ArrayList;
import java.util.List;

public class Wishlist {
    private List<Wish> wishes;

    public Wishlist() {
        this.wishes = new ArrayList<>();
    }

    public Wishlist(List<Wish> wishes) {
        this.wishes = wishes;
    }

    public void addWish(Wish wish) {
        wishes.add(wish);

    }

    public List<Wish> getWishes(){

        System.out.println(wishes.get(0).getName());

        return wishes;
    }

}
