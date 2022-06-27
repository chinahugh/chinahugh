package com.hugh.leanspringboot.jpa.service;


import com.hugh.leanspringboot.jpa.common.R;
import com.hugh.leanspringboot.jpa.dao.AddressDao;
import com.hugh.leanspringboot.jpa.dao.ComplexTableDao;
import com.hugh.leanspringboot.jpa.dao.CourseDao;
import com.hugh.leanspringboot.jpa.dao.GradeDao;
import com.hugh.leanspringboot.jpa.dao.UserDao;
import com.hugh.leanspringboot.jpa.entity.Address;
import com.hugh.leanspringboot.jpa.entity.Course;
import com.hugh.leanspringboot.jpa.entity.Grade;
import com.hugh.leanspringboot.jpa.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {
    @Resource
    private UserDao userDao;

    @Resource
    private GradeDao gradeDao;
    @Resource
    private AddressDao addressDao;
    @Resource
    private CourseDao courseDao;
    @Resource
    ComplexTableDao complexTableDao;


    public void test() {
        Grade grade = new Grade("二年级");
        Address address = new Address("地点2");
        User user = new User("胡国晖", address, grade);

        Set<Course> courses=new HashSet<>();
        courses.add(new Course("英语2"));
        courses.add(new Course("数学2"));
        user.setCourses(courses);
        userDao.save(user);
    }

    public List<User> list() {
        return userDao.findAll();
    }

    public List<Grade> list2() {
        return gradeDao.findAll();
    }

    public List<Address> list3() {
        return addressDao.findAll();
    }

    public List<Course> list4() {
        return courseDao.findAll();
    }

    public R delete(){
        courseDao.deleteById(1L);
        return R.ok();
    }


}
