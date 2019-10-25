package grammar2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @Deacription 接收端
 * @Author BarryLee
 * @Date 2019/10/24 15:25
 *
 * 1.使用DatagramSocket，指定端口，创建接收端
 * 2.准备容器，封装成DatagramPacket包裹
 * 3.阻塞式接收包裹receive(DatagramPacket packet)
 * 4.分析数据：getData(), getLength
 * 5.释放资源
 *
 */
public class G39UDPServer_String {
  public static void main(String[] args) throws IOException {
    System.out.println("Server端启动 .. ");
    // 使用DatagramSocket，指定端口，创建接收端
    DatagramSocket socket = new DatagramSocket(9090);
    // 2.准备容器，封装成DatagramPacket包裹
    byte[] bs = new byte[1024*60];
    DatagramPacket packet = new DatagramPacket(bs, 0, bs.length);
    // 3.阻塞式接收包裹receive(DatagramPacket packet)
    socket.receive(packet);
    // 4.分析数据：getData(), getLength
    byte[] data = packet.getData();
    String res = new String(data);
    System.out.println(res);
    // 5.释放资源
    socket.close();
  }
}
