package grammar;

/**
 * @Deacription 类型转换
 * @Author BarryLee
 * @Date 2019/10/14 19:48
 */
public class G07Conversion {
  public static void main(String[] args) {
    // 转换的特例
    short s = 13;
    System.out.println(s);

    char c = 'a'; // 97
    int i = c + 1;
    System.out.println(c);
    System.out.println(i);
    System.out.println((char)i);


    System.out.println("------------------");

    // 溢出问题
    int a = 1000000000;
    int b = 30;
    int res = a * b;// 溢出，结果是负数
    System.out.println(res);

    long res2 = a * b; // 和上面的结果是一样的，负数，因为右边已经溢出了
    System.out.println(res2);

    long res3 = a * (long) b; // 正确操作
    System.out.println(res3);

  }
}
