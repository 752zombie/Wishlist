package com.example.wishlist.controllers;

import com.example.wishlist.models.User;
import com.example.wishlist.models.Wish;
import com.example.wishlist.models.Wishlist;
import com.example.wishlist.services.WishRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class WishListController {


    @GetMapping("/wish-list")
    public String createWish(){

        return "createWish.html";

    }



    @PostMapping("wish-saved")
    public String createWish(@RequestParam("nameWish") String nameWish, @RequestParam("price") String price, @RequestParam("quantity") String quantity,
                             @RequestParam("linkToWish") String linkToWish, HttpSession session){

    User user = (User) session.getAttribute("user");
    WishRepository.addWish(nameWish, Integer.parseInt(price), Integer.parseInt(quantity), linkToWish, user.getId());

        return "createWish.html";
    }

    @GetMapping("see-wishlist")
    public String seeWishlist(HttpSession session, Model model){

       User user = (User) session.getAttribute("user");

       ArrayList<Wish> wishlist = WishRepository.getWishList(user.getId());


        for (Wish wish : wishlist) {
            System.out.println(wish.getName() + " " + wish.getPrice());
        }

        System.out.println(user.getId() + user.getName());

       model.addAttribute("wishlist", wishlist);


       return "seeWishlist.html";

    }

    @GetMapping("/return-frontPage")
    public String returnFrontpage(){

        return "redirect:/";
    }

}
