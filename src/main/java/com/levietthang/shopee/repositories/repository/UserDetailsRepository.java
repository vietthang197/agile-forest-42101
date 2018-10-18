package com.levietthang.shopee.repositories.repository;

import com.levietthang.shopee.entities.UserDetails;
import com.levietthang.shopee.repositories.custom.CustomUserDetailsRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Integer>, CustomUserDetailsRepository {

}
