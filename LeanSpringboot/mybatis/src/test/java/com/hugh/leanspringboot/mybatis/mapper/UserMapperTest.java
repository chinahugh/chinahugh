package com.hugh.leanspringboot.mybatis.mapper;

import com.hugh.leanspringboot.mybatis.MybatisApplicationTests;
import com.hugh.leanspringboot.mybatis.dao.TSaveDao;
import com.hugh.leanspringboot.mybatis.entity.TSave;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserMapperTest extends MybatisApplicationTests {

    @Resource
    TSaveDao tSaveDao;
    @Resource
    JdbcTemplate jdbcTemplate;

    @Test
    @Transactional
    void cusList() {
        long l = System.currentTimeMillis();

        List<TSave> list = new ArrayList<>(100000);
        for (int i = 0; i < 1; i++) {
            TSave user = new TSave();
//            user.setId((long) i);
            user.setName("胡国晖");
            user.setGradeId(user.getId());
            user.setAddressId((long) 1);
            user.setCreatedById((long) 1);
            user.setCreatedDate(LocalDateTime.now());
            user.setLastModifiedDate(LocalDateTime.now());
            user.setLastModifiedById((long) 1);
            list.add(user);
        }
        tSaveDao.saveBatch(list);
//        List<TSave> tSaves = tSaveDao.queryAll(new TSave());
//        System.out.println("tSaves = " + tSaves);

        long l1 = System.currentTimeMillis();
        System.out.println("耗时 = " + (l1 - l) / 1000);
    }
}
