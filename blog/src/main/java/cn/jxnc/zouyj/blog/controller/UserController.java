package cn.jxnc.zouyj.blog.controller;


import cn.jxnc.zouyj.blog.constant.WebConstant;
import cn.jxnc.zouyj.blog.entity.User;
import cn.jxnc.zouyj.blog.mapper.ArticleMapper;
import cn.jxnc.zouyj.blog.mapper.TagMapper;
import cn.jxnc.zouyj.blog.mapper.UserMapper;
import cn.jxnc.zouyj.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class UserController {

    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    UserService userService;
    @Autowired
    TagMapper tagMapper;
    @Autowired
    UserMapper userMapper;

    private final ResourceLoader resourceLoader;
    @Value("${web.upload-path}")
    private String path;

    @Autowired
    public UserController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

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

    /**
     * 根据ID查询图片
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/getUserImg/{id}")
    public String getUserImg(@PathVariable int id,Model model){
        String ImgFileUrl=userMapper.selectUserImageById(id);
        model.addAttribute("ImgFileUrl",ImgFileUrl);
        return "test/showImg";
    }

    @RequestMapping("/showImg")
    public ResponseEntity showImg(String fileName){
        try {
            // 由于是读取本机的文件，file是一定要加上的， path是在application配置文件中的路径
            return ResponseEntity.ok(resourceLoader.getResource("file:" + path + fileName));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
