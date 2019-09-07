package ckafkaAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.Scanner;

import dao.CreateTopicParam;
import util.TimeUtils;

public class CreateTopicTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		CreateTopicParam ct = new CreateTopicParam();
		System.out.println("请输入您要创建的Topic所在实例的地域："); 
		Scanner sc = new Scanner(System.in); 
		ct.setRegion(sc.next());
		System.out.println(ct.getRegion());
		System.out.println("请输入您要创建的Topic所属的实例ID："); ct.setInstanceId((new
		Scanner(System.in).next())); System.out.println(ct.getInstanceId());
		ct.setTimestamp(TimeUtils.convertTimeToInt(new Date().getTime()));
		//ct.setNonce((int)(Math.random()*(999999-1+1)+999999));;
		ct.setNonce((int)(1+Math.random()*(100-1+1)));
		ct.setSignatureMethod("HmacSHA256");
		System.out.println("请输入您要创建的TopicName："); ct.setTopicName((new
		Scanner(System.in).next()));
		System.out.println("请输入您要创建的Topic的Partition的个数（大于零）：");
		ct.setPartitionNum(new Scanner(System.in).nextInt());
		System.out.println("请输入您要创建的Topic的副本个数（不能大于Ckafka集群的broker的个数，最大为3）：");
		ct.setReplicaNum(new Scanner(System.in).nextInt());
		String requestUrl = CreateTopicParam.URL + "?Action=" + CreateTopicParam.ACTION + "&SecretId="+CreateTopicParam.secretId+"&Signature="+ct.getSignature()+"&Region="+ct.region+"&Timestamp="+ct.getTimestamp()+"&Nonce="+ct.getNonce()+"&TopicName="+ct.getTopicName()+"&InstanceId="+ct.getInstanceId()+"&partitionNum="+ct.getPartitionNum()+"&replicaNum="+ct.getReplicaNum();
		System.out.println(requestUrl);
		try {
			URL url = new URL(requestUrl);
			HttpURLConnection connection = null;
			InputStream is = null;
			BufferedReader br = null;
			String result = null;
			connection = (HttpURLConnection) url.openConnection();
			// 设置连接方式：get
			connection.setRequestMethod("GET");
			// 设置连接主机服务器的超时时间：15000毫秒
			connection.setConnectTimeout(15000);
			// 设置读取远程返回的数据时间：60000毫秒
			connection.setReadTimeout(60000);
			// 发送请求
			connection.connect();
			// 通过connection连接，获取输入流
			int responseCode = connection.getResponseCode();
			if (responseCode == 200) {
				is = connection.getInputStream();
				// 封装输入流is，并指定字符集
				br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				// 存放数据
				StringBuffer sbf = new StringBuffer();
				String temp = null;
				while ((temp = br.readLine()) != null) {
					sbf.append(temp);
					sbf.append("\r\n");
				}
				result = sbf.toString();
			}
			try {
				url.openConnection();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				// 关闭资源
				if (null != br) {
					try {
						br.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

				if (null != is) {
					try {
						is.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				connection.disconnect();// 关闭远程连接
			}
			System.out.println(result);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
