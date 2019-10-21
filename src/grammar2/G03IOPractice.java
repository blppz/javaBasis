package grammar2;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @Deacription IO 相关几个练习
 * @Author BarryLee
 * @Date 2019/10/20 8:48
 */
public class G03IOPractice {
  public static void main(String[] args) throws IOException {
    //copyText();
    //copyImage();
    //keyboardToFile();
    //readFile();
    copyFileWithUTF8();
  }

  /**
   * 复制一个文本文件
   * 分析：
   * 1.明确源和目的
   * InputStream, OutputStream, Reader, Writer
   * 2.是否纯文本
   * Reader、 Writer
   * 3.输入输出设备
   * 都是文件
   * FileReader, FileWriter
   * 4.额外功能
   * BufferedReader, BufferedWriter
   */
  public static void copyText() throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader("e:/test/testCopy.txt"));
    BufferedWriter writer = new BufferedWriter(new FileWriter("e:/test/testCopy2.txt"));
    String line;
    while((line=reader.readLine()) != null) {
      writer.write(line);
      writer.newLine();
      writer.flush();
    }
    reader.close();
    writer.close();
  }

  /**
   * 复制一个图片文件
   * 分析：
   * 1.明确源和目的
   * InputStream, OutputStream, Reader, Writer
   * 2.是否纯文本
   * InputStream, OutputStream
   * 3.输入输出设备
   * FileInputStream, FileOutputStream
   * 4.额外功能
   * BufferedInputStream
   * BufferedOutStream
   */
  public static void copyImage() throws IOException {
    BufferedInputStream in = new BufferedInputStream(new FileInputStream("e:/test/01.jpg"));
    BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("e:/test/02.jpg"));
    int len;
    byte[] bytes = new byte[512];
    while((len = in.read(bytes, 0, bytes.length)) != -1) {
      out.write(bytes, 0, len);
    }
    in.close();
    out.close();
  }

  /**
   * 读取键盘录入，存储到一个文件中
   * 分析：
   * 1.明确源和目的
   * InputStream, OutputStream, Reader, Writer
   * 2.是否纯文本
   * 键盘输入，肯定是文本，Reader, Writer
   * 3.输入输出设备
   * System.in, FileWriter
   * 4.额外功能
   * 转换流InputStreamReader
   * BufferedReader, BufferedWriter
   */
  public static void keyboardToFile() throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new FileWriter("e:/test/testKeyBoardInput.txt"));
    String line;
    while((line = reader.readLine()) != null) {
      writer.write(line);
      System.out.println(line);
      writer.newLine();
      // 字符流记得刷新流
      writer.flush();
    }
    reader.close();
    writer.close();
  }

  /**
   * 读取一个文本文件，显示到显示器上
   * 分析:
   * 1.明确源和目的
   * InputStream, OutputStream, Reader, Writer
   * 2.是否纯文本
   * Reader, Writer
   * 3.输入输出设备
   * FileReader, System.out
   * 4.额外功能
   * BufferedReader, BufferedWriter
   */
  public static void readFile() throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader("e:/test/testCopy.txt"));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    String line;
    while((line = reader.readLine()) != null) {
      writer.write(line);
      writer.newLine();
      writer.flush();
    }
    reader.close();
    writer.close();
  }

  /**
   * 读取一个文本文件，将文本按照指定的编码表UTF-8写入到另一个文件中
   * 分析：
   * 1.明确源和目的
   * InputStream, OutputStream, Reader, Writer
   * 2.是否纯文本
   * Reader, Writer
   * 3.输入输出设备
   * FileReader, FileWriter
   * 4.额外功能
   * BufferedReader, BufferedWriter
   *
   * 这里注意一点，如果读入的文件是GBK，这段代码会产生一个有乱码的写出文件
   * 这种情况可以指定读入的文件格式：new InputStreamReader(inputStream, "GB2312")
   */
  public static void copyFileWithUTF8() throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader("e:/test/copyFileWithUTF8.txt"));

    FileOutputStream outputStream = new FileOutputStream("e:/test/copyFileWithUTF8_2.txt");
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));

    String line;
    while((line = reader.readLine()) != null) {
      writer.write(line);
      writer.newLine();
      writer.flush();
    }
    reader.close();
    writer.close();
  }
}
