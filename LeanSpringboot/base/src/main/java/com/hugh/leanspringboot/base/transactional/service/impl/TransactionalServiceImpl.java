package com.hugh.leanspringboot.base.transactional.service.impl;

import com.hugh.leanspringboot.base.transactional.service.TransactionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionalServiceImpl implements TransactionalService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * springboot 事务
     *  传1 库里有数据
     *  传2 库里没有数据
     * @param name
     * @return
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public String save(String name) throws Exception {

        int update = 0;

        update = jdbcTemplate.update("insert into test(a,thread) values(?,?)", name, Thread.currentThread().getName());

        if ("1".equals(name)) {
            throw new Exception(name);
        } else if ("2".equals(name)) {
            throw new RuntimeException(name);
        }
        return " ok " + update;
    }
}
