package com.example.wishlist.controllers;

import com.example.wishlist.services.DatabaseConnection;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WishListController {

    @GetMapping("/wish-list")
    public String createWish(){

        DatabaseConnection.getConnection();

        return "wishPage.html";

    }
}
