package com.yzy.thread.test.q1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description:
 * Date: 2019-09-19
 *
 * @author youzhiyong
 */
public class Test5 {

    private static ReentrantLock reentrantLock = new ReentrantLock();
    private static Condition condition = reentrantLock.newCondition();

    public static void main(String[] args) {


        new Thread(() -> {
            try {
                for (int i=0; i<10;i++) {
                    System.out.print("A");
                    reentrantLock.lock();
                    condition.signal();
                    condition.await();
                    reentrantLock.unlock();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();

        new Thread(() -> {
            try {
                for (int i=0; i<10;i++) {
                    reentrantLock.lock();
                    condition.await();
                    System.out.println("B");
                    condition.signal();
                    reentrantLock.unlock();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();


    }


    // 这里有个bug ,但打印A的线程先获取锁则会出现死锁
    static void solution1() {

        new Thread(() -> {
            try {
                for (int i=0; i<10;i++) {
                    reentrantLock.lock();
                    condition.await();
                    System.out.println("B");
                    condition.signal();
                    reentrantLock.unlock();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();

        new Thread(() -> {
            try {
                for (int i=0; i<10;i++) {
                    reentrantLock.lock();
                    System.out.print("A");
                    condition.signal();
                    condition.await();
                    reentrantLock.unlock();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();

    }


}
