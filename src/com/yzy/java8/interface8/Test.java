package com.yzy.java8.interface8;

/**
 * Description:
 * Date: 2019-06-06
 *
 * @author youzhiyong
 */
public class Test {

    public static void main(String[] args) {
        InterfaceA.sayNo();
        InterfaceB.sayNo();

        ClassA classA = new ClassA();
        classA.sayHello();
        classA.sayYes();  //注意，实现类只能继承接口的default方法，不能继承接口的static方法
        //classA.sayNo(); //error
        //ClassA.sayNo(); //error

        ClassAB classAB = new ClassAB();
        classAB.sayYes();
    }

}
