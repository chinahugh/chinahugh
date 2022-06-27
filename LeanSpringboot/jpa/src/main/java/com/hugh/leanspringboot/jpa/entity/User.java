package com.hugh.leanspringboot.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hugh.leanspringboot.jpa.common.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;
@Entity
@Table(name = "t_user")
public class User extends BaseEntity<Long> {
    @Column
    private String name;

    @JsonIgnoreProperties(value = {"users"})
    @ManyToOne(targetEntity = Grade.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "grade_id", referencedColumnName = "id")
    private Grade grade;

    @JsonIgnoreProperties(value = {"users"})
    @OneToOne(targetEntity = Address.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @JsonIgnoreProperties(value = {"users"})
    @ManyToMany(targetEntity = Course.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "t_user_course",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "course_id", referencedColumnName = "id")})
    private Set<Course> courses = new HashSet<>();


    public User(String name, Address address, Grade grade) {
        this.name = name;
        this.address = address;
        this.grade = grade;
    }

    public User() {

    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("grade=" + grade)
                .add("address=" + address)
                .add("courses=" + courses)
                .toString();
    }
}
