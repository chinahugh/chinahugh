package com.hugh.leanspringboot.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
public class MyKafkaConsumer {
    Logger logger= LoggerFactory.getLogger(MyKafkaConsumer.class);



    //topic的名称
    public final static String TOPIC_NAME = "mykafka";
    // 消费监听
    @KafkaListener(id = "发",topics = {"mykafka"},groupId = "a")
    public void onMessage1(ConsumerRecord<?, ?> record, Acknowledgment ack,  @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        // 消费的哪个topic、partition的消息,打印出消息内容
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        ack.acknowledge();

        logger.info("简单消费：" + record.topic() + "-" + record.partition() + "-" + record.value());
    }
    @KafkaListener(id = "阿斯顿",topics = {"mykafka"},groupId = "ab")
    public void onMessageb(ConsumerRecord<?, ?> record, Acknowledgment ack,  @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        // 消费的哪个topic、partition的消息,打印出消息内容
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//       ack.acknowledge();
        logger.info("简单消费：" + record.topic() + "-" + record.partition() + "-" + record.value());
    }
//    @KafkaListener(id = "阿斯顿as",topics = {"mykafka"},groupId = "abv" )
//    public void onMessageb(List<ConsumerRecord<?, ?>> records, Acknowledgment ack) {
//        // 消费的哪个topic、partition的消息,打印出消息内容
////        try {
////            Thread.sleep(3000);
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        }
//        ack.acknowledge();
//        for (ConsumerRecord record:records) {
//            logger.info("简单消费：" + record.topic() + "-" + record.partition() + "-" + record.value());
//
//        }
//    }
//    @Autowired
//    ThreadPoolTaskExecutor poolTaskExecutor;
//    public void t(){
//        poolTaskExecutor.submitListenable(() -> {
//
//        }).addCallback(success->{},ex -> {});
//
//    }
}
