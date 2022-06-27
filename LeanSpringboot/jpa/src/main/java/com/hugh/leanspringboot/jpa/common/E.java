package com.hugh.leanspringboot.jpa.common;

/**
 * 自定义异常
 */
public class E extends RuntimeException {
    public E() {
        super("后台错误，请联系信息部");
    }

    public E(String message) {
        super(message);
    }

    public E(String message, Throwable cause) {
        super(message, cause);
    }

    public E(Throwable cause) {
        super(cause);
    }

}
