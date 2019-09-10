package util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Map;

/**
 * �Դ���Map�������ݽ���ƴ�ӣ���ʽ��key1=value1&key2=value2&...
 * @author 34375
 *
 */
public class Ksort {
	public static String Ksort(Map<String, Object> map)  {

        String sb = "";
        String[] key = new String[map.size()];
        int index = 0;
        for (String k : map.keySet()) {
            key[index] = k;
            index++;
        }
        Arrays.sort(key);
        for (String s : key) {
            sb += s + "=" + map.get(s) + "&";
        }
        sb = sb.substring(0, sb.length() - 1);
        // ���õ����ַ������д���õ�Ŀ���ʽ���ַ���
        try {
            sb = URLEncoder.encode(sb, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }// ʹ�ó�����UTF-8����
        sb = sb.replace("%3D", "=").replace("%26", "&");
        
        //System.out.println(sb);
        return sb;
    }

}
