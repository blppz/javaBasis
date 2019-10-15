package grammar;

/**
 * @Deacription 递归
 * @Author BarryLee
 * @Date 2019/10/14 21:15
 *
 * 一般来说，递归代码简洁，但递归占用资源比较多，耗时较长，并且有栈溢出的情况，所以并不建议使用
 */
public class G10Recursion {
  public static void main(String[] args) {
    int times = 15;

    long start = System.currentTimeMillis();
    long a = count(times);
    long end = System.currentTimeMillis();
    System.out.println(end - start);

    long start2 = System.currentTimeMillis();
    long b = count2(times);
    long end2 = System.currentTimeMillis();
    System.out.println(end2 - start2);

    System.out.println(a);
    System.out.println(b);
  }

  // 利用递归计算阶乘
  public static long count(int n) {
    if(n >= 1) {
      return n * count(n-1);
    } else {
      return 1;
    }
  }

  // 利用循环计算阶乘
  public static long count2(int n) {
    long res = n;
    while(n > 1) {
      res *= (n-1);
      n--;
    }
    return res;
  }
}
