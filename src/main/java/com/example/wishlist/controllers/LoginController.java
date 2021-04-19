package com.example.wishlist.controllers;

import com.example.wishlist.models.User;
import com.example.wishlist.services.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;
import java.util.NoSuchElementException;

@Controller
public class LoginController {

    @GetMapping("/sign-out")
    public String signOut(HttpSession session) {

        session.invalidate();
        return "redirect:/";
    }


    @GetMapping("/sign-in")
    public String signIn(){
        return "login";
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
            return "signupFailed";
        }

        return "index";
    }

    @PostMapping("/sign-in")
    public String signIn(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session) {

        try {
            User user = UserRepository.attemptLogin(email, password);
            session.setAttribute("user", user);
            return  "redirect:/";
        }

        //incorrect email or password
        catch (NoSuchElementException e) {
            return "loginFailed";
        }
    }

    @GetMapping("/sign-up")
    public String signUp() {
        return "signup";
    }

}
