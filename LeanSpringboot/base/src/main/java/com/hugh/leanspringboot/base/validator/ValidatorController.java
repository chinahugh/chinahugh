package com.hugh.leanspringboot.base.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
@Validated
@RestController
@RequestMapping("/v")
public class ValidatorController {
    Logger logger = LoggerFactory.getLogger(ValidatorController.class);

    @GetMapping("t")
    public Object t(HttpServletRequest request, @NotBlank String username, @Min(value = 10 ) Integer a) {
        logger.info(username);
        logger.info(String.valueOf(a));
        return username;
    }
}
