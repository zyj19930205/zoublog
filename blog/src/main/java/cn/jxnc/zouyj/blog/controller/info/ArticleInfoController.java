package cn.jxnc.zouyj.blog.controller.info;

import cn.jxnc.zouyj.blog.entity.Article;
import cn.jxnc.zouyj.blog.entity.bo.ArticleBo;
import cn.jxnc.zouyj.blog.mapper.ArticleMapper;
import cn.jxnc.zouyj.blog.service.ArticleService;
import cn.jxnc.zouyj.blog.util.EntityResponse;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
    public IPage<ArticleBo> getArticleInfo(){
        Page<ArticleBo> page=new Page<ArticleBo>(1,8);
        //IPage<Article> selectPage=articleMapper.selectPage(page,null);
        IPage<ArticleBo> articleBoIPage=articleMapper.findByPage(page);
       // List<ArticleBo> articles=articleMapper.selectArticles();
        return articleBoIPage;
    }


}
