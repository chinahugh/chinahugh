package com.hugh.leanspringboot.jpa;

import com.hugh.leanspringboot.jpa.dao.ComplexTableDao;
import com.hugh.leanspringboot.jpa.entity.ComplexKey;
import com.hugh.leanspringboot.jpa.entity.ComplexTable;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

@SpringBootTest
class JpaApplicationTests {
	@Resource
	ComplexTableDao complexTableDao;

	@Test
	void contextLoads() {

		ComplexTable entity = new ComplexTable();
		entity.setName("asd");
		ComplexKey complexKey = new ComplexKey();
		complexKey.setKey1("1");
		complexKey.setKey2("2");
		entity.setComplexKey(complexKey);
		ComplexTable save = complexTableDao.save(entity);
		System.out.println("save = " + save);
		int page=0;
		int size=15;
		complexTableDao.findAll(PageRequest.of(page,size));
	}

}
