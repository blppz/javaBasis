package grammar3.myServer.servlet;

import grammar3.myServer.core.Request;
import grammar3.myServer.core.Response;
import grammar3.myServer.core.Servlet;

/**
 * @Deacription 提交表单到这里处理
 * @Author BarryLee
 * @Date 2019/10/27 16:24
 */
public class RegActionServlet implements Servlet {
  @Override
  public void service(Request request, Response response) {

    response.print("<html>");
    response.print("<head>");
    response.print("<title>test web server</title>");
    response.print("<meta http-equiv=\"content-type\" content=\"text/html;charset=utf-8\">" );
    response.print("</head>");
    response.print("<body>");

    String name = request.getParameter("name");
    String[] loves = request.getParameters("love");
    response.println("name = " + name);
    if(loves != null) {
      for(int i = 0; i < loves.length; i++) {
        switch (loves[i]) {
          case "1":
            response.print("打代码");
            break;
          case "2":
            response.print("弹吉他");
            break;
          case "3":
            response.print("泡妹纸");
            break;
        }
      }
    }

    response.print("</body>");
    response.print("</html>");
  }
}
