package com.annlu.springbootmall.dao;

import com.annlu.springbootmall.dto.UserRegisterRequest;
import com.annlu.springbootmall.model.User;

public interface UserDao {

    User getUserById(Integer userId);

    User getUserByEmail(String email);

    Integer createUser(UserRegisterRequest userRegisterRequest);
}
