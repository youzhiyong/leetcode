package com.yzy.thread.test.q1;

import com.yzy.thread.ThreadUtils;

/**
 * Description: 问题1 依次打印n次 AB, 一个线程打印A，另一个线程打印B
 * Date: 2019-09-17
 *
 *
 * wait/notify模型
 *
 * @author youzhiyong
 */
public class Test1 {

    private static boolean flag;

    private static volatile Object lock = new Object();


    public static void main(String[] args) {

        Thread b = new Thread(() -> {
            for (int i=0; i<10; i++) {
                synchronized (lock) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("B");
                    flag = !flag;
                    lock.notifyAll();
                }
            }
        });

        Thread a = new Thread(() -> {
            for (int i=0; i<10; i++) {
                synchronized (lock) {
                    System.out.print("A");
                    lock.notifyAll();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        //打印B的线程必须先获取到锁然后进入等待状态,否则可能出现死锁
        b.start();
        a.start();

        //死锁
        /*a.start();
        b.start();*/
    }


    public static void solution2() {
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
