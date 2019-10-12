package cn.jxnc.zouyj.blog.service;

import cn.jxnc.zouyj.blog.entity.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getCommentByArticleId(int aid);
}
