package com.hugh.leanspringboot.kafka;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
class KafkaProducerApplicationTests {
//	private final static String TOPIC_NAME = "mykafka"; //topic的名称
//	@Resource
//	KafkaTemplate<String,String> kafkaTemplate;
//
//	@Test
//	public void kafka() {
//		ListenableFuture<SendResult<String, String>> key = kafkaTemplate.send(TOPIC_NAME, "key", UUID.randomUUID().toString()+"test message send22~");
//		key.addCallback(result -> System.out.println("result = " + result),ex -> System.out.println("ex = " + ex));
//	}
//
	@Test
	void contextLoads() {

	}

}
