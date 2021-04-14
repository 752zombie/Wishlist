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
    public String login(@RequestParam("name") String name, @RequestParam("amount") String amount,
                        @RequestParam("url") String url, HttpSession session){

        Wishlist wishList = new Wishlist();

        Wish wish = new Wish(name, url, Integer.parseInt(amount));

        // do we need a UserList when we add user to DB?
        wishList.addWish(wish);

        // make call to DB class method(add user)

        session.setAttribute("user", name);

        return "index.html";
    }

}
