/*
package com.yzy.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ice.plugin.logger.api.LoggerUtil;
import com.member.service.common.HttpClientUtil;
import com.member.service.model.Coupon;
import com.member.service.model.CouponBatch;
import com.member.service.model.CouponType;

import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

*/
/**
 * 封装微信卡券相关操作
 * @author youzhiyong
 *
 *//*

public class WechatCoupon {
	
	private static String privateKey = "";
	private static String merchantId = "";
	private static String serialNo = "";
	private static String appId = "";
	//创建商家券API
	private final static String CREATE_COUPON_BATCH_URL = "https://api.mch.weixin.qq.com/v3/marketing/busifavor/stocks";
	//核销用户券API
	private final static String USE_COUPON_URL = "https://api.mch.weixin.qq.com/v3/marketing/busifavor/coupons/use";
	//退回用户券API
	private final static String REFUND_COUPON_URL = "";
	
	*/
/*static {
		
		InputStream is = null;
		try {
			// String path = System.getProperty("user.dir") + File.separator +
			// "conf" + File.separator +"pagoda.properties";
			String path = "/home/member/server" + File.separator + "conf" + File.separator + "pagoda.properties";
			is = new FileInputStream(path);
			Properties properties = new Properties();
			properties.load(is);
			
			privateKey = properties.getProperty("WECHAT_PRIVATE_KEY",null);
			merchantId = properties.getProperty("WECHAT_MERCHANT_ID",null);
			serialNo = properties.getProperty("WECHAT_SERIAL_NO",null);
			appId = properties.getProperty("WECHAT_APP_ID",null);
		} catch (Exception e) {
			System.out.println("not find properties . e={}", e.getMessage());
		} finally {
			try {
				if (is != null)
					is.close();
			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println("io exception . e={}", e2.getMessage());
			}
		}
		
	}*//*

	
	*/
/**
	 * 在批次审核通过后调用
	 * 用于创建对应的腾讯卡券批次  商家券
	 * @return stock_id 腾讯端批次号 需要保存
	 *//*

	public static String createCouponBatch(CouponType type, CouponBatch batch) {
		
		String data = "{\r\n" + 
				"  \"stock_name\":\"8月1日活动券\",\r\n" + 
				"  \"belong_merchant\":\"1517380661\",\r\n" + 
				"  \"comment\": \"活动使用\",\r\n" + 
				"  \"goods_name\": \"填写代金券可适用的商品或服务\",\r\n" + 
				"  \"stock_type\": \"NORMAL\",\r\n" + 
				"  \"coupon_use_rule\": {\r\n" + 
				"    \"coupon_available_time\": {\r\n" + 
				"      \"available_begin_time\": \"2019-05-20T13:29:35.120+08:00\",\r\n" + 
				"      \"available_end_time\": \"2020-05-20T13:29:35.120+08:00\",\r\n" + 
				"      \"available_day_after_receive\": 3\r\n" + 
				"    },\r\n" + 
				"    \"fixed_normal_coupon\": {\r\n" + 
				"      \"discount_amount\": 5,\r\n" + 
				"      \"transaction_minimum\": 100\r\n" + 
				"    },\r\n" + 
				"    \"discount_coupon\": {\r\n" + 
				"      \"discount_percent\": 88,\r\n" + 
				"      \"transaction_minimum\":100\r\n" + 
				"    },\r\n" + 
				"    \"exchange_coupon\":{\r\n" + 
				"      \"exchange_price\":100,\r\n" + 
				"      \"transaction_minimum\":100\r\n" + 
				"    },\r\n" + 
				"    \"use_method\": \"OFF_LINE\",\r\n" + 
				"    \"mini_programs_appid\":\"wx23232232323\",\r\n" + 
				"    \"mini_programs_path\":\"/path/index/index\"\r\n" + 
				"  },\r\n" + 
				"  \"stock_send_rule\": {\r\n" + 
				"    \"max_amount\": 100000,\r\n" + 
				"    \"max_coupons\": 100,\r\n" + 
				"    \"max_coupons_per_user\": 5,\r\n" + 
				"    \"natural_person_limit\": false,\r\n" + 
				"    \"prevent_api_abuse\": false,\r\n" + 
				"    \"transferable\": false,\r\n" + 
				"    \"shareable\": false\r\n" + 
				"  },\r\n" + 
				"  \"out_request_no\": \"100002322019090134234sfdf\",\r\n" + 
				"  \r\n" + 
				"  \"display_pattern_info\": {\r\n" + 
				"    \"description\": \"xxx门店可用\",\r\n" + 
				"    \"merchant_logo_url\": \"https://xxx\",\r\n" + 
				"    \"merchant_name\": \"微信支付\",\r\n" + 
				"    \"background_color\": \"xxxxx\",\r\n" + 
				"    \"coupon_image_url\": \"图片cdn地址\"\r\n" + 
				"  },\r\n" + 
				"  \"coupon_code_mode\": \"WECHATPAY_MODE\"\r\n" + 
				"}";
		String res = doHttp("POST", data, CREATE_COUPON_BATCH_URL);
		//处理异常
		
		System.out.print(res);
		JSONObject object = JSON.parseObject(res);
		return object.getString("stock_id");
	}
	
	*/
