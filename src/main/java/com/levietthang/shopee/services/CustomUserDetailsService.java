package com.levietthang.shopee.services;

import com.levietthang.shopee.entities.UserDetails;

import java.util.List;


public interface CustomUserDetailsService {
    List<UserDetails> findAll();
    boolean checkExistsEmail(String email);
}
