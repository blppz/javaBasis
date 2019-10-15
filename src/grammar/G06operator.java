package grammar;

/**
 * @Deacription 操作符
 * @Author BarryLee
 * @Date 2019/10/14 16:03
 */
public class G06operator {
  public static void main(String[] args) {
    // 取余，符号和左边的相同，这是规定。。
    System.out.println(7%2);
    System.out.println(-7%2);
    System.out.println(7%-2);

    System.out.println(1 ^ 2);
    System.out.println(true ^ true);
  }
}
