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
		System.out.println("��������Ҫ������Topic����ʵ���ĵ���"); 
		Scanner sc = new Scanner(System.in); 
		ct.setRegion(sc.next());
		System.out.println(ct.getRegion());
		System.out.println("��������Ҫ������Topic������ʵ��ID��"); ct.setInstanceId((new
		Scanner(System.in).next())); System.out.println(ct.getInstanceId());
		ct.setTimestamp(TimeUtils.convertTimeToInt(new Date().getTime()));
		//ct.setNonce((int)(Math.random()*(999999-1+1)+999999));;
		ct.setNonce((int)(1+Math.random()*(100-1+1)));
		ct.setSignatureMethod("HmacSHA256");
		System.out.println("��������Ҫ������TopicName��"); ct.setTopicName((new
		Scanner(System.in).next()));
		System.out.println("��������Ҫ������Topic��Partition�ĸ����������㣩��");
		ct.setPartitionNum(new Scanner(System.in).nextInt());
		System.out.println("��������Ҫ������Topic�ĸ������������ܴ���Ckafka��Ⱥ��broker�ĸ��������Ϊ3����");
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
			// �������ӷ�ʽ��get
			connection.setRequestMethod("GET");
			// �������������������ĳ�ʱʱ�䣺15000����
			connection.setConnectTimeout(15000);
			// ���ö�ȡԶ�̷��ص�����ʱ�䣺60000����
			connection.setReadTimeout(60000);
			// ��������
			connection.connect();
			// ͨ��connection���ӣ���ȡ������
			int responseCode = connection.getResponseCode();
			if (responseCode == 200) {
				is = connection.getInputStream();
				// ��װ������is����ָ���ַ���
				br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				// �������
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
				// �ر���Դ
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
				connection.disconnect();// �ر�Զ������
			}
			System.out.println(result);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
