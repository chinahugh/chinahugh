package com.hugh.lenaspringboot.security.jwt;

import com.hugh.lenaspringboot.security.jwt.filter.MyJwtAuthenticationSuccessHandler;
import com.hugh.lenaspringboot.security.jwt.filter.MyJwtBasicAuthenticationFilter;
import com.hugh.lenaspringboot.security.session.UserDetailsService;
import com.hugh.lenaspringboot.security.session.filter.MyUsernamePasswordAuthenticationFilter;
import com.hugh.lenaspringboot.security.session.handle.MyAccessDeniedHandler;
import com.hugh.lenaspringboot.security.session.handle.MyAuthenticationEntryPoint;
import com.hugh.lenaspringboot.security.session.handle.MyAuthenticationFailureHandler;
import com.hugh.lenaspringboot.security.session.handle.MyInvalidSessionStrategy;
import com.hugh.lenaspringboot.security.session.handle.MyLogoutHandler;
import com.hugh.lenaspringboot.security.session.handle.MyLogoutSuccessHandler;
import com.hugh.lenaspringboot.security.session.handle.MySessionInformationExpiredStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    Logger logger = LoggerFactory.getLogger(WebSecurityConfig.class);
    @Resource
    UserDetailsService userDetailsService;
    @Resource
    MyJwtAuthenticationSuccessHandler myJwtAuthenticationSuccessHandler ;
    @Resource
    MyLogoutHandler myLogoutHandler;
    @Resource
    MyLogoutSuccessHandler myLogoutSuccessHandler;
    @Resource
    MyAuthenticationFailureHandler myAuthenticationFailureHandler;
    @Resource
    MyAccessDeniedHandler myAccessDeniedHandler;

    @Resource
    MyAuthenticationEntryPoint myAuthenticationEntryPoint;
    @Resource
    MyInvalidSessionStrategy myInvalidSessionStrategy;
    @Resource
    MySessionInformationExpiredStrategy mySessionInformationExpiredStrategy;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET,
                        "/", "/*.html", "/**/*.html", "/**/*.css", "/**/*.js", "/profile/**"
                ).permitAll()
                .antMatchers("/login*").permitAll()
                .antMatchers("/test").permitAll()
//                .antMatchers("/instances**").anonymous()
                .antMatchers("/actuator/**").anonymous()
                .anyRequest().authenticated();

        http.addFilterAt(myUsernamePasswordAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                .userDetailsService(userDetailsService)
//                处理HTTP请求的BASIC授权标头，然后将结果放入SecurityContextHolder 。
                .addFilter(new MyJwtBasicAuthenticationFilter(super.authenticationManager()))
                /*不需要session */
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.logout()
                .addLogoutHandler(myLogoutHandler)
                .logoutSuccessHandler(myLogoutSuccessHandler)
                .clearAuthentication(true)
                .deleteCookies("JSESSIONID");

        http.exceptionHandling()
                //未登录自定义处理类
                .authenticationEntryPoint(myAuthenticationEntryPoint)
                // 设定为自定义的权限不足处理器
                .accessDeniedHandler(myAccessDeniedHandler);
    }

    @Bean
    public UsernamePasswordAuthenticationFilter myUsernamePasswordAuthenticationFilter() throws Exception {
        MyUsernamePasswordAuthenticationFilter myUsernamePasswordAuthenticationFilter = new MyUsernamePasswordAuthenticationFilter();
        myUsernamePasswordAuthenticationFilter.setFilterProcessesUrl("/login");
        myUsernamePasswordAuthenticationFilter.setAuthenticationSuccessHandler(myJwtAuthenticationSuccessHandler);
        myUsernamePasswordAuthenticationFilter.setAuthenticationFailureHandler(myAuthenticationFailureHandler);
        myUsernamePasswordAuthenticationFilter.setAuthenticationManager(super.authenticationManager());
        return myUsernamePasswordAuthenticationFilter;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence rawPassword) {
                return (String) rawPassword;
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                logger.info("rawPassword = " + rawPassword);
                logger.info("encodedPassword = " + encodedPassword);
                return rawPassword.equals(encodedPassword);
            }
        };
    }
}
