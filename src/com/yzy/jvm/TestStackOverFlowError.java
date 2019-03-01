package com.yzy.jvm;

/**
 * Description: 测试 stackOverFlow 异常，无限递归调用
 * Date: 2018-09-04
 *  减小栈内存的大小
 *  -Xss128k    最低108k
 * @author youzhiyong
 */
public class TestStackOverFlowError {

    public static int deep = 0;

    public static void main(String[] args) {
        try {
            test();
        } catch (Throwable e) {
            System.out.println("stack deep :" + deep);
            e.printStackTrace();
        }

    }

    public static void test() {
        deep++;
        test();
    }
}
