package grammar2;

import util.Utils;

import java.io.*;
import java.net.Socket;

/**
 * @Deacription 聊天室 - 客户端
 * @Author BarryLee
 * @Date 2019/10/25 20:08
 */
public class G46TcpChatClient {
  public static void main(String[] args) throws IOException {
    Socket socket = new Socket("localhost", 8989);
    new Thread(new Send(socket)).start();
    new Thread(new Receive(socket)).start();
  }
  static class Send implements Runnable{
    private Socket socket;
    private DataOutputStream out;
    private BufferedReader in;
    public Send(Socket socket) {
      this.socket = socket;
      try {
        // 写出
        out = new DataOutputStream(socket.getOutputStream());
        // 从控制台读入
        in = new BufferedReader(new InputStreamReader(System.in));
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    @Override
    public void run() {
      System.out.println("【私聊格式：@黑色大丽花:你好哇】");
      // 上来就给你一个名字
      System.out.print("请输入用户名：");
      try {
        String username = in.readLine();
        send(username);
        // 然后就可以随意聊天了
        while(true) {
          String msg = in.readLine();
          send(msg);
        }
      } catch (IOException e) {
        e.printStackTrace();
        Utils.close(in, out, socket);
      }
    }
    private void send(String msg) {
      try {
        out.writeUTF(msg);
        out.flush();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
  static class Receive implements Runnable{
    private Socket socket;
    private DataInputStream in;
    public Receive(Socket socket) {
      this.socket = socket;
      try {
        in = new DataInputStream(socket.getInputStream());
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    @Override
    public void run() {
      // 只管接收并且输出
      String msg;
      while(true) {
        try {
          msg = in.readUTF();
          System.out.println(msg);
        } catch (IOException e) {
          e.printStackTrace();
          Utils.close(in, socket);
          break;
        }
      }
    }
  }
}
