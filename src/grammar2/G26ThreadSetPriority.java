package grammar2;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/22 19:57
 */
public class G26ThreadSetPriority {
  /**
   * 设置线程的优先级
   * 更改此线程的优先级。
   * 首先调用这个线程的checkAccess方法，没有参数。 这可能会导致投掷SecurityException 。
   * 否则，该线程的优先级设置为指定的小newPriority和最大允许的线程的线程组的优先级。
   * 1 - 10
   * 默认是 5 - NORM_PRIORITY
   */
  public static void main(String[] args) {
    Thread t1 = new Thread(new MyRun());
    Thread t2 = new Thread(new MyRun());
    t1.checkAccess();
    System.out.println(t1.getPriority());
    //Thread t3 = new Thread(new MyRun());
    //Thread t4 = new Thread(new MyRun());
    //Thread t5 = new Thread(new MyRun());
    //Thread t6 = new Thread(new MyRun());

    t1.setPriority(Thread.MAX_PRIORITY);
    t2.setPriority(Thread.MIN_PRIORITY);
    //t3.setPriority(Thread.MAX_PRIORITY);
    //t4.setPriority(Thread.MIN_PRIORITY);
    //t5.setPriority(Thread.MIN_PRIORITY);
    //t6.setPriority(Thread.MIN_PRIORITY);

    //t6.start();
    //t5.start();
    //t4.start();
    t1.start();
    t2.start();
    //t3.start();
  }
  static class MyRun implements Runnable {
    @Override
    public void run() {
      for(int i = 0; i < 20; i++) {
        System.out.println(Thread.currentThread().getName() + "->" + i);
      }
    }
  }
}
