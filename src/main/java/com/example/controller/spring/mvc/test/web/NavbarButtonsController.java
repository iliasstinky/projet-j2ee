package com.example.controller.spring.mvc.test.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class NavbarButtonsController {

    @GetMapping("/mainbutton")

    public String MytaskNotion(){

        return "pages/main";

    }

    @GetMapping("/KanbanBoard")

    public String MytaskNotion2(){

        return "tasks/indexx";


    }
}
