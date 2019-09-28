package cn.jxnc.zouyj.blog.controller.info;

import cn.jxnc.zouyj.blog.entity.Article;
import cn.jxnc.zouyj.blog.service.ArticleService;
import cn.jxnc.zouyj.blog.util.EntityResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zouyujie
 * @date 2019/9/28 11:19
 */
@RestController
public class ArticleInfoController {

    @Autowired
    ArticleService articleService;

    @RequestMapping("/getArticleInfo")
    public EntityResponse<List<Article>> getArticleInfo(){
        List<Article> articles=articleService.getAllArticle();
        return new EntityResponse<List<Article>>().success(articles);
    }
}
