package com.annlu.springbootmall.service;

import com.annlu.springbootmall.dao.UserDao;
import com.annlu.springbootmall.dto.UserRegisterRequest;
import com.annlu.springbootmall.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        return userDao.createUser(userRegisterRequest);
    }
}
