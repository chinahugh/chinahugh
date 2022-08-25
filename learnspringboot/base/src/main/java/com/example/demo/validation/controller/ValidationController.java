package com.example.demo.validation.controller;

import com.example.demo.validation.common.Update;
import com.example.demo.validation.vo.ValidUserVo;
import com.example.demo.validation.service.impl.ValidationService2;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * @author HGH
 */
@Validated
@Api(tags = "参数验证")
@RestController
@RequestMapping("validation")
public class ValidationController {
    @Autowired
    private ValidationService2 validationService2;

//    @ApiOperation(value = "byId简要说明", notes = "byId详细说明", response = String.class)
    @GetMapping("{id}")
    public String byId(@PathVariable @ApiParam("ID") @NotNull @Min(value = 10) Integer id) {
        System.out.println("id = " + id);
        Integer s = validationService2.test(id);
        return "OK";
    }

//    @ApiOperation(value = "简要说明", notes = "详细说明")
    @GetMapping("get")
    public String get(@RequestParam @ApiParam("名字") @NotNull @NotBlank String name,
                      @RequestParam @ApiParam("年龄") @NotNull @Min(value = 10) Integer age,
                      @RequestParam @ApiParam("时间") @NotNull @Future LocalDateTime dateTime) {
        System.out.println("name = " + name);
        System.out.println("age = " + age);

        System.out.println("dateTime = " + dateTime);
        return "OK";
    }

//    @ApiOperation(value = "简要说明", notes = "详细说明")
    @PostMapping("post")
    public ValidUserVo post(@RequestBody @Valid ValidUserVo validUser) {
        System.out.println("validUser = " + validUser);
        return validUser;
    }

//    @ApiOperation(value = "update", notes = "详细说明")
    @PostMapping("update")
    public ResponseEntity update(@RequestBody @Validated({Update.class}) ValidUserVo validUser) {
        System.out.println("validUser = " + validUser);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(validUser);
    }
}
