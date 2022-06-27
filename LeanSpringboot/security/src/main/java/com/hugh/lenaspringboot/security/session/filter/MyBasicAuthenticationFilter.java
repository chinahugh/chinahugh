package com.hugh.lenaspringboot.security.session.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *必过过滤器
 */
public class MyBasicAuthenticationFilter extends BasicAuthenticationFilter {
    Logger logger = LoggerFactory.getLogger(MyBasicAuthenticationFilter.class);

    public MyBasicAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.info("MyBasicAuthenticationFilter");
        logger.info(String.valueOf(SecurityContextHolder.getContext().getAuthentication()));
        super.doFilterInternal(request, response, chain);
    }
}
