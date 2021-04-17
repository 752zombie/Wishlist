package com.example.wishlist.controllers;

import com.example.wishlist.models.User;
import com.example.wishlist.models.Wish;
import com.example.wishlist.services.WishRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.InputMismatchException;

@Controller
public class WishListController {


    @GetMapping("/wish-list")
    public String createWish(){

        return "createWish.html";

    }



    @PostMapping("wish-saved")
    public String createWish(@RequestParam("nameWish") String nameWish, @RequestParam("price") String price, @RequestParam("quantity") String quantity,
                             @RequestParam("linkToWish") String linkToWish, HttpSession session){

   try {

       User user = (User) session.getAttribute("user");
       WishRepository.addWish(nameWish, Integer.parseInt(quantity), Integer.parseInt(price), linkToWish, user.getId());


       return "createWish.html";
   }

   catch (NumberFormatException n){

       return "wishFailed.html";
   }
    }

    @GetMapping("see-wishlist")
    public String seeWishlist(HttpSession session, Model model){

       User user = (User) session.getAttribute("user");

       ArrayList<Wish> wishlist = WishRepository.getWishList(user.getId());

       model.addAttribute("wishlist", wishlist);


       return "seeWishlist.html";

    }

    @GetMapping("deleteWishList")
    public String deleteWishes(HttpSession session){


        User user = (User) session.getAttribute("user");

        WishRepository.deleteWishlist(user.getId());


        return "seeWishlist.html";
    }

    @GetMapping("/return-frontPage")
    public String returnFrontpage(){

        return "redirect:/";
    }

}
