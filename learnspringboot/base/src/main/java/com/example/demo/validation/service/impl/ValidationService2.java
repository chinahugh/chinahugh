package com.example.demo.validation.service.impl;

import com.example.demo.validation.dao.UserDao;
import com.example.demo.validation.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class ValidationService2  {
    @Resource
    private UserDao userDao;
//    @Transactional
    public Integer test(Integer id) {
        User user=new User(id,"胡国晖",Long.MAX_VALUE,new Date());

        int insert = userDao.insert(user);
        return insert;
    }
    public Integer test2(Integer id) {
        User user=new User(id,"胡国晖",Long.MAX_VALUE,new Date());

        int insert = userDao.insert(user);
        return insert;
    }
}
