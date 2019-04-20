package com.yzy.singleton;

/**
 * Description:

 这样实现的单例其实是不安全的，执行语句4时，实际包含3个步骤：
 a. 给singleton分配内存
 b. 在内存中初始化singleton对象
 c. 将内存地址赋给singleton变量（这时singleton变量就不为null了）

 因为编译器会进行指令重排，如果指令重排之后第c步先于第b步执行，那可能会发生如下的错误：
 1）线程1执行语句4，这时线程1工作内存的singleton变量不为null，可能会立即写回到主存中，也可能迟点再写回到主存中。

 2）然后这时线程的时间分片又刚好用完了，就会切换到线程2，如果线程1的singleton已经写回到主存中，那么这时线程2执行语句1就为false，然后返回single对象，但实际上第2步还没执行，即对象还没初始化，使用该对象会导致程序报错。

 解决的方法：
 使用volatile修饰singleton变量，volatile保证对volatile变量进行读/写操作的那一行代码的顺序不变，即第c步顺序就一定是在b之后的，确保对象初始化完再将内存地址赋给singleton变量。第c步就是对volatile变量进行写操作。

 synchronized虽然能保证互斥，但是不保证在一个时间分片内将代码块中的所有代码执行完毕，会释放时间分片，等待再分配时间分片再继续执行下去。

 结论：Java使用double check（双重检查）实现单例模式时，单例变量要使用volatile修饰

 * Date: 2019-03-29
 *
 * @author youzhiyong
 */
public class Singleton {

    /** private volatile Singleton instance; **/
    private Singleton instance;

    public Singleton getInstance() {
        if (instance == null) {   //1
            synchronized (Singleton.class) {  //2
                if (instance == null) {   //3
                    instance = new Singleton();  //4
                }
            }
        }
        return instance;
    }
}
