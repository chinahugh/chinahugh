package com.hugh.leanspringboot.base.interceptor;

import cn.hutool.json.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyHandlerInterceptor implements HandlerInterceptor {
    Logger logger = LoggerFactory.getLogger(MyHandlerInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info(JSONUtil.toJsonStr(handler));
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info(JSONUtil.toJsonStr(handler));
        logger.info(JSONUtil.toJsonStr(modelAndView));
        System.out.println("postHandle = ");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion = ");
        logger.info(JSONUtil.toJsonStr(handler));
        logger.info(JSONUtil.toJsonStr(ex));
    }
}
