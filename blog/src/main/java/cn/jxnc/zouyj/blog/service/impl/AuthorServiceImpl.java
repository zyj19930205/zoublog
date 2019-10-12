package cn.jxnc.zouyj.blog.service.impl;

import cn.jxnc.zouyj.blog.entity.Article;
import cn.jxnc.zouyj.blog.entity.Author;
import cn.jxnc.zouyj.blog.mapper.AuthorMapper;
import cn.jxnc.zouyj.blog.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    AuthorMapper authorMapper;

    @Override
    public List<Author> getAllAuthor() {
        return authorMapper.selectList(null);
    }


}
