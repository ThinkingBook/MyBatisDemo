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
    //使用@Param传递参数
    User selectUserByNP(@Param("username") String username,@Param("pwd") String pwd);
    //使用Map传递参数
    User selectUserByNP2(Map<String,Object> map);
    //新增用户
    int addUser(User user);
    //修改数据
    int updateUser(User user);
    //删除数据
    int delUser(int id);
}
