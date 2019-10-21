package grammar2;

import java.io.*;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/20 21:40
 */
public class G11Print {
  /**
   * 打印流
   */
  public static void main(String[] args) throws FileNotFoundException {
    // 1.设置System.out输出到文件
    PrintStream ps = new PrintStream(new FileOutputStream("e:/test/testPrint.txt"));
    System.setOut(ps);
    //ps.println("老干妈");
    //ps.println("老干爹");
    System.out.println("laoganma");
    System.out.println("laogandie");
    ps.flush();
    ps.close();

    // 然后再设置回来
    System.setOut(new PrintStream(
        new BufferedOutputStream(
            new FileOutputStream(FileDescriptor.out)), true));
    System.out.println("hello");
    System.out.println("world");
    System.out.println("again");
  }
}
