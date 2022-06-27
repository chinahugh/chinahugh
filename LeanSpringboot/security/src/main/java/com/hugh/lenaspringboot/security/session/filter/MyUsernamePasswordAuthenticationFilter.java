package com.hugh.lenaspringboot.security.session.filter;


import cn.hutool.json.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    Logger logger = LoggerFactory.getLogger(MyUsernamePasswordAuthenticationFilter.class);

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        logger.info("MyUsernamePasswordAuthenticationFilter");
//        if (!request.getMethod().equals("POST")) {
//            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
//        }
        String username = obtainUsername(request);
        username = (username != null) ? username : "";
        username = username.trim();
        String password = obtainPassword(request);
        password = (password != null) ? password : "";
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
        logger.info("JSONUtil.toJsonStr(auth) = " + JSONUtil.toJsonStr(authRequest));
        return super.getAuthenticationManager().authenticate(authRequest);
    }
}
