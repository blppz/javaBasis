package grammar2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * @Deacription 发送端
 * @Author BarryLee
 * @Date 2019/10/24 15:30
 *
 * 1.使用DatagramSocket，指定端口，创建发送端
 * 2.准备数据，转成字节数组
 * 3.准备容器，封装成DatagramPacket包裹，指定目的地
 * 4.发送包裹 send(DatagramPacket packet)
 * 5.释放资源
 */
public class G39UDPClient_String {
  public static void main(String[] args) throws IOException {
    System.out.println("Client端启动 .. ");
    // 1.使用DatagramSocket，指定端口，创建发送端
    DatagramSocket socket = new DatagramSocket();
    // 2.准备数据，转成字节数组
    byte[] bs = "你好，逸川同学".getBytes();
    // 3.准备容器，封装成DatagramPackage包裹，指定目的地
    DatagramPacket packet = new DatagramPacket(bs, 0, bs.length,
        new InetSocketAddress("localhost", 9090));
    // 4.发送包裹 send(DatagramPackage package)
    socket.send(packet);
    // 5.释放资源
    socket.close();
  }
}
