package com.hugh.leanspringboot.mybatis.entity;

import java.io.Serializable;

/**
 * (TBalance)实体类
 *
 * @author makejava
 * @since 2022-03-14 14:51:47
 */
public class TBalance implements Serializable {
    private static final long serialVersionUID = 429583584172561893L;

    public TBalance() {
    }

    public TBalance(Integer id, Double balance) {
        this.id = id;
        this.balance = balance;
    }

    private Integer id;

    private Double balance;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

}
