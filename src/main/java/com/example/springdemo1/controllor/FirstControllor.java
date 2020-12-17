package com.example.springdemo1.controllor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FirstControllor {

//    @Autowired
//    private Person person;



    @RequestMapping("/home")
    @ResponseBody
    public String home(){

//         return person.toString();
//        return "姓名："+ name + "年龄：" + age;
        return "";
    }

}
