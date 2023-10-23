package com.annlu.springbootmall.service;

import com.annlu.springbootmall.dto.UserLoginRequest;
import com.annlu.springbootmall.dto.UserRegisterRequest;
import com.annlu.springbootmall.model.User;

public interface UserService {

    User getUserById(Integer userId);

    Integer register(UserRegisterRequest userRegisterRequest);

    User login(UserLoginRequest userLoginRequest);
}
