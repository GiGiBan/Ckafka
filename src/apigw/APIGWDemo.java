package apigw;

import util.SignAndSend;

public class APIGWDemo {
	public static void main(String[] args) {
		String url = "http://service-94xa7jny-1251123904.gz.apigw.tencentcs.com/test/mail_client.php?email=362854025@qq.com&from=343759746@qq.com&subject=API����ʵս&content=API����ʵս�����Ҫ�����ϰ��";
		String secretId = "AKIDfpgehh5pu92my88f2r57v404zwY39xj8jgyb";
		String secretKey = "6mf65zKV68jS3xBTzSDb9I56fJa3lQ8t6T2xAO0p";
		for(int i=0;i<10;i++)
		{
			//ǩ������APIGW
			//SignAndSend signAndSendInstance = new SignAndSend();
			String result = SignAndSend.sendGet(url, secretId, secretKey);
	        System.out.println(result);
		}
    }
}

