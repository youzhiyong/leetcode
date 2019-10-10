package com.yzy.thread;

/**
 * Description:
 * Date: 2019-10-10
 *
 * @author youzhiyong
 */
public class TestInterrupt {

    public static void main(String[] args) {

        Thread thread = new Thread(new Running());

        thread.start();
        /*System.out.println("中断状态:" + thread.isInterrupted());
        ThreadUtils.sleep(1);
        thread.interrupt();
        ThreadUtils.sleep(2);
        System.out.println("中断状态:" + thread.isInterrupted());
        thread.interrupt();
        ThreadUtils.sleep(2);
        System.out.println("中断状态:" + thread.isInterrupted());*/
    }

    static class Running implements Runnable {
        @Override
        public void run() {
            System.out.println("中断状态:" + Thread.currentThread().isInterrupted());
            System.out.println("中断状态:" + Thread.interrupted());
            Thread.currentThread().interrupt();
            System.out.println("中断状态:" + Thread.interrupted());
            System.out.println("中断状态:" + Thread.currentThread().isInterrupted());
/*
            while (!Thread.interrupted()) {
                //ThreadUtils.sleep(1);
                System.out.println("线程未中断");
            }
            System.out.println("检测到线程被中断");

            while (!Thread.interrupted()) {
                //ThreadUtils.sleep(1);
                System.out.println("线程未中断-2");
            }*/
        }
    }

}
