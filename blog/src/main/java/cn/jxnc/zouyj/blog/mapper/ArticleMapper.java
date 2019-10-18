package cn.jxnc.zouyj.blog.mapper;

import cn.jxnc.zouyj.blog.entity.Article;
import cn.jxnc.zouyj.blog.entity.bo.ArticleBo;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zouyujie
 * @date 2019/9/27 20:25
 */
@CacheConfig(cacheNames = "article")
@Repository
public interface ArticleMapper extends BaseMapper<Article> {


    List<ArticleBo> selectArticles();

    List<ArticleBo> selectArticlesByTagId(int id);

    IPage<ArticleBo> findByPage(Page<ArticleBo> articleBoPage);

    Integer updateArticleHits(int id);

    void insertToAct(int aid,int tid);
}
