package com.hugh.leanspringboot.zookeeper;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class ZookeeperTest {
    public static void main(String[] args) {
        try {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            ZooKeeper zooKeeper = new ZooKeeper("192.168.0.102:2181", 4000, event -> {
                System.out.println("new ObjectMapper().createObjectNode().putPOJO(\"a\",event).toString() = " +
                        new ObjectMapper().createObjectNode().putPOJO("a", event).toString());
                countDownLatch.countDown();
            });
            countDownLatch.await();
            System.out.println(zooKeeper.getState());
            zooKeeper.delete("/runoob",1);
            zooKeeper.create("/runoob","110".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        } catch (IOException | InterruptedException | KeeperException e) {
            e.printStackTrace();
        }
    }
}
