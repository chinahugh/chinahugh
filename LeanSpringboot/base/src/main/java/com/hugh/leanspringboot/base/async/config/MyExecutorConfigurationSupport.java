//package com.hugh.leanspringboot.base.async.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.lang.Nullable;
//import org.springframework.scheduling.concurrent.ExecutorConfigurationSupport;
//
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.RejectedExecutionHandler;
//import java.util.concurrent.ThreadFactory;
//import java.util.concurrent.ThreadPoolExecutor;
//
//@Configuration
//public   class MyExecutorConfigurationSupport extends ExecutorConfigurationSupport {
//    @Override
//    public void setRejectedExecutionHandler(@Nullable RejectedExecutionHandler rejectedExecutionHandler) {
//        super.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
//    }
//
//    @Override
//    protected ExecutorService initializeExecutor(ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
//        return super.initializeExecutor(threadFactory, rejectedExecutionHandler);
//    }
//}
