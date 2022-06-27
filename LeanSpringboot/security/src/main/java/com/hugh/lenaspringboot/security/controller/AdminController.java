package com.hugh.lenaspringboot.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {


    @GetMapping(value = {"/t"})
    @PreAuthorize("hasAuthority('/admin/t')")
    public String index(String name){
        return name;
    }
}
