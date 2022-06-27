package com.hugh.leanspringboot.base;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {
        System.out.println("list = " + Runtime.getRuntime().availableProcessors());
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("1 = " + 1);
        });
        Void join = voidCompletableFuture.join();

    }
}
