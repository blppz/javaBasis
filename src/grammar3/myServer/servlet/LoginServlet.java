package grammar3.myServer.servlet;

import grammar3.myServer.core.Request;
import grammar3.myServer.core.Response;
import grammar3.myServer.core.Servlet;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/26 15:41
 */
public class LoginServlet implements Servlet {
  @Override
  public void service(Request request, Response response) {
    // 只关注内容
    response.print("<html>");
    response.print("<head>");
    response.print("<title>test web server</title>");
    response.print("<meta http-equiv=\"content-type\" content=\"text/html;charset=utf-8\">" );
    response.print("</head>");
    response.print("<body>");
    response.print("<span>登录成功</span>");
    response.print("</body>");
    response.print("</html>");
  }
}
