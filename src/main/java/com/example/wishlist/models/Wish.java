package com.example.wishlist.models;

public class Wish {
    private int id;
    private static int nextId = 0;
    private int amount;
    private String name;
    private String url;

    public Wish(String name, String url, int amount) {
        this.amount = amount;
        this.name = name;
        this.url = url;
        this.id = ++nextId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Wish.nextId = nextId;
    }
}
