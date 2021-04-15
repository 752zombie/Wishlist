package com.example.wishlist.controllers;


import com.example.wishlist.models.User;
import com.example.wishlist.models.UserList;
import com.example.wishlist.services.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

   public UserRepository userRepository;

    @GetMapping("sign-in")
    public String signIn(){

        return "login.html";
    }

    @PostMapping("sign-in-saved")
    public String login(@RequestParam("name") String name, @RequestParam("email") String eMail,
                        @RequestParam("password") String password, HttpSession session){



        UserRepository.addUser(name, eMail, password);

        session.setAttribute("user", name);

        return "index.html";
    }
}
