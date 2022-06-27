package com.hugh.leanspringboot.cache;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class RedisTest {

    public static void main(String[] args) throws IOException {
        File file = new File("D:/a.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file,false);
        int num =  1000000000;//Integer.MAX_VALUE;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                Runtime.getRuntime().availableProcessors(),
                Runtime.getRuntime().availableProcessors() * 2,
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(num),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());
        CompletableFuture<Void> a = CompletableFuture.runAsync(() -> {
            try {
                for (int m = 0; m < num; m++) {
                    fileOutputStream.write((Thread.currentThread().getName() + "____" + m + "\n").getBytes());
                    fileOutputStream.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        CompletableFuture<Void> b= CompletableFuture.runAsync(() -> {
            try {
                for (int m = 0; m < num; m++) {
                    fileOutputStream.write((Thread.currentThread().getName() + "____" + m + "\n").getBytes());
                    fileOutputStream.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        CompletableFuture<Void> c = CompletableFuture.runAsync(() -> {
            try {
                for (int m = 0; m < num; m++) {
                    fileOutputStream.write((Thread.currentThread().getName() + "____" + m + "\n").getBytes());
                    fileOutputStream.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        CompletableFuture<Void> d = CompletableFuture.runAsync(() -> {
            try {
                for (int m = 0; m < num; m++) {
                    fileOutputStream.write((Thread.currentThread().getName() + "____" + m + "\n").getBytes());
                    fileOutputStream.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(a,b,c,d).thenRun(() -> {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        voidCompletableFuture.join();

        threadPoolExecutor.shutdown();
    }
}
