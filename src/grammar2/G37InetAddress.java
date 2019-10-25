package grammar2;

import org.junit.Test;

import java.net.*;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/24 11:11
 */
public class G37InetAddress {

  /**
   * TCP和UDP各占 0 - 65535 端口
   */

  @Test
  public void test1() throws UnknownHostException {
    InetAddress localHost = InetAddress.getLocalHost();
    System.out.println(localHost);
    System.out.println(localHost.getHostName());
    System.out.println(localHost.getHostAddress());

    /**
     * 这里有个DNS的概念
     * DNS就是可以解析域名的东东，将这些192...解析成人能看懂的有意义的字符串
     * 或者反过来
     */
    InetAddress byName = InetAddress.getByName("www.google.com");
    System.out.println(byName);

    InetAddress byName1 = InetAddress.getByName("74.86.118.12");
    System.out.println(byName1);
  }

  @Test
  public void test2() {
    InetSocketAddress address = new InetSocketAddress("localhost", 7878);
    System.out.println(address);
    System.out.println(address.getHostName());
    System.out.println(address.getAddress());
    System.out.println(address.getPort());
  }



}
