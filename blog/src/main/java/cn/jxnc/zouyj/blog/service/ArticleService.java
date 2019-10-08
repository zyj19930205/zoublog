package cn.jxnc.zouyj.blog.service;

import cn.jxnc.zouyj.blog.entity.Article;
import cn.jxnc.zouyj.blog.entity.bo.ArticleBo;

import java.util.List;

/**
 * @author zouyujie
 * @date 2019/9/27 20:26
 */
public interface ArticleService {
    List<ArticleBo> getAllArticle();
    Article getArticleById(Integer aid);
    Integer delArticleById(Integer aid);
    void updateArticle(Article article);
    void addArticle(Article article);

}
