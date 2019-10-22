package cn.jxnc.zouyj.blog.mapper;

import cn.jxnc.zouyj.blog.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

     User selectUserByUsernameAndPassowrd(String username, String password);
     String selectUserImageById(int id);
}
