package grammar2;

import java.io.*;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/19 22:49
 */
public class G02Chat {
  /**
   * 转换流练习
   * InputStreamReader
   * OutputStreamWriter
   *
   * 需求：模拟英文聊天程序，要求：
   *      (1) 从键盘录入英文字符，每录一行就把它转成大写输出到控制台；
   *      (2) 保存聊天记录到字节流文件。
   * 分析需求1
   * 1.控制台输入System.in
   * 2.控制台接收的是字节流，使用InputStream
   * 3.要转换成大写，需要的是字符，使用转换流InputStreamReader将字节流转换为字符流
   * 4.一行一行的录，BufferedReader有这个方法
   *
   * 分析需求2
   * 1.刚刚得到的已经是字符了，要转换为字节流，使用OutputStreamWriter
   * 2.要写到文件，用FileOutputStream
   * 3.可以使用BufferedWriter加速，并且他有newLine方法，当然，也可以写一个'\n'进去
   */
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("e://test//testReader.txt")));
    String line = null;
    while((line = reader.readLine()) != null) {
      line = line.toUpperCase();
      System.out.println(line);
      writer.write(line);
      writer.newLine();
      writer.flush();
    }
    reader.close();
    writer.close();
  }
}
