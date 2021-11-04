package com.atxieji.dao;

import com.atxieji.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author lmhstart
 * @create 2021/10/31-22:30
 */
@Mapper
public interface UserDao {
    //登录验证
    User userLogin(User user);

    //判断用户名是否已经存在
    User existsUser(String username);

    //注册用户
    int addUser(User user);

    int deleteById(@Param("id") Integer id);

    int updateUser(User user);
}
