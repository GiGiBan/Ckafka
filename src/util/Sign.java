/*
 * Copyright (c) 2018 THL A29 Limited, a Tencent company. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package util;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.TreeMap;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;;

/**
 * ǩ��������
 */
public class Sign {
    private final static Charset UTF8 = StandardCharsets.UTF_8;
    
    /**
     * 
     * @param sigStr
     * @param secretKey
     * @param sigMethod
     * @return string  sign string
     * @throws InvalidKeyException 
     * @throws SdkException
     */
    public static String sign(String secretKey, String sigStr, String sigMethod) throws InvalidKeyException 
    {
    	String sig = null;
	    	Mac mac = null;
			try {
				mac = Mac.getInstance(sigMethod);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        byte[] hash;
	        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(UTF8), mac.getAlgorithm());

	        mac.init(secretKeySpec);
	        hash = mac.doFinal(sigStr.getBytes(UTF8));
	        sig = DatatypeConverter.printBase64Binary(hash);

        return sig;	
    }
    
    public static String makeSignPlainText(TreeMap<String, String> requestParams, String reqMethod, String host, String path) {

        String retStr = "";
        retStr += reqMethod;
        retStr += host;
        retStr += path;
        retStr += buildParamStr(requestParams, reqMethod);
        return retStr;
    }

    protected static String buildParamStr(TreeMap<String, String> requestParams, String requestMethod) {

        String retStr = "";
        for(String key: requestParams.keySet()) {
            String value = requestParams.get(key).toString();
            if (retStr.length() == 0) {
                retStr += '?';
            } else {
                retStr += '&';
            }
            retStr += key.replace("_", ".") + '=' + value;

        }
        return retStr;
    }

    public static String sha256Hex(String s) throws Exception   {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw e;
        }
        byte[] d = md.digest(s.getBytes(UTF8));
        return DatatypeConverter.printHexBinary(d).toLowerCase();
    }

    public static String sha256Hex(byte[] b) throws Exception {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("SHA-256 is not supported." + e.getMessage());
        }
        byte[] d = md.digest(b);
        return DatatypeConverter.printHexBinary(d).toLowerCase();
    }
    
    public static byte[] hmac256(byte[] key, String msg) throws Exception {
        Mac mac;
        try {
            mac = Mac.getInstance("HmacSHA256");
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("HmacSHA256 is not supported." + e.getMessage());
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, mac.getAlgorithm());
        try {
            mac.init(secretKeySpec);
        } catch (InvalidKeyException e) {
            throw new Exception(e.getClass().getName() + "-" + e.getMessage());
        }
        return mac.doFinal(msg.getBytes(UTF8));
    }
}