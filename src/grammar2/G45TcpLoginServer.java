package grammar2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Deacription 多线程、双向通讯
 * @Author BarryLee
 * @Date 2019/10/25 10:10
 */
public class G45TcpLoginServer {
  public static void main(String[] args) throws IOException {
    ServerSocket serverSocket = new ServerSocket(8990);
    while(true) {
      Socket socket = serverSocket.accept();
      new Thread(new Server(socket)).start();
    }
  }

  static class Server implements Runnable {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    public Server(Socket socket) {
      this.socket = socket;
      try {
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    @Override
    public void run() {
      String user = receive();
      String[] split = user.split("&");
      String username = "";
      String password = "";
      for(String s: split) {
        String[] kv = s.split("=");
        if(kv[0].equals("username")) {
          username = kv[1];
        } else if(kv[0].equals("password")) {
          password = kv[1];
        }
      }
      System.out.println("username=" + username + ", password=" + password);

      // 写出结果
      String msg = "欢迎回来：" + username;
      send(msg);

      // 释放资源
      release();
    }

    private void send(String msg) {
      try {
        out.writeUTF(msg);
        out.flush();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    private String receive() {
      String user = "";
      try {
        user = in.readUTF();
      } catch (IOException e) {
        e.printStackTrace();
      }
      return user;
    }
    // 释放资源
    private void release() {
      try {
        if(null != in) {
          in.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
      try {
        if(null != out) {
          out.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
      try {
        if(null != socket) {
          socket.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
