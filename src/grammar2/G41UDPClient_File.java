package grammar2;

import org.apache.commons.io.IOUtils;
import sun.nio.ch.IOUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * @Deacription UDP 文件传输  发送方
 * @Author BarryLee
 * @Date 2019/10/24 19:32
 */
public class G41UDPClient_File {
  public static void main(String[] args) throws IOException {
    DatagramSocket socket = new DatagramSocket();
    // java.net.SocketException: The message is larger
    // 也就是文件不能太大了
    //byte[] bs = IOUtils.toByteArray(new FileInputStream("e:/test/01.jpg"));
    byte[] bs = IOUtils.toByteArray(new FileInputStream("e:/test/erweima.png"));
    DatagramPacket packet = new DatagramPacket(bs, 0, bs.length,
        new InetSocketAddress("localhost", 8970));
    socket.send(packet);
    socket.close();
  }
}
