package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpRequest {
	//String createTopicURL = "http://ckafka.api.qcloud.com";
	
	
	public static String doGet(String httpurl) {
		   HttpURLConnection connection = null;
		   InputStream is = null;
		   BufferedReader br = null;
		   String result = null;// ���ؽ���ַ���
		   try {
		       // ����Զ��url���Ӷ���
		       URL url = new URL(httpurl);
		       // ͨ��Զ��url���Ӷ����һ�����ӣ�ǿת��httpURLConnection��
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
		   } catch (MalformedURLException e) {
		       e.printStackTrace();
		   } catch (IOException e) {
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
		   return result;
		}

		/**
		* Post����
		*
		* @param httpUrl url��ַ
		* @param param   ����
		* @return ����
		*/
		public static String doPost(String httpUrl, String param) {
		   HttpURLConnection connection = null;
		   InputStream is = null;
		   OutputStream os = null;
		   BufferedReader br = null;
		   String result = null;
		   try {
		       URL url = new URL(httpUrl);
		       // ͨ��Զ��url���Ӷ��������
		       connection = (HttpURLConnection) url.openConnection();
		       // ������������ʽ
		       connection.setRequestMethod("POST");
		       // ��������������������ʱʱ�䣺15000����
		       connection.setConnectTimeout(15000);
		       // ���ö�ȡ�����������������ݳ�ʱʱ�䣺60000����
		       connection.setReadTimeout(60000);

		       // Ĭ��ֵΪ��false������Զ�̷�������������/д����ʱ����Ҫ����Ϊtrue
		       connection.setDoOutput(true);
		       // Ĭ��ֵΪ��true����ǰ��Զ�̷����ȡ����ʱ������Ϊtrue���ò������п���
		       connection.setDoInput(true);
		       // ��������ж�,���ʺŵ�˵����Stringƴ�ӣ���֮��Ϊjson
		       if (param.contains("=")) {
		           // ���ô�������ĸ�ʽ:�������Ӧ���� name1=value1&name2=value2 ����ʽ��
		           connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		       } else {
		           //���ò���������json��ʽ
		           connection.setRequestProperty("Content-Type", "application/json;charset=utf-8");
		       }
		       // ͨ�����Ӷ����ȡһ�������
		       os = connection.getOutputStream();
		       // ͨ����������󽫲���д��ȥ/�����ȥ,����ͨ���ֽ�����д����,������utf-8,��ֹ���ĳ���
		       os.write(param.getBytes("utf-8"));
		       // ͨ�����Ӷ����ȡһ������������Զ�̶�ȡ
		       if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
		           is = connection.getInputStream();
		           // ��������������а�װ:charset���ݹ�����Ŀ���Ҫ��������
		           br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

		           StringBuffer sbf = new StringBuffer();
		           String temp = null;
		           // ѭ������һ��һ�ж�ȡ����
		           while ((temp = br.readLine()) != null) {
		               sbf.append(temp);
		               sbf.append("\r\n");
		           }
		           result = sbf.toString();
		       } else {
		           System.out.println("ResponseCode is an error code��" + connection.getResponseCode());
		       }
		   } catch (MalformedURLException e) {
		       e.printStackTrace();
		   } catch (IOException e) {
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
		       if (null != os) {
		           try {
		               os.close();
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
		       // �Ͽ���Զ�̵�ַurl������
		       connection.disconnect();
		   }
		   return result;
		}

}