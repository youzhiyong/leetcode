package com.yzy.others;


import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Description:
 * Date: 2019-03-14
 *
 * @author youzhiyong
 */
public class Test {

    public static void main(String[] args) {
/*

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
*/

        /*String a = "<xml><ToUserName><![CDATA[sz-baiguoyuan]]></ToUserName><FromUserName><![CDATA[owJnujl_gNUgI2Di1pcOepVPKowo]]></FromUserName><CreateTime>1556208144</CreateTime><MsgType><![CDATA[event]]></MsgType><Event><![CDATA[unsubscribe]]></Event><EventKey><![CDATA[]]></EventKey></xml>";
        System.out.println(a.substring(78, 106));*/
        /*int a = 1;
        a ^= 1 & 1;
        System.out.println(a);*/
/*
        int mainAccount = 817820;
        int fee = 9464;
        int presentSum = 15010;
        double depositMoney = 150000;

        double a1 = ServiceUtil.divide(mainAccount, 100.0);
        double a2 = ServiceUtil.subtract(1, ServiceUtil.divide4(fee, 10000.0));
        double a3 = ServiceUtil.multiply4(a1, a2);
        double a4 = ServiceUtil.subtract(a3, ServiceUtil.divide4(presentSum, 100.0));

        double a5 = ServiceUtil.divide(mainAccount, 100.0);
        double a6 = ServiceUtil.divide(depositMoney, 100.0);
        double a7 = ServiceUtil.subtract(a5, a6);
        double a8 = ServiceUtil.divide4(a4, a7);
        double a9 = ServiceUtil.subtract(1, a8);

        System.out.println(a9);*/

        /*int couponValue = 10;

        StringBuffer fruitCoinCount = new StringBuffer();

        fruitCoinCount.append("10");

        if (fruitCoinCount.length() == 0) fruitCoinCount.append(couponValue);
//			else fruitCoinCount.append(Integer.parseInt(fruitCoinCount.toString()) + couponValue);
        else fruitCoinCount = new StringBuffer(Integer.parseInt(fruitCoinCount.toString()) + couponValue + "");

        System.out.println(fruitCoinCount);*/


       /* Date date = new Date(2018, 01, 01);

        Date date2 = new Date(2019, 01, 01);

        System.out.println(date.after(date2));
        System.out.println(date.before(date2));
        JSONObject jsonObject = JSONObject.parseObject("1001");
        System.out.println(jsonObject);*/

        List<A> list1 = new ArrayList<>();
        list1.add(new A("aaa", 1));
        list1.add(new A("bbb", 2));
        list1.add(new A("ccc", 3));

        List<A> list3 = new ArrayList<>();
        for (A a : list1) {
            if(a.num != 2){
                change(a);
                a.num = 10;
                a.str = "abc";
                list3.add(a);
            }

        }

        System.out.println(list1);

    }

    public static void change(A a) {
        a.str = "aaa";
    }

    static class A {
        public String str;
        public int num;

        public A(String str, int num) {
            this.str = str;
            this.num = num;
        }

        public String getStr() {
            return str;
        }

        public void setStr(String str) {
            this.str = str;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }
    }

}
