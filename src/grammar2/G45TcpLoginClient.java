package grammar2;

import java.io.*;
import java.net.Socket;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/25 10:10
 */
public class G45TcpLoginClient {
  public static void main(String[] args) throws IOException {
    Socket socket = new Socket("localhost", 8990);
    new Request(socket).request();
    new Response(socket).response();
  }
  static class Request {
    private BufferedReader console;
    private DataOutputStream out;
    //private Socket socket;
    public Request(Socket socket) {
      //this.socket = socket;
      console = new BufferedReader(new InputStreamReader(System.in));
      try {
        out = new DataOutputStream(socket.getOutputStream());
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    public void request() {
      try {
        // 发送用户名密码
        System.out.print("请输入用户名：");
        String username = console.readLine();
        System.out.print("请输入密码：");
        String password = console.readLine();
        String sendMsg = "username=" + username + "&password=" + password;
        out.writeUTF(sendMsg);
        out.flush();
      } catch (IOException e) {
        e.printStackTrace();
      } finally {
        // 这个out不能关闭，因为流的关闭规则是先关闭里面的，再关闭外面的，这样就会关闭了Socket！！！！！
        //try {
        //  if(null != out) {
        //    out.close();
        //  }
        //} catch (IOException e) {
        //  e.printStackTrace();
        //}
      }
    }
  }
  static class Response {
    private BufferedReader reader;
    private Socket socket;
    public Response(Socket socket) {
      this.socket = socket;
      try {
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    public void response() {
      // 接收结果
      String msg = "";
      try {
        if(reader != null) {
          msg = reader.readLine();
        }
        System.out.println(msg);
      } catch (IOException e) {
        e.printStackTrace();
      } finally {
        try {
          if(null != reader) {
            reader.close();
          }
          if(null != socket) {
            socket.close();
          }
        } catch (IOException e) {
          e.printStackTrace();
        }

      }
    }
  }
}
