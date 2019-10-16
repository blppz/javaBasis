package grammar;

/**
 * @Deacription 重写Object中toString方法
 * @Author BarryLee
 * @Date 2019/10/15 15:29
 */
public class G19Object {
  public static void main(String[] args) {
    G19Object o = new G19Object();
    System.out.println(o);
    System.out.println(o.toString());
  }

  public String toString() {
    return "重写了";
  }
}
