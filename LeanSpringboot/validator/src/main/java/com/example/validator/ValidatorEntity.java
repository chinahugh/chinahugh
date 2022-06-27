package com.example.validator;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.util.StringJoiner;

public class ValidatorEntity {

    @NotNull
    @NotBlank(message = "不能为空")
    @Length(min = 2, message = "姓名长度不能小于2")
    private String username;

    @NotNull
    @Min(value = 0, message = "年龄大于0")
    private Integer age;

    @NotNull
    @NotBlank(message = "不能为空")
    @Pattern(regexp = "^[FM]$",message = "性别只能为F或M")
    private String sex;

    @NotNull
    @NotBlank(message = "不能为空")
    @Email(message = "邮箱不正确")
    private String mail;

    @NotNull()
    @Past(message = "时间不能大于现在")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime birdth;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public LocalDateTime getBirdth() {
        return birdth;
    }

    public void setBirdth(LocalDateTime birdth) {
        this.birdth = birdth;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ValidatorEntity.class.getSimpleName() + "[", "]")
                .add("username='" + username + "'")
                .add("age=" + age)
                .add("sex='" + sex + "'")
                .add("mail='" + mail + "'")
                .add("birdth=" + birdth)
                .toString();
    }
}
