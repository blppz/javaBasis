package grammar2;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @Deacription 文件工具类
 * @Author BarryLee
 * @Date 2019/10/20 16:21
 */
public class G07FileUtils {

  /**
   * 流拷贝
   * @param in inputStream
   * @param out outputStream
   */
  public static void copy(InputStream in, OutputStream out) {
    int len;
    byte[] bs = new byte[1024*20];
    try {
      while((len = in.read(bs)) != -1) {
        out.write(bs, 0, len);
        out.flush();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * 关闭流
   * @param ios in, out
   */
  public static void close(Closeable... ios) {
    for(Closeable io: ios) {
      if(io != null) {
        try {
          io.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
