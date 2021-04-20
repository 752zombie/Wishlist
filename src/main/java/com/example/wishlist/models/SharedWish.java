package com.example.wishlist.models;

public class SharedWish {

    private String sharerName;
    private String productName;
    private String url;
    private int quantity;
    private int price;

    public SharedWish(String sharer_name, String product_name, String url, int quantity, int price) {
        this.sharerName = sharer_name;
        this.quantity = quantity;
        this.productName = product_name;
        this.url = url;
        this.price = price;
    }

    public String getSharerName() {
        return sharerName;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return productName;
    }

    public String getUrl() {
        return url;
    }

    public int getPrice() {
        return price;
    }

    public void setSharerName(String sharerName) {
        this.sharerName = sharerName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "SharedWish{" +
                "sharer_name='" + sharerName + '\'' +
                ", quantity=" + quantity +
                ", product_name='" + productName + '\'' +
                ", url='" + url + '\'' +
                ", price=" + price +
                '}';
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
