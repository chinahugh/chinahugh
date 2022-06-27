package com.hugh.leanspringboot.cache.def;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class ConcurrentMapCacheController {
    Logger logger = LoggerFactory.getLogger(ConcurrentMapCacheController.class);

    @Resource
    private RedisTemplate redisTemplate;

    @GetMapping("/get0")
    public Map<String, String> get0(int key) {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < key; i++) {
            map.put(String.valueOf(i), String.valueOf(i));
        }
//        redisTemplate.opsForHash().putAll("cac#60#s", map);
        return map;
    }


    @GetMapping("/get")
    @Cacheable(cacheNames = "cac#60#s", key = "#key")
    public String get(String key) {
        String uuid = UUID.randomUUID().toString();
        logger.info("我不是缓存");
        return uuid;
    }

    @GetMapping("/getmap")
    @Cacheable(cacheNames = "cac#60#s", key = "#key")
    public Map<String, String> getmap(int key) {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < key; i++) {
            map.put(String.valueOf(i), String.valueOf(i));
        }
        return map;
    }

    @GetMapping("/put")
    @CachePut(cacheNames = "cac#60#s", key = "#key")
    public String put(HttpServletRequest request, String key, String value) {
        logger.info(value);
        logger.info("我不是缓存");
        return value;
    }

    @GetMapping("/del")
    @CacheEvict(cacheNames = "cac",key = "#key")
    public String del(String key) {
        logger.info("我不是缓存");
        return "ok";
    }

    /**
     * redis 订阅
     *
     * @param key
     * @return
     */
    @GetMapping("/dy")
    public String dy(String key, String msg) {
        redisTemplate.convertAndSend(key, msg);
        return "ok";
    }
}
