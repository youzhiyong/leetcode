package com.yzy.jvm;

/**
 * Description: 测试 在不同JDK下 JVM加载 长度为64 位的变量 的区别
 * 1. 分两次加载  一次加载32位
 * 2. 一次加载64位
 *
 * 测试不成功！
 *
 * Date: 2019-05-17
 *
 * @author youzhiyong
 */
public class TestLoadLong {

    public static void main(String[] args) {
        long b = Integer.MAX_VALUE + 100L;
        int c = 100;
        long d = b++;
        int e = c++;
        System.out.println(d * e);
    }

}
