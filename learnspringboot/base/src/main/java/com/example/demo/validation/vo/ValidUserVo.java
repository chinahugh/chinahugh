package com.example.demo.validation.vo;

import com.example.demo.validation.common.Delete;
import com.example.demo.validation.common.Insert;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@ApiModel(description = "测试Vo类")
public class ValidUserVo {
    @ApiModelProperty(value = "字段名词", example = "100", required = true)
    @Min(value = 10)
    private int a;

    private long b;

    private double c;

    @Pattern(regexp = "男|女|未知", message = "只能为男|女|未知")
    private String d;

    private Integer e;

    private Long f;

    @ApiModelProperty(value = "g字段")
    @NotNull(message = "密码不能为空", groups = {Insert.class, Delete.class, Default.class})
    private Double g;

    @NotNull
    @Future()
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime future;

    @NotNull
    @Future()
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;

    @ApiModelProperty(value = "list字段", required = true)
//    @Valid
    @NotNull @Size(min = 1)
    List<ValidUserVo> list;

    public List<ValidUserVo> getList() {
        return list;
    }

    public void setList(List<ValidUserVo> list) {
        this.list = list;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public long getB() {
        return b;
    }

    public void setB(long b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public Integer getE() {
        return e;
    }

    public void setE(Integer e) {
        this.e = e;
    }

    public Long getF() {
        return f;
    }

    public void setF(Long f) {
        this.f = f;
    }

    public Double getG() {
        return g;
    }

    public void setG(Double g) {
        this.g = g;
    }

    public LocalDateTime getFuture() {
        return future;
    }

    public void setFuture(LocalDateTime future) {
        this.future = future;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ValidUser{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d='" + d + '\'' +
                ", e=" + e +
                ", f=" + f +
                ", g=" + g +
                ", future=" + future +
                ", date=" + date +
                ", list=" + list +
                '}';
    }
}
