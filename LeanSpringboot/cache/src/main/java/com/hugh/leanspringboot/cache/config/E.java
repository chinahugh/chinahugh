package com.hugh.leanspringboot.cache.config;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class E   {

    @ExceptionHandler({Exception.class})
    public Object exception(Exception e){
        return e.getMessage();
    }
}
