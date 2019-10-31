package grammar;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/31 9:20
 */
public class G54finally_return {
  public static void main(String[] args) {
    System.out.println(fun());
    System.out.println(fun2());
  }
  public static int fun() {
    int res = 0;
    try {
      res = 1;
      res /= 0;
      return 2;
    } catch (RuntimeException e) {
      res = 6;
      return res;
    } finally {
      res = 4;
      System.out.println("finally .. ");
      return res;
    }
    // return res;
  }
  public static int fun2() {
    int res = 0;
    try {
      res = 1;
      res /= 0;
      return 2;
    } catch (RuntimeException e) {
      res = 6;
      return res;
    } finally {
      res = 4;
      System.out.println("finally .. ");
    }
    // return res;
  }

}
