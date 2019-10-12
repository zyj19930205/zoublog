package cn.jxnc.zouyj.blog.service.impl;

import cn.jxnc.zouyj.blog.entity.Comment;
import cn.jxnc.zouyj.blog.mapper.CommentMapper;
import cn.jxnc.zouyj.blog.service.CommentService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentMapper commentMapper;

    @Override
    public List<Comment> getCommentByArticleId(int aid) {
        QueryWrapper<Comment> commentQueryWrapper=new QueryWrapper<>();
        commentQueryWrapper.eq("articleId",aid);
        return commentMapper.selectList(commentQueryWrapper);
    }
}
