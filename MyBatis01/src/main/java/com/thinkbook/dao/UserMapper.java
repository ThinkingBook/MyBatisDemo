package com.thinkbook.dao;

import com.thinkbook.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //查询所有用户
    List<User> selectUser();
}
