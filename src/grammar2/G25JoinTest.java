package grammar2;

/**
 * @Deacription Thread.join()
 * @Author BarryLee
 * @Date 2019/10/22 16:07
 */
public class G25JoinTest {

  /**
   * 简单解析：在b线程里面调用了 a.join()就意味着b让a插队了
   */

  public static void main(String[] args) {
    Thread aThread = new Thread(new AThread());
    Thread bThread = new Thread(new BThread(aThread));

    bThread.start();
    aThread.start();
  }

  static class AThread implements Runnable{
    @Override
    public void run() {
      for(int i = 0; i < 100; i++) {
        System.out.println("A ->" + i);
      }
      try {
        Thread.sleep(3000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
  static class BThread implements Runnable {
    private Thread a;
    public BThread(Thread a) {
      this.a = a;
    }

    @Override
    public void run() {
      try {
        a.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      for(int i = 0; i < 100; i++) {
        System.out.println("B ->" + i);
      }
    }
  }
}
