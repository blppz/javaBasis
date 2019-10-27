package grammar3.myServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.URLDecoder;
import java.util.*;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/26 23:01
 */
public class Request {
  private InputStream in;
  private String requestInfo;
  private String method;
  private String pattern;
  private Map<String, List<String>> paramMap;
  private static final String BLANK = " ";
  private static final String CRLF = "\r\n";
  public Request() {}
  public Request(Socket socket) {
    try {
      paramMap = new HashMap<>();
      in = socket.getInputStream();
      byte[] data = new byte[1024*1024];
      int len = in.read(data);
      requestInfo = new String(data, 0, len);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  public void parseRequestInfo() {
    //GET /index.html?name=aa&pwd=111 HTTP/1.1
    int spritIdx = requestInfo.indexOf("/");
    method = requestInfo.substring(0, spritIdx - 1);
    int beforeHttpIdx = requestInfo.indexOf(" HTTP/");
    String info = requestInfo.substring(spritIdx + 1, beforeHttpIdx);
    int quesIdx = info.indexOf("?");
    String param = null;
    if(quesIdx > -1) {
      String[] strs = info.split("\\?");
      pattern = strs[0];
      param = strs[1];
    } else {
      pattern = info;
    }

    // 如果是post请求，最后一行可能有参数
    String postParam = requestInfo.substring(requestInfo.lastIndexOf(CRLF)).trim();
    //System.out.println(postParam);
    param = param!=null&&param.length()>0 ? param+"&"+postParam : postParam;
    convertMap(param);

    //System.out.println("pattern=" + pattern);
    //System.out.println("param=" + param);
    //Set<Map.Entry<String, List<String>>> entries = paramMap.entrySet();
    //for(Map.Entry<String, List<String>>entry: entries) {
    //  String key = entry.getKey();
    //  List<String> values = entry.getValue();
    //  System.out.println(key);
    //  System.out.println(values);
    //}
  }
  private void convertMap(String param) {
    if(param != null && param.length() > 0) {
      String[] strs = param.split("&");
      for(String item: strs) {
        String[] entity = item.split("=");
        entity = Arrays.copyOf(entity, 2);
        String key = entity[0];
        String value = decode(entity[1], "utf-8");
        if(paramMap.containsKey(key)) {
          List<String> values = paramMap.get(key);
          values.add(value);
        } else {
          List<String> values = new ArrayList<>();
          values.add(value);
          paramMap.put(key, values);
        }
      }
    }
  }
  public String getValue(String key) {
    List<String> values = paramMap.get(key);
    return values.get(0);
  }
  public String[] getValues(String key) {
    List<String> values = paramMap.get(key);
    return values.toArray(new String[0]);
  }

  // 处理中文乱码
  public String decode(String val, String enc) {
    String res = val;
    try {
      res = URLDecoder.decode(val, enc);
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    return res;
  }

  public String getPattern() {
    return pattern;
  }
  public String getMethod() {
    return method;
  }
}
