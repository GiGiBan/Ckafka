package util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLCode {
	/**
	 * URL����
	 * @param str
	 * @return
	 */
	public static String decode(String url)  
	{  
	          try {  
	               String prevURL="";  
	               String decodeURL=url;  
	               while(!prevURL.equals(decodeURL))  
	               {  
	                    prevURL=decodeURL;  
	                    decodeURL=URLDecoder.decode( decodeURL, "UTF-8" );  
	               }  
	               return decodeURL;  
	          } catch (UnsupportedEncodingException e) {  
	               return "Issue while decoding" +e.getMessage();  
	          }  
	}
	/**
	 * URL����
	 * @param str
	 * @return
	 */
	public static String encode(String url)  
	{  
	          try {  
	               String encodeURL=URLEncoder.encode( url, "UTF-8" );  
	               return encodeURL;  
	          } catch (UnsupportedEncodingException e) {  
	               return "Issue while encoding" +e.getMessage();  
	          }  
	}

}
