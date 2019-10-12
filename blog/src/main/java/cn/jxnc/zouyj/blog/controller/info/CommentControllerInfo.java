package cn.jxnc.zouyj.blog.controller.info;


import cn.jxnc.zouyj.blog.entity.Comment;
import cn.jxnc.zouyj.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentControllerInfo {

    @Autowired
    CommentService commentService;

    @RequestMapping("/getCommentByArticle/{aid}")
    public List<Comment> getComment(@PathVariable("aid") Integer aid){
        return commentService.getCommentByArticleId(aid);
    }
}
