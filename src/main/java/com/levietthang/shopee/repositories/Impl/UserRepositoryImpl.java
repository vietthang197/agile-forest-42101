package com.levietthang.shopee.repositories.Impl;

import com.levietthang.shopee.dto.UserRegisterDTO;
import com.levietthang.shopee.entities.Role;
import com.levietthang.shopee.entities.User;
import com.levietthang.shopee.entities.UserDetails;
import com.levietthang.shopee.repositories.custom.CustomUserDetailsRepository;
import com.levietthang.shopee.repositories.custom.CustomUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class UserRepositoryImpl  implements CustomUserRepository {

    @Autowired
    private EntityManager entityManager;
    
}
