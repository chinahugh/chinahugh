package com.hugh.leanspringboot.jpa.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedHashMap;

/**
 * 自定义返回类
 */
public class R extends LinkedHashMap<String, Object> {
    private static final long serialVersionUID = 4626535312542645606L;

    private final Logger logger = LoggerFactory.getLogger(R.class);

    private R() {
        super(16);
    }

    @Override
    public R put(String key, Object value) {
        if (key == null || "".equals(key) || value == null || "".equals(value.toString())) {
            logger.error("The key-value pair put into the map is empty, key:'{}',value:'{}',R:'{}' ", key, value, this);
        } else {
            super.put(key, value);
        }
        return this;
    }

    public static R make(int code) {
        return new R().put("code", code).put("timestamp", System.currentTimeMillis());
    }

    public static R ok() {
        return make(200);
    }

    public static R ok(Object data) {
        return ok().put("data", data);
    }

    public static R ok(String msg) {
        return ok().put("msg", msg);
    }

    public static R ok(String msg, Object data) {
        return ok().put("msg", msg).put("data", data);
    }

    public static R error() {
        return make(500);
    }

    public static R error(String msg) {
        return  make(500).put("msg", msg);
    }

//    public  R putMap(Map<String, Object> map) {
//        map.forEach((key, value) -> this.put(key, value));
//        return this;
//    }
}
