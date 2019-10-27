package grammar3.myServer;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/26 15:41
 */
public class RegisterServlet implements Servlet {
  @Override
  public void service(Request request, Response response) {
    // 只关注内容
    response.print("<html>");
    response.print("<head>");
    response.print("<title>test web server</title>");
    response.print("</head>");
    response.print("<body>");
    response.print("<span>注册成功：逸川同学--"+request.getValue("pwd")+"--</span>");
    response.print("</body>");
    response.print("</html>");
  }
}