/**
	 * 标记为腾讯卡券的优惠券使用完成后需要通知到腾讯
	 *//*

	public static boolean notifyUseCoupon(Coupon coupon) {
		String data = "{\r\n" + 
				"  \"coupon_code\": \"" + coupon.getCouponCode() + "\",\r\n" + 
				"  \"stock_id\": \"" + coupon.getBatchNum() + "\",\r\n" +   //这里是腾讯端的批次号
				"  \"appid\": \"wx1234567889999\",\r\n" +                   //公众号ID
				"  \"use_time\": \"2015-05-20T13:29:35.120+08:00\",\r\n" + 
				"  \"use_request_no\": \"1002600620019090123143254435\",\r\n" + 
				// "  \"openid\": \"xsd3434454567676\"\r\n" + 没有openid 
				"}";
		return false;
	}
	
	*/
/**
	 * 标记为腾讯卡券的优惠券取消使用/退款后需要通知到腾讯
	 *//*

	public static boolean notifyRefundCoupon(Coupon coupon) {

		return false;
	}
	
	public static final MediaType JSON_TYPE = MediaType.parse("application/json; charset=utf-8");
	private static final OkHttpClient client = new OkHttpClient().newBuilder()
			  .connectTimeout(10, TimeUnit.SECONDS).readTimeout(10, TimeUnit.SECONDS).writeTimeout(10, TimeUnit.SECONDS).build();
	
	private static String doHttp(String method, String data, String url) {
		HttpUrl httpUrl = HttpUrl.parse(url);
		String auth = SignUtils.getAuth(method, httpUrl, data);
		Request request = null;
		if ("GET".equalsIgnoreCase(method)) {
			request = new Request.Builder()
					.addHeader("Authorization", auth)
					.addHeader("Accept", "application/json")
					.url(httpUrl).get().build();
		} else {
			RequestBody body = RequestBody.create(JSON_TYPE, data);
			request = new Request.Builder()
					.addHeader("Authorization", auth)
					.addHeader("Accept", "application/json")
					.addHeader("Content-Type", "application/json")
					.url(httpUrl).post(body).build();
		}
		
		Response response;
		try {
			response = client.newCall(request).execute();
			String result = response.body().string();
			LoggerUtil.debug("doHttp response result={}",result);
			System.out.print(result);
			if (response.isSuccessful()) {
				  return result;
			} else {
				return null;
			}	
	  } catch (Exception e) {
		  System.out.println("doHttp  exception ={}",e);
		  return null;
	  }		  
	}
	
	public static void main(String[] args) {
		
		// 测试获取证书
		*/
/*String res = doHttp("GET", "", "https://api.mch.weixin.qq.com/v3/certificates?p=1+2&q=3/4");
		System.out.print(res);*//*

		
		// 测试创建批次
		createCouponBatch(null, null);
	}
	
	
	static class SignUtils {
		
		public static String getAuth(String method, HttpUrl url, String body) {
			long time = System.currentTimeMillis();
		    String nonceStr = time + "";
		    long timestamp = time / 1000;
		    String message = buildMessage(method, url, timestamp, nonceStr, body);
		    String signature = sign(message, privateKey);

		    return "WECHATPAY2-SHA256-RSA2048 mchid=\"" + merchantId + "\","
		    + "nonce_str=\"" + nonceStr + "\","
		    + "timestamp=\"" + timestamp + "\","
		    + "serial_no=\"" + serialNo + "\","
		    + "signature=\"" + signature + "\"";
		}

		public static String sign(String message, String privateKey) {
		    try {
			    Signature sign = Signature.getInstance("SHA256withRSA");
				sign.initSign(getPrivateKey(privateKey));
			    sign.update(message.getBytes("utf-8"));
			    return Base64.getEncoder().encodeToString(sign.sign());
			} catch (InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException | SignatureException | UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		    return null;

		}
		
		public static PrivateKey getPrivateKey(String privateKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
			byte[] bytes = Base64.getDecoder().decode(privateKey);
	        KeySpec keySpec = new PKCS8EncodedKeySpec(bytes);
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
	        return keyFactory.generatePrivate(keySpec);
		}
		
		

		public static String buildMessage(String method, HttpUrl url, long timestamp, String nonceStr, String body) {
		    String canonicalUrl = url.encodedPath();
		    if (url.encodedQuery() != null) {
		      canonicalUrl += "?" + url.encodedQuery();
		    }

		    return method + "\n"
		        + canonicalUrl + "\n"
		        + timestamp + "\n"
		        + nonceStr + "\n"
		        + body + "\n";
		}
	}

}
*/
