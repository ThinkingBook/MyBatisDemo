package com.thinkbook.dao;

import com.thinkbook.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //查询所有用户
    List<User> selectUser();
    //根据id查询用户
    User selectUserById(int id);
    //根据姓名和密码查询用户
    User selectUserByNP(@Param("username") String username,@Param("pwd") String pwd);
    User selectUserByNP2(Map<String,Object> map);

}
