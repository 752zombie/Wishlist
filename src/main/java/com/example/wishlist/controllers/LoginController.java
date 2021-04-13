package com.example.wishlist.controllers;


import com.example.wishlist.models.User;
import com.example.wishlist.models.UserList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {


    @GetMapping("sign-in")
    public String signIn(){

        return "login.html";
    }

    @PostMapping("sign-in-saved")
    public String login(@RequestParam("name") String name, @RequestParam("email") String eMail,
                        @RequestParam("password") String password, HttpSession session){

        UserList userList = new UserList();

        User user = new User(name, eMail, password);

        // do we need a UserList when we add user to DB?
        userList.addUser(user);

        // make call to DB class method(add user)

        session.setAttribute("user", name);

        return "index.html";
    }
}
