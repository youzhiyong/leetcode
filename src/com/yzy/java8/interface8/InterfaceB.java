package com.yzy.java8.interface8;

/**
 * Description: @FunctionalInterface 注解标识此接口只能有一个抽象方法，但可以有多个default和static方法
 *  * InterfaceB 接口清单：
 * 1. 抽象方法 void sayHello(String name)
 * 2. 默认方法 default void sayYes()
 * 3. 静态方法 static void sayNo()
 *
 * Date: 2019-06-06
 *
 * @author youzhiyong
 */
@FunctionalInterface
public interface InterfaceB {

    void sayHello(String name);

    //error: 'sayHello(String)' is already defined in 'com.yzy.java8.interface8.InterfaceA'
    /*default void sayHello(String name) {

    }*/

    default void sayYes() {
        System.out.println("InterfaceB.default.yes");
    }

    static void sayNo() {
        System.out.println("InterfaceB.static.No");
    }

}
