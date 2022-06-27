package com.hugh.leanspringboot.base.async.service.impl;

import com.hugh.leanspringboot.base.BaseApplicationTests;
import com.hugh.leanspringboot.base.async.service.AsyncService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class AsyncServiceImplTest extends BaseApplicationTests {
    Logger logger = LoggerFactory.getLogger(AsyncServiceImplTest.class);
    @Autowired
    ThreadPoolTaskExecutor threadPoolTaskExecutor;
    @Autowired
    private AsyncService asyncService;

    @Test
    void testAsyncTask1() throws Exception {
        System.out.println("threadPoolTaskExecutor.getClass().getCanonicalName() = " +
                threadPoolTaskExecutor.getClass().getName());
        long l = System.currentTimeMillis();
        asyncService.asyncTask();
        asyncService.asyncTask();
        long l1 = System.currentTimeMillis() - l;
        System.out.println("耗时 = " + l1);


        System.out.println("l1 = " + l1);
    }

    @Test
    void testAsyncTask2() throws Exception {
        System.out.println("threadPoolTaskExecutor.getClass().getName() = " + threadPoolTaskExecutor.getClass().getName());
        long l = System.currentTimeMillis();
        logger.info("threadPoolTaskExecutor.getActiveCount() = " + threadPoolTaskExecutor.getActiveCount());
        Future<String> stringFuture = asyncService.asyncTask("asyncService");
        logger.info("threadPoolTaskExecutor.getActiveCount() = " + threadPoolTaskExecutor.getActiveCount());

//        Future<String> stringFuture1 = asyncService.asyncTask("2");
//        logger.info("threadPoolTaskExecutor.getActiveCount() = " + taskExecutor.getActiveCount());
//
//        Future<String> stringFuture2 = asyncService.asyncTask("3");
//        logger.info("threadPoolTaskExecutor.getActiveCount() = " + taskExecutor.getActiveCount());
//
//        Future<String> stringFuture3 = asyncService.asyncTask("4");
//        logger.info("threadPoolTaskExecutor.getActiveCount() = " + taskExecutor.getActiveCount());
//
//        Future<String> stringFuture4 = asyncService.asyncTask("5");
//        logger.info("threadPoolTaskExecutor.getActiveCount() = " + taskExecutor.getActiveCount());

        while (!stringFuture.isDone()
//                || !stringFuture1.isDone()
//                || !stringFuture2.isDone() || !stringFuture3.isDone()
//                || !stringFuture4.isDone()
        ) {
            System.out.println("stringFuture = " + stringFuture);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        try {
//            stringFuture.get();
//            stringFuture1.get();
//            stringFuture2.get();
//            stringFuture3.get();
//            stringFuture4.get();
//        } catch (InterruptedException | ExecutionException e) {
//            e.printStackTrace();
//        }
        long l1 = System.currentTimeMillis() - l;
        System.out.println("耗时 = " + l1);
    }

    @Test
    void testAsyncTask3() throws Exception {
        long l = System.currentTimeMillis();
        asyncService.asyncTaskForTransaction(true);
        asyncService.asyncTaskForTransaction(false);
        long l1 = System.currentTimeMillis() - l;
        System.out.println("耗时 = " + l1);
    }

    @Test
    public void useSynchronousQueue() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        SynchronousQueue<Object> synchronousQueue = new SynchronousQueue<>();

        Runnable producer = () -> {
            Object object = new Object();
            try {

                synchronousQueue.put(object);

            } catch (InterruptedException ex) {
                logger.error(ex.getMessage(), ex);
            }
            logger.info("produced {}", object);
        };

        Runnable consumer = () -> {
            try {
                Object object = null;
                object = synchronousQueue.take();
                logger.info("consumed {}", object);
            } catch (InterruptedException ex) {
                logger.error(ex.getMessage(), ex);
            }
        };

        executor.submit(producer);
        executor.submit(consumer);

        executor.awaitTermination(50000, TimeUnit.MILLISECONDS);
        executor.shutdown();
    }
}
