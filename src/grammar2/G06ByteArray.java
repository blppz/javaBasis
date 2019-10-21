package grammar2;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/20 15:26
 */
public class G06ByteArray {
  /**
   * ByteArrayInputStream, ByteArrayOutputStream
   * 这两个的源是内存而不是硬盘，之前的文件都是与操作系统打交道的
   * 而这个内存，我们Java是可以操控的，所以close()方法是空的，因为内存是由GC来清理的
   *
   * 注意点：
   * 不能太大（不能太占内存了）
   *
   */

  @Test
  public void test1() throws IOException {
    byte[] inBytes = "talk is cheap, show me the code".getBytes();
    ByteArrayInputStream in = new ByteArrayInputStream(inBytes);

    // 这里值得注意，这个构造没有指定目的地，它是自己独特的方法
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    byte[] flush = new byte[8];
    int len;
    while((len = in.read(flush)) != -1) {
      //System.out.println(new String(flush, 0, len));
      out.write(flush, 0, len);
    }

    // 最后打印结果看一下
    System.out.println(new String(out.toByteArray()));
  }
}
