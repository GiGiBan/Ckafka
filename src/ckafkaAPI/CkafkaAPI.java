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
			System.out.println("��������Ҫ��ѯ�ĵ���");
			ltd.setRegion(new Scanner(System.in).next());
			System.out.println("��������Ҫ��ѯ��ʵ��ID��");
			ltd.setInstanceId(new Scanner(System.in).next());
			int num =TimeUtils.converTime(new Date().getTime());
			ltd.setNonce(num);
			ltd.setTimestamp(num);
			String url = "ckafka.api.qcloud.com/v2/index.php?"+Ksort.Ksort(ClassUtil.setConditionMap(ltd));
			System.out.println(url);
			String secretKey = "g7PSJyShkaBXeV9XifRxDEzYu52nIYYI";
			String signStr = Sign.sign("GET"+url, secretKey,ltd.SignatureMethod);
			System.out.println("ǩ������"+signStr);
			ltd.setSignature(URLCode.encode(signStr));
			url="https://"+url+"&Signature="+ltd.getSignature();
			System.out.println(url);
			String result = HttpRequest.doGet(url);
			
			//SignAndSend.sendGet(url, ltd.SecretId, secretKey);
			return result;
		}

}
