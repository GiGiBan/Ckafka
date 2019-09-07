package util;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class HMACSHA256 {
	public static String HMACSHA256(String data, String key) throws Exception {

	       Mac sha256_HMAC = Mac.getInstance("HmacSHA256");

	       SecretKeySpec secret_key = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");

	       sha256_HMAC.init(secret_key);

	       byte[] array = sha256_HMAC.doFinal(data.getBytes("UTF-8"));

	       StringBuilder sb = new StringBuilder();
	       

	       for (byte item : array) {

	           sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));

	       }

	       return sb.toString().toUpperCase();

	   }
	
	/**
	* 
	* @Description: ʹ��hmacSHA256���м���
	* @param data ��������
	* @param key ��Կ
	* @return
	* @throws Exception
	*/
	public static String encryptHmacSHA256(String data,String key) throws Exception { 

		SecretKey secretKey = new SecretKeySpec(key.getBytes(), "HmacSHA256");
		Mac mac = Mac.getInstance(secretKey.getAlgorithm());
		mac.init(secretKey);
		
		return new String(mac.doFinal(data.getBytes())); 
	}
}
