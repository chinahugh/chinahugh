package com.hugh.lenaspringboot.security.session.handle;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 未登录自定义处理类
 */
@Component
public class MyAuthenticationEntryPoint implements AuthenticationEntryPoint {
    Logger logger = LoggerFactory.getLogger(MyAuthenticationEntryPoint.class);

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException auth) throws IOException, ServletException {
        logger.info("MyAuthenticationEntryPoint");
//        logger.info("JSONUtil.toJsonStr(auth) = " + JSONUtil.toJsonStr(auth));
        logger.info(request.getRequestURL().toString());


        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().append(
                new ObjectMapper().createObjectNode()
                        .put("status", 401)
                        .put("msg", "未登录，请登录后访问")
                        .toString());
    }
}
