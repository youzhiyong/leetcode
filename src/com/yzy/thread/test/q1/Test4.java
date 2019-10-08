package com.yzy.thread.test.q1;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Semaphore;

/**
 * Description:
 * Date: 2019-09-19
 *
 * 使用Semaphore
 *
 * @author youzhiyong
 */
public class Test4 {

    //release + 1
    //acquire - 1   减1后 值>=0值获取锁成功
    private static Semaphore semaphoreA = new Semaphore(0);  // 构造函数中的参数只是初始值，这个值可以随着release的次数无限增加
    private static Semaphore semaphoreB = new Semaphore(0);

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                for (int i=0; i<10;i++) {
                    System.out.print("A");
                    semaphoreB.release();
                    semaphoreA.acquire();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();

        new Thread(() -> {

            try {
                for (int i=0; i<10;i++) {
                    semaphoreB.acquire();
                    System.out.println("B");
                    semaphoreA.release();
                }

            } catch (Exception e) {

            }
        }).start();
    }

}
