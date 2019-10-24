package grammar2;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/22 15:30
 */
public class G24YieldTest extends Thread {

  /**
   * 使当前线程从执行状态（运行状态）变为可执行态（就绪状态）。
   * cpu会从众多的可执行态里选择，也就是说，当前也就是刚刚的那个线程还是有可能会被再次执行到的，
   * 并不是说一定会执行其他线程而该线程在下一次中不会执行到了。
   */

  private String name;
  public G24YieldTest(String name) {
    this.name = name;
  }

  public static void main(String[] args) {
    new G24YieldTest("张三").start();

    new G24YieldTest("李四").start();
  }

  @Override
  public void run() {
    for(int i = 0; i < 100; i++) {
      //System.out.println(Thread.currentThread().getName() + "->" + i);
      System.out.println(name + "->" + i);
      if(i == 30) {
        Thread.yield();
      }
    }
  }
}
