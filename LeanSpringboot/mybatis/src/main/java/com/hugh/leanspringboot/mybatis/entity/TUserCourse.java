package com.hugh.leanspringboot.mybatis.entity;

import java.io.Serializable;

/**
 * (TUserCourse)实体类
 *
 * @author makejava
 * @since 2022-02-12 16:06:02
 */
public class TUserCourse implements Serializable {
    private static final long serialVersionUID = 353523926466464595L;
    
    private Long userId;
    
    private Long courseId;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

}