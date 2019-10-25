package util;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Deacription 写在这方便以后获取本机地址
 * @Author BarryLee
 * @Date 2019/10/24 11:45
 */
public class GetMyAddres {
  public static void main(String[] args) throws UnknownHostException {
    InetAddress localHost = InetAddress.getLocalHost();
    System.out.println(localHost);
  }
}
