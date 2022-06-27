package com.hugh.leanspringboot.mybatis.controller;

import com.hugh.leanspringboot.mybatis.entity.TBalanceRecord;
import com.hugh.leanspringboot.mybatis.service.TBalanceRecordService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TBalanceRecord)表控制层
 *
 * @author makejava
 * @since 2022-03-14 14:52:13
 */
@RestController
@RequestMapping("tBalanceRecord")
public class TBalanceRecordController {
    /**
     * 服务对象
     */
@Resource
    private TBalanceRecordService tBalanceRecordService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TBalanceRecord selectOne(Integer id) {
        return this.tBalanceRecordService.queryById(id);
    }

}
