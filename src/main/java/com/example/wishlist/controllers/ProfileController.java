package com.example.wishlist.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {



    @GetMapping("changeUserInfo")
    public String userInfo(){

        return "profile.html";
    }


    @GetMapping("/change-user-info")
    public String changeSettings(){

        return "profile.html";

    }

}
