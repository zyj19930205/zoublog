package cn.jxnc.zouyj.blog.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 文章评论实体类
 */
@Data
@TableName("z_comment")
public class Comment {
    private int id;
    @TableField("articleId")
    private Integer articleId;
    @TableField("userId")
    private Integer userId;
    private String content;
}
