package com.yzy.others;


import com.alibaba.fastjson.JSONObject;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
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
        System.out.println(b);*/

        //System.out.println(new Date().getTime());
        /*Calendar calendar = Calendar.getInstance();
        calendar.set(2019, Calendar.DECEMBER, 4);
        System.out.println(calendar.getTime());
        System.out.println(new Date());
        System.out.println(new Date().getTime() - calendar.getTime().getTime());

        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeZone(TimeZone.getDefault());
        calendar2.set(2020, Calendar.DECEMBER, 4);
        System.out.println(calendar2.getTime());
        System.out.println(calendar2.getTime().getTime());

        System.out.println((calendar2.getTime().getTime() - calendar.getTime().getTime()) / 1000 / 60 / 60 / 24);
*/
        /*
        select * from member where memberNum='13910711327';
select * from member where memberNum='13910711327‬';
         */

       /* String a = "13910711327";
        String b = "13910711327‬";

        System.out.println(getEncode(a));
        System.out.println(getEncode(b));
        System.out.println(a.equals(b));*/

        /*Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTime());
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - 7);
        System.out.println(calendar.getTime().getTime() + "");
        System.out.println(calendar.getTime().before(new Date()));
        System.out.println(calendar.getTime().after(new Date()));
        System.out.println(calendar.getTime().after(new Date()));

        int a = 10;
        int b = -a;
        System.out.println(b);*/
/*
        String privateKey =
                "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDItMBHlPFQnPgq"
                        + "oAF+CZryc6XvvlpO7EhgocKO26S6cIcU6JKkBRuUxh2ooRJ+wwb6nMFyyAYLPDRk"
                        + "96bBPntq/FBw/deXs3qF3p/RMucrPvw4SUsG3cTf8gzpoyhV07bmNRYVYUUA2ka/"
                        + "2cbrJYw5KuhuonvG562f1Triwcfwj+1pBZsTa/1PRGxireu5Mad+m7eoCzcXlZx1"
                        + "pQIsZ9i7AtUhXHyXU4W0wkpfUBG8iKx7YPlDkvuDu4mos4PXsB1yi49KGLQx/adU"
                        + "+bE7H3rjZeyc3O21269HNjN7V7JXEtv9uI/a7B+kfeCIx+J4/l5El18tTkN2aeCi"
                        + "OFUNhOHDAgMBAAECggEBAJA2YBqPCL21rBNkmO3pFO607jxPeDBRUsgsMtHXPIvC"
                        + "Iy2A1y0HhoPlvpXV9qYimDcmv1EsLDuSbMtHrwgXTzLWTS6DFpAoJBdgmVEF1Fic"
                        + "jzoaX9B1NOr8zw5pb6gL0dWju1Rtadls/X0IjAeWGSVSkWQ9V9bZzUWVPxSDzJgq"
                        + "bBrrxvW1fj2VwSuSIe7Et8iPmmxD4iG4En2/K3MCxHE9VVgNqkFmN2uwjYrg0tsJ"
                        + "awoSXqfvm1iVEqQmAW5vV3IupWs2yJpwQ/cDyLbo7CTtVTTeqbIMzW+b+42IfRVD"
                        + "Q7Zqj2naiStHdzvKzDVmIrJDwUJmCjn/cY2V4hSp4kECgYEA8pgt3LHDM9EISzhv"
                        + "xC4at8uk771eV76D65d9xgNzCujw2WRKMO3F7kklkwQQ9BlPFA0BvW9RUidIc9Xq"
                        + "9JBkPWP1XRL/49XjtrS3hS3i3lIAnPKh6vLLN1FWlLXG7OW63Xmjcap62O0As/ji"
                        + "dKwYdVUInt4plUY4f3V8cxH1mxMCgYEA08wBR0XVWBV/TC50UIdjqaOBlqytS1l9"
                        + "9gfXZoIwKVvO3MazA/upcXEzcGoeWLtkyuqTPsYkZVnLWA3GlUcj1NP1x/TFkqDV"
                        + "nPPv2EBUe4a+RY1aYviydxagI3SCMsfsAtseJK2T6VIIDK0celXtExZhxeWdoEKP"
                        + "D+JVnXLNRJECgYBuhRf3wGB+3c9afYalqJ9xdmxY8Dvn25q8HRMmv/GMWd1IHOGT"
                        + "8u9GhLqChMq4ekNFjjtpsyooNE9UvnNBIfsY4M4qrfo4MPyCA0jMesAtqswutHdB"
                        + "04TzWbIJI9tRl8OPHNhyc0luRGMamtuIbdLiuW+o+OuW3xvkLYEZ52euUwKBgQCL"
                        + "UoyYvOhdvC50B6799kHqKqOpYUfR5DnG6VuZlBRocHtAofjKqvbIqCWlUjlKN2NT"
                        + "VEGuLptsjEgGUXGLazO34gKxGWQKU4CRcaoZwB+S7o0lpZmKt3x2eEy5Zf/rtbWc"
                        + "H1XR3NkKx6qB5DJyiymbv8JrcuNgs8f2M/YLz6QV8QKBgHX+w+gDupwxAAsiOLYI"
                        + "xEw3wp3lkOUAVnZ68fdjYWgaAImUkA7IUKkczLkMXyWqT0dRxiXU9CLOc2IwJaVz"
                        + "AjdFO3B4IksSECzo+R5DlUG/nnlKF61l967al6QtKzWNcIWK52YI2ddfe98In7+w"
                        + "NPCCqbFCEU6bNlNV3BIfYsnU";

        System.out.println(privateKey.length());*/


        System.out.println("13554241446".substring(5));

    }


}
