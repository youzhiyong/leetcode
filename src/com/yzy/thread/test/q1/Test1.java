package com.yzy.thread.test.q1;

/**
 * Description: 问题1 依次打印n次 AB, 一个线程打印A，另一个线程打印B
 * Date: 2019-09-17
 *
 * @author youzhiyong
 */
public class Test1 {

    private static boolean flag;

    private static volatile Object lock = new Object();


    public static void main(String[] args) {
        new Thread(() -> {
            for (int i=0; i<10; i++) {
                synchronized (lock) {
                    while (flag) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("A");
                    flag = !flag;
                    lock.notifyAll();
                }
            }
        }).start();

        new Thread(() -> {
            for (int i=0; i<10; i++) {
                synchronized (lock) {
                    while (!flag) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println("B");
                    flag = !flag;
                    lock.notifyAll();
                }
            }
        }).start();
    }


}
