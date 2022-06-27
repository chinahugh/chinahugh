package com.hugh.leanspringboot.server.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class ThreadA extends Thread {
   static final Logger logger = LoggerFactory.getLogger(ThreadA.class);

    public ThreadA(String name) {
        super(name);
    }

    @Override
    public void run() {
        logger.info("this = " + 8);
        synchronized (this) {
            logger.info("this = " + this);
            try {
                logger.info("true = " + true);
                Thread.sleep(1000); //  使当前线阻塞 1 s，确保主程序的 t1.wait(); 执行之后再执行 notify()
            } catch (Exception e) {
                e.printStackTrace();
            }
            logger.info(Thread.currentThread().getName() + " call notify()");
            // 唤醒当前的wait线程
            this.notify();
            try {
                Thread.sleep(2000);
                logger.info(Thread.currentThread().getName() + " call notify() 再执行");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info(Thread.currentThread().getName() + " synchronized 再执行");
    }
}

public class WaitTest {
  static final  Logger logger = LoggerFactory.getLogger(WaitTest.class);

    public static void main(String[] args) {
        ThreadA t1 = new ThreadA("t1");
        synchronized (t1) {
            logger.info("t1 = " + t1);
            try {
                // 启动“线程t1”
                logger.info(Thread.currentThread().getName() + " start t1");
                t1.start();
//                Thread.sleep(100);
                // 主线程等待t1通过notify()唤醒。
                logger.info(Thread.currentThread().getName() + " wait()");
                t1.wait();  //  不是使t1线程等待，而是当前执行wait的线程等待
                logger.info(Thread.currentThread().getName() + " continue");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        logger.info("11111111 = " + 11111111);
    }
}
