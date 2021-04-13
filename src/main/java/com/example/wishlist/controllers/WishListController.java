package com.example.wishlist.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WishListController {

    @GetMapping("wish-list")
    public String createWish(){

        return "wishPage.html";

    }
}
