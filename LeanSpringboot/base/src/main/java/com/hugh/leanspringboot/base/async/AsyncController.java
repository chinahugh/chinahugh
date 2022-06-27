package com.hugh.leanspringboot.base.async;

import com.hugh.leanspringboot.base.async.service.AsyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

@RestController
@RequestMapping("/async")
public class AsyncController {
    Logger logger = LoggerFactory.getLogger(AsyncController.class);
    @Autowired
    AsyncService async;

    @GetMapping("a1")
    public Object asyncTask() throws Exception {
        logger.info("start");
        long start = System.currentTimeMillis();
        async.asyncTask();
        logger.info("end :" + (System.currentTimeMillis() - start));
        return null;
    }

    @GetMapping("a2")
    public Object asyncTask(String id) throws Exception {
        long start = System.currentTimeMillis();

        logger.info("controller 中调用 异步 service 耗时 :" + (System.currentTimeMillis() - start));
        Future<String> stringFuture = async.asyncTask(id);
        try {
            String s = stringFuture.get();
            logger.info("异步 service 执行耗时 :" + (System.currentTimeMillis() - start));
            return s;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return start;
    }

    /**
     * 异步调用，无返回值，事务测试
     */
    @GetMapping("a3")
    public void asyncTaskForTransaction(Boolean flag) throws Exception {
        logger.info("start");
        long start = System.currentTimeMillis();
        async.asyncTaskForTransaction(flag);
        logger.info("end2 :" + (System.currentTimeMillis() - start));
    }
}
