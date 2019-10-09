package cn.jxnc.zouyj.blog.controller;

import cn.jxnc.zouyj.blog.entity.Article;
import cn.jxnc.zouyj.blog.entity.Author;
import cn.jxnc.zouyj.blog.entity.bo.ArticleBo;
import cn.jxnc.zouyj.blog.mapper.ArticleMapper;
import cn.jxnc.zouyj.blog.service.ArticleService;
import cn.jxnc.zouyj.blog.service.AuthorService;
import cn.jxnc.zouyj.blog.util.EntityResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zouyujie
 * @date 2019/9/27 20:29
 */
@Controller
public class ArticleController {

    @Autowired
    ArticleService articleService;
    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    AuthorService authorService;

    /**
     * 获取所有文章
     * @param model
     * @return
     */
    @RequestMapping("/getArticle")
    public String getArticle(Model model){
        List<ArticleBo> articles=articleService.getAllArticle();

        model.addAttribute("article",articles);

        return "articlelist";
    }

    /**
     * 根据id获取文章
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/getArticle/{id}")
    public String getArticle(@PathVariable Integer id,Model model){
        Article article=articleService.getArticleById(id);
        model.addAttribute("article",article);
        return "showArticle";
    }


    @RequestMapping("/addArticle")
    public String addArticle(){
        return "addArticle";
    }

    @PostMapping("/publish")
    public String publishArticle(Article article){
        articleService.addArticle(article);
        return "redirect:/getArticle";
    }



    @RequestMapping("/delArticle/{id}")
    public String delArticle(@PathVariable Integer id){
        Integer result=articleService.delArticleById(id);
        return "redirect:/getArticle";
    }

    /**
     * 跳转到文章编辑页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/editArticle/{id}")
    public String editArticle(@PathVariable Integer id,Model model){
        Article article=articleService.getArticleById(id);
        System.out.println(article);
        model.addAttribute("article",article);
        return "editArticle";
    }

    /**
     * 更新文章
     * @param article
     * @return
     */
    @PostMapping("/updateArticle")
    public String updateArticle(Article article){
        articleService.updateArticle(article);
        return "showArticle";
    }


    /**
     * 根据tag查询文章
     */
    @RequestMapping("/getArticleByTag/{id}")
    public String getArticleByTag(@PathVariable int id,Model model){
        List<ArticleBo> articles=articleMapper.selectArticlesByTagId(id);
        model.addAttribute("article",articles);
        return "taglist";
    }
}
