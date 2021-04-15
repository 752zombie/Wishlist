package com.example.wishlist;

import com.example.wishlist.controllers.LoginController;
import com.example.wishlist.controllers.WishListController;
import com.example.wishlist.models.Wish;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WishlistApplication {
    public static void main(String[] args) {

        WishListController w = new WishListController();

        String n = "N";
        String b = "z";
        String c = "5";




        SpringApplication.run(WishlistApplication.class, args);
    }

}
