package com.example.wishlist.controllers;


import com.example.wishlist.models.User;
import com.example.wishlist.models.UserList;
import com.example.wishlist.services.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.NoSuchElementException;

@Controller
public class LoginController {


    @GetMapping("/sign-in")
    public String signIn(){

        return "login.html";
    }

    @PostMapping("/sign-up")
    public String login(@RequestParam("name") String name, @RequestParam("email") String eMail,
                        @RequestParam("password") String password, HttpSession session){

        //User created successfully and should now be logged in
        if (UserRepository.addUser(name, eMail, password)) {
            User user = UserRepository.attemptLogin(eMail, password);
            session.setAttribute("user", user);
        }

        //User already exists
        else {
            //add error handling here
        }

        return "index.html";
    }

    @PostMapping("/sign-in")
    public String signIn(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session) {

        try {
            User user = UserRepository.attemptLogin(email, password);
            session.setAttribute("user", user);
            return "index";
        }

        //incorrect email or password
        catch (NoSuchElementException e) {
            //handle this situation here
            return "login";
        }
    }

    @GetMapping("/sign-up")
    public String signUp() {
        return "signup";
    }

}
