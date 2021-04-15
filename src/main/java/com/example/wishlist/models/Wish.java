package com.example.wishlist.models;

public class Wish {
    private int id;
    private int quantity;
    private String name;
    private String url;
    private int price;

    public Wish(int id, String name, String url, int amount, int price) {
        this.quantity = amount;
        this.name = name;
        this.url = url;
        this.price = price;
        this.id = id;

    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

    @Override
    public String toString() {
        return "Wish{" +
                "id=" + id +
                ", amount=" + quantity +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
