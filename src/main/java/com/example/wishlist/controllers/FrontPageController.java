package com.example.wishlist.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class FrontPageController {


    @GetMapping("/sign-out")
    public String signOut(HttpSession session) {

        session.invalidate();
        return "redirect:/";
    }
}
