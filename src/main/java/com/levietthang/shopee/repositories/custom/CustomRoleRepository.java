package com.levietthang.shopee.repositories.custom;

import com.levietthang.shopee.entities.Role;

import java.util.Set;

public interface CustomRoleRepository {
    Set<Role> findRoleByName(String name);
}
