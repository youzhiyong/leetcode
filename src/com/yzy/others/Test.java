package com.yzy.others;


/**
 * Description:
 * Date: 2019-03-14
 *
 * @author youzhiyong
 */
public class Test {

    public static void main(String[] args) {


        String s3 = new String("1") + new String("1");    // 此时生成了四个对象 常量池中的"1" + 2个堆中的"1" + s3指向的堆中的对象（注此时常量池不会生成"11"）
        s3.intern();    // jdk1.7之后，常量池不仅仅可以存储对象，还可以存储对象的引用，会直接将s3的地址存储在常量池
        String s4 = "11";    // jdk1.7之后，常量池中的地址其实就是s3的地址
        System.out.println(s3 == s4); // jdk1.7之前false， jdk1.7及之后true



        s3 = new String("2") + new String("2");
        s4 = "22";        // 常量池中不存在22，所以会新开辟一个存储22对象的常量池地址
        String s5 = s3.intern();    // 若存在s4=22; 这条语句，则s3.intern()会直接返回常量池中22的地址，即s4指向的地址   若不存在s4=22;这条语句，即常量池中不存在22，则s3.intern()会直接将s3的地址存储在常量池(jdk7+)

        System.out.println(s3 == s4); // false
        System.out.println(s3 == s5); // 若有 s4 = "22"; 则为false, 没有则为true
        System.out.println(s5 == s4); // true

    }

}
