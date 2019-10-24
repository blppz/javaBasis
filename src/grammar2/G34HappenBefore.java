package grammar2;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/23 21:24
 */
public class G34HappenBefore {
  /**
   * 指令重排问题
   * 指令执行顺序：
   * 1.获取指令
   * 2.将主存中的值拿到工作内存
   * 3.计算
   * 4.将结果重新写回主存
   *
   * 其中第4步可能耗时，从而导致指令重排问题，这里使用Thread来模拟
   * （每个线程都有自己的工作内存）
   *
   * 指令重排会发生问题的几种情况
   * 写后写
   * 写后读
   * 读后写
   */
  static int a = 0;
  static boolean flag = false;
  public static void main(String[] args) {
    // 写
    Thread t1 = new Thread(() -> {
      if(!flag) {
        a = 1;
        flag = true;
      }
    });
    // 读
    Thread t2 = new Thread(() -> {
      if(flag) {
        a *= 1;
      }
      if(a == 0) {
        // 如果这里输出1，则证明指令重排了
        // 因为进入这里的时候是a==0，但是输出时a被修改为1了
       System.out.println("happen before a=" + a);
      }
    });

    t2.start();
    t1.start();
  }
}
