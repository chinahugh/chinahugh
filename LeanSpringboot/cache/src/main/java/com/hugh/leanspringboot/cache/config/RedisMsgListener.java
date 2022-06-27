package com.hugh.leanspringboot.cache.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.Duration;

@Component
public class RedisMsgListener implements MessageListener {
    Logger logger = LoggerFactory.getLogger(RedisMsgListener.class);
    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public void onMessage(Message message, byte[] pattern) {
        redisTemplate.opsForValue().set(1,1, Duration.ofSeconds(3));
        // 获取消息
        byte[] messageBody = message.getBody();
        // 使用值序列化器转换
        Object msg = redisTemplate.getValueSerializer().deserialize(messageBody);
        logger.info( msg + " : " + new String(message.getChannel()));
        logger.info(new String(pattern));
    }
}
