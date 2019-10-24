package grammar2;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/22 9:28
 */
public class G21LambdaThread {
  /**
   * Lambda在Thread中的推导
   * 1.外部类
   * 2.静态内部类
   * 3.局部内部类
   * 4.匿名内部类
   * 5.lambda表达式简化
   *
   * lambda对线程的简化使用场景是
   * 比较简单的方法、只有一个方法、只用一次
   *
   * 好处：避免匿名内部类定义过多、函数式编程
   */

  // 2
  static class MyRun implements Runnable {
    @Override
    public void run() {
      System.out.println("i am myRun function");
    }
  }

  public static void main(String[] args) {
    new Thread(new MyRun()).start();

    // 3
    class MyThread implements Runnable{
      @Override
      public void run() {
        System.out.println("MyThread running");
      }
    }
    new Thread(new MyThread()).start();

    //4
    new Thread(new Runnable() {
      @Override
      public void run() {
        System.out.println("this is no body function");
      }
    }).start();

    //5.
    new Thread(() -> {
      for(int i = 0; i < 10; i++) {
        System.out.print(i);
      }
    }).start();
  }
}
