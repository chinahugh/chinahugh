package com.hugh.leanspringboot.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hugh.leanspringboot.jpa.common.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;

@Entity
@Table(name = "t_course")
public class Course extends BaseEntity<Long> {

    private String name;

    @JsonIgnoreProperties(value = {"courses"})
    @ManyToMany(targetEntity = User.class, cascade = CascadeType.ALL)
    @JoinTable(name = "t_user_course",
            joinColumns = {@JoinColumn(name = "course_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")})
    private Set<User> users = new HashSet<>();

    public Course(String name) {
        this.name = name;
    }

    public Course() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Course.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("users=" + users)
                .toString();
    }
}
