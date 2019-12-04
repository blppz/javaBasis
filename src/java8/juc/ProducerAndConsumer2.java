package java8.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/12/2 19:25
 */
public class ProducerAndConsumer2 {
  public static void main(String[] args) {
    Clerk2 clerk2 = new Clerk2();
    new Thread(new Consumer2(clerk2)).start();
    new Thread(new Consumer2(clerk2)).start();
    new Thread(new Producer2(clerk2)).start();
    new Thread(new Producer2(clerk2)).start();
  }
}
class Clerk2 {
  Lock lock = new ReentrantLock();
  Condition condition = lock.newCondition();

  private int num;
  public void consume() {
    lock.lock();
    try {
      while(num<=0) {
        condition.await();
      }
      System.out.println(--num);
      condition.signalAll();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      // 一定要释放锁
      lock.unlock();
    }
  }
  public void add() {
    lock.lock();
    try {
      while(num>0) {
        condition.await();
      }
      System.out.println(++num);
      condition.signalAll();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
  }
}
class Producer2 implements Runnable{
  private Clerk2 clerk2;
  Producer2(Clerk2 clerk2) {
    this.clerk2 = clerk2;
  }
  @Override
  public void run() {
    for(int i = 0; i<10; i++) {
      clerk2.add();
    }
  }
}
class Consumer2 implements Runnable {
  private Clerk2 clerk2;
  Consumer2(Clerk2 clerk2) {
    this.clerk2 = clerk2;
  }
  @Override
  public void run() {
    for(int i = 0; i<10; i++) {
      clerk2.consume();
    }
  }
}