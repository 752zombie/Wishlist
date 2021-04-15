package com.example.wishlist.controllers;

import com.example.wishlist.services.WishRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WishListController {


    @GetMapping("/wish-list")
    public String createWish(){

        return "wishPage.html";

    }



    @PostMapping("wish-saved")
    public String createWish(@RequestParam("nameWish") String nameWish, @RequestParam("price") String price, @RequestParam("quantity") String quantity,
                        @RequestParam("linkToWish") String linkToWish){


    WishRepository.addWish(nameWish, Integer.parseInt(price), Integer.parseInt(quantity), linkToWish);

        return "wishPage.html";
    }

    @GetMapping("/return-frontPage")
    public String fP(){

        return "redirect:/";
    }

}
