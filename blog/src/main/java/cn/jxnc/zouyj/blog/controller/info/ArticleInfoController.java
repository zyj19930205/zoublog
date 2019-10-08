package cn.jxnc.zouyj.blog.controller.info;

import cn.jxnc.zouyj.blog.entity.Article;
import cn.jxnc.zouyj.blog.entity.bo.ArticleBo;
import cn.jxnc.zouyj.blog.mapper.ArticleMapper;
import cn.jxnc.zouyj.blog.service.ArticleService;
import cn.jxnc.zouyj.blog.util.EntityResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
    @Autowired
    ArticleMapper articleMapper;

    @RequestMapping("/getArticleInfo")
    public EntityResponse<List<Article>> getArticleInfo(){
        List<ArticleBo> articles=articleMapper.selectArticles();
        return new EntityResponse<List<Article>>().success(articles);
    }


}
