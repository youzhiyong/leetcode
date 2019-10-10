package com.yzy.thread.test.q1;


import java.util.concurrent.Exchanger;

/**
 * Description:
 * Date: 2019-09-19
 * 使用Exchanger
 *
 * @author youzhiyong
 */
public class Test7 {

    public static void main(String[] args) {

        Exchanger<Integer> exchanger = new Exchanger<>();
        new A(exchanger).start();
        new B(exchanger).start();


    }

    static class A extends Thread {
        private Exchanger<Integer> exchanger;
        A(Exchanger<Integer> exchanger) {
            this.exchanger = exchanger;
        }

        @Override
        public void run() {
            for (int i=0; i<10; i++) {
                try {
                    System.out.print("A");
                    exchanger.exchange(1);
                    exchanger.exchange(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class B extends Thread {
        private Exchanger<Integer> exchanger;
        B(Exchanger<Integer> exchanger) {
            this.exchanger = exchanger;
        }

        @Override
        public void run() {
            for (int i=0; i<10; i++) {
                try {
                    exchanger.exchange(1);
                    System.out.println("B");
                    exchanger.exchange(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
