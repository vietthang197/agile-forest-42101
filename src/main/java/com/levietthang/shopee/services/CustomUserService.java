package com.levietthang.shopee.services;

import  com.levietthang.shopee.dto.UserRegisterDTO;
import  com.levietthang.shopee.entities.User;
import com.levietthang.shopee.model.RegisterStatus;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CustomUserService {
    List<User> findAllUser();
    void createUser(User user);
    RegisterStatus createUserAccount(UserRegisterDTO userRegisterDTO);
    User setAdminRole(User user);
}
