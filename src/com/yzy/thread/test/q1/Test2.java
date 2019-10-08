package com.yzy.thread.test.q1;

import java.util.concurrent.CountDownLatch;

/**
 * Description:
 * Date: 2019-09-19
 *
 * 使用CountDownLatch
 *
 * @author youzhiyong
 */
public class Test2 {

    private static CountDownLatch countDownLatchA = new CountDownLatch(1);
    private static CountDownLatch countDownLatchB = new CountDownLatch(1);

    public static void main(String[] args) {

        new Thread(() ->{
            try {
                for (int i = 0; i < 10; i++) {
                    countDownLatchA = new CountDownLatch(1);
                    System.out.print("A");
                    countDownLatchB.countDown();
                    countDownLatchA.await();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }).start();

        new Thread(() ->{
            try {
                for (int i = 0; i < 10; i++) {

                    countDownLatchB.await();
                    System.out.println("B");
                    countDownLatchA.countDown();
                    countDownLatchB = new CountDownLatch(1);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }).start();


    }

}
