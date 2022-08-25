package com.example.demo.validation.service.impl;

import com.example.demo.validation.dao.UserDao;
import com.example.demo.validation.entity.User;
import com.example.demo.validation.service.ValidationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class ValidationServiceImpl implements ValidationService {
    @Resource
    private UserDao userDao;
    @Transactional
    @Override
    public Integer test(Integer id) {
        User user=new User(id,"胡国晖",Long.MAX_VALUE,new Date());

        int insert = userDao.insert(user);
        return insert;
    }
    @Override
    public Integer test2(Integer id) {
        User user=new User(id,"胡国晖",Long.MAX_VALUE,new Date());

        int insert = userDao.insert(user);
        return insert;
    }
}
