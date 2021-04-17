package com.example.wishlist.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {



    @GetMapping("changeUserInfo")
    public String userInfo(Model model){

       // ArrayList<Wish> wishes = wishlist.getWishes();

        // model.addAttribute(wishes);

        return "user.html";
    }





}
