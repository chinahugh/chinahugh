package com.example.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.concurrent.CountDownLatch;

public class Test {
    public static void main() throws InterruptedException, IOException {
        File file1 = new File("E:/a.txt");

        System.out.println(file1.length());
        int i = Runtime.getRuntime().availableProcessors()-1;

        System.out.println("线程数" + i);
        long l = file1.length() / i;
        long l1 = file1.length() % i;


        long mil = System.currentTimeMillis();
        CountDownLatch count = new CountDownLatch(i);
        for (int j = 0; j < i; j++) {
            int finalJ = j;
            new Thread(() -> {
                try {
                    RandomAccessFile file = new RandomAccessFile(file1, "r");
                    file.seek(finalJ * l);
                    System.out.println("finalJ = " + finalJ * l);
                    long sy = l;
                    int a = l > Integer.MAX_VALUE >> 3 ? Integer.MAX_VALUE >>3 : (int) l;
                    byte[] b = new byte[a];
                    while ((a = file.read(b)) != -1) {
                        if ((sy = sy - a) > 0) {
                            if (a > sy) {
                                a = (int) sy;
                                b = new byte[a];
                            }
                        } else {
                            break;
                        }
                    }
                    file.close();
                    count.countDown();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        if (l1 > 0) {
            try {
                RandomAccessFile file = new RandomAccessFile(file1, "r");
                file.seek((i) * l);
                int a = l > Integer.MAX_VALUE >> 4 ? Integer.MAX_VALUE >> 4 : (int) l;
                byte[] b = new byte[a];
                while ((a = file.read(b)) != -1) {

                }
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        count.await();
        System.out.println((System.currentTimeMillis() - mil) / 1000);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
//        Thread.sleep(3000);
//        readerFile("E:/a.txt");
        main();
    }

    // 读取文件
    public static void readerFile(String path) {
        try {
//            BufferedInputStream br = new BufferedInputStream(new FileInputStream(path));
            FileInputStream br = new FileInputStream(path);
            long start = System.currentTimeMillis();
            int a = Integer.MAX_VALUE >> 4;
            byte[] b = new byte[a];
            while ((a = br.read(b)) != -1) {

            }
            br.close();
            long end = System.currentTimeMillis();
            System.out.println("读取耗时：" + (end - start) + "ms = "
                    + ((double) (end - start) / 1000) + "s");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }  // 读取文件

    public static void readerFile2(String path) {
        try {
            File file = new File(path);
            FileChannel channel = new FileInputStream(file).getChannel();
//            channel.read()
            long start = System.currentTimeMillis();
            long end = System.currentTimeMillis();
            System.out.println("读取耗时：" + (end - start) + "ms = "
                    + ((double) (end - start) / 1000) + "s");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
