package com.hugh.leanspringboot.mybatis.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (TBalanceRecord)实体类
 *
 * @author makejava
 * @since 2022-03-14 14:52:13
 */
public class TBalanceRecord implements Serializable {
    private static final long serialVersionUID = 572690347194896627L;
    
    private Integer id;
    
    private Integer fromId;
    
    private Integer toId;
    
    private Double amount;
    
    private Date insertime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFromId() {
        return fromId;
    }

    public void setFromId(Integer fromId) {
        this.fromId = fromId;
    }

    public Integer getToId() {
        return toId;
    }

    public void setToId(Integer toId) {
        this.toId = toId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getInsertime() {
        return insertime;
    }

    public void setInsertime(Date insertime) {
        this.insertime = insertime;
    }

}