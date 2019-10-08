package com.yzy.thread.test.q2;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description:
 * Date: 2019-09-17
 *
 * 原子操作类
 *
 * @author youzhiyong
 */
public class Test1 {

    private static int s = 0;
    private static volatile int i = 0;
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {

        Thread a = new Thread(() -> {
            for (int j=0;j<10000;j++) {
                i++;
                s++;
                atomicInteger.incrementAndGet();
            }
        });

        Thread b = new Thread(() -> {
            for (int j=0;j<10000;j++) {
                i++;
                s++;
                atomicInteger.incrementAndGet();
            }
        });

        a.start();
        b.start();

        a.join();
        b.join();

        System.out.println(s);
        System.out.println(i);
        System.out.println(atomicInteger.get());

    }

}
