package com.hugh.leanspringboot.mybatis.controller;

import com.hugh.leanspringboot.mybatis.entity.TBalance;
import com.hugh.leanspringboot.mybatis.service.TBalanceService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TBalance)表控制层
 *
 * @author makejava
 * @since 2022-03-14 14:51:47
 */
@RestController
@RequestMapping("tBalance")
public class TBalanceController {
    /**
     * 服务对象
     */
    @Resource
    private TBalanceService tBalanceService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TBalance selectOne(Integer id) {
        return this.tBalanceService.queryById(id);
    }
    @GetMapping("transaction")
    public TBalance transaction (int fromId, int toId,double amount) throws Exception {
        return this.tBalanceService.transaction(fromId,toId,amount);
    }

}
