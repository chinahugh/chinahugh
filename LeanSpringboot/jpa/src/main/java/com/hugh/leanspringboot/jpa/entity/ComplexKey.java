package com.hugh.leanspringboot.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.StringJoiner;

@Embeddable
public class ComplexKey implements Serializable {

    @Column(name = "key1")
    private String key1;

    @Column(name = "key2")
    private String key2;

    public String getKey1() {
        return key1;
    }

    public void setKey1(String key1) {
        this.key1 = key1;
    }

    public String getKey2() {
        return key2;
    }

    public void setKey2(String key2) {
        this.key2 = key2;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ComplexKey.class.getSimpleName() + "[", "]")
                .add("key1='" + key1 + "'")
                .add("key2='" + key2 + "'")
                .toString();
    }
}
