package com.example.demo.validation.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2022-08-16 22:09:47
 */
public class User implements Serializable {
    private static final long serialVersionUID = -98599240320305008L;

    public User(Integer id, String name, Long hx, Date birth) {
        this.id = id;
        this.name = name;
        this.hx = hx;
        this.birth = birth;
    }

    private Integer id;

    private String name;

    private Long hx;

    private Date birth;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getHx() {
        return hx;
    }

    public void setHx(Long hx) {
        this.hx = hx;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

}

