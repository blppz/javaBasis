package grammar3.myServer.core;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * @Deacription 分发器
 * @Author BarryLee
 * @Date 2019/10/27 14:33
 */
public class Dispatcher implements Runnable{
  private Socket socket;
  private Request request;
  private Response response;

  public Dispatcher(Socket socket) {
    this.socket = socket;
    request = new Request(socket);
    response = new Response(socket);
  }

  @Override
  public void run() {
    request.parseRequestInfo();
    Servlet servlet = WebApp.getServletFromUrl(request.getPattern());
    try {
      if(request.getPattern() == null || request.getPattern().length() == 0) {
        InputStream in = Thread.currentThread().getContextClassLoader()
            .getResourceAsStream("grammar3/myServer/front/index.html");
        byte[]bs = new byte[1024*1024];
        if(in != null) {
          int len = in.read(bs, 0, bs.length);
          response.print(new String(bs, 0, len));
        }
        response.send(200);
        release();
        return;
      }

      if(null != servlet) {
        servlet.service(request, response);
        response.send(200);
      } else {
        InputStream in = Thread.currentThread().getContextClassLoader()
            .getResourceAsStream("grammar3/myServer/front/error.html");
        byte[]bs = new byte[1024*1024];
        if(in != null) {
          int len = in.read(bs, 0, bs.length);
          response.print(new String(bs, 0, len));
        }
        response.send(404);
      }
    } catch (IOException e) {
      e.printStackTrace();
      try {
        response.send(500);
      } catch (IOException ex) {
        ex.printStackTrace();
        release();
      }
      release();
    }
    release();
  }

  public void release() {
    try {
      socket.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
