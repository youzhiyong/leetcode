package com.yzy.java8.interface8;

/**
 * Description: 只继承接口A
 * ClassA 继承 接口InterfaceA
 * 重写了抽象方法sayHello()
 * 并且继承了接口 InterfaceA 的默认方法 default void sayYes()，并且可以对默认方法进行重写
 * 不可以对接口 InterfaceA 的静态方法 static void sayNo()静态重写
 * Date: 2019-06-06
 *
 * @author youzhiyong
 */
public class ClassA implements InterfaceA {
    @Override
    public void sayHello() {
        System.out.println("ClassA.sayHello.hello");
    }

    //ok 可以对默认方法进行重写
    /*@Override
    public void sayYes() {

    }*/

    //error 不可以对接口的静态方法重写, 类的静态方法也不能被重写
    /*@Override
    public static void sayNo() {

    }*/
}
