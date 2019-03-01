package com.yzy.others;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class EncryptUtil {
    static {
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
    }

    public static final String CHARSET = "utf-8";
    public static final String CIPHER_ALGORITHM = "AES/ECB/PKCS7Padding";

    /**
     * AES加密
     *
     * @param content
     *            需要加密的内容
     * @param password
     *            加密密码 16位
     * @return
     */
    public static String encryptAES(String content, String password)
            throws Exception {
        SecretKeySpec key = new SecretKeySpec(password.getBytes(CHARSET), "AES");
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedData = cipher.doFinal(content.getBytes(CHARSET));
        return EncryptUtil.parseByte2HexStr(encryptedData);
    }

    /**
     * 解密
     *
     * @param content
     *            待解密内容
     * @param password
     *            解密密钥 16位
     * @return
     */
    public static String decryptAES(String content, String password)
            throws Exception {
        byte[] byteMi = EncryptUtil.parseHexStr2Byte(content);
        SecretKeySpec key = new SecretKeySpec(password.getBytes(CHARSET), "AES");
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedData = cipher.doFinal(byteMi);
        return new String(decryptedData);
    }

    /**
     * 将二进制转换成16进制
     *
     * @param buf
     * @return
     */
    public static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    /**
     * 将16进制转换为二进制
     *
     * @param hexStr
     * @return
     */
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1)
            return null;
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2),
                    16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

    /**
     * sha1编码
     *
     * @param data
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public static String sha1(String data) throws NoSuchAlgorithmException,
            UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance("SHA1");
        md.update(data.getBytes(CHARSET));
        StringBuffer buf = new StringBuffer();
        byte[] bits = md.digest();
        for (int i = 0; i < bits.length; i++) {
            int a = bits[i];
            if (a < 0)
                a += 256;
            if (a < 16)
                buf.append("0");
            buf.append(Integer.toHexString(a));
        }
        return buf.toString();
    }

    /**
     * 参数排序并拼接成字符串
     * @param params2
     * @return
     */
    private static String concatParams(Map<String, String> params) {
        Object[] key_arr = params.keySet().toArray();
        Arrays.sort(key_arr);
        StringBuilder str = new StringBuilder();
        for (Object key : key_arr) {
            if(key.equals("sign"))
                continue;
            String val = params.get(key);
            str.append(key).append("=").append(val);
        }
        return str.toString();
    }

    public static boolean checkSign(HashMap signMap) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        String sign = (String)signMap.get("sign");
        sign = sign.substring(0, sign.length() - 64);
        HashMap<String, String> map = new HashMap<String, String>();
        Iterator iterator = signMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            String key = (String) entry.getKey();
            if(key.equals("sign"))
                continue;
            map.put(key, (String)entry.getValue());
        }
        String sha1 = sha1(concatParams(map) + "_" + ORG_KEY);
        if(sign.equals(sha1)){
            return true;
        }else{
            return false;
        }
    }

    public static String getSign(HashMap map, String orgKey, String orgSecret) throws NoSuchAlgorithmException, UnsupportedEncodingException, Exception {
        return sha1(concatParams(map) + "_" + orgKey) + encryptAES(System.currentTimeMillis() + "_BGY", orgSecret);
    }

    public static String mapToQueryString(Map<String, String> map) throws Exception {
        // 构建请求参数
        StringBuffer sb = new StringBuffer();
        if (map != null) {
            Object[] key_arr = map.keySet().toArray();
            Arrays.sort(key_arr);
            for (Object key : key_arr) {
                String val = map.get(key);
                sb.append(key).append("=").append(val).append("&");
            }
            sb.delete(sb.length() - 1, sb.length());
        }
        return sb.toString();
    }



    private static final String APP_KEY = "test";
    private static final String ORG_KEY = "blySWouydxpwS6dpqD4nogKR";
    private static final String ORG_SECRET = "0sah0rx5p8cscovp";
    public static void main(String[] args) throws Exception {
        //blySWouydxpwS6dpqD4nogKR
        //0sah0rx5p8cscovp

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("appKey", APP_KEY);
        map.put("cardNo", "930195934090051768967");
        map.put("operator", "00875");
        map.put("phone", "13200000000");

        //生产签名
        map.put("sign", EncryptUtil.getSign(map, ORG_KEY, ORG_SECRET));
        System.out.println(" sign: " + map.get("sign"));
        /*map.put("shopName", "0087_测试门店1");
        map.put("posNo", "00875");
        map.put("shopNo", "0087");

        String url = "http://116.204.26.11:8899/servlet/com.shrj.ierp.mem.api.servlet.gift.GiftCardBarCodeRechargeServlet";
        System.out.println(" url: " + url);
        String params = EncryptUtil.mapToQueryString(map);
        System.out.println(" params: " + params);
        Object obj = EncryptUtil.http(url, "POST", params);
        System.out.println(" result: " + String.valueOf(obj));*/

    }

    public static Object http(String url, String method, String params) throws Exception {
        // 读取返回内容
        StringBuffer buffer = null;
        BufferedReader br = null;
        OutputStream os = null;
        URL u = null;
        HttpURLConnection con = null;

        // 尝试发送请求
        try {
            u = new URL(url);
            con = (HttpURLConnection) u.openConnection();
            // // POST 只能为大写，严格限制，post会不识别\
            con.setConnectTimeout(10000); // 连接主机的超时时间（单位：毫秒）
            con.setReadTimeout(10000); //从主机读取数据的超时时间（单位：毫秒）
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setUseCaches(false);
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            // 设置请求方式（GET/POST）
            con.setRequestMethod(method);
            if ("GET".equalsIgnoreCase(method))
                con.connect();

            // 当有数据需要提交时
            if (null != params) {
                os = con.getOutputStream();
                // 注意编码格式，防止中文乱码
                os.write(params.getBytes("UTF-8"));
                os.flush();
            }

            // 将返回的输入流转换成字符串
            br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
            String temp;
            buffer = new StringBuffer();
            while ((temp = br.readLine()) != null) {
                buffer.append(temp);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                if (os != null)
                    os.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            try {
                if (br != null)
                    br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            if (con != null)
                con.disconnect();

        }
        return buffer;
    }
}
