package com.hugh.lenaspringboot.security.session.handle;

import cn.hutool.json.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Component
public  class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {
    Logger logger= LoggerFactory.getLogger(MyAuthenticationFailureHandler.class);
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException e) throws IOException, ServletException {
        logger.info("MyAuthenticationFailureHandler");
        // 设定响应状态码为200
        response.setStatus(HttpServletResponse.SC_OK);
        // 设定响应内容是utf-8编码的json类型
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding("utf-8");
        // 组装自己的结果对象
        Map<String,Object> map=new HashMap();
        map.put("code",2);

        if (e instanceof LockedException) {
            map.put("msg", "账户被锁定，登录失败!");
        } else if (e instanceof BadCredentialsException) {
            map.put("msg", "账户名或密码输入错误，登录失败!");
        } else if (e instanceof DisabledException) {
            map.put("msg", "账户被禁用，登录失败!");
        } else if (e instanceof AccountExpiredException) {
            map.put("msg", "账户已过期，登录失败!");
        } else if (e instanceof CredentialsExpiredException) {
            map.put("msg", "密码已过期，登录失败!");
        } else {
            map.put("msg", "登录失败!"+e.getMessage());
        }

        // 序列化结果对象为JSON
        String resultJSON = JSONUtil.toJsonStr(map);
        // 写入响应体
        PrintWriter writer = response.getWriter();
        writer.write(resultJSON);
        writer.flush();
        writer.close();
    }
}
