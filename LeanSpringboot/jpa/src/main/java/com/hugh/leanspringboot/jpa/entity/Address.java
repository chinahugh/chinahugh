package com.hugh.leanspringboot.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hugh.leanspringboot.jpa.common.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.StringJoiner;

@Entity
@Table(name = "t_address")
public class Address extends BaseEntity<Long> {

    @Column
    private String address;


    @JsonIgnoreProperties(value = {"address"})
    @OneToOne(mappedBy = "address", cascade = CascadeType.ALL)
    private User user;

    public Address() {    }
    public Address(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Address.class.getSimpleName() + "[", "]")
                .add("address='" + address + "'")
                .add("user=" + user)
                .toString();
    }
}
