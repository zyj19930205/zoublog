package cn.jxnc.zouyj.blog.service.impl;

import cn.jxnc.zouyj.blog.entity.User;
import cn.jxnc.zouyj.blog.mapper.UserMapper;
import cn.jxnc.zouyj.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User login(String username, String password) {
        User user=userMapper.selectUserByUsernameAndPassowrd(username,password);
        return user;
    }
}
