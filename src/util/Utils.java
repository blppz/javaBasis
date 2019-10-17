package util;

/**
 * @Deacription 工具类
 * @Author BarryLee
 * @Date 2019/10/16 19:33
 */
public class Utils {
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
}
