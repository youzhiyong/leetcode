package com.yzy.thread.test.q1;

import java.util.concurrent.locks.LockSupport;

/**
 * Description:
 * Date: 2019-09-19
 * 使用LockSupport 的 park/unpark模型
 *
 * @author youzhiyong
 */
public class Test6 {

    private static Thread a = null;
    private static Thread b = null;

    public static void main(String[] args) {


        a = new Thread(() -> {

            for (int i=0; i<10;i++) {
                System.out.print("A");
                LockSupport.unpark(b);
                LockSupport.park();
            }

        });

        b = new Thread(() -> {

            for (int i=0; i<10;i++) {
                LockSupport.park();
                System.out.println("B");
                LockSupport.unpark(a);
            }

        });

        a.start();
        b.start();

    }
}
