//package com.hugh.lenaspringboot.security;
//
//import cn.hutool.jwt.JWT;
//
//import java.nio.charset.StandardCharsets;
//
//public class JWTTest {
//    public static void main(String[] args) {
//        String key = "123456和";
//        JWT jwt = JWT.create();
//        jwt.setPayload("username", "阿斯顿");
//        jwt.setKey(key.getBytes(StandardCharsets.UTF_8));
//
//        String sign = jwt.sign();
//        System.out.println("sign = " + sign);
//        JWT of = JWT.of("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6MTIzfQ.3tx5AsZDY6eB9egnMhYQmEa2YzXKTu3_KaIcFey3gts");
////        System.out.println("of.sign() = " + of.sign());
////        System.out.println("of.getPayload(\"username\") = " + of.getPayload("username"));
////        System.out.println("of.validate(0) = " + of.validate(2));
////        System.out.println("of.verify() = " + of.verify());
//        of.getPayloads().forEach((a, b) -> System.out.println(a + " " + b));
//        of.getHeaders().forEach((a, b) -> System.out.println(a + " " + b));
//        System.out.println("of.setKey(key.getBytes()).verify() = " +
//                of
//                        .setKey(key.getBytes(StandardCharsets.UTF_8)).verify());
//    }
//}
////eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6IumYv-aWr-mhvyJ9.zZSWBIXzsmJHCWaQUzvn6bXkY6hzEeKNXpnkZAhBSXs
////eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6IumYv-aWr-mhvyJ9.zZSWBIXzsmJHCWaQUzvn6bXkY6hzEeKNXpnkZAhBSXs
