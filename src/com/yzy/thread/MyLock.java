package com.yzy.thread;

import sun.misc.Unsafe;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Description: 自定义锁
 * Date: 2019-09-19
 *
 * @author youzhiyong
 */
public class MyLock implements Lock {

    /**
     * 通过静态内部类 继承 同步器(AbstractQueuedSynchronizer) 是实现锁和其他同步组件的主要方式
     *
     * 同步器(AbstractQueuedSynchronizer) 可以重写以下5个方法
     * 1. protected boolean tryAcquire(int arg)     尝试获取独占锁
     * 2. protected boolean tryRelease(int arg)     尝试释放独占锁
     * 3. protected int tryAcquireShared(int arg)   尝试获取共享锁
     * 4. protected boolean tryReleaseShared(int arg)  尝试释放共享锁
     * 5. protected boolean isHeldExclusively()      是否处于占用状态
     *
     * 同步器(AbstractQueuedSynchronizer) 中有一个重要的实现原子操作字段 UnSafe CAS操作
     *
     * UnSafe.objectFieldOffset(Field f)   获取类中某个字段的内存偏移
     * UnSafe.compareAndSwapInt(Object o, Long offset, int expect, int newValue)    o:对象，offset:要修改的字段在对象o中的内存偏移(定位字段) expect：期望值(原值)  newValue:修改后的值
     * UnSafe.compareAndSwapObject(Object o, Long offset, Object expect, Object newValue)    o:对象，offset:要修改的字段在对象o中的内存偏移(定位字段) expect：期望值(原值)  newValue:修改后的值
     * UnSafe.compareAndSwapObject(Object o, Long offset, Long expect, Long newValue)    o:对象，offset:要修改的字段在对象o中的内存偏移(定位字段) expect：期望值(原值)  newValue:修改后的值
     *
     *
     */
    static final class Sync extends AbstractQueuedSynchronizer {

        @Override
        protected boolean tryAcquire(int arg) {

            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;

        }

        @Override
        protected boolean tryRelease(int arg) {
            if (getState() == 0) throw new IllegalMonitorStateException();
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        final ConditionObject newCondition() {
            return new ConditionObject();
        }
    }

    //将锁操作代理到sync上
    private final Sync sync = new Sync();

    /**
     * 阻塞方式获取锁
     */
    @Override
    public void lock() {
        sync.acquire(1);
    }

    /**
     * 可中断的方式获取锁
     * @throws InterruptedException
     */
    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    /**
     * 非阻塞方式获取锁
     * @return
     */
    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    /**
     * 指定超时时间获取锁
     * @param time
     * @param unit
     * @return
     * @throws InterruptedException
     */
    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(time));
    }

    /**
     * 释放锁
     */
    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }


    /**
     * 测试场景(AQS实现独占锁的获取和释放过程)包括：
     * 1. 没有线程占有锁的状态下获取锁
     * 2. 有线程占有锁但没有线程等待锁的状态下获取锁
     * 3. 有线程占有锁同时还有线程在等待的状态下获取锁
     * 4. 演示公平锁和非公平锁在获取锁时的区别
     * 5. 演示释放锁后唤醒下一个线程获取锁的过程
     * @param args
     */
    public static void main(String[] args) {
        final Lock lock = new MyLock();

        new Thread(() -> {

            lock.lock();

            try {
                //while (true) {}
                //ThreadUtils.sleep(1);
            } finally {
                lock.unlock();
            }
        }, "MyThread-A").start();

        new Thread(() -> {
            lock.lock();
            try {
                //while (true) {}
            } finally {
                lock.unlock();
            }
        }, "MyThread-B").start();

        new Thread(() -> {
            lock.lock();
            try {
                //while (true) {}
            } finally {
                lock.unlock();
            }
        }, "MyThread-C").start();

    }


}
