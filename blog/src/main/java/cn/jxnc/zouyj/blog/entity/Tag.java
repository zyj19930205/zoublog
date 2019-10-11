package cn.jxnc.zouyj.blog.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("z_tag")
public class Tag {
    private int id;
    @TableField("tagName")
    private String tagName;
}
