package com.hugh.lenaspringboot.security.session.handle;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.session.InvalidSessionStrategy;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Component
public class MyInvalidSessionStrategy implements InvalidSessionStrategy {
    Logger logger= LoggerFactory.getLogger(MyInvalidSessionStrategy.class);
    @Override
    public void onInvalidSessionDetected(HttpServletRequest request, HttpServletResponse rp) throws IOException, ServletException {
        logger.info("MyInvalidSessionStrategy");
        rp.setContentType("application/json;charset=utf-8");
        PrintWriter out = rp.getWriter();
        rp.setStatus(200);
        Map<String, Object> map = new HashMap<>();
        map.put("status", 200);
        map.put("msg", "重新登录");
        ObjectMapper om = new ObjectMapper();
        out.write(om.writeValueAsString(map));
        out.flush();
        out.close();
    }
}
