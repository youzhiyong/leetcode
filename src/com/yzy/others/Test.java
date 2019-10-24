package com.yzy.others;


import com.alibaba.fastjson.JSONObject;

import java.security.MessageDigest;
import java.util.*;

/**
 * Description:
 * Date: 2019-03-14
 *
 * @author youzhiyong
 */
public class Test {
    private static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    /**
     * 加密
     * @param str
     * @return
     */
    public static String encode(String str) {
        try {
            // 此 MessageDigest 类为应用程序提供信息摘要算法的功能，必须用try,catch捕获
            MessageDigest md5 = MessageDigest.getInstance("MD5");

            // 输入的字符串转换成字节数组
            byte[] inputByteArray = str.getBytes();

            // inputByteArray是输入字符串转换得到的字节数组
            md5.update(inputByteArray);
            byte[] resultByteArray = md5.digest();

            // 字符数组转换成字符串返回
            return bytesToHexString(resultByteArray);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void main(String[] args) {
        /*System.out.println(encode("A").toUpperCase());
        long a = 365 * 24 * 60 * 60 * 1000;  //!!!
        long b = 365 * 24 * 60 * 60 * 1000L; //!!!
        System.out.println(a);
        System.out.println(b);

        //System.out.println(new Date().getTime());
        Calendar calendar = Calendar.getInstance();
        calendar.set(2018, Calendar.OCTOBER, 23);
        System.out.println(calendar.getTime());
        System.out.println(new Date());
        System.out.println(new Date().getTime() - calendar.getTime().getTime());

        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeZone(TimeZone.getDefault());
        calendar2.set(1971, Calendar.JANUARY, 1, 7, 59, 59);
        System.out.println(calendar2.getTime());
        System.out.println(calendar2.getTime().getTime());*/

        /*
        select * from member where memberNum='13910711327';
select * from member where memberNum='13910711327‬';
         */

        String a = "13910711327";
        String b = "13910711327‬";

        System.out.println(getEncode(a));
        System.out.println(getEncode(b));
        System.out.println(a.equals(b));

    }

    /**
     * 获取字符串的编码格式
     * @param str
     * @return
     */
    private static String getEncode(String str) {
        String encode = "GB2312";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) { //判断是不是GB2312
                return encode; //是的话，返回“GB2312“，以下代码同理
            }
        } catch (Exception exception) {
        }
        encode = "ISO-8859-1";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) { //判断是不是ISO-8859-1
                return encode;
            }
        } catch (Exception exception1) {
        }
        encode = "UTF-8";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) { //判断是不是UTF-8
                return encode;
            }
        } catch (Exception exception2) {
        }
        encode = "GBK";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) { //判断是不是GBK
                return encode;
            }
        } catch (Exception exception3) {
        }
        return "";
    }

}
