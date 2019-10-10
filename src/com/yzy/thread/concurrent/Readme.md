java.util.concurrent 包下的关于并发编程工具类的使用，如
         AbstractQueuedSynchronizer  同步器，是实现锁和同步组件的基础
         ReentrantLock               独占锁(包括公平和非公平模式)  基于同步器实现
         ReentrantReadWriteLock      读写锁(包括公平和非公平模式)  基于同步器实现
         CountDownLatch              
            创建时会初始化一个数量n(n>=0)  如n=3
            countDown() 用于将 n的数值减1
            await()用于获取锁，当数量n=0时返回获取成功，否则(n>0) 线程阻塞等待锁
         CyclicBarrier 可循环使用
             创建时会初始化一个数量n(n>0)  如n=3
             await() 用于将 n的数值减1
                如减1后的值等于0，则获取成功，所有处于等待的线程都会终止等待状态，任何n的值恢复成初始值3
         Semaphore
            信号量，可以初始化多个资源，Semaphore 只有3个操作：初始化/增加(release + 1)/减少(acquire - 1)