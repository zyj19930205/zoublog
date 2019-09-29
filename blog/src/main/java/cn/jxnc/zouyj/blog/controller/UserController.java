package cn.jxnc.zouyj.blog.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("/login")
    public String login(@PathVariable String username,@PathVariable String password){
        if(username.equals(null)&&password.equals(null)){

        }
    }
}
