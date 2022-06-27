package com.hugh.lenaspringboot.security.session.handle;

import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * 登陆成功后
 */
@Component
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    Logger logger = LoggerFactory.getLogger(MyAuthenticationSuccessHandler.class);

    @Override
    public void onAuthenticationSuccess(HttpServletRequest rq, HttpServletResponse rp, Authentication auth)
            throws IOException, ServletException {
        logger.info("MyAuthenticationSuccessHandler");
        logger.info("JSONUtil.toJsonStr(auth) = " + JSONUtil.toJsonStr(auth));
        logger.info("auth.getPrincipal() = " + JSONUtil.toJsonStr(auth.getPrincipal()));
        logger.info("JSONUtil.toJsonStr(auth.getAuthorities()) = " + JSONUtil.toJsonStr(auth.getAuthorities()));
        logger.info(auth.toString());
        logger.info(auth.getPrincipal().toString());
        logger.info(auth.getAuthorities().toString());

        rp.setContentType("application/json;charset=utf-8");
        PrintWriter out = rp.getWriter();
        rp.setStatus(200);
        Map<String, Object> map = new HashMap<>();
        map.put("status", 200);
        map.put("msg", auth.getPrincipal());
        ObjectMapper om = new ObjectMapper();
        out.write(om.writeValueAsString(map));
        out.flush();
        out.close();

    }
}
