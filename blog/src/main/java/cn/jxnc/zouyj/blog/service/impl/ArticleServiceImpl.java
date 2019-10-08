package cn.jxnc.zouyj.blog.service.impl;

import cn.jxnc.zouyj.blog.entity.Article;
import cn.jxnc.zouyj.blog.entity.bo.ArticleBo;
import cn.jxnc.zouyj.blog.mapper.ArticleMapper;
import cn.jxnc.zouyj.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zouyujie
 * @date 2019/9/27 20:27
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleMapper articleMapper;

    @Override
    public List<ArticleBo> getAllArticle() {
        List<ArticleBo> articles=articleMapper.selectArticles();
        return articles;
    }

    @Override
    public Article getArticleById(Integer aid) {
       Article article=articleMapper.selectById(aid);
        return article;
    }

    @Override
    public Integer delArticleById(Integer aid) {
       Integer result= articleMapper.deleteById(aid);
       return result;
    }

    @Override
    public void updateArticle(Article article) {
        articleMapper.updateById(article);
    }

    @Override
    public void addArticle(Article article) {
        articleMapper.insert(article);
    }

}
