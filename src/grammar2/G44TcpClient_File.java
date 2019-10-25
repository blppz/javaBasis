package grammar2;

import java.io.*;
import java.net.Socket;

/**
 * @Deacription TCP 文件传输
 * @Author BarryLee
 * @Date 2019/10/25 9:09
 */
public class G44TcpClient_File {
  public static void main(String[] args) throws IOException {
    Socket socket = new Socket("localhost", 8989);
    BufferedInputStream in = new BufferedInputStream(new FileInputStream("e:/test/01.jpg"));
    BufferedOutputStream out = new BufferedOutputStream(socket.getOutputStream());
    byte[] bs = new byte[1024*100];
    int len;
    while((len=in.read(bs)) != -1) {
      out.write(bs, 0, len);
    }
    out.flush();
    out.close();
    in.close();
    socket.close();
  }
}
