package com.hugh.leanspringboot.mybatis.service.impl;

import com.hugh.leanspringboot.mybatis.MybatisApplicationTests;
import com.hugh.leanspringboot.mybatis.service.TBalanceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class TBalanceServiceImplTest extends MybatisApplicationTests {
    @Autowired
    TBalanceService tBalanceService;

    @Test
    void transaction() throws Exception {
        tBalanceService.transaction(1,2,20.1);
    }
}
