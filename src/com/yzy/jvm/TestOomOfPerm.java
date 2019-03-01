package com.yzy.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 测试永久代(常量)内存溢出 在不同 JDK的表现
 * Date: 2018-09-04
 * -Xms20m -Xmx20m -XX:PermSize=2m -XX:MaxPermSize=2m -XX:MaxMetaspaceSize=10m
 *
 * -XX:PermSize=128M -XX:MaxPermSize=128M  <=JDK1.7
 * -XX:MaxMetaspaceSize=2m JDK1.8
 * JDK1.7以前常量存放在Perm(永久代)中   OOM in Perm
 * JDK1.7中还有Perm空间，但是常量已经移到heap中 OOM in Heap
 * JDK1.8已经完全移除Perm空间，新增Metadata空间用于存储类信息,Metadata在本地内存中，常量还是在heap中  OOM in heap
 * @author youzhiyong
 */
public class TestOomOfPerm {

    public static final String s1 = "youzhiyong";
    public static final String s2 = "Hello world";
    public static final String s3 = "public class TestOomOfPerm {";
    public static final String s4 = "public static void main(String[] args) {";
    public static final String s5 = "-Xms20m -Xmx20m -XX:PermSize=2m -XX:MaxPermSize=2m -XX:MaxMetaspaceSize=10m";
    public static final String s6 = "-XX:PermSize=128M -XX:MaxPermSize=128M  <=JDK1.7";
    public static final String s7 = "-XX:MaxMetaspaceSize=2m JDK1.8";

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        long i = 1;
        while (true) {
            System.out.println(i++);
            list.add(String.valueOf(i + s1 + s2 + s3 + s4 + s5 + s6 + s7).intern());
        }

    }



}
