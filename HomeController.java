package com.SpringWebApp.SpringWebApp.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {
    //Now Iam adding spring actuator for checking the health of spring application
    @RequestMapping("/")
    public String Home(){
        return "home";
    }
}
