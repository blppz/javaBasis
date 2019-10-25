package grammar2;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @Deacription TCP Demo 客户端
 * @Author BarryLee
 * @Date 2019/10/25 8:48
 *
 * 1.建立连接：使用Socket创建客户端 + 服务器的地址和端口
 * 2.操作  输入输出流操作
 * 3.关闭资源
 */
public class G43TcpClient {
  public static void main(String[] args) throws IOException {
    Socket socket = new Socket("localhost", 8989);
    DataOutputStream out = new DataOutputStream(socket.getOutputStream());
    out.writeUTF("老干妈");
    out.flush();
    out.close();
    socket.close();
  }
}
