package com.example.wishlist.models;

import java.util.ArrayList;
import java.util.List;

public class Wishlist {
    private List<Wish> wishes;

    public Wishlist() {
        this.wishes = new ArrayList<Wish>();
    }

    public Wishlist(List<Wish> wishes) {
        this.wishes = wishes;
    }

    public void addWish(Wish wish) {
        wishes.add(wish);
    }

    public void addWish(String name, String url, int amount) {
        wishes.add(new Wish(name, url, amount));
    }
}
