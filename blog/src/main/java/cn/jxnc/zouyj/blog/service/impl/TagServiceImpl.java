package cn.jxnc.zouyj.blog.service.impl;

import cn.jxnc.zouyj.blog.entity.Tag;
import cn.jxnc.zouyj.blog.mapper.TagMapper;
import cn.jxnc.zouyj.blog.service.TagService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    TagMapper tagMapper;

    @Override
    public List<Tag> getAllTags() {
        return tagMapper.selectList(null);
    }

    /**
     * 查询tag是否存在，如果存在返回1
     * @param tagName
     * @return
     */
    @Override
    public Integer IsTagExsit(String tagName) {
        QueryWrapper<Tag> tagQueryWrapper=new QueryWrapper<Tag>().eq("tagname",tagName);
        if(tagMapper.selectOne(tagQueryWrapper)!=null){
            return 1;
        };
        return 0;
    }
}
