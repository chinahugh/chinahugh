package com.hugh.lenaspringboot.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {


    @GetMapping(value = {"/t"}) @PreAuthorize("hasAuthority('/user/t')")
    public String index(String name){
        return name;
    }
}
