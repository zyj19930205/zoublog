package cn.jxnc.zouyj.blog.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("z_author")
public class Author {
    private Integer id;
    @TableField("authorName")
    private String authorName;
    private Integer age;
    private String level;
}
