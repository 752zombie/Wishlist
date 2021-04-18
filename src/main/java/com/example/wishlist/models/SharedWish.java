package com.example.wishlist.models;

public class SharedWish {

    private String sharer_name;
    private String product_name;
    private String url;
    private int quantity;
    private int price;

    public SharedWish(String sharer_name, String product_name, String url, int quantity, int price) {
        this.sharer_name = sharer_name;
        this.quantity = quantity;
        this.product_name = product_name;
        this.url = url;
        this.price = price;
    }

    public String getSharer_name() {
        return sharer_name;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return product_name;
    }

    public String getUrl() {
        return url;
    }

    public int getPrice() {
        return price;
    }

    public void setSharer_name(String sharer_name) {
        this.sharer_name = sharer_name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "SharedWish{" +
                "sharer_name='" + sharer_name + '\'' +
                ", quantity=" + quantity +
                ", product_name='" + product_name + '\'' +
                ", url='" + url + '\'' +
                ", price=" + price +
                '}';
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
