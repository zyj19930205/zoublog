package cn.jxnc.zouyj.blog.mapper;

import cn.jxnc.zouyj.blog.entity.Author;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;



@Mapper
@Repository
public interface AuthorMapper extends BaseMapper<Author> {

}
