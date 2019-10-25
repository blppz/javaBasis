package grammar2;

import util.Utils;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Deacription 聊天室 - 服务端
 * @Author BarryLee
 * @Date 2019/10/25 20:08
 *
 * 1.系统发送给当前用户
 * 2.系统通知所有用户
 * 2.群聊：用户发消息给其他用户
 * 4.私聊：用户发送消息给指定用户@xx:
 */
public class G46TcpChatServer {
  private static CopyOnWriteArrayList<Server> allClients = new CopyOnWriteArrayList<>();
  public static void main(String[] args) throws IOException {
    ServerSocket server = new ServerSocket(8989);
    while(true) {
      Socket socket = server.accept();
      System.out.println("一个用户进入 .. ");
      Server client = new Server(socket);
      allClients.add(client);
      new Thread(client).start();
    }
  }
  static class Server implements Runnable{
    private Socket socket;
    private String username;
    private DataInputStream in;
    private DataOutputStream out;
    public Server(Socket socket) {
      this.socket = socket;
      try {
        out = new DataOutputStream(socket.getOutputStream());
        in = new DataInputStream(socket.getInputStream());
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    @Override
    public void run() {
      // 收到的第一条消息为用户名
      username = read();
      // 收到用户名之后欢迎这个用户 并且 通知其他用户她的到来
      sendSysMsg("欢迎"+username+"来到Bl聊天室", 1);
      sendSysMsg(username + "来了",2);
      while(true) {
        try {
          String msg = in.readUTF();
          sendMsg(msg);
        } catch (IOException e) {
          e.printStackTrace();
          sendSysMsg(username+"离开了Bl聊天室", 2);
          Utils.close(in, out, socket);
          break;
        }
      }
    }
    // 读取一行消息
    private String read() {
      String line = "";
      try {
        line = in.readUTF();
      } catch (IOException e) {
        e.printStackTrace();
      }
      return line;
    }
    // 发送用户消息
    // msg：@xx: 为私聊，其他为群聊
    private void sendMsg(String msg) {
      if(null == msg) {
        return;
      }
      System.out.println("-----" + msg);
      String bro = null;
      if(msg.startsWith("@")) {
        int idx = msg.indexOf(":");
        bro = msg.substring(1, idx);
        msg = this.username + "悄咪咪对你说：" + msg.substring(idx+1);
      } else {
        msg = this.username + "说：" + msg;
      }
      System.out.println("-----" + bro);
      try {
        if(null != bro) {
          for(Server client: allClients) {
            if(bro.equals(client.username)) {
              client.out.writeUTF(msg);
              client.out.flush();
              break;
            }
          }
        } else {
          for(Server client: allClients) {
            if(this.username.equals(client.username)) {
              continue;
            }
            System.out.println("来了");
            client.out.writeUTF(msg);
            client.out.flush();
          }
        }

      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    // 发送系统消息
    // target：1=当前用户，2=当前用户之外的用户，3所有用户
    private void sendSysMsg(String msg, int target) {
      if(null == msg) {
        return;
      }

      msg = "系统消息：" + msg;
      try {
        switch (target) {
          case 1:
            System.out.println(1);
            out.writeUTF(msg);
            out.flush();
            break;
          case 2:
            System.out.println(2);
            for(Server client: allClients) {
              if(!this.username.equals(client.username)) {
                client.out.writeUTF(msg);
                client.out.flush();
              }
            }
            break;
          case 3:
            System.out.println(3);
            for(Server client: allClients) {
              client.out.writeUTF(msg);
              client.out.flush();
            }
            break;
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
