package cn.jxnc.zouyj.blog.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class User {

    private int id;
    private String username;
    private String password;
    @TableField("user_img")
    private String user_img;
}
