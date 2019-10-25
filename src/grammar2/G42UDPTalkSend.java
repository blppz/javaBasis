package grammar2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/24 20:33
 */
public class G42UDPTalkSend implements Runnable{
  private String host;
  private int port;
  public G42UDPTalkSend(String host, int port) {
    this.host = host;
    this.port = port;
  }

  @Override
  public void run() {
    // 1.使用DatagramSocket，指定端口，创建发送端
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    try (DatagramSocket socket = new DatagramSocket()) {
      while (true) {
        // 2.准备数据，转成字节数组
        String line = reader.readLine();
        byte[] bs = line.getBytes();
        // 3.准备容器，封装成DatagramPackage包裹，指定目的地
        DatagramPacket packet = new DatagramPacket(bs, 0, bs.length,
            new InetSocketAddress(host, port));
        // 4.发送包裹 send(DatagramPackage package)
        socket.send(packet);
        if ("bye".equals(line)) {
          System.out.println("发送了bye");
          return;
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
