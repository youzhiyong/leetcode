package com.yzy.utils;

/**
 * Description:
 * Date: 2019-10-23
 *
 * @author youzhiyong
 */
public class StringUtil {

    /**
     * 获取字符串的编码格式
     * @param str
     * @return
     */
    public static String getEncode(String str) {
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
