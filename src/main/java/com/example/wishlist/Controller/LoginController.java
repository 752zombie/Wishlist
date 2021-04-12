package com.example.wishlist.Controller;


import com.example.wishlist.Model.User;
import com.example.wishlist.Model.UserList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @PostMapping("login")
    public String login(@RequestParam("name") String name, @RequestParam("eMail") String eMail,
                        @RequestParam("password") String password, @RequestParam("userId") String userId){

        User user = new User(name, eMail, password, Integer.parseInt(userId));
        UserList userList = new UserList();
        userList.addUser(user);
        return "indsætHtml";
    }
}
