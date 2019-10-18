package cn.jxnc.zouyj.blog.controller;


import cn.jxnc.zouyj.blog.constant.WebConstant;
import cn.jxnc.zouyj.blog.entity.User;
import cn.jxnc.zouyj.blog.mapper.ArticleMapper;
import cn.jxnc.zouyj.blog.mapper.TagMapper;
import cn.jxnc.zouyj.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class UserController {

    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    UserService userService;
    @Autowired
    TagMapper tagMapper;



    @RequestMapping(value = {""})
    public String loginPage(){
        return "admin/login";
    }

    @PostMapping(value = "/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpServletRequest request){
        User user=userService.login(username,password);
        if(user!=null){
            HttpSession session=request.getSession();
            session.setAttribute("user",user);
            System.out.println("在登陆环节中"+session.getAttribute("user"));
            return "forward:/getArticle";
        }
        return "error!";
    }

    @RequestMapping("/toIndex")
    public String toIndex(Model model){
        int article_count=articleMapper.selectCount(null);
        int tag_count=tagMapper.selectCount(null);
        model.addAttribute("count",article_count);
        model.addAttribute("tag_count",tag_count);
        return "admin/index";
    }
}
