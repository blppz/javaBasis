package grammar2;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/22 20:20
 */
public class G27Deamon {
  /**
   * 守护线程
   * 线程总的来讲，分为两类：用户线程、守护线程
   * 用户线程：我们平常new的线程就是用户线程，虚拟机会等待用户线程执行完毕
   * 守护线程：而守护线程是守护用户线程的，服务用户线程，虚拟机不会等待它的执行完毕
   */
  public static void main(String[] args) {
    Thread godThread = new Thread(new God());
    // 设置god为守护线程，setDaemon默认为false
    godThread.setDaemon(true);

    Thread humanThread = new Thread(new Human());

    godThread.start();
    humanThread.start();
  }
  static class God implements Runnable {
    @Override
    public void run() {
      while(true) {
        System.out.println("god bless you ... ");
      }
    }
  }
  static class Human implements Runnable {
    @Override
    public void run() {
      for(int i = 1; i < 365 * 100; i++) {
        System.out.println("happy life ... ");
      }
    }
  }
}
