package com.yzy.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 测试 栈内存 溢出
 * Date: 2018-09-04
 * 加大堆内存 Xmx Xms  系统可供JVM的内存是有限的，堆内存和栈内存是处于此消彼长的状态，所以加大堆内存可以减小栈内存
 *  OutOfMemoryError: stack Stack空间不足以创建额外的线程。
 * @author youzhiyong
 */
public class TestOomOfStack {
    public static void main(String[] args) {
        List<MyThread> list = new ArrayList<>();
        long id = 1;
        while (true) {
            try {
                System.out.println(id);
                MyThread thread = new MyThread(id++);
                thread.start();
                list.add(thread);
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }

    static class MyThread extends Thread {

        private long id;

        public MyThread(long id) {
            this.id = id;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
