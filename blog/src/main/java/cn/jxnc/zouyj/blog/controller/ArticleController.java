package cn.jxnc.zouyj.blog.controller;

import cn.jxnc.zouyj.blog.constant.WebConstant;
import cn.jxnc.zouyj.blog.entity.Article;
import cn.jxnc.zouyj.blog.entity.Tag;
import cn.jxnc.zouyj.blog.entity.bo.ArticleBo;
import cn.jxnc.zouyj.blog.mapper.ArticleMapper;
import cn.jxnc.zouyj.blog.mapper.TagMapper;
import cn.jxnc.zouyj.blog.service.ArticleService;
import cn.jxnc.zouyj.blog.service.AuthorService;
import cn.jxnc.zouyj.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

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
    @Autowired
    TagService tagService;
    @Autowired
    TagMapper tagMapper;
    /**
     * 获取所有文章
     * @param model
     * @return
     */
    @RequestMapping("/getArticle")
    public String getArticle(Model model, HttpServletRequest request){
        HttpSession session=request.getSession();
        if(session.getAttribute("user")==null){
            System.out.println("在getarticle中"+session.getAttribute("user"));
            request.setAttribute("error","权限不够，请登录");
            return "admin/login";
        }
        List<ArticleBo> articles=articleService.getAllArticle();
        model.addAttribute("article",articles);
        return "admin/articlelist";
    }

    /**
     * 根据id获取文章
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/getArticle/{id}")
    public String getArticle(@PathVariable Integer id,Model model,HttpServletRequest request){
        Article article=articleService.getArticleById(id);
        if(article!=null) {
            if(request.getSession().getAttribute("user")!="admin"){
                articleService.addArticleHits(id);
            }
            model.addAttribute("article", article);
            return "showArticle";
        }else {
            return "error";
        }

    }


    /**
     * 进入发布文章页面
     * @return
     */
    @RequestMapping("/addArticle")
    public String addArticle(){
        return "addArticle";
    }


    /**
     * 发布文章
     * @param article
     * @return
     */
    @PostMapping("/publish")
    public String publishArticle(Article article,HttpServletRequest request){
        articleService.addArticle(article);
        String tagName=request.getParameter("tag");
        Integer result=tagService.IsTagExsit(tagName);
        if(result==0){
            tagMapper.addNewTag(tagName);
        }
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
    public String getArticleByTag(@PathVariable int id, Model model){
        List<ArticleBo> articles=articleMapper.selectArticlesByTagId(id);
        model.addAttribute("article",articles);
        return "taglist";
    }

    /**
     * 统计文章数量
     */
    @GetMapping("/getArticlesCount")
    public String getArticlesCount(Model model){
        int count=articleMapper.selectCount(null);
        model.addAttribute("count",count);
        return "admin/index";
    }
}
