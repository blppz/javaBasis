package grammar3.myServer;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/26 16:54
 */
public class WebServer {
  private ServerSocket serverSocket;
  public static void main(String[] args) {
    WebServer server = new WebServer();
    server.start();
  }
  private void start() {
    try {
      serverSocket = new ServerSocket(8989);
      accept();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  private void accept() {
    try {
      Socket socket = serverSocket.accept();
      System.out.println("一个客户端建立了连接 .. ");
      receive(socket);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  private void receive(Socket socket) {
    Request request = new Request(socket);
    request.parseRequestInfo();
    response(socket);
  }
  private void response(Socket socket) {
    try {
      Response response = new Response(socket);

      // 只关注内容
      response.print("<html>");
      response.print("<head>");
      response.print("<title>test web server</title>");
      response.print("</head>");
      response.print("<body>");
      response.print("<span>逸川同学</span>");
      response.print("</body>");
      response.print("</html>");

			// 以及状态码
      response.send(200);

    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
