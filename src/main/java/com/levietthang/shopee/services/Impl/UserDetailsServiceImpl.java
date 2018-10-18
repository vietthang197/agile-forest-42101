package com.levietthang.shopee.services.Impl;

import com.levietthang.shopee.repositories.repository.UserDetailsRepository;
import com.levietthang.shopee.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.levietthang.shopee.entities.UserDetails;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements CustomUserDetailsService {

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Override
    public List<UserDetails> findAll() {
        return userDetailsRepository.findAll();
    }

    @Override
    public boolean checkExistsEmail(String email) {
        return userDetailsRepository.checkExistsEmail(email);
    }
}
