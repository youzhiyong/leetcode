package com.yzy.thread;

/**
 * Description:
 * Date: 2019-09-17
 * 测试捕获线程中的异常
 * 异常捕获优先级 ：本线程 > 线程组 > 全局  三者取其一，若都没有则抛出到控制台
 * Thread.setUncaughtExceptionHandler  > ThreadGroup > Thread.setDefaultUncaughtExceptionHandler
 *
 * @author youzhiyong
 */
public class TestUncaughtExceptionHandler {

    public static void main(String[] args) {

        try {
            ThreadGroup threadGroup = new MyThreadGroup("yzy-thread-group");
            Thread thread = new Thread(threadGroup, () -> {
                int a = 1 / 0;
            });

            thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                @Override
                public void uncaughtException(Thread t, Throwable e) {
                    System.out.println("Handle Exception in UncaughtExceptionHandler" + e.getMessage());
                }
            });

            Thread.setDefaultUncaughtExceptionHandler((t, e) -> System.out.println("Handle Exception in DefaultUncaughtExceptionHandler" + e.getMessage()));

            thread.start();

        } catch (Exception e) {
            System.out.println("Handle Exception in main try catch" + e.getMessage());
        }

        new Thread().start();

    }

    static class MyThreadGroup extends ThreadGroup {

        public MyThreadGroup(String name) {
            super(name);
        }

        public MyThreadGroup(ThreadGroup parent, String name) {
            super(parent, name);
        }

        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println("Handle Exception in ThreadGroup" + e.getMessage());
        }
    }

}
