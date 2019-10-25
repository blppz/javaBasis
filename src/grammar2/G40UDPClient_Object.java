package grammar2;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * @Deacription 发送方
 * @Author BarryLee
 * @Date 2019/10/24 16:23
 */
public class G40UDPClient_Object {
  public static void main(String[] args) throws IOException {
    DatagramSocket socket = new DatagramSocket();
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ObjectOutputStream outputStream = new ObjectOutputStream(new BufferedOutputStream(baos));
    Student student = new Student(18, "希希");
    outputStream.writeObject(student);
    // 一定要flush!!!!!!!!
    // 这里没flush会导致server ObjectInputStream in一行报错：StreamCorruptedException
    outputStream.flush();
    byte[] bs = baos.toByteArray();
    //System.out.println(bs.length);
    DatagramPacket packet = new DatagramPacket(bs, 0, bs.length,
        new InetSocketAddress("localhost", 9970));
    socket.send(packet);
    socket.close();
  }
}
