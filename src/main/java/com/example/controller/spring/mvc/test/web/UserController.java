package com.example.controller.spring.mvc.test.web;


import com.example.controller.spring.mvc.test.doa.Entities.UserEntity;
import com.example.controller.spring.mvc.test.doa.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController  {

     @Autowired
     private UserRepo user ;


     @GetMapping("/AddUser")
     public String AddUser(Model model){


         model.addAttribute("User",new UserEntity());

         return "Forms/SignUp";


     }

    @PostMapping("/SaveUser")

     public String SaveUser(@ModelAttribute("User") UserEntity User ){

         user.save(User);

         return "redirect:cc";

     }


}
