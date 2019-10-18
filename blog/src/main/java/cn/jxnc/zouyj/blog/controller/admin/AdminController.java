package cn.jxnc.zouyj.blog.controller.admin;


import cn.jxnc.zouyj.blog.entity.Article;
import cn.jxnc.zouyj.blog.entity.bo.ArticleBo;
import cn.jxnc.zouyj.blog.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    ArticleMapper articleMapper;

    @RequestMapping("/tables")
    public String toTables(Model model){
        List<ArticleBo> articles=articleMapper.selectArticles();
        model.addAttribute("articles",articles);
        return "admin/tables";
    }

    @RequestMapping("/charts")
    public String toCharts(){
        return "admin/charts";
    }

    @RequestMapping("/forms")
    public String toForms(){
        return "admin/forms";
    }

    @RequestMapping("/header")
    public String toheader(){
        return "admin/header";
    }


}
