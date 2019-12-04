package com.yzy.utils;

import java.security.MessageDigest;

public class Md5Util {
	
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

}
