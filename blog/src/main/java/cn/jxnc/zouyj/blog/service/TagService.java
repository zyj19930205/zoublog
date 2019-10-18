package cn.jxnc.zouyj.blog.service;

import cn.jxnc.zouyj.blog.entity.Tag;

import java.util.List;

public interface TagService {
    List<Tag> getAllTags();
    Integer IsTagExsit(String tagName);
}
