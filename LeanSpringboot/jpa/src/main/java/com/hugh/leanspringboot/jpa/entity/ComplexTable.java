package com.hugh.leanspringboot.jpa.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.StringJoiner;

@Entity
@Table(name = "t_ComplexTable")
public class ComplexTable   {
    @EmbeddedId
    private ComplexKey complexKey;


    private String name;

    public ComplexKey getComplexKey() {
        return complexKey;
    }

    public void setComplexKey(ComplexKey complexKey) {
        this.complexKey = complexKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ComplexTable.class.getSimpleName() + "[", "]")
                .add("complexKey=" + complexKey)
                .add("name='" + name + "'")
                .toString();
    }
}
