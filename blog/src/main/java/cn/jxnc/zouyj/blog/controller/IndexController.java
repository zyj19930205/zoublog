package cn.jxnc.zouyj.blog.controller;

import cn.jxnc.zouyj.blog.entity.Article;
import cn.jxnc.zouyj.blog.entity.Author;
import cn.jxnc.zouyj.blog.entity.bo.ArticleBo;
import cn.jxnc.zouyj.blog.service.ArticleService;
import cn.jxnc.zouyj.blog.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author zouyujie
 * @date 2019/9/27 20:08
 */
@Controller
public class IndexController {
    @Autowired
    ArticleService articleService;
    @Autowired
    AuthorService authorService;

    @RequestMapping({"/",""})
    public String index(Model model){
        List<ArticleBo> articleBoList=articleService.getAllArticle();
        List<Author> authors=authorService.getAllAuthor();
        model.addAttribute("articles",articleBoList);
        model.addAttribute("author",authors);
        return "index";
    }

    @RequestMapping("/haha")
    public String haha(Model model){
        model.addAttribute("haha","xixi");
        return "index";
    }
}
