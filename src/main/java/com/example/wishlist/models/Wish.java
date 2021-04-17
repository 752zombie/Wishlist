package com.example.wishlist.models;

public class Wish {
    private int id;
    private int quantity;
    private String name;
    private String url;
    private int price;

    public Wish(int id, String name, String url, int quantity, int price) {
        this.quantity = quantity;
        this.name = name;
        this.url = url;
        this.price = price;
        this.id = id;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }
    public String getUrl(){

        return url;
    }

    public int getQuantity(){

        return quantity;
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
