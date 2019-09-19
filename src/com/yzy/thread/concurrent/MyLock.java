package com.yzy.thread.concurrent;

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
        protected int tryAcquireShared(int arg) {
            return super.tryAcquireShared(arg);
        }

        @Override
        protected boolean tryReleaseShared(int arg) {
            return super.tryReleaseShared(arg);
        }

        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
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
        return null;
    }
}
