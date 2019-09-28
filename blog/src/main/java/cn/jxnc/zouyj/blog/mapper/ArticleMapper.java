package cn.jxnc.zouyj.blog.mapper;

import cn.jxnc.zouyj.blog.entity.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author zouyujie
 * @date 2019/9/27 20:25
 */
@Repository
public interface ArticleMapper extends BaseMapper<Article> {

}
