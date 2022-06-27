package com.hugh.leanspringboot.jpa;

import com.hugh.leanspringboot.jpa.common.R;
import com.hugh.leanspringboot.jpa.entity.Address;
import com.hugh.leanspringboot.jpa.entity.Course;
import com.hugh.leanspringboot.jpa.entity.Grade;
import com.hugh.leanspringboot.jpa.entity.User;
import com.hugh.leanspringboot.jpa.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class Controller {

    @Resource
    UserService userService;

    @PostMapping("index")
    public String index(HttpServletRequest request) {
        System.out.println("request = " + request.getSession().getId());
        userService.test();
        return "ok";
    }

    @PostMapping("index2")
    public List<User> index2(HttpServletRequest request) {
        System.out.println("request = " + request.getSession().getId());
        List<User> list = userService.list();
        return list;
    }

    @PostMapping("index3")
    public List<Grade> index3(HttpServletRequest request) {
        System.out.println("request = " + request.getSession().getId());
        List<Grade> list = userService.list2();
        return list;
    }

    @PostMapping("index4")
    public List<Address> index4(HttpServletRequest request) {
        System.out.println("request = " + request.getSession().getId());
        List<Address> list = userService.list3();
        return list;
    }

    @PostMapping("index5")
    public List<Course> index5(HttpServletRequest request) {
        System.out.println("request = " + request.getSession().getId());
        List<Course> list = userService.list4();
        return list;
    }

    @PostMapping("delete")
    public R delete(HttpServletRequest request) {
        return userService.delete();
    }
}
