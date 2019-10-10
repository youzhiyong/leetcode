package com.yzy.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description:
 * Date: 2019-09-17
 *
 * 原子操作类
 *
 * @author youzhiyong
 */
public class TestAtomicInteger {

    private static int s = 0;
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {

        Thread a = new Thread(() -> {
            for (int j=0;j<10000;j++) {
                s++;
                atomicInteger.incrementAndGet();
            }
        });

        Thread b = new Thread(() -> {
            for (int j=0;j<10000;j++) {
                s++;
                atomicInteger.incrementAndGet();
            }
        });

        a.start();
        b.start();

        a.join();
        b.join();

        System.out.println(s);
        System.out.println(atomicInteger.get());

    }

}
