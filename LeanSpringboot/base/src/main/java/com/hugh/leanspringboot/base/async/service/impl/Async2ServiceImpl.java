package com.hugh.leanspringboot.base.async.service.impl;

import cn.hutool.core.thread.ThreadUtil;
import com.hugh.leanspringboot.base.async.service.Async2Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.Future;

@Service
public class Async2ServiceImpl implements Async2Service {
    static final Logger logger = LoggerFactory.getLogger(Async2ServiceImpl.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Async
    @Override
    public void asyncTask() throws Exception {
        logger.info("异步调用，无返回值 start");
        for (int i = 0; i < 3; i++) {
            ThreadUtil.sleep(1000);
            int a = 1 / 0;
        }
        logger.info("异步调用，无返回值 end");
    }

    @Async
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Future<String> asyncTask(String s) throws Exception {
        long arg1 = System.currentTimeMillis();
        logger.info("异步调用，有返回值，开始 ：{} ，线程名：{} ", arg1, Thread.currentThread().getName());
        jdbcTemplate.update("insert into test(a,thread) values(?,?)", s + "1", Thread.currentThread().getName());
        jdbcTemplate.update("insert into test(a,thread) values(?,?)", s + "2", Thread.currentThread().getName());
        logger.info("异步调用，有返回值，结束 ：{}，线程名：{} ，", System.currentTimeMillis() - arg1, Thread.currentThread().getName());
        return AsyncResult.forValue(s + " hello");
    }

    @Transactional(rollbackFor = Exception.class)
    @Async
    @Override
    public void asyncTaskForTransaction(Boolean exFlag) throws Exception {
        logger.info("异步调用，无返回值，事务测试 start " + exFlag);
        jdbcTemplate.update("insert into test(a,thread) values(?,?)", exFlag + "_2_1",
                Thread.currentThread().getName());
        jdbcTemplate.update("insert into test(a,thread) values(?)", exFlag + "_2_2", Thread.currentThread().getName());
        logger.info("异步调用，无返回值，事务测试 end ");
    }
}
