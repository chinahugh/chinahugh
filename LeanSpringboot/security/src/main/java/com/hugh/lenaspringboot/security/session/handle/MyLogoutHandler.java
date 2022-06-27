package com.hugh.lenaspringboot.security.session.handle;

import cn.hutool.json.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class MyLogoutHandler implements LogoutHandler {
    Logger logger = LoggerFactory.getLogger(MyLogoutHandler.class);

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication auth) {
        logger.info("MyLogoutHandler");
        logger.info("JSONUtil.toJsonStr(auth) = " + JSONUtil.toJsonStr(auth));
    }
}
