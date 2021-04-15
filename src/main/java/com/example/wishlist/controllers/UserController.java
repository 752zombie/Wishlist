package com.example.wishlist.controllers;

import com.example.wishlist.models.Wish;
import com.example.wishlist.models.Wishlist;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class UserController {



    @GetMapping("changeUserInfo")
    public String userInfo(Model model){

       // ArrayList<Wish> wishes = wishlist.getWishes();

        // model.addAttribute(wishes);

        return "user.html";
    }



}
