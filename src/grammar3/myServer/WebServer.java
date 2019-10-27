package grammar3.myServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/26 16:54
 */
public class WebServer {
  private ServerSocket serverSocket;
  private Request request;
  private Response response;
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
      request = new Request(socket);
      response = new Response(socket);
      request.parseRequestInfo();

      Servlet servlet = WebApp.getServletFromUrl(request.getPattern());
      if(null != servlet) {
        servlet.service(request, response);
        response.send(200);
      } else {
        response.send(404);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
