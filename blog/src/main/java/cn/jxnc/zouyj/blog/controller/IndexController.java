package cn.jxnc.zouyj.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zouyujie
 * @date 2019/9/27 20:08
 */
@Controller
public class IndexController {

    @RequestMapping({"/",""})
    public String index(){
        return "index";
    }

    @RequestMapping("/haha")
    public String haha(Model model){
        model.addAttribute("haha","xixi");
        return "index";
    }
}
