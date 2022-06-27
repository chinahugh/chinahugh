package com.hugh.leanspringboot.server.thread;

public class T1 extends Thread  {
    public static void main(String[] args) {
        T1 t1 = new T1();
        t1.start2();
//        start1();
        return;
    }

    private  static void start1() {
        T1 t1 = new T1();
        t1.start();
        System.out.println("main = " + Thread.currentThread().getName());
//        System.exit(1);
    } private    void start2() {
        T1 t1 = new T1();
//        t1.setDaemon(true);
        t1.start();
        System.out.println("Thread.currentThread().isAlive() = " + Thread.currentThread().isAlive());
        Thread.currentThread().setDaemon(true);
//        try {
//            t1.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("main = " + Thread.currentThread().getName());
//        System.exit(1);
    }


    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("true = " + Thread.currentThread().getName());
    }
}
