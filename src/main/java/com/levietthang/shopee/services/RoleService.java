package com.levietthang.shopee.services;

import com.levietthang.shopee.entities.Role;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface RoleService {
    Set<Role> findRoleByName(String name);
    Role createRole(Role role);
    Set<Role> findAll();
}
