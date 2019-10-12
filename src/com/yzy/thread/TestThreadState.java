package com.yzy.thread;


import com.yzy.thread.ThreadUtils;

/**
 * Description:
 * Date: 2019-09-17
 *
 * @author youzhiyong
 */
public class TestThreadState {

    public static void main(String[] args) {

        /*Thread thread = new Thread(new Running(), "new-00");

        // NEW
        System.out.println(thread.getId() + " - " + thread.getName() + " - " + thread.getState());
        thread.start();
        // Runnable
        System.out.println(thread.getId() + " - " + thread.getName() + " - " + thread.getState());
        thread.interrupt();  //将线程设置为已中断
        ThreadUtils.sleep(1);
        // TERMINATED
        System.out.println(thread.getId() + " - " + thread.getName() + " - " + thread.getState());
*/

        // WAITING
        new Thread(new Waiting(), "waiting-01").start();

        //TIME_WAITING
        new Thread(new TimeWaiting0(), "TimeWaiting-02").start();
        new Thread(new TimeWaiting(), "timeWaiting-03").start();

        //两个Blocked 线程，一个获取锁成功，进入sleep， 另一个等待获取锁
        new Thread(new Blocked(), "block-04").start();
        new Thread(new Blocked(), "block-05").start();

        //打印线程信息
        ThreadUtils.printAllThreadStatus();


        //ThreadUtils.sleep(10);


        //打印线程信息
        //ThreadUtils.printAllThreadStatus();

        System.exit(0);

    }

    static class Running implements Runnable {   // running
        @Override
        public void run() {
                while (!Thread.interrupted()) {}

        }
    }

    static class Waiting implements Runnable {   // waiting
        @Override
        public void run() {
            synchronized (Waiting.class) {
                try {
                    Waiting.class.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e.getMessage());
                }
            }
        }
    }

    static class TimeWaiting0 implements Runnable {  // time_waiting
        @Override
        public void run() {
            while (true) {
                ThreadUtils.sleep(10);
            }
        }
    }

    static class TimeWaiting implements Runnable {     // time_waiting
        @Override
        public void run() {
            synchronized (TimeWaiting.class) {
                try {
                    TimeWaiting.class.wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Blocked implements Runnable {
        @Override
        public void run() {
            synchronized (Blocked.class) {
                ThreadUtils.sleep(10);
            }
        }
    }

}
