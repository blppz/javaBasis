import jdk.nashorn.internal.runtime.linker.LinkerCallSite;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/28 22:37
 */
public class G09Spider {

  @Test
  public void test1() {
    String path = "https://www.163.com/";
    String charset = "gbk";
    List<String> list = getUrlList(path, charset);
    for (String s: list) {
      System.out.println(s);
    }
    // get到之后可以继续反复调用，甚至放到磁盘中。。
  }

  public static List<String> getUrlList(String path, String charset) {
    List<String> list = new ArrayList<>();
    String content = getUrlContent(path, charset);

    // 开始匹配url
    // 默认是贪婪模式，下面的?代表勉强模式：https://www.cnblogs.com/kevin-yuan/archive/2012/09/02/2667428.html
    // 然后括号就是分组，配合group(1)表示匹配到之后取第一组
    Pattern pattern = Pattern.compile("href=\"([\\w\\s:/.]+?)\"");
    Matcher matcher = pattern.matcher(content);

    while(matcher.find()) {
      // System.out.println(matcher.group());
      // System.out.println(matcher.group(1));
      list.add(matcher.group(1));
    }

    return list;
  }

  public static String getUrlContent(String path, String charset) {
    StringBuilder sb = new StringBuilder();
    try {
      URL url = new URL(path);
      InputStream in = url.openStream();
      BufferedReader reader = new BufferedReader(new InputStreamReader(in,charset));
      String line;
      while((line=reader.readLine()) != null) {
        sb.append(line);
      }

    } catch (IOException e) {
      //e.printStackTrace();
    }
    return sb.toString();
  }
}
