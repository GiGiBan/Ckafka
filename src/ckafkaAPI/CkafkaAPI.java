package ckafkaAPI;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import util.HttpRequest;

public class CkafkaAPI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//HttpRequest hr = new HttpRequest();
		//System.out.println("通过HttpURLConnection的get方式：" + HttpRequest.doGet("http://106.14.139.36:8082/jpress"));
	      Map<String, Object> map = new HashMap<>();
	      map.put("name", "tyron");
	      map.put("age", 18);
	      //System.out.println("通过HttpURLConnection的POST方式，参数为json形式：" + HttpRequest.doPost("http://106.14.139.36/jpress", parseJson(map)));
	      String param = "Action=CreateTopic&Region=ap-chengdu&Timestamp="+Long.toString(new Date().getTime())+"&Nonce="+ (int)(Math.random()*(999999-1+1)+999999)+"&SecretId=AKIDSkmY3xI1B5nFRNvZmkSxEF3i9KHzGllW&Signature=g7PSJyShkaBXeV9XifRxDEzYu52nIYYI&instanceId=ckafka-k751tfoo&topicName=wujing-test1&partitionNum=3&replicaNum=3";
	      System.out.println(param);
	      System.out.println("通过HttpURLConnection的POST方式，参数为String形式：" + HttpRequest.doPost("http://ckafka.api.qcloud.com", param));

	}
	  /**
	   * map转string
	   *
	   * @param map map
	   * @return
	   */
	  public static String parseJson(Map<String, Object> map) {
	      return "JSONObject";
	  }

}
