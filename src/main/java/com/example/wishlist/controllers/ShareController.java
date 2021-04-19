package com.example.wishlist.controllers;

import com.example.wishlist.models.SharedWish;
import com.example.wishlist.models.User;
import com.example.wishlist.models.Wish;
import com.example.wishlist.services.ShareRepository;
import com.example.wishlist.services.WishRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.util.ArrayList;

@Controller
public class ShareController {



    @GetMapping("/share-list")
    public String whoToShareWithForm(){

        return "shareWishlist.html";

    }

    @PostMapping("share-wishlist")
    public String shareRequest(@RequestParam("receiverName") String receiverName, HttpSession session){


        User user = (User) session.getAttribute("user");
        ArrayList<Wish> wishes = WishRepository.getWishList(user.getId());

        ShareRepository.shareWishlist(receiverName, wishes, user.getId());


     return "shareCompleted.html";

    }

    @GetMapping("/seeSharedWish")
    public String seeSharedWishlist(HttpSession session, Model model){


        User user = (User) session.getAttribute("user");

       ArrayList<SharedWish> sharedWishes = ShareRepository.getSharedWishList(user.getId());

        model.addAttribute("sharedWishes", sharedWishes);

        return "seeSharedWishlist";

    }

}
