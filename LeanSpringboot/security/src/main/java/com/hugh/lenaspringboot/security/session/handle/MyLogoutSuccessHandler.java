package com.hugh.lenaspringboot.security.session.handle;

import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Component
public class MyLogoutSuccessHandler implements LogoutSuccessHandler {
    Logger logger= LoggerFactory.getLogger(MyLogoutSuccessHandler.class);
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse rp, Authentication auth) throws IOException, ServletException {
        logger.info("MyLogoutSuccessHandler");
        logger.info("JSONUtil.toJsonStr(auth) = " + JSONUtil.toJsonStr(auth));
//        response.sendRedirect("/login");              //跳转到自定义登陆页面
        rp.setContentType("application/json;charset=utf-8");
        PrintWriter out = rp.getWriter();
        rp.setStatus(200);
        Map<String, Object> map = new HashMap<>();
        map.put("status", 200);
        map.put("msg", "登出成功");
        ObjectMapper om = new ObjectMapper();
        out.write(om.writeValueAsString(map));
        out.flush();
        out.close();
    }
}
