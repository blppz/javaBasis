package grammar3.myServer.core;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/26 20:19
 */
public class Response {
  private static final String BLANK = " ";
  private static final String CRLF = "\r\n";
  private BufferedWriter writer;
  private StringBuilder contents = new StringBuilder();
  // 这个size是响应体的字节长度
  private int size;
  private StringBuilder responseInfo = new StringBuilder();

  public Response() {}
  public Response(OutputStream out) {
    writer = new BufferedWriter(new OutputStreamWriter(out));
  }
  public Response(Socket socket) {
    try {
      writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void send(int code) throws IOException {
    // 1.响应行
    responseLine(code);
    // 2.响应头
    responseHeader();
    // 3.响应体
    responseInfo.append(contents);

    // 4.响应
    writer.write(responseInfo.toString());
    writer.flush();
  }
  private void responseLine(int code) {
    //1.响应行: HTTP/1.1 200 OK
    responseInfo.append("HTTP/1.1");
    responseInfo.append(BLANK);
    responseInfo.append(code);
    String info = "";
    switch (code) {
      case 200:
        info="OK";
        break;
      case 404:
        info = "NOT FOUND";
        break;
      case 500:
        info = "SERVER ERROR";
        break;
    }
    responseInfo.append(BLANK);
    responseInfo.append(info).append(CRLF);
  }
  private void responseHeader() {
    //2.响应头(最后一行存在空行):
    /*
     * Date:Mon,31Dec209904:25:57GMT
     * Server:shsxt Server/0.0.1;charset=GBK
     * Content-type:text/html
     * Content-length:39725426
     */
    responseInfo.append("Date:").append(new Date()).append(CRLF);
    responseInfo.append("Server:bl Server/0.0.1;charset=GBK").append(CRLF);
    responseInfo.append("Content-type:text/html").append(CRLF);
    responseInfo.append("Content-length:").append(size).append(CRLF);
    // 这里还有个空行 。。。
    responseInfo.append(CRLF);
  }

  public Response print(String str) {
    contents.append(str);
    size += str.getBytes().length;
    return this;
  }
  public Response println(String str) {
    contents.append(str).append(CRLF);
    size += CRLF.length() + str.getBytes().length;
    return this;
  }

}
