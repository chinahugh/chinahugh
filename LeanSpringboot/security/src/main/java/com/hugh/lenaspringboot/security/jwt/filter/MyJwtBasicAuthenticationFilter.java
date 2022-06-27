package com.hugh.lenaspringboot.security.jwt.filter;

import cn.hutool.json.JSONUtil;
import cn.hutool.jwt.JWT;
import com.hugh.lenaspringboot.security.entity.Menu;
import com.hugh.lenaspringboot.security.entity.UserInfo;
import com.hugh.lenaspringboot.security.jwt.JWTConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 必过过滤器
 */
public class MyJwtBasicAuthenticationFilter extends BasicAuthenticationFilter {
    Logger logger = LoggerFactory.getLogger(MyJwtBasicAuthenticationFilter.class);

    public MyJwtBasicAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.info("MyBasicAuthenticationFilter");
        logger.info(request.getRequestURL().toString());
        String token = request.getHeader(JWTConfig.TOKEN);
        logger.info(token);
        if (token == null) {
            chain.doFilter(request, response);
            return;
        }

        // 如果请求头中有token，则进行解析，并且设置认证信息
        SecurityContextHolder.getContext().setAuthentication(getAuthentication(token));
        super.doFilterInternal(request, response, chain);
    }

    private Authentication getAuthentication(String token) {
        JWT of = JWT.of(token);
        String username = (String) of.getPayload("username");
        UserInfo userinfo =   JSONUtil.toBean((String)of.getPayload("userinfo"), UserInfo.class);
        int id = (int) of.getPayload("id");
        Long date = (Long) of.getPayload("date");
        if (userinfo != null) {
            List<SimpleGrantedAuthority> collect = userinfo.getMenus().stream().map(Menu::getMunu).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
            return new UsernamePasswordAuthenticationToken(userinfo.getUsername(), null,collect);
        }
        return null;
    }
}
