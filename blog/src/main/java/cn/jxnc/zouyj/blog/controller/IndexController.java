package cn.jxnc.zouyj.blog.controller;

import cn.jxnc.zouyj.blog.entity.Article;
import cn.jxnc.zouyj.blog.entity.Author;
import cn.jxnc.zouyj.blog.entity.Tag;
import cn.jxnc.zouyj.blog.entity.bo.ArticleBo;
import cn.jxnc.zouyj.blog.mapper.ArticleMapper;
import cn.jxnc.zouyj.blog.service.ArticleService;
import cn.jxnc.zouyj.blog.service.AuthorService;
import cn.jxnc.zouyj.blog.service.TagService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author zouyujie
 * @date 2019/9/27 20:08
 */
@Controller
public class IndexController {
    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    ArticleService articleService;
    @Autowired
    AuthorService authorService;
    @Autowired
    TagService tagService;

    @RequestMapping({"/","","/index"})
    public String index(Model model, @RequestParam(value = "limit",defaultValue = "8") int limit,@RequestParam(value="pageNo",defaultValue = "1")
                        int pageNo){
        Page<ArticleBo> articleIPage=new Page<ArticleBo>(pageNo,limit);
        IPage<ArticleBo> articles=articleMapper.findByPage(articleIPage);
        //List<ArticleBo> articleBoList=articleService.getAllArticle();
        List<Author> authors=authorService.getAllAuthor();
        List<Tag> tagList=tagService.getAllTags();
        model.addAttribute("articles",articles);
        model.addAttribute("author",authors);
        model.addAttribute("tags",tagList);
        return "index";
    }


}
