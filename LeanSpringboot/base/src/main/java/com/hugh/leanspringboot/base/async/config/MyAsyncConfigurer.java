//package com.hugh.leanspringboot.base.async.config;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.AsyncConfigurer;
//import org.springframework.scheduling.annotation.EnableAsync;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
//import org.springframework.transaction.interceptor.TransactionAspectSupport;
//
//import java.lang.reflect.Method;
//import java.util.Arrays;
//import java.util.concurrent.Executor;
//@EnableAsync
//@Configuration
//public class MyAsyncConfigurer implements AsyncConfigurer {
//    Logger logger = LoggerFactory.getLogger(MyAsyncConfigurer.class);
//    @Autowired
//    ThreadPoolTaskExecutor threadPoolTaskExecutor;
//    @Override
//    public Executor getAsyncExecutor() {
//        return threadPoolTaskExecutor;
//    }
//
//    @Override
//    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
//        return new AsyncUncaughtExceptionHandler() {
//            @Override
//            public void handleUncaughtException(Throwable ex, Method method, Object... params) {
//                logger.error("AsyncTask Error: {}, {}, {}",
//                        ex.getMessage(),
//                        method.getDeclaringClass().getName() + "." + method.getName(),
//                        Arrays.toString(params));
//                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//            }
//        };
//    }
//}
