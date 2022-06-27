package com.hugh.leanspringboot.mybatis.controller;

import com.hugh.leanspringboot.mybatis.entity.TSave;
import com.hugh.leanspringboot.mybatis.service.TSaveService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TSave)表控制层
 *
 * @author makejava
 * @since 2022-06-24 17:49:06
 */
@RestController
@RequestMapping("tSave")
public class TSaveController {
    /**
     * 服务对象
     */
    @Resource
    private TSaveService tSaveService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TSave selectOne(Long id) {
        return this.tSaveService.queryById(id);
    }

}