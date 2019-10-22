package grammar2;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/21 20:51
 */
public class G17Ticket01 {
  public static void main(String[] args) {
    /**
     * 模拟多线程抢票
     * 同时展现并发的问题 -- 共享资源，数据错误，锁的引入
     */
    new Thread(new MyRun()).start();
    new Thread(new MyRun()).start();
    new Thread(new MyRun()).start();
  }

  static class MyRun implements Runnable {
    private int ticketNums = 99;
    @Override
    public void run() {
      while(ticketNums > 0) {
        try {
          Thread.sleep(10);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " -> " + ticketNums--);
      }
    }
  }
}

