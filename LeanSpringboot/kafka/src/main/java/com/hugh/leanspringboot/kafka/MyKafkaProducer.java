package com.hugh.leanspringboot.kafka;


import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@Configuration
public class MyKafkaProducer {

    Logger logger= LoggerFactory.getLogger(MyKafkaProducer.class);

    /**
     * 创建TopicName为topic.hangge.initial的Topic并设置分区数为8以及副本数为1
     */
    @Bean
    public NewTopic initialTopic() {
        return new NewTopic("topic.hangge.initial", 8, (short) 1);
    }

    /**
     * 创建TopicName为topic.hangge.initial的Topic并设置分区数为8以及副本数为1
     */
    @Bean
    public NewTopic initialTopic1() {
        return new NewTopic("topic.hangge.initial1", 2, (short) 1);
    }

    /**
     * 创建TopicName为topic.hangge.initial的Topic并设置分区数为8以及副本数为1
     */
    @Bean
    public NewTopic initialTopic2() {
        return new NewTopic("mykafka", 10, (short) 1);
    }


}
