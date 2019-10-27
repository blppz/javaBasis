package grammar3.myServer.servlet;

import grammar3.myServer.core.Request;
import grammar3.myServer.core.Response;
import grammar3.myServer.core.Servlet;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Deacription 返回一个注册页面
 * @Author BarryLee
 * @Date 2019/10/26 15:41
 */
public class RegisterServlet implements Servlet {
  @Override
  public void service(Request request, Response response) {
    InputStream in = Thread.currentThread().getContextClassLoader()
        .getResourceAsStream("grammar3/myServer/front/register.html");
    byte[] bs = new byte[1024];
    int len;
    try {
      if(in != null) {
        while((len=in.read(bs)) != -1) {
          String str = new String(bs, 0, len);
          response.print(str);
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }


  }
}
