package com.yzy.thread;

/**
 * Description:
 * Date: 2019-09-18
 *
 * @author youzhiyong
 */
public class TestNotifyAndNotifyAll {

    public static void main(String[] args) {

        new Thread(new Runner(), " runner-1").start();
        new Thread(new Runner(), " runner-2").start();

        ThreadUtils.sleep(1);

        /**
         此时两个线程的状态为  WAITING，都在阻塞队列中 输出如下：
         13 -  runner-2 - WAITING
         12 -  runner-1 - WAITING
         */
        ThreadUtils.printThreadStatus(false);


        synchronized (Runner.class) {
            Runner.class.notify();   // 唤醒其中一个等待该锁的线程由 阻塞队列 进入 同步队列，进入同步队列的线程有机会获取到锁进入 RUNNABLE 状态，；另一个在阻塞队列为获取到锁的线程处于 WAITING状态
            //Runner.class.notifyAll(); // 唤醒所有等待该锁的线程由 阻塞队列 进去同步队列，进入同步队列的线程会有一个线程有机会获取到锁进入 RUNNABLE 状态,另一个在同步队列未获取到锁的线程处于 BLOCKED状态
        }

        ThreadUtils.sleep(1);

        ThreadUtils.printThreadStatus(false);
        /**
         若为 Runner.class.notify();则输出可能如下
         13 -  runner-2 - RUNNABLE    ---运行
         12 -  runner-1 - WAITING     ---处于阻塞队列

         若为 Runner.class.notifyAll();则输出可能如下
         13 -  runner-2 - RUNNABLE    ---运行
         12 -  runner-1 - BLOCKED     ---处于同步队列
         */

        System.exit(0);
    }

    static class Runner implements Runnable {
        @Override
        public void run() {
            synchronized (Runner.class) {

                try {
                    Runner.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                while (true) {}
            }

        }
    }

}
