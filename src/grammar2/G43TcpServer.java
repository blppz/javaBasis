package grammar2;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Deacription TCP Demo 服务端
 * @Author BarryLee
 * @Date 2019/10/25 8:47
 *
 * 1.指定端口，使用ServerSocket创建服务器
 * 2.阻塞式等待连接 accept
 * 3.操作  输入输出流操作
 * 4.关闭资源
 */
public class G43TcpServer {
  public static void main(String[] args) throws IOException {
    ServerSocket serverSocket = new ServerSocket(8989);
    Socket socket = serverSocket.accept();
    DataInputStream in = new DataInputStream(socket.getInputStream());
    String name = in.readUTF();
    System.out.println(name);
    in.close();
    serverSocket.close();
  }
}
