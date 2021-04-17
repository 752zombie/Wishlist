package com.example.wishlist.controllers;

import com.example.wishlist.models.User;
import com.example.wishlist.models.Wish;
import com.example.wishlist.services.UserRepository;
import com.example.wishlist.services.WishRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class ShareController {



    @GetMapping("/share-list")
    public String whoToShareWithForm(Model model){




        return "shareWishlist.html";

    }

    @PostMapping("share-wishlist")
    public String shareRequest(@RequestParam("username") String username, HttpSession session){


        User user = (User) session.getAttribute("user");
        ArrayList<Wish> wishes = WishRepository.getWishList(user.getId());
        UserRepository.shareWishlist(username, wishes);


     return "shareCompleted.html";

    }

}
