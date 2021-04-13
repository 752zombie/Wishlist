package com.example.wishlist.controllers;


import com.example.wishlist.models.User;
import com.example.wishlist.models.UserList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @PostMapping("login")
    public String login(@RequestParam("name") String name, @RequestParam("eMail") String eMail,
                        @RequestParam("password") String password, @RequestParam("userId") String userId){

        UserList userList = new UserList();


        User user = new User(name, eMail, password, Integer.parseInt(userId));

        // do we need a UserList when we add user to DB?
        userList.addUser(user);

        // call to DB class method(add user)


        return "login.html";
    }
}
