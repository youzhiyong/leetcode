package com.yzy.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Description:
 * Date: 2019-09-17
 *
 * @author youzhiyong
 */
public class TestCreateThread {

    public static void main(String[] args) {

        //1. 实现Runnable接口
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("实现Runnable接口 ");
            }
        }).start();

        //2. 继承Thread类
        new MyThread().start();

        //3. 实现Callnable接口  实际上也是实现的Runnable接口
        FutureTask task = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("实现Callnable接口 ");
                return null;
            }
        });
        new Thread(task).start();
    }


    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("继承Thread类");
        }
    }


}
