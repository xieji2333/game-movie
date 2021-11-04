package com.atxieji.service;


import com.atxieji.bean.User;


/**
 * @author lmhstart
 * @create 2021/11/1-14:23
 */
public interface UserService {
    User userLogin(User user);

    boolean existsUser(String username);

    int addUser(User user);

    int deleteById(Integer id);

    int updateUser(User user);
}
