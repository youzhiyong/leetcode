package com.yzy.thread.test.q1;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Description:
 * Date: 2019-09-19
 *
 * @author youzhiyong
 */
public class Test3 {

    //CyclicBarrier 可循环使用
    private static CyclicBarrier cyclicBarrierA = new CyclicBarrier(2);
    private static CyclicBarrier cyclicBarrierB = new CyclicBarrier(2);

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                for (int i=0; i<10;i++) {
                    System.out.print("A");
                    cyclicBarrierB.await();
                    cyclicBarrierA.await();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }


        }).start();

        new Thread(() -> {

            try {
                for (int i=0; i<10;i++) {
                    cyclicBarrierB.await();
                    System.out.println("B");
                    cyclicBarrierA.await();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();


    }

}
