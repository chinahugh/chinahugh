package com.hugh.leanspringboot.base.async.service;

import java.util.concurrent.Future;

public interface AsyncService {

    /**
     * 异步调用，无返回值
     */
    void asyncTask()throws Exception ;

    /**
     * 异步调用，有返回值
     */
    Future<String> asyncTask(String s)throws Exception ;

    /**
     * 异步调用，无返回值，事务测试
     */
    void asyncTaskForTransaction(Boolean exFlag)throws Exception ;
}
