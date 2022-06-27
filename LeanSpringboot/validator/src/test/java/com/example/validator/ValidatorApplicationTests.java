package com.example.validator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ValidatorApplicationTests {

	@Test
	void contextLoads() {
	}

    @Autowired
    private ValidatorApplication validatorApplication;

    @Test
    public void test(){
        ValidatorEntity validated=new ValidatorEntity();
        Object o= validatorApplication.test(validated);
        System.out.println(o);
    }
}
