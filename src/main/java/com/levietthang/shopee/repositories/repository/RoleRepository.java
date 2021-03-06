package com.levietthang.shopee.repositories.repository;

import com.levietthang.shopee.entities.Role;
import com.levietthang.shopee.repositories.custom.CustomRoleRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>, CustomRoleRepository {
    @Query("SELECT r FROM com.levietthang.shopee.entities.Role r WHERE r.name = ?1")
    Set<Role> findRoleByName(String name);
    @Query("SELECT r FROM com.levietthang.shopee.entities.Role r")
    Set<Role> findAllRole();
}
