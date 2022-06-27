package com.hugh.leanspringboot.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@SpringBootApplication
@RestController
public class KafkaApplication {
    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    public static void main(String[] args) {
        SpringApplication.run(KafkaApplication.class, args);
    }

    @GetMapping("/k")
    public void kafka(String msg) {
//        ListenableFuture<SendResult<String, String>> key = kafkaTemplate.send(KafkaConsumer.TOPIC_NAME,  UUID.randomUUID().toString() + msg);
//        key.addCallback(
//                result -> System.out.println("result = " + result),
//                ex -> System.out.println("ex = " + ex));
        kafkaProducer(msg);
    }

    @Bean
    public void kafkaProducer( ) {
        kafkaProducer("默认");
    }
    public void kafkaProducer(String msg) {
        Runnable runnable = () -> {
            for (int i = 0; i < 10; i++) {
                ListenableFuture<SendResult<String, String>> key = kafkaTemplate.send(
                        MyKafkaConsumer.TOPIC_NAME, i + "_" + msg);
                key.addCallback(
                        result -> System.out.println("result = " + result),
                        ex -> System.out.println("ex = " + ex));
            }
        };
        runnable.run();
    }
}
