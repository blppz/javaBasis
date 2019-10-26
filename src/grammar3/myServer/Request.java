package grammar3.myServer;

import com.sun.org.apache.xerces.internal.impl.validation.EntityState;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
  private Map<String, String> paramMap;
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
    System.out.println("---------");
    System.out.println(info);
    int quesIdx = info.indexOf("?");
    String param = null;
    if(quesIdx > -1) {
      String[] strs = info.split("\\?");
      System.out.println("len = " + strs.length);
      pattern = strs[0];
      param = strs[1];
    } else {
      pattern = info;
    }
    if(param != null) {
      String[] strs = param.split("&");
      for(String item: strs) {
        String[] entity = item.split("=");
        paramMap.put(entity[0], entity[1]);
      }
    }
    System.out.println("pattern=" + pattern);
    System.out.println("param=" + param);
    Set<Map.Entry<String, String>> entries = paramMap.entrySet();
    for(Map.Entry<String, String> entry: entries) {
      System.out.println(entry.getKey() + ": " + entry.getValue());
    }
  }
}
