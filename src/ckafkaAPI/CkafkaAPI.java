package ckafkaAPI;

import java.util.Date;
import java.util.Scanner;

import dao.ListTopicDao;
import util.ClassUtil;
import util.HttpRequest;
import util.Ksort;
import util.Sign;
import util.TimeUtils;
import util.URLCode;

public class CkafkaAPI {

		@SuppressWarnings("resource")
		public static String listTopic() throws Exception {
			ListTopicDao ltd = new ListTopicDao();
			System.out.println("请输入您要查询的地域：");
			ltd.setRegion(new Scanner(System.in).next());
			System.out.println("请输入你要查询的实例ID：");
			ltd.setInstanceId(new Scanner(System.in).next());
			int num =TimeUtils.converTime(new Date().getTime());
			ltd.setNonce(num);
			ltd.setTimestamp(num);
			String url = "ckafka.api.qcloud.com/v2/index.php?"+Ksort.Ksort(ClassUtil.setConditionMap(ltd));
			System.out.println(url);
			String secretKey = "g7PSJyShkaBXeV9XifRxDEzYu52nIYYI";
			String signStr = Sign.sign("GET"+url, secretKey,ltd.SignatureMethod);
			System.out.println("签名串："+signStr);
			ltd.setSignature(URLCode.encode(signStr));
			url="https://"+url+"&Signature="+ltd.getSignature();
			System.out.println(url);
			String result = HttpRequest.doGet(url);
			
			//SignAndSend.sendGet(url, ltd.SecretId, secretKey);
			return result;
		}

}
