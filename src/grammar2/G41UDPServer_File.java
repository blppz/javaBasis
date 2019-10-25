package grammar2;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @Deacription UDP  文件传输  接收方
 * @Author BarryLee
 * @Date 2019/10/24 19:32
 */
public class G41UDPServer_File {
  public static void main(String[] args) throws IOException {
    DatagramSocket socket = new DatagramSocket(8970);
    byte[] bs = new byte[1024*60];
    DatagramPacket packet = new DatagramPacket(bs, 0, bs.length);
    socket.receive(packet);
    byte[] data = packet.getData();
    // 这两个长度不一样
    System.out.println(data.length);
    System.out.println(packet.getLength());
    FileOutputStream out = new FileOutputStream("e:/test/erweima2.png");
    out.write(data, 0, packet.getLength());
    socket.close();
  }
}
