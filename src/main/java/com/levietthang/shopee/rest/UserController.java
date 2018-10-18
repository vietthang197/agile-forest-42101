package com.levietthang.shopee.rest;

import com.levietthang.shopee.dto.UserRegisterDTO;
import com.levietthang.shopee.model.RegisterStatus;
import com.levietthang.shopee.services.CustomUserDetailsService;
import com.levietthang.shopee.services.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ComponentScan(basePackages = {"com.levietthang.eeshopserver", "com.levietthang.eeshopserver.rest"})
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private CustomUserService userService;
    @Autowired
    private CustomUserDetailsService userDetailsService;

    @PostMapping("/register")
    public RegisterStatus register(@RequestBody UserRegisterDTO userRegisterDTO) {
        return  userService.createUserAccount(userRegisterDTO);
    }
}
