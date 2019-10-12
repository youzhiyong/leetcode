package com.yzy.others;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class FizzBuzz {
    private int n;
    private AtomicInteger atomicInt = new AtomicInteger(1);
    private Thread threadA = null;
    private Thread threadB = null;
    private Thread threadC = null;
    private Thread threadD = null;
    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz() throws InterruptedException {
        int i = atomicInt.get();
        threadA = Thread.currentThread();
        while (i <= n) {
            if (i % 3 == 0 && i % 5 != 0) {
                System.out.println("fizz");
                i = atomicInt.incrementAndGet();
                if (i % 3 == 0 && i % 5 == 0) {
                    while (threadC == null) {}  //等待threadC赋值
                    LockSupport.unpark(threadC);
                } else if (i % 3 != 0 && i % 5 == 0) {
                    while (threadB == null) {}  //等待threadB赋值
                    LockSupport.unpark(threadB);
                } else {
                    while (threadD == null) {}  //等待threadD赋值
                    LockSupport.unpark(threadD);
                }
            } else {
                LockSupport.park();
                i = atomicInt.get();
            }
        }

        LockSupport.unpark(threadB);
        LockSupport.unpark(threadD);
        LockSupport.unpark(threadC);
    }

    // printBuzz.run() outputs "buzz".
    public void buzz() throws InterruptedException {
        threadB = Thread.currentThread();
        int i = atomicInt.get();
        while (i <= n) {
            if (i % 3 != 0 && i % 5 == 0) {
                System.out.println("buzz");
                i = atomicInt.incrementAndGet();
                if (i % 3 == 0 && i % 5 == 0) {
                    while (threadC == null) {}  //等待threadC赋值
                    LockSupport.unpark(threadC);
                } else if (i % 3 == 0 && i % 5 != 0) {
                    while (threadA == null) {}  //等待threadB赋值
                    LockSupport.unpark(threadA);
                } else {
                    while (threadD == null) {}  //等待threadD赋值
                    LockSupport.unpark(threadD);
                }
            } else {
                LockSupport.park();
                i = atomicInt.get();
            }
        }

        LockSupport.unpark(threadA);
        LockSupport.unpark(threadD);
        LockSupport.unpark(threadC);
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz() throws InterruptedException {
        threadC = Thread.currentThread();
        int i = atomicInt.get();
        while (i <= n) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("fizzbuzz");
                i = atomicInt.incrementAndGet();
                if (i % 3 == 0 && i % 5 != 0) {
                    while (threadA == null) {}  //等待threadC赋值
                    LockSupport.unpark(threadA);
                } else if (i % 3 != 0 && i % 5 == 0) {
                    while (threadB == null) {}  //等待threadB赋值
                    LockSupport.unpark(threadB);
                } else {
                    while (threadD == null) {}  //等待threadD赋值
                    LockSupport.unpark(threadD);
                }
            } else {
                LockSupport.park();
                i = atomicInt.get();
            }
        }
        LockSupport.unpark(threadA);
        LockSupport.unpark(threadB);
        LockSupport.unpark(threadD);


    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number() throws InterruptedException {
        threadD = Thread.currentThread();
        int i = atomicInt.get();
        while (i <= n) {
            if (i % 3 != 0 && i % 5 != 0) {
                System.out.println(i);
                i = atomicInt.incrementAndGet();
                if (i % 3 == 0 && i % 5 == 0) {
                    while (threadC == null) {}  //等待threadC赋值
                    LockSupport.unpark(threadC);
                } else if (i % 3 != 0 && i % 5 == 0) {
                    while (threadB == null) {}  //等待threadB赋值
                    LockSupport.unpark(threadB);
                } else {
                    while (threadA == null) {}  //等待threadD赋值
                    LockSupport.unpark(threadA);
                }
            } else {
                LockSupport.park();
                i = atomicInt.get();
            }
        }
        LockSupport.unpark(threadA);
        LockSupport.unpark(threadB);
        LockSupport.unpark(threadC);
    }


    public static void main(String[] args) {
        final int num = 15;
        final FizzBuzz fizzBuzz  = new FizzBuzz(num);
        new Thread(() -> {
            try {
                fizzBuzz.fizz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                fizzBuzz.buzz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                fizzBuzz.fizzbuzz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                fizzBuzz.number();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


    }
}