package com.atxieji.service.impl;

import com.atxieji.bean.User;
import com.atxieji.dao.UserDao;
import com.atxieji.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lmhstart
 * @create 2021/11/1-14:27
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User userLogin(User user) {
        return userDao.userLogin(user);
    }

    @Override
    public boolean existsUser(String username) {
        User existsUser = userDao.existsUser(username);
        return existsUser != null;
    }

    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public int deleteById(Integer id) {
        return userDao.deleteById(id);
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }
}
