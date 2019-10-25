package grammar2;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @Deacription 接收方
 * @Author BarryLee
 * @Date 2019/10/24 16:23
 */
public class G40UDPServer_Object {
  public static void main(String[] args) throws IOException, ClassNotFoundException {
    DatagramSocket socket = new DatagramSocket(9970);
    byte[] bs = new byte[1024*60];
    DatagramPacket packet = new DatagramPacket(bs, 0, bs.length);
    socket.receive(packet);
    byte[] data = packet.getData();
    ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(data)));
    Student student = (Student) in.readObject();
    System.out.println(student);
    socket.close();
  }
}
class Student implements Serializable{
  private int age;
  private String name;
  public Student(int age, String name) {
    this.age = age;
    this.name = name;
  }

  @Override
  public String toString() {
    return name + ": " + age;
  }
}
