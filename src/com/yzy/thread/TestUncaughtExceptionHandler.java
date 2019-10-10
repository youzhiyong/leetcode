package com.yzy.thread;

/**
 * Description:
 * Date: 2019-09-17
 * 测试捕获线程中的异常
 * @author youzhiyong
 */
public class TestUncaughtExceptionHandler {

    public static void main(String[] args) {

        try {

            Thread thread = new Thread(() -> {
                int a = 1 / 0;
            });

            thread.setUncaughtExceptionHandler((t, e) -> System.out.println("Handle Exception in UncaughtExceptionHandler" + e.getMessage()));

            Thread.setDefaultUncaughtExceptionHandler((t, e) -> System.out.println("Handle Exception in DefaultUncaughtExceptionHandler" + e.getMessage()));

            thread.start();

        } catch (Exception e) {
            System.out.println("Handle Exception in main try catch" + e.getMessage());
        }

    }

}
