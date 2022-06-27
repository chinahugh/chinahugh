package com.hugh.leanspringboot.mybatis.controller;

import com.hugh.leanspringboot.mybatis.entity.TUserCourse;
import com.hugh.leanspringboot.mybatis.service.TUserCourseService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TUserCourse)表控制层
 *
 * @author makejava
 * @since 2022-02-12 16:06:02
 */
@RestController
@RequestMapping("tUserCourse")
public class TUserCourseController {
    /**
     * 服务对象
     */
    @Resource
    private TUserCourseService tUserCourseService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TUserCourse selectOne(Long id) {
        return this.tUserCourseService.queryById(id);
    }

}