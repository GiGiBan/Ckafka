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
import util.HMACSHA256;
import util.TimeUtils;

public class CakafkaInstanceList {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		CreateTopicParam ct = new CreateTopicParam();
		System.out.println("��������Ҫ��ѯ�ĵ���"); 
		Scanner sc = new Scanner(System.in); 
		ct.setRegion(sc.next());
		System.out.println(ct.getRegion());
		new TimeUtils();
		ct.setTimestamp(TimeUtils.converTime(new Date().getTime()));
		System.out.println(ct.getTimestamp());
		//System.out.println(Long.toString(new Date().getTime()));
		ct.setNonce((int)(1+Math.random()*(100-1+1)));;
		System.out.println(ct.getNonce());
		ct.setSignatureMethod("HmacSHA256");
		try {
			ct.setSignture(HMACSHA256.HMACSHA256(CreateTopicParam.getSecretid(), "g7PSJyShkaBXeV9XifRxDEzYu52nIYYI"));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String requestUrl = CreateTopicParam.URL + "?Action=ListInstance" + "&SecretId="+CreateTopicParam.secretId+"&Signature="+ct.getSignature()+"&Region="+ct.region+"&Timestamp="+ct.getTimestamp()+"&Nonce="+ct.getNonce();
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
			System.out.println("����http����ʧ�ܣ��쳣��Ϣ���£�");
			e.printStackTrace();
		}

	}


}
