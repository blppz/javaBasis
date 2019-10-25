package grammar2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Deacription TCP 文件传输
 * @Author BarryLee
 * @Date 2019/10/25 9:10
 */
public class G44TcpServer_File {
  public static void main(String[] args) throws IOException {
    ServerSocket serverSocket = new ServerSocket(8989);
    Socket socket = serverSocket.accept();
    BufferedInputStream in = new BufferedInputStream(socket.getInputStream());
    BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("e:/test/01_cp.jpg"));
    int len;
    byte[] bs = new byte[1024*100];
    while((len = in.read(bs)) != -1) {
      out.write(bs, 0, len);
    }
    out.flush();
    out.close();
    in.close();
    socket.close();
    serverSocket.close();
  }
}
