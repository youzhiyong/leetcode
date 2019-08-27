package com.yzy.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 测试 堆内存 溢出
 * Date: 2018-09-04
 *  -Xmx20m -Xms20m 设置堆内存大小
 *  -XX:+PrintGCDetails 打印GC信息
 *  -XX:+PrintGCDetails -Xloggc:d:/gc.log
 * @author youzhiyong
 */
public class TestOomOfHeap {
    public static void main(String[] args) {

        List<OOMObject> list = new ArrayList<>();
        int num = 0;
        while (true) {
            System.out.println(++num);
            //Thread.sleep(1);
            list.add(new OOMObject());
        }
    }


    static class OOMObject {

    }
}

