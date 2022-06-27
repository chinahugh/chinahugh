package com.hugh.leanspringboot.base.async.service.impl;

import cn.hutool.core.thread.ThreadUtil;
import com.hugh.leanspringboot.base.async.service.Async2Service;
import com.hugh.leanspringboot.base.async.service.AsyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.Future;

@Service
public class AsyncServiceImpl implements AsyncService {
    static final Logger logger = LoggerFactory.getLogger(AsyncServiceImpl.class);
    @Autowired
    ThreadPoolTaskExecutor threadPoolTaskExecutor;
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    Async2Service async2Service;

    @Async
    @Override
    public void asyncTask() throws Exception {
        logger.info("异步调用，无返回值 start");
        this.async2Service.asyncTask();
        for (int i = 0; i < 3; i++) {
            ThreadUtil.sleep(1000);
        }
        logger.info("异步调用，无返回值 end");
    }

    /**
     * 事务无法向 async2Service.asyncTask传递，async2Service.asyncTask开启的事务为新事务，但可向外传递
     * @param s
     * @return
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    @Async
    @Override
    public Future<String> asyncTask(String s) throws Exception  { //此处的throws Exception 为 async2Service.asyncTask抛出的，但实际为 async2Service.get()运行时抛出
        long arg1 = System.currentTimeMillis();
        logger.info("异步调用，有返回值，开始 ：{} ，线程名：{} ", arg1, Thread.currentThread().getName());

        //事务无法向 async2Service.asyncTask传递，async2Service.asyncTask开启的事务为新事务，但可向外传递
        Future<String> async2ServiceFuture =  async2Service.asyncTask("async2Service");

        jdbcTemplate.update("insert into test(a,thread) values(?,?)", s + "1", Thread.currentThread().getName());
        jdbcTemplate.update("insert into test(a,thread) values(?)", s + "2", Thread.currentThread().getName());

        try {
            String s1 = async2ServiceFuture.get(); //如果有全局异常处理，此处异常无需捕获，直接抛出，如果捕获，也必须向上抛出
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;//必须抛出异常，否则async2Service中出现异常，本方法无法回退，如异步任务不影响本方法的事务，捕获后无需抛出
        }

        logger.info("异步调用，有返回值，结束 ：{}，线程名：{} ，", System.currentTimeMillis() - arg1, Thread.currentThread().getName());
        return AsyncResult.forValue(s + " hello");
    }

    @Transactional(rollbackFor = Exception.class)
    @Async
    @Override
    public void asyncTaskForTransaction(Boolean exFlag) throws Exception {
        logger.info("异步调用，无返回值，事务测试 start " + exFlag);
        this.async2Service.asyncTaskForTransaction(exFlag);

        jdbcTemplate.update("insert into test(a,thread) values(?,?)", exFlag + "1_1", Thread.currentThread().getName());
        jdbcTemplate.update("insert into test(a,thread) values(?,?)", exFlag + "1_2", Thread.currentThread().getName());
        logger.info("异步调用，无返回值，事务测试 end ");
    }
}
