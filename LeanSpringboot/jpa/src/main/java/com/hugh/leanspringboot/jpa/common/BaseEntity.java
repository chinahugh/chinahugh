package com.hugh.leanspringboot.jpa.common;

import com.hugh.leanspringboot.jpa.entity.User;
import org.springframework.data.jpa.domain.AbstractAuditable;
import org.springframework.lang.Nullable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.StringJoiner;

@MappedSuperclass
public class BaseEntity<PK extends Serializable>  extends AbstractAuditable<User, PK> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Nullable PK id;


    public PK getId() {
        return id;
    }

    public void setId(@Nullable PK id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", BaseEntity.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .toString();
    }
}
