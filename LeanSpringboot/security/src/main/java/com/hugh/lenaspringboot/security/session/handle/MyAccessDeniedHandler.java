package com.hugh.lenaspringboot.security.session.handle;

import cn.hutool.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 自定义权限不足处理器
 */
@Component
public class MyAccessDeniedHandler implements AccessDeniedHandler {
    Logger logger= LoggerFactory.getLogger(MyAccessDeniedHandler.class);
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException, ServletException {
        logger.info("MyAccessDeniedHandler");
        // 设定响应状态码为403
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        // 设定响应内容是utf-8编码的json类型
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding("utf-8");
        // 组装自己的结果对象
        JSONObject result = new JSONObject();
        result.set("msg","权限不足！请联系管理员！");
        result.set("e",accessDeniedException.getMessage());
        // 序列化结果对象为JSON
        // 写入响应体
        PrintWriter writer = response.getWriter();
        writer.write(result.toString());
        writer.flush();
        writer.close();

    }
}
