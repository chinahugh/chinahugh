package com.hugh.leanspringboot.base.validator;

import cn.hutool.json.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;


@RestControllerAdvice
public class ExHandleAdvice {
    Logger logger = LoggerFactory.getLogger(ExHandleAdvice.class);

    @ExceptionHandler(value = BindException.class)
    public Object handleBindException(BindException ex) {
        logger.error(ex.getMessage(), ex);
        List<String> defaultMsg = ex.getBindingResult().getAllErrors()
                .stream()
                .map(e -> e.getObjectName() + " ： " + e.getDefaultMessage() + "asdasd")
                .collect(Collectors.toList());

        return JSONUtil.toJsonStr(defaultMsg);
    }

    /**
     * 单个参数校验
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    public Object handleBindGetException(ConstraintViolationException ex) {
        logger.error(ex.getMessage(), ex);
        List<String> defaultMsg = ex.getConstraintViolations()
                .stream()
                .map(e -> e.getPropertyPath() + ":" + e.getMessage())
                .collect(Collectors.toList());
        return JSONUtil.toJsonStr(defaultMsg);
    }

    @ExceptionHandler(value = Exception.class)
    public Object handleBindException2(Exception ex) {

        logger.error(ex.getMessage(), ex);
        return JSONUtil.toJsonStr(ex);
    }
}
