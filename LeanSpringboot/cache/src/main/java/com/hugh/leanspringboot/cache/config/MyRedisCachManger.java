package com.hugh.leanspringboot.cache.config;

import io.lettuce.core.RedisException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.cache.RedisCache;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;

import java.time.Duration;

/**
 * redis 缓存过期时间的配置
 */
public class MyRedisCachManger extends RedisCacheManager {
    static final Logger logger = LoggerFactory.getLogger(MyRedisCachManger.class);
    static final String splstr = "#";

    public MyRedisCachManger(RedisCacheWriter cacheWriter, RedisCacheConfiguration defaultCacheConfiguration) {
        super(cacheWriter, defaultCacheConfiguration);
    }

    /**
     * 重新创建缓存的方法
     *
     * @param name
     * @param cacheConfig
     * @return
     */
    @Override
    protected RedisCache createRedisCache(String name, RedisCacheConfiguration cacheConfig) {

        logger.info("缓存名称：" + getCacheNames() + " ");
        //名称中存在#标记进行到期时间配置
        if (!name.isEmpty() && name.split(splstr).length == 3) {
           final String[] SPEL = name.split(splstr);
            //配置缓存到期时间
            int cycle = Integer.parseInt(SPEL[1]);
            //单位
            String type = SPEL[2];

            long time = 0;

            switch (type) {
                case "s"://秒
                    time = cycle;
                    break;
                case "m"://分
                    time = 60 * cycle;
                    break;
                case "h"://时
                    time = 60 * 60 * cycle;
                    break;
                case "d"://天
                    time = 24 * 60 * 60 * cycle;
                    break;
                default:
                    throw new RedisException("缓存cacheNames格式必须为“***#数字#时间类型”");
            }
            return super.createRedisCache(SPEL[0], cacheConfig.entryTtl(Duration.ofSeconds(time)));
        }
        throw new RedisException("缓存cacheNames格式必须为“***#数字#时间类型”");
    }
}
