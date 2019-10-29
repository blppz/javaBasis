package util;

import java.io.Closeable;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @Deacription 工具类
 * @Author BarryLee
 * @Date 2019/10/16 19:33
 */
public class Utils {

  /**
   * yyyy-MM-dd hh:mm:ss
   */
  public static long strToTimestamp(String strDate) {
    DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    long res = 0;
    try {
      res = format.parse(strDate).getTime();
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return res;
  }

  public static void printArray(int[] arr) {
    for(int a: arr) {
      System.out.print(a + "  ");
    }
    System.out.println();
  }

  public static void printArray(String[] arr) {
    for(String a: arr) {
      System.out.print(a + "  ");
    }
    System.out.println();
  }

  /**
   * 关流
   */
  public static void close(Closeable... closeables) {
    for(Closeable c: closeables) {
      try {
        if(null != c) {
          c.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
