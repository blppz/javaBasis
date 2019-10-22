package grammar2;

/**
 * @Deacription 多线程模拟龟兔赛跑
 * @Author BarryLee
 * @Date 2019/10/21 21:10
 */
public class G18ThreadRacer {
  public static void main(String[] args) {
    MyRun r = new MyRun();
    new Thread(r, "乌龟").start();
    new Thread(r, "兔子").start();
  }
  static class MyRun implements Runnable {
    private int step;
    private static boolean isGameOver = false;
    @Override
    public void run() {
      for(int i = 0; i <= 100; i++) {
        if(isGameOver) {
          break;
        }
        step++;
        if(step == 100) {
          System.out.println(Thread.currentThread().getName() + "->Winner");
          isGameOver = true;
          break;
        } else {
          System.out.println(Thread.currentThread().getName() + "->" + step);
        }
      }
    }
  }
}
