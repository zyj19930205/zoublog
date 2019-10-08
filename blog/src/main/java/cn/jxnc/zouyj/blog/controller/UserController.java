package cn.jxnc.zouyj.blog.controller;


import cn.jxnc.zouyj.blog.constant.WebConstant;
import cn.jxnc.zouyj.blog.entity.User;
import cn.jxnc.zouyj.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("admin")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/loginpage")
    public String loginPage(){
        return "admin/login";
    }

    @PostMapping(value = "login")
    @ResponseBody
    public String login(@RequestParam String username, @RequestParam String password, HttpServletRequest request){
        User user=userService.login(username,password);
        if(user!=null){
            request.getSession().setAttribute(WebConstant.LOGIN_SESSION_KEY,user);
            return "success!";
        }
        return "error!";
    }
}
