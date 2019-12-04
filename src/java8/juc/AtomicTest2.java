package java8.juc;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/12/2 9:16
 */

/**
 * 原子性
 */
public class AtomicTest2 {
  public static void main(String[] args) {
    MyThread2 mt = new MyThread2();
    for(int i = 0; i < 10; i++) {
      new Thread(mt).start();
    }
  }
}
class MyThread2 implements Runnable {
  private volatile int num = 0;
  @Override
  public void run() {
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(add());
  }
  public int add() {
    return num++;
  }
}