package grammar;

/**
 * @Deacription 重载 Overload
 * @Author BarryLee
 * @Date 2019/10/14 21:05
 */
public class G09Overload {
  public static void main(String[] args) {
    /**
     * 重载和方法名和参数相关，其他例如返回值等是无关的
     */
  }

  // 这是参数的个数不同构成的重载
  private static int add(int a, int b) {
    return a + b;
  }
  public static int add(int a, int b, int c) {
    return a + b + c;
  }

  // 这是参数的类型不同构成的重载
  public static long add(long a, long b) {
    return a + b;
  }

  // 这是参数顺序不同构成的重载
  public static long add(int a, long b) {
    return a + b;
  }
  public static long add(long a, int b) {
    return a + b;
  }
}
