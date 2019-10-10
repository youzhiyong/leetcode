package com.yzy.thread.test.q1;

import com.yzy.thread.ThreadUtils;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description:
 * Date: 2019-09-19
 * 使用可重入锁和Condition
 *
 * @author youzhiyong
 */
public class Test5 {

    private static Lock reentrantLock = new ReentrantLock();
    private static Condition condition = reentrantLock.newCondition();

    public static void main(String[] args) {


        //ThreadUtils.sleep(1);
        new Thread(() -> {
            try {
                for (int i=0; i<10;i++) {
                    reentrantLock.lock();
                    try {
                        condition.await();
                        System.out.println("B");
                        condition.signal();
                    } finally {
                        reentrantLock.unlock();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();

        new Thread(() -> {
            try {
                for (int i=0; i<10;i++) {
                    System.out.print("A");
                    reentrantLock.lock();
                    try {
                        condition.signal();
                        condition.await();
                    } finally {
                        reentrantLock.unlock();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();

        // 这里有个bug ,打印A的线程先获取锁并执行condition.signal();则会出现死锁

    }

}
