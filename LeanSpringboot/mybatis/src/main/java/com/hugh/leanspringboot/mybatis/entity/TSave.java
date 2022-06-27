package com.hugh.leanspringboot.mybatis.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.StringJoiner;

/**
 * (TSave)实体类
 *
 * @author makejava
 * @since 2022-06-24 17:49:06
 */
public class TSave implements Serializable {
    private static final long serialVersionUID = -46620956752433909L;

    private Long id;

    private String name;

    private Long addressId;

    private Long gradeId;

    private LocalDateTime createdDate;

    private LocalDateTime lastModifiedDate;

    private Long createdById;

    private Long lastModifiedById;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public Long getGradeId() {
        return gradeId;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }

    public Object getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Long getCreatedById() {
        return createdById;
    }

    public void setCreatedById(Long createdById) {
        this.createdById = createdById;
    }

    public Long getLastModifiedById() {
        return lastModifiedById;
    }

    public void setLastModifiedById(Long lastModifiedById) {
        this.lastModifiedById = lastModifiedById;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TSave.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("addressId=" + addressId)
                .add("gradeId=" + gradeId)
                .add("createdDate=" + createdDate)
                .add("lastModifiedDate=" + lastModifiedDate)
                .add("createdById=" + createdById)
                .add("lastModifiedById=" + lastModifiedById)
                .toString();
    }
}
