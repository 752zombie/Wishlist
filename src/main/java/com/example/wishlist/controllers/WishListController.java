package com.example.wishlist.controllers;

import com.example.wishlist.models.User;
import com.example.wishlist.models.UserList;
import com.example.wishlist.models.Wish;
import com.example.wishlist.models.Wishlist;
import com.example.wishlist.services.DatabaseConnection;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class WishListController {

    @GetMapping("/wish-list")
    public String createWish(){

        DatabaseConnection.getConnection();

        return "wishPage.html";

    }

    @PostMapping("wish-saved")
    public String login(@RequestParam("nameWish") String nameWish, @RequestParam("amount") String amount,
                        @RequestParam("linkToWish") String linkToWish){


        Wishlist wishList = new Wishlist();

        Wish wish = new Wish(nameWish, linkToWish, Integer.parseInt(amount));

        wishList.addWish(wish);



        return "index.html";
    }

}
