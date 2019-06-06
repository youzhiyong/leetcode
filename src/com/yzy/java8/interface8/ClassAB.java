package com.yzy.java8.interface8;

/**
 * Description: 同时继承接口A和B
 * ClassAB 同时继承接口 InterfaceA 和接口 InterfaceB
 * 问题：接口 InterfaceA 和接口 InterfaceB有相同的默认方法default void sayYes()
 * 当出现这种问题时，实现类必须对这个默认方法进行重写，不重写则编译不通过
 *
 *
 * Date: 2019-06-06
 *
 * @author youzhiyong
 */
public class ClassAB implements InterfaceA, InterfaceB{

    @Override
    public void sayHello() {
        System.out.println("ClassAB.sayHello.hello");
    }

    @Override
    public void sayHello(String name) {
        System.out.println("ClassAB.sayHello.hello" + name);
    }

    /**
     * 1. 接口A和接口B都有sayYes()这个default方法，必须要对这个方法进行重写
     * 2. 实现类重写接口的default方法时，不能在方法上添加default关键字
     */
    @Override
    public void sayYes() {
        InterfaceA.super.sayYes(); //可以选择其中的一个接口实现作为继承类的实现
        //InterfaceB.super.sayYes();
    }
}
