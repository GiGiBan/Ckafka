package ckafkaAPI;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

import util.HMACSHA256;
import util.TimeUtils;

public class Test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		try {
			URL url = new URL("http://106.14.139.36/jpresss");
			URLConnection hc = url.openConnection();
			//hc.connect();
			hc.setConnectTimeout(60);
			hc.setRequestProperty("name", "wujing");
			hc.setConnectTimeout(90);
			System.out.println(hc.getConnectTimeout());
			System.out.println(hc.getURL());
			System.out.println(hc.getRequestProperties());
			//System.out.println(hc.getContent());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(TimeUtils.convertTimeToInt(new Date().getTime()));
		System.out.println(TimeUtils.converTime(new Date().getTime()));
		try {
			System.out.println(HMACSHA256.HMACSHA256("AKIDSkmY3xI1B5nFRNvZmkSxEF3i9KHzGllW", "g7PSJyShkaBXeV9XifRxDEzYu52nIYYI"));
			System.out.println(HMACSHA256.encryptHmacSHA256("AKIDSkmY3xI1B5nFRNvZmkSxEF3i9KHzGllW", "g7PSJyShkaBXeV9XifRxDEzYu52nIYYI"));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
