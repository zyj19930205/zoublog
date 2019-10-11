package cn.jxnc.zouyj.blog.service.impl;

import cn.jxnc.zouyj.blog.entity.Tag;
import cn.jxnc.zouyj.blog.mapper.TagMapper;
import cn.jxnc.zouyj.blog.service.TagService;
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
}
