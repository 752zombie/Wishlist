package com.example.wishlist.controllers;

import com.example.wishlist.models.User;
import com.example.wishlist.models.UserAttribute;
import com.example.wishlist.services.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.NoSuchElementException;

@Controller
public class UserController {



    @GetMapping("/change-user-info")
    public String userInfo(Model model){

       // ArrayList<Wish> wishes = wishlist.getWishes();

        // model.addAttribute(wishes);

        return "user.html";
    }

    @GetMapping("/profile")
    public String profilePage() {
        return "profile";
    }

    @GetMapping("/change-user-name")
    public String usernameChangeForm() {
        return "username-form";
    }

    @PostMapping("/change-user-name")
    public String changeUserName(@RequestParam("name") String username, HttpSession session) {
        User user = (User) session.getAttribute("user");
        UserRepository.updateUserInfo(user.getId(), UserAttribute.name, username);
        return "success";
    }

    @GetMapping("/change-email")
    public String emailChangeForm() {
        return "email-form";
    }

    @PostMapping("/change-email")
    public String changeEmail(@RequestParam("email") String email, HttpSession session) {
        User user = (User) session.getAttribute("user");
        UserRepository.updateUserInfo(user.getId(), UserAttribute.email, email);
        return "success";
    }

    @GetMapping("/change-password")
    public String passwordChangeForm() {
        return "password-form";
    }

    @PostMapping("/change-password")
    public String changePassword(@RequestParam("current-password") String currentPassword,
                                 @RequestParam("new-password") String newPassword,  HttpSession session) {
        User user = (User) session.getAttribute("user");

        try {
            UserRepository.attemptLogin(user.getEmail(), currentPassword);
        }

        catch (NoSuchElementException e) {
            return "password-form";
        }

        UserRepository.updateUserInfo(user.getId(), UserAttribute.password, newPassword);
        return "success";
    }



}
