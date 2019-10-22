package cn.jxnc.zouyj.blog.controller.admin;


import cn.jxnc.zouyj.blog.entity.Article;
import cn.jxnc.zouyj.blog.entity.Author;
import cn.jxnc.zouyj.blog.entity.Tag;
import cn.jxnc.zouyj.blog.entity.bo.ArticleBo;
import cn.jxnc.zouyj.blog.mapper.ArticleMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    ArticleMapper articleMapper;


    @RequestMapping("/tables")
    public String toTables(Model model, @RequestParam(value = "limit",defaultValue = "8") int limit, @RequestParam(value="pageNo",defaultValue = "1")
            int pageNo){
        Page<ArticleBo> articleIPage=new Page<ArticleBo>(pageNo,limit);
        IPage<ArticleBo> articles=articleMapper.findByPage(articleIPage);
        //List<ArticleBo> articleBoList=articleService.getAllArticle();
//        List<Author> authors=authorService.getAllAuthor();
//        List<Tag> tagList=tagService.getAllTags();
        model.addAttribute("articles",articles);
//        model.addAttribute("author",authors);
//        model.addAttribute("tags",tagList);
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
