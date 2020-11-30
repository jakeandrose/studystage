package com.example.springdemo1.controllor;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class FirstControllor {

    @RequestMapping("/home")
    @ResponseBody
    public String home(){
        return "first controller";
    }

}