package com.levietthang.shopee.rest;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ComponentScan(basePackages = {"com.levietthang.shopee", "com.levietthang.shopee.rest"})
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String defaultRoute() {
        return "HEROKU APP";
    }
}