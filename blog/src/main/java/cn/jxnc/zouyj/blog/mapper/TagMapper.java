package cn.jxnc.zouyj.blog.mapper;

import cn.jxnc.zouyj.blog.entity.Tag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

@Repository
public interface TagMapper extends BaseMapper<Tag> {

    @Insert("insert into z_tag (tagname) values(#{tagName})")
    void addNewTag(String tagName);

    Integer selectFromTagByTagName(String tagName);
}
