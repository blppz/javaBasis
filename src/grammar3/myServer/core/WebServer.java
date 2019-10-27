package grammar3.myServer.core;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Deacription 服务器启动入口
 * @Author BarryLee
 * @Date 2019/10/26 16:54
 */
public class WebServer {
  private ServerSocket serverSocket;
  private boolean isRunning;
  private static WebServer server;

  public static void main(String[] args) {
    server = new WebServer();
    server.start();
  }
  // 启动服务器
  private void start() {
    try {
      serverSocket = new ServerSocket(8989);
      isRunning = true;
      accept();
    } catch (IOException e) {
      e.printStackTrace();
      stop();
    }
  }
  private void accept() {
    while(isRunning) {
      try {
        Socket socket = serverSocket.accept();
        System.out.println("一个客户端建立了连接 .. ");
        new Thread(new Dispatcher(socket)).start();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
  private void stop() {
    isRunning = false;
    server.stop();
  }
}
