package cn.jxnc.zouyj.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author zouyujie
 * @date 2019/9/27 20:22
 */
@Data
@TableName("z_article")
public class Article {


    @TableId(type = IdType.AUTO)
    private Integer id;

    private String title;

    private String content;

    private String comment;

    private String summary;
}
