package grammar2;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/24 14:46
 */
public class G38URl {
  @Test
  public void test1() throws MalformedURLException {
    URL url = new URL("http://www.google.com:9090/index.html?a=123&b=321#qq");
    System.out.println(url.getProtocol());
    System.out.println(url.getHost());
    System.out.println(url.getPort());
    System.out.println(url.getFile());
    System.out.println(url.getPath());
    System.out.println(url.getQuery());
    System.out.println(url.getUserInfo());
  }

  /**
   * 一个巨简单的爬虫
   */
  @Test
  public void test2() throws IOException {
    URL url = new URL("https://www.jd.com");
    //URL url = new URL("https://www.dianping.com");
    InputStream inputStream = url.openStream();
    BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
    String str;
    while((str=in.readLine()) != null) {
      System.out.println(str);
    }
    in.close();
  }

  /**
   * 也是一个爬虫，有些网站是不能直接爬取的，比如上边的dianping网返回了403
   * 需要模拟浏览器，使用httpUrlConnection
   */
  @Test
  public void test3() throws IOException {
    URL url = new URL("https://www.dianping.com");
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setRequestMethod("GET");
    connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.120 Safari/537.36");
    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
    String line;
    while((line = reader.readLine()) != null) {
      System.out.println(line);
    }
  }
}
