package com.yzy.utils;

// import org.apache.commons.codec.binary.Base64;
// import org.apache.commons.codec.digest.DigestUtils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * Description: 用于浦发联名卡接口加解密
 * Date: 2019-10-22
 *
 * @author youzhiyong
 */
public class DES3Utils {
/*

    */
/**
     * 转换成十六进制字符串
     * @param key
     * @return
     *
     * lee on 2017-08-09 10:54:19
     *//*

    public static byte[] hex(String key){
        String f = DigestUtils.md5Hex(key);
        byte[] bkeys = new String(f).getBytes();
        byte[] enk = new byte[24];
        for (int i=0;i<24;i++){
            enk[i] = bkeys[i];
        }
        return enk;
    }

    */
/**
     * 3DES加密
     * @param key 密钥（长度为24字节），base64加密后的串
     * @param srcStr 原的字符串
     * @return
     *
     *//*

    public static String  encode3Des(String key,String srcStr){

        Base64 base64 = new Base64();
        byte[] keybyte = base64.decode(key);
        byte[] src = srcStr.getBytes();
        try {
            //生成密钥
            SecretKey deskey = new SecretKeySpec(keybyte, "DESede");
            //加密
            Cipher c1 = Cipher.getInstance("DESede/ECB/PKCS5Padding");  //加解密算法/工作模式/填充方式
            c1.init(Cipher.ENCRYPT_MODE, deskey);

            return Base64.encodeBase64String(c1.doFinal(src));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    */
/**
     * 3DES解密
     * @param key 加密密钥（长度为24字节），base64加密后的串
     * @param desStr 加密后的字符串
     * @return
     *
     *//*

    public static String decode3Des(String key, String desStr){
        Base64 base64 = new Base64();
        byte[] keybyte = base64.decode(key); //byte[] keybyte = hex(key);
        byte[] src = base64.decode(desStr);

        try {
            //生成密钥
            SecretKey deskey = new SecretKeySpec(keybyte, "DESede");
            //解密
            Cipher c1 = Cipher.getInstance("DESede/ECB/PKCS5Padding"); //加解密算法/工作模式/填充方式
            c1.init(Cipher.DECRYPT_MODE, deskey);
            return new String(c1.doFinal(src));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
*/

}
