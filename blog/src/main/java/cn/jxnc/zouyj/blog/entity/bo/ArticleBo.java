package cn.jxnc.zouyj.blog.entity.bo;

import cn.jxnc.zouyj.blog.entity.Article;
import cn.jxnc.zouyj.blog.entity.Tag;
import lombok.Data;

import java.util.List;

@Data
public class ArticleBo extends Article {
    private List<Tag> tags;
}
