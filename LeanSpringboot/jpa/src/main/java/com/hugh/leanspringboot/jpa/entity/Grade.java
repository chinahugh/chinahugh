package com.hugh.leanspringboot.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hugh.leanspringboot.jpa.common.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

@Entity
@Table(name = "t_grade")
public class Grade extends BaseEntity<Long> {

    private String name;

    @JsonIgnoreProperties(value = {"grade"})
    @OneToMany(mappedBy = "grade",cascade = CascadeType.ALL)//targetEntity = User.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER
    private List<User> users=new ArrayList<>();

    public Grade(String name) {
        this.name = name;
    }

    public Grade() {

    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Grade.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("users=" + users)
                .toString();
    }
}
