package com.example.wishlist.controllers;

import com.example.wishlist.models.User;
import com.example.wishlist.models.UserList;
import com.example.wishlist.models.Wish;
import com.example.wishlist.models.Wishlist;
import com.example.wishlist.services.DatabaseConnection;
import com.example.wishlist.services.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class WishListController {




    @GetMapping("/wish-list")
    public String createWish(){

        return "wishPage.html";

    }



    @PostMapping("wish-saved")
    public String createWish(@RequestParam("nameWish") String nameWish, @RequestParam("price") String price, @RequestParam("amount") String amount,
                        @RequestParam("linkToWish") String linkToWish){




        return "wishPage.html";
    }

    @GetMapping("/return-frontPage")
    public String fP(){

        return "redirect:/";
    }

}
