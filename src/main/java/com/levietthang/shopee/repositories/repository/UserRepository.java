package com.levietthang.shopee.repositories.repository;

import com.levietthang.shopee.entities.Role;
import com.levietthang.shopee.entities.User;
import com.levietthang.shopee.repositories.custom.CustomUserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>, CustomUserRepository {
    @Query("SELECT u FROM com.levietthang.shopee.entities.User u WHERE u.username =?1")
    User findUserByUsername(String username);

    @Query("SELECT u FROM com.levietthang.shopee.entities.User u WHERE u.username =?1 AND u.id =?2")
    User findUserByUsernameAndId(String username, int id);

    @Query("SELECT u FROM com.levietthang.shopee.entities.User u WHERE u.email =?1")
    User findUserByEmail(String email);
}
