package com.yzy.thread.concurrent;

import com.yzy.thread.ThreadUtils;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Description:
 * Date: 2019-09-19
 *
 * @author youzhiyong
 */
public class TestThreadState {

    static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {

        new Thread(() -> {

            System.out.println("1111111111111");
           lock.lock();

           while (true) {

           }

           //lock.unlock();

        }).start();


        new Thread(() -> {
            System.out.println("222222222222");
            lock.lock();

            while (true) {

            }


        }).start();

        ThreadUtils.sleep(1);

        ThreadUtils.printThreadStatus(false);

    }

}
