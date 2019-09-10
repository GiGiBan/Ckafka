package util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Map;

/**
 * 对传入Map集合数据进行拼接，格式：key1=value1&key2=value2&...
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
        // 将得到的字符串进行处理得到目标格式的字符串
        try {
            sb = URLEncoder.encode(sb, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }// 使用常见的UTF-8编码
        sb = sb.replace("%3D", "=").replace("%26", "&");
        
        //System.out.println(sb);
        return sb;
    }

}
