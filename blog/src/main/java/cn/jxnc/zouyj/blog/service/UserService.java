package cn.jxnc.zouyj.blog.service;

import cn.jxnc.zouyj.blog.entity.User;

public interface UserService {
    public User login(String username, String password);
}
