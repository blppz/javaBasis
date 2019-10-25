package grammar2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/24 20:33
 */
public class G42UDPTalkReceive implements Runnable{
  private int port;
  public G42UDPTalkReceive(int port) {
    this.port = port;
  }
  @Override
  public void run() {
    // 使用DatagramSocket，指定端口，创建接收端
    // 2.准备容器，封装成DatagramPacket包裹

    try (DatagramSocket socket = new DatagramSocket(port)) {
      while (true) {
        byte[] bs = new byte[1024*60];
        DatagramPacket packet = new DatagramPacket(bs, 0, bs.length);
        // 3.阻塞式接收包裹receive(DatagramPacket packet)
        socket.receive(packet);
        // 4.分析数据：getData(), getLength
        byte[] data = packet.getData();
        String res = new String(data, 0, packet.getLength());
        System.out.println(res);
        if ("bye".equals(res)) {
          System.out.println("接收到bye");
          return;
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
