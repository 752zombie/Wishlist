package com.example.wishlist.controllers;

import com.example.wishlist.services.DatabaseConnection;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Connection;

@Controller
public class WishListController {
    @GetMapping("/")
    @ResponseBody
    public String test() {
        Connection connection = DatabaseConnection.getConnection();
        return "hej";
    }
}
