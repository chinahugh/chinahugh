package com.hugh.lenaspringboot.security.controller;

import com.hugh.lenaspringboot.security.service.UserInfoService;
import com.hugh.lenaspringboot.security.session.UserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Resource
    UserInfoService userInfoService;
    @Resource
    UserDetailsService userDetailsService;


    @GetMapping(value = {"/", "/login"})
    public String login() {
        logger.info("login controller");
        return "login";
    }
    @PostMapping(value = {"/login"})
    public String login(String username, String password) {
        logger.info("login controller");
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        return "index";
    }

    @ResponseBody
    @RequestMapping(value = {"/mylogin"})
    public String login2(String username, String password) {
        logger.info("username = " + username);
        logger.info("password = " + password);
        System.out.println("SecurityContextHolder.getContext().getAuthentication() = " + SecurityContextHolder.getContext().getAuthentication());
//        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        return "index";
    }
    @ResponseBody
    @RequestMapping("/test")
    public String test(HttpServletRequest request) {
        logger.info("test = "  );
        System.out.println("SecurityContextHolder.getContext().getAuthentication() = " + SecurityContextHolder.getContext().getAuthentication());

        return "所有登录的人都可以访问";
    }

    @ResponseBody
    @RequestMapping("/test2")
    public String test2() {
        logger.info("test2 = " );
        return "所有登录的人都可以访问";
    }
}
