package com.levietthang.shopee.rest;

import com.levietthang.shopee.entities.Role;
import com.levietthang.shopee.entities.User;
import com.levietthang.shopee.services.CustomUserService;
import com.levietthang.shopee.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@ComponentScan(basePackages = {"com.levietthang.eeshopserver", "com.levietthang.eeshopserver.rest"})
@RequestMapping("/api/role")
public class SuperAdminController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private CustomUserService userService;

    @PostMapping("/create")
    public Role insertRole(@RequestBody Role role) {
        return roleService.createRole(role);
    }

    @PutMapping("/set-admin-role")
    public User setAdminRole(@RequestBody User user) {
        return userService.setAdminRole(user);
    }
}
