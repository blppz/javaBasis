package java8.juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/12/2 9:26
 */
public class AtomicTest3 {
  public static void main(String[] args) {
    MyThread3 mt = new MyThread3();
    for(int i = 0; i < 10 ;i++) {
      new Thread(mt).start();
    }
  }
}
class MyThread3 implements Runnable {
  private AtomicInteger num = new AtomicInteger(0);
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
    return num.getAndIncrement();
  }
}
