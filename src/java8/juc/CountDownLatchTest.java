package java8.juc;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/12/2 12:18
 */

import java8.lambdaTest.LambdaDemo;

import java.util.concurrent.CountDownLatch;

/**
 * 就是初始化一个数，特定的时机让他减一，减到零的时候执行指定的操作
 * 可以用于需要其他线程执行完毕之后才执行的操作
 *
 * 这里是一个 -- 计算十个线程执行完的总时间
 */
public class CountDownLatchTest {
  public static void main(String[] args) {
    CountDownLatch latch = new CountDownLatch(10);
    long start = System.currentTimeMillis();
    CDThread thread = new CDThread(latch);
    for(int i = 0; i < 10; i++) {
      new Thread(thread).start();
    }

    try {
      latch.await();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    long end = System.currentTimeMillis();
    System.out.println("执行时间：" +( end-start));
  }
}
class CDThread implements Runnable {
  private CountDownLatch latch;
  CDThread(CountDownLatch latch) {
    this.latch = latch;
  }
  @Override
  public void run() {
    for(int i = 0;i<50000; i++) {
      if(i%2==0) {
        System.out.println(i);
      }
    }
    latch.countDown();
  }
}
